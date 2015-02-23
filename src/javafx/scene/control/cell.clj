(ns javafx.scene.control.cell
  (:require [javafx-wrapper :refer :all]))
(defobject check-box-list-cell javafx.scene.control.cell.CheckBoxListCell)
(defobject choice-box-list-cell javafx.scene.control.cell.ChoiceBoxListCell
  ([]
   (javafx.scene.control.cell.ChoiceBoxListCell.))
  ([^javafx.util.StringConverter converter & items]
   (javafx.scene.control.cell.ChoiceBoxListCell. converter (into-array Object items))))
(defobject combo-box-list-cell javafx.scene.control.cell.ComboBoxListCell
  ([]
   (javafx.scene.control.cell.ComboBoxListCell.))
  ([^javafx.util.StringConverter converter & items]
   (javafx.scene.control.cell.ComboBoxListCell. converter) (into-array Object items)))
(defobject text-field-list-cell javafx.scene.control.cell.TextFieldListCell)
(defobject check-box-table-cell javafx.scene.control.cell.CheckBoxTableCell)
(defobject choice-box-table-cell javafx.scene.control.cell.ChoiceBoxTableCell
  ([]
   (javafx.scene.control.cell.ChoiceBoxTableCell.))
  ([^javafx.util.StringConverter converter & items]
   (javafx.scene.control.cell.ChoiceBoxTableCell. converter) (into-array Object items)))
(defobject combo-box-table-cell javafx.scene.control.cell.ComboBoxTableCell
  ([]
   (javafx.scene.control.cell.ComboBoxTableCell.))
  ([^javafx.util.StringConverter converter & items]
   (javafx.scene.control.cell.ComboBoxTableCell. converter) (into-array Object items)))
(defobject progress-bar-table-cell javafx.scene.control.cell.ProgressBarTableCell)
(defobject text-field-table-cell javafx.scene.control.cell.TextFieldTableCell)
(defobject check-box-tree-cell javafx.scene.control.cell.CheckBoxTreeCell)
(defobject choice-box-tree-cell javafx.scene.control.cell.ChoiceBoxTreeCell
  ([]
   (javafx.scene.control.cell.ChoiceBoxTreeCell.))
  ([^javafx.util.StringConverter converter & items]
   (javafx.scene.control.cell.ChoiceBoxTreeCell. converter) (into-array Object items))  )
(defobject combo-box-tree-cell javafx.scene.control.cell.ComboBoxTreeCell
  ([]
   (javafx.scene.control.cell.ComboBoxTreeCell))
  ([^javafx.util.StringConverter converter & items]
   (javafx.scene.control.cell.ComboBoxTreeCell. converter) (into-array Object items)))
(defobject text-field-tree-cell javafx.scene.control.cell.TextFieldTreeCell)
(defobject check-box-tree-table-cell javafx.scene.control.cell.CheckBoxTreeTableCell)
(defobject choice-box-tree-table-cell javafx.scene.control.cell.ChoiceBoxTreeTableCell
  ([]
   (javafx.scene.control.cell.ChoiceBoxTreeTableCell))
  ([^javafx.util.StringConverter converter & items]
   (javafx.scene.control.cell.ChoiceBoxTreeTableCell. converter) (into-array Object items)))
(defobject combo-box-tree-table-cell javafx.scene.control.cell.ComboBoxTreeTableCell
  ([]
   (javafx.scene.control.cell.ComboBoxTreeTableCell))
  ([^javafx.util.StringConverter converter & items]
   (javafx.scene.control.cell.ComboBoxTreeTableCell. converter) (into-array Object items)))
(defobject progress-bar-tree-table-cell javafx.scene.control.cell.ProgressBarTreeTableCell)
(defobject text-field-tree-table-cell javafx.scene.control.cell.TextFieldTreeTableCell)
