(ns javafx.application
  (:require [javafx-wrapper :refer :all]))

(defobject preloader-error-notification javafx.application.Preloader$ErrorNotification)
(defobject preloader-progress-notification javafx.application.Preloader$ProgressNotification)
(defobject preloader-state-change-notification javafx.application.Preloader$StateChangeNotification)
