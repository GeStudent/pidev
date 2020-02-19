/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import edu.gestudent.entities.Livre;
import edu.gestudent.entities.exams;
import edu.gestudent.services.examsCRUD;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ExamenController implements Initializable {

    examsCRUD exc = new examsCRUD();
    @FXML
    private TextField txtnom;
    @FXML
    private DatePicker datetxt;
    @FXML
    private TextField txtduree;
    @FXML
    private TableColumn<exams, Integer> idexa;
    @FXML
    private TableColumn<exams, String> nomex;
    @FXML
    private TableColumn<exams, String> dateex;
    @FXML
    private TableColumn<exams, String> duree;

    public ObservableList<exams> data = FXCollections.observableArrayList();

    @FXML
    private TableView<exams> examtv;
    @FXML
    private TextField txtduree1;

//    public int getTxtduree() {
//        return Integer.parseInt(txtduree.getText());
//    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.addAll(exc.afficherex());
    
      
        // TODO
        this.idexa.setCellValueFactory(new PropertyValueFactory<>("idexa"));
       this.nomex.setCellValueFactory(new PropertyValueFactory<>("nomex"));
       this.dateex.setCellValueFactory(new PropertyValueFactory<>("dateex"));
       this.duree.setCellValueFactory(new PropertyValueFactory<>("duree"));
        this.examtv.setItems(data);
         //this for edit
           this.examtv.setEditable(true);
//        this.nomex.setCellFactory(TextFieldTableCell.forTableColumn());
        this.dateex.setCellFactory(TextFieldTableCell.forTableColumn());
//        this.duree.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    @FXML
    private void addex(ActionEvent event) {
        String date = datetxt.getValue().format(DateTimeFormatter.ISO_DATE);
      
        String numberAsString=txtduree +"Heurs";
        
       // String duree= txtduree.getText().concat(txtduree+"Heurs");
        //System.out.println(date);

        exams e;
        e = new exams(txtnom.getText(), date, txtduree.getText()+"Heurs");
        exc.ajoutex(e);
        Alert succAddExamAlert = new Alert(Alert.AlertType.INFORMATION);
        succAddExamAlert.setTitle("Add Exam");
        succAddExamAlert.setHeaderText("Results:");
        succAddExamAlert.setContentText("Exam added successfully!");
        succAddExamAlert.showAndWait();

        data.clear();
        data.addAll(exc.afficherex());
    }

    @FXML
    private void editex(ActionEvent event) {
        if (examtv.getSelectionModel().getSelectedItem() != null) {

            exams e = examtv.getSelectionModel().getSelectedItem();

            try {
                exc.updateex(e.getIdexa(), e.getDateex());
            } catch (SQLException ex) {
                Logger.getLogger(ExamenController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Alert ExamAlert = new Alert(Alert.AlertType.INFORMATION);
            ExamAlert.setTitle("edit");
            ExamAlert.setHeaderText(null);
            ExamAlert.setContentText("Exam was succfuly edit");
            ExamAlert.showAndWait();

        } else {
            //Alert Select exam :
            Alert selectExamAlert = new Alert(Alert.AlertType.WARNING);
            selectExamAlert.setTitle("Select a Exam");
            selectExamAlert.setHeaderText(null);
            selectExamAlert.setContentText("You need to select Exam first!");
            selectExamAlert.showAndWait();
            //Alert Select Exam !
        }
    }

    @FXML
    private void removeex(ActionEvent event) {
        if (examtv.getSelectionModel().getSelectedItem() != null) {
            Alert deleteExamAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteExamAlert.setTitle("Delete Partner");
            deleteExamAlert.setHeaderText(null);
            deleteExamAlert.setContentText("Are you sure want to delete this Exam ?");
            Optional<ButtonType> optionDeleteExamAlert = deleteExamAlert.showAndWait();
            if (optionDeleteExamAlert.get() == ButtonType.OK) {
                exams e = examtv.getSelectionModel().getSelectedItem();
                try {
                    exc.delete(e);
                } catch (SQLException ex) {
                    Logger.getLogger(ExamenController.class.getName()).log(Level.SEVERE, null, ex);
                }

                data.clear();
                data.addAll(exc.afficherex());

                //Alert Delete Blog :
                Alert succDeleteExamAlert = new Alert(Alert.AlertType.INFORMATION);
                succDeleteExamAlert.setTitle("Delete Exam");
                succDeleteExamAlert.setHeaderText("Results:");
                succDeleteExamAlert.setContentText("Exam deleted successfully!");

                succDeleteExamAlert.showAndWait();
            } else if (optionDeleteExamAlert.get() == ButtonType.CANCEL) {

            }

        } else {

            //Alert Select Exam :
            Alert selectExamAlert = new Alert(Alert.AlertType.WARNING);
            selectExamAlert.setTitle("Select a Exam");
            selectExamAlert.setHeaderText(null);
            selectExamAlert.setContentText("You need to select Exam first!");
            selectExamAlert.showAndWait();
            //Alert Select Exam !

        }
    }

    @FXML
    private void displayex(ActionEvent event) {
         data.clear();
        data.addAll(exc.RechercheReclamation(txtduree1.getText()));
          this.idexa.setCellValueFactory(new PropertyValueFactory<>("idexa"));
       this.nomex.setCellValueFactory(new PropertyValueFactory<>("nomex"));
       this.dateex.setCellValueFactory(new PropertyValueFactory<>("dateex"));
       this.duree.setCellValueFactory(new PropertyValueFactory<>("duree"));
        this.examtv.setItems(data);
    }
//      @FXML
//    public void changeNameCellEvent(CellEditEvent edittedCell
//    ) {
//        exams ExamSelected = examtv.getSelectionModel().getSelectedItem();
//        ExamSelected.setNomex(edittedCell.getNewValue().toString());
//  }
    @FXML
     public void changeDateCellEvent(CellEditEvent edittedCell
    ) {
        exams ExamSelected = examtv.getSelectionModel().getSelectedItem();
        ExamSelected.setDateex(edittedCell.getNewValue().toString());
    }
//      @FXML
//     public void changeTimeCellEvent(CellEditEvent edittedCell
//    ) {
//        exams ExamSelected = examtv.getSelectionModel().getSelectedItem();
//        ExamSelected.setDuree(Integer.parseInt(edittedCell.getNewValue().toString()));
//    }
//
//    @FXML
//    private void changeNameCellEvent(CellEditEvent edittedCell) {
//    }
//
//    @FXML
//    private void changeDateCellEvent(CellEditEvent edittedCell) {
//    }
//
//    @FXML
//    private void changeTimeCellEvent(CellEditEvent edittedCell) {
//    }

}
