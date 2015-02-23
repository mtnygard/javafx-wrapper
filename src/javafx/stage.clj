(ns javafx.stage
  (:require [javafx-wrapper :refer :all]))

(defobject directory-chooser javafx.stage.DirectoryChooser)
(defobject file-chooser javafx.stage.FileChooser)
(defobject file-chooser-extension-filter javafx.stage.FileChooser$ExtensionFilter
  ([^String description & extensions]
   (javafx.stage.FileChooser$ExtensionFilter. description (seq extensions))))
(defobject window javafx.stage.Window)
(defobject popup javafx.stage.Popup)
(defobject stage javafx.stage.Stage)
