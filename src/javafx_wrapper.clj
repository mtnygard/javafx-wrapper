(ns javafx-wrapper
  "Provides the `defobject` macro to create the wrapper for
a JavaFX class. Also supplies the `apply-properties` function
that updates an object's state from a map of properties."
  (:require [clojure.tools.macro :refer [name-with-attributes]]
            [camel-snake-kebab :refer :all])
  (:import [javafx.event EventHandler WeakEventHandler]))

;; Force JavaFX to initialize
(defonce force-toolkit-init (javafx.embed.swing.JFXPanel.))

(defprotocol Mutable
  (apply-properties [this props]
    "Update the state of the JavaFX object with the supplied
map of properties and values. The keys are in keyword-style.
For example, a key of :scale-x means update the object by
calling .setScaleX.

Ordinary values are passed through directly. Event handlers
are treated specially. The value of an event handler should
be a function, which will be wrapped into a
`WeakEventHandler`."))

(defn- handle
  [f]
  (reify EventHandler
    (handle [this event]
      (f event))))

(defn- weak [^EventHandler h]
  (WeakEventHandler. h))

(defn wrap-handler
  [f]
  (if (instance? EventHandler f)
    f
    (weak
     (handle f))))

(def ^:private property-translators
  {javafx.beans.property.ObjectProperty 'identity
   javafx.beans.property.BooleanProperty 'boolean})

(defn event-handler?
  [p]
  (.startsWith (.getName p) "on"))

(defn- property-translator
  [p]
  (if (event-handler? p)
    'wrap-handler
    (property-translators (.getReturnType p) 'identity)))

(defn- property-policy
  [p]
  (let [nm        (.getName p)
        nm        (subs nm 0 (- (count nm) (count "Property")))
        setter    (symbol (str "set" (->CamelCase nm)))
        kw        (keyword (->kebab-case nm))
        translate (property-translator p)]
    [kw setter translate]))

(defn- properties-of
  [class]
  (filter
   #(and (.endsWith (.getName %) "Property") (not (.startsWith (.getName %) "impl_")))
   (seq (.getMethods class))))

(defn- property-mutator-sexps
  [class]
  (let [disposition (map property-policy (properties-of class))]
    `(extend-protocol Mutable
       '~class
       (apply-properties [~'this ~'props]
         ~@(for [[kind setter-name translate] disposition]
             `(when (contains? ~'props ~kind)
                (let [v# (get ~'props ~kind)]
                  (. ~'this (~setter-name (~translate v#))))))
         ~'this))))

(defn define-property-mutator
  "Extend the Mutable protocol to the JavaFX class named here.
This must be done after macroexpansion so that JavaFX can be
initialized separately. Otherwise, some classes will fail to load."
  [classname]
  (eval (property-mutator-sexps classname)))

(defn- last-part [n]
  (subs n (inc (.lastIndexOf n "."))))

(defn- ctor-arglist
  [^java.lang.reflect.Constructor ctor]
  (letfn [(argname [^Class class]
            (-> (if (.isArray class) (.getComponentType class) class)
                (.getName)
                last-part
                ->kebab-case
                symbol))
          (hinted [^Class class]
            (if (.isPrimitive class)
              (argname class)
              (vary-meta (argname class) assoc :tag class)))]
    (mapv hinted (.getParameterTypes ctor))))

(defmacro defobject
  "Bring a JavaFX class into the Clojure world. Creates a function
to construct the JavaFX object. Also extends the Mutable protocol
to that object, so you can call `apply-properties` with a map.

Example:
  (defobject circle javafx.scene.shape.Circle)

This simple form works for classes with unambiguous constructors. If
a class has multiple constructors of the same arity, then you must write
the desired constructors directly. E.g., javafx.animation.KeyFrame has multiple
constructors with arity 4 and 3.

  (defobject key-frame javafx.animation.KeyFrame
    ([time finished & values] (KeyFrame. time finished (into-array Object values)))"
  [symb & forms]
  (let [[symb forms]   (name-with-attributes symb forms)
        classname      (resolve (first forms))
        explicit-ctors (next forms)
        arglists       (map ctor-arglist (.getConstructors classname))
        ctor-arities   (map #(.getParameterCount %) (.getConstructors classname))]
    `(do
       (define-property-mutator '~classname)
       (defn ~symb
         ~@(if explicit-ctors
             explicit-ctors
             (if (empty? arglists)
               `([] (throw (ex-info "Cannot construct" {:class ~classname})))
               (for [arglist arglists]
                 (list arglist
                       (list* 'new classname arglist)))))))))
