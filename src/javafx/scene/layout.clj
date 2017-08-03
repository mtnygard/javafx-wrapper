(ns javafx.scene.layout
  (:require [javafx-wrapper :refer :all]))

(defobject background javafx.scene.layout.Background
  ([fills images]
   (javafx.scene.layout.Background. (seq fills) (seq images))))
(defobject background-fill javafx.scene.layout.BackgroundFill)
(defobject background-image javafx.scene.layout.BackgroundImage)
(defobject background-position javafx.scene.layout.BackgroundPosition)
(defobject background-size javafx.scene.layout.BackgroundSize)
(defobject border javafx.scene.layout.Border
  ([strokes images]
   (javafx.scene.layout.Border. (seq strokes) (seq images))))
(defobject border-image javafx.scene.layout.BorderImage)
(defobject border-stroke javafx.scene.layout.BorderStroke)
(defobject border-stroke-style javafx.scene.layout.BorderStrokeStyle)
(defobject border-widths javafx.scene.layout.BorderWidths)
(defobject column-constraints javafx.scene.layout.ColumnConstraints)
(defobject row-constraints javafx.scene.layout.RowConstraints)
(defobject corner-radii javafx.scene.layout.CornerRadii)
(defobject region javafx.scene.layout.Region)
(defobject pane javafx.scene.layout.Pane)
(defobject anchor-pane javafx.scene.layout.AnchorPane)
(defobject border-pane javafx.scene.layout.BorderPane)
(defobject flow-pane javafx.scene.layout.FlowPane
  ([] (javafx.scene.layout.FlowPane.))
  ([orientation hgap vgap & children]
   (javafx.scene.layout.FlowPane. orientation hgap vgap (into-array javafx.scene.Node children))))
(defobject grid-pane javafx.scene.layout.GridPane)
(defobject h-box javafx.scene.layout.HBox
  ([] (javafx.scene.layout.HBox.))
  ([spacing & children]
   (javafx.scene.layout.HBox. spacing (into-array javafx.scene.Node children))))
(defobject stack-pane javafx.scene.layout.StackPane)
(defobject tile-pane javafx.scene.layout.TilePane
  ([] (javafx.scene.layout.TilePane.))
  ([orientation hgap vgap & children]
   (javafx.scene.layout.TilePane. orientation hgap vgap (into-array javafx.scene.Node children))))
(defobject v-box javafx.scene.layout.VBox
  ([] (javafx.scene.layout.VBox.))
  ([spacing & children]
   (javafx.scene.layout.VBox. spacing (into-array javafx.scene.Node children))))
