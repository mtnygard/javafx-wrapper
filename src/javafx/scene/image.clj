(ns javafx.scene.image
  (:require [javafx-wrapper :refer :all]))

(defobject image javafx.scene.image.Image
  ([^String url]
   (javafx.scene.image.Image. url))
  ([^String url width height preserve-ratio smooth]
   (javafx.scene.image.Image. url width height preserve-ratio smooth))
  ([^String url width height preserve-ratio smooth background-loading]
   (javafx.scene.image.Image. url width height preserve-ratio smooth background-loading)))
(defobject writable-image javafx.scene.image.WritableImage)
(defobject image-view javafx.scene.image.ImageView
  ([]
   (javafx.scene.image.ImageView.))
  ([^javafx.scene.image.Image image]
   (javafx.scene.image.ImageView. image)))
