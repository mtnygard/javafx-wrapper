# javafx-wrapper

This library mainly serves to help with instantiating and mutating
JavaFX objects.

Each mapped class gets a multiple-arity function to construct
instances. For example

```clojure
(require '[javafx-wrapper :as w])
;; => nil

(require '[javafx.scene.control :as c])
;; => nil

;; Use the no-arg constructor
(c/button)
;; => #<Button Button@46549137[styleClass=button]''>

;; Provide a label
(c/button "A Label")
;; => #<Button Button@3cc8111c[styleClass=button]'A Label'>
```

There's also a multimethod `apply-properties` that updates a JavaFX
object with a map of values:

```
(require '[javafx-wrapper :as w])
;; => nil

(require '[javafx.scene.shape :as s])
;; => nil

(s/circle)
;; => #<Circle Circle[centerX=0.0, centerY=0.0, radius=0.0, fill=0x000000ff]>

(w/apply-properties (s/circle) {:center-x 100.0 :center-y 100.0 :radius 500})
;; => #<Circle Circle[centerX=100.0, centerY=0.0, radius=500.0, fill=0x000000ff]>
```

Event handlers are just "on-xxx" properties with a function for a
value.

```
(w/apply-properties (c/button) {:on-action #(println "Button pushed")})
<Button Button@666d53d0[styleClass=button]''>
```

The main advantage of this library comes when you AOT it: very minimal
code but still a nice Clojure interface.

## License

Copyright © 2015 Michael Nygard

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
