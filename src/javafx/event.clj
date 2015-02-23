(ns javafx.event
  (:require
   [javafx-wrapper :refer :all]))

(defobject event javafx.event.Event)
(defobject action-event javafx.event.ActionEvent)
(defobject event-type javafx.event.EventType
  ([name] (javafx.event.EventType. name))
  ([supertype name] (javafx.event.EventType. supertype name)))
