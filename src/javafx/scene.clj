(ns javafx.scene
  (:require [javafx-wrapper :refer :all]))

(defobject image-cursor javafx.scene.ImageCursor)
(defobject parallel-camera javafx.scene.ParallelCamera)
(defobject perspective-camera javafx.scene.PerspectiveCamera)
(defobject ambient-light javafx.scene.AmbientLight)
(defobject point-light javafx.scene.PointLight)
(defobject group javafx.scene.Group
  ([] (javafx.scene.Group.))
  ([& children] (javafx.scene.Group. (into-array javafx.scene.Node children))))
(defobject sub-scene javafx.scene.SubScene)
(defobject scene javafx.scene.Scene
  ([^javafx.scene.Parent root]
   (javafx.scene.Scene. root))
  ([^javafx.scene.Parent root width height]
   (javafx.scene.Scene. root width height))
  ([^javafx.scene.Parent root width height depth-buffer]
   (javafx.scene.Scene. root width height depth-buffer))
  ([^javafx.scene.Parent root width height depth-buffer ^javafx.scene.SceneAntialiasing anti-aliasing]
   (javafx.scene.Scene. root width height depth-buffer anti-aliasing)))
(defobject scene-antialiasing javafx.scene.SceneAntialiasing)
(defobject snapshot-parameters javafx.scene.SnapshotParameters)
(defobject snapshot-result javafx.scene.SnapshotResult)
