/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.StringUtils;
import edu.gestudent.entities.Emprunt;
import edu.gestudent.entities.Livre;
import edu.gestudent.entities.exams;
import edu.gestudent.services.examsCRUD;
import edu.gestudent.utils.DataBase;
import edu.gestudent.utils.gestudentAssistantUtil;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ExamenController implements Initializable {

    @FXML
    PieChart piechart;
    Connection con;
    Statement ste;
        private static Statement stmt = null;
    @FXML
    private StackPane ExamInfoContainer;

       public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        }
        finally {
        }
        return result;
    }
     public ObservableList<PieChart.Data> getExamGraphStatistics() {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        try {
            String qu1 = "SELECT COUNT(*) FROM exams";
                        String qu2 = "SELECT COUNT(*) FROM behaviour";
            ResultSet rs = execQuery(qu1);
            if (rs.next()) {
                int count = rs.getInt(1);
                data.add(new PieChart.Data("Total exams (" + count + ")", count));
            }
                  rs = execQuery(qu2);
            if (rs.next()) {
                int count = rs.getInt(1);
                data.add(new PieChart.Data("Behaviour in exams (" + count + ")", count));
            }
          
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    ArrayList< String> p = new ArrayList< String>();
    ArrayList< Integer> c = new ArrayList< Integer>();
    examsCRUD exc = new examsCRUD();
    private StackPane rootPane;
    @FXML
    private TextField txtnom;
    @FXML
    private DatePicker datetxt;
    @FXML
    private TextField txtduree;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //loadData();
        initGraphs();

      //  piechart.setData(piechartdata);

        data.addAll(exc.afficherex());

        // TODO
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
    public void initGraphs(){
            piechart = new PieChart(getExamGraphStatistics());
 ExamInfoContainer.getChildren().add(piechart);
}

    public int getnomq() throws SQLException {
        int q = 4;
        con = DataBase.getInstance().getConnection();
        String requete4 = "select nomex from exams;";
        PreparedStatement pst;

        pst = con.prepareStatement(requete4);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            exams e = new exams();
            if (rs.getString("nomex").equals(nomex)) {
                q++;
            }

        }
        return q;
    }

//    public void loadData() {
//
//        String query = "select * From exams "; //ORDER BY P asc
//
//        piechartdata = FXCollections.observableArrayList();
//
//        con = DataBase.getInstance().getConnection();
//
//        try {
//
//            ResultSet rs = con.createStatement().executeQuery(query);
//            while (rs.next()) {
//                exams e = new exams();
//                //	int result = Integer.parseInt(e.getDuree());
//                piechartdata.add(new PieChart.Data(rs.getString("nomex"), rs.getInt("idexa")));
//                p.add(rs.getString("nomex"));
//                c.add(rs.getInt("idexa"));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    @FXML
    private void addex(ActionEvent event) {
        Alert alertl = new Alert(Alert.AlertType.ERROR);
        if (datetxt.getValue().isBefore(LocalDate.now())) {
//            alertl.setTitle("Date Failed");
//            alertl.setContentText("The Date can't be in the Past !!");
//            alertl.showAndWait();
            //     JFXButton btn = new JFXButton("Okay!");
            AlertMaker.showErrorMessage("Date Failed!", "The Date can't be in the Past !!");

            return;
        }
        System.out.println(datetxt.getValue().isBefore(LocalDate.now()));
        Alert alert2 = new Alert(Alert.AlertType.ERROR);
        if (txtduree.getText().matches("(.*):(.*)") == false) {
//                alert2.setTitle("Duree Failed");
//               alert2.setContentText("The Time must be like 00:00 !!");
//                alert2.showAndWait();
            AlertMaker.showErrorMessage("Duree Failed!", "The Time must be like 00:00 !!");
            return;
        }
        System.out.println(txtduree.getText().matches("(.*):(.*)"));
        String date = datetxt.getValue().format(DateTimeFormatter.ISO_DATE);
        String numberAsString = txtduree + "Heurs";

        // String duree= txtduree.getText().concat(txtduree+"Heurs");
        //System.out.println(date);
        exams e;
        e = new exams(txtnom.getText(), date, txtduree.getText());
        exc.ajoutex(e);
        Alert succAddExamAlert = new Alert(Alert.AlertType.INFORMATION);
//        succAddExamAlert.setTitle("Add Exam");
//        succAddExamAlert.setHeaderText("Results:");
//        succAddExamAlert.setContentText("Exam added successfully!");
//        succAddExamAlert.showAndWait();
        AlertMaker.showSimpleAlert("Add Exam", "Exam added successfully!");

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
//            ExamAlert.setTitle("edit");
//            ExamAlert.setHeaderText(null);
//            ExamAlert.setContentText("Exam was succfuly edit");
//            ExamAlert.showAndWait();
        AlertMaker.showSimpleAlert("edit", "Exam was succfuly edit!");


        } else {
            //Alert Select exam :
            Alert selectExamAlert = new Alert(Alert.AlertType.WARNING);
//            selectExamAlert.setTitle("Select a Exam");
//            selectExamAlert.setHeaderText(null);
//            selectExamAlert.setContentText("You need to select Exam first!");
//            selectExamAlert.showAndWait();
        AlertMaker.showwarningMessage("Select a Exam", "You need to select Exam first!");

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
//                Alert succDeleteExamAlert = new Alert(Alert.AlertType.INFORMATION);
//                succDeleteExamAlert.setTitle("Delete Exam");
//                succDeleteExamAlert.setHeaderText("Results:");
//                succDeleteExamAlert.setContentText("Exam deleted successfully!");
//
//                succDeleteExamAlert.showAndWait();
        AlertMaker.showSimpleAlert("Delete Exam", "Exam deleted successfully!");

            } else if (optionDeleteExamAlert.get() == ButtonType.CANCEL) {

            }

        } else {

            //Alert Select Exam :
//            Alert selectExamAlert = new Alert(Alert.AlertType.WARNING);
//            selectExamAlert.setTitle("Select a Exam");
//            selectExamAlert.setHeaderText(null);
//            selectExamAlert.setContentText("You need to select Exam first!");
//            selectExamAlert.showAndWait();
        AlertMaker.showwarningMessage("Select a Exam", "You need to select Exam first!");

            //Alert Select Exam !

        }
    }

    @FXML
    private void displayex(ActionEvent event) {
        data.clear();
        data.addAll(exc.RechercheReclamation(txtduree1.getText()));
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

    private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }

    @FXML
    private void handleMenuFullScreen(ActionEvent event) {
        Stage stage = getStage();
        stage.setFullScreen(!stage.isFullScreen());
    }

    @FXML
    private void handleAboutMenu(ActionEvent event) {
                gestudentAssistantUtil.loadWindow(getClass().getResource("/edu/gestudent/about/about.fxml"), "About Us", null);
    }

}
