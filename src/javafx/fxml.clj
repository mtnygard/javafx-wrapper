(ns javafx.fxml
  (:require [javafx-wrapper :refer :all]))

(defobject fxml-loader javafx.fxml.FXMLLoader
  ([]
   (javafx.fxml.FXMLLoader.))
  ([^java.net.URL location]
   (javafx.fxml.FXMLLoader. location))
  ([^java.net.URL location ^java.util.ResourceBundle resources]
   (javafx.fxml.FXMLLoader. location resources))
  ([^java.net.URL location ^java.util.ResourceBundle resources ^javafx.util.BuilderFactory builder-factory]
   (javafx.fxml.FXMLLoader. location resources builder-factory))
  ([^java.net.URL location ^java.util.ResourceBundle resources ^javafx.util.BuilderFactory builder-factory controller-factory]
   (javafx.fxml.FXMLLoader. location resources builder-factory (reify javafx.util.Callback (call [this param] (controller-factory param)))))
  ([^java.net.URL location ^java.util.ResourceBundle resources ^javafx.util.BuilderFactory builder-factory controller-factory ^java.nio.charset.Charset charset]
   (javafx.fxml.FXMLLoader. location resources builder-factory (reify javafx.util.Callback (call [this param] (controller-factory param))) charset)))
