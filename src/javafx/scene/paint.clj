(ns javafx.scene.paint
  (:require [javafx-wrapper :refer :all]))

(defobject phong-material javafx.scene.paint.PhongMaterial)
(defobject color javafx.scene.paint.Color)
(defobject image-pattern javafx.scene.paint.ImagePattern)
(defobject linear-gradient javafx.scene.paint.LinearGradient
  ([start-x start-y end-x end-y proportional ^javafx.scene.paint.CycleMethod cycle-method & stops]
   (javafx.scene.paint.LinearGradient. start-x start-y end-x end-y proportional cycle-method (seq stops))))
(defobject radial-gradient javafx.scene.paint.RadialGradient
  ([focus-angle focus-distance center-x center-y radius proportional ^javafx.scene.paint.CycleMethod cycle-method & stops]
   (javafx.scene.paint.RadialGradient. focus-angle focus-distance center-x center-y radius proportional ^javafx.scene.paint.CycleMethod cycle-method (seq stops))))
(defobject stop javafx.scene.paint.Stop)
