(ns javafx.animation
  (:require
   [javafx-wrapper :refer :all]))

(defobject timeline javafx.animation.Timeline
  ([] (javafx.animation.Timeline.))
  ([framerate & values] (javafx.animation.Timeline. framerate (into-array javafx.animation.KeyFrame values))))
(defobject fade-transition javafx.animation.FadeTransition)
(defobject fill-transition javafx.animation.FillTransition)
(defobject parallel-transition javafx.animation.ParallelTransition
  ([] (javafx.animation.ParallelTransition.))
  ([node & children] (javafx.animation.ParallelTransition. node (into-array javafx.animation.Animation children))))
(defobject path-transition javafx.animation.PathTransition)
(defobject pause-transition javafx.animation.PauseTransition)
(defobject rotate-transition javafx.animation.RotateTransition)
(defobject scale-transition javafx.animation.ScaleTransition)
(defobject sequential-transition javafx.animation.SequentialTransition
  ([] (javafx.animation.SequentialTransition.))
  ([node & children] (javafx.animation.SequentialTransition. node (into-array javafx.animation.Animation children))))
(defobject stroke-transition javafx.animation.StrokeTransition)
(defobject translate-transition javafx.animation.TranslateTransition)
(defobject key-frame javafx.animation.KeyFrame
  ([^javafx.util.Duration time ^String name finished values]
   (javafx.animation.KeyFrame. time name (wrap-handler finished) (into-array javafx.animation.KeyValue values))))
(defobject key-value javafx.animation.KeyValue)
