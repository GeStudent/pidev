/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import edu.gestudent.entities.Club;
import edu.gestudent.services.ServiceClub;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Ayadi
 */
public class ClubpageController implements Initializable {

    ServiceClub Sc = new ServiceClub();

    @FXML
    private TextField txtid_club;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtnumero;
    @FXML
    private TextField txtdescription;
    @FXML
    private TextField txtetat;
    @FXML
    private TextField txtid_president;

    @FXML
    private Button ReturnButton;

    @FXML
    private TableColumn<Club, Integer> id_club;
    @FXML
    private TableColumn<Club, String> nom;
    @FXML
    private TableColumn<Club, String> date;
    @FXML
    private TableColumn<Club, String> email;

    @FXML
    private TableColumn<Club, String> numero;

    @FXML
    private TableColumn<Club, String> description;

    @FXML
    private TableColumn<Club, String> etat;
    ;
            
    @FXML
    private TableColumn<Club, String> id_president;
    public ObservableList<Club> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Club> clubtv;
    @FXML
    private Label club;
    @FXML
    private Button AddButton;
    @FXML
    private Button EditButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button SearchButton;
    @FXML
    private Button EmailButton;
    @FXML
    private DatePicker datetxt;

    public int getTxtid_club() {
        return Integer.parseInt(txtid_club.getText());
    }

    public int getTxtnumero() {
        return Integer.parseInt(txtnumero.getText());
    }

    public int getTxtetat() {
        return Integer.parseInt(txtetat.getText());
    }

    public int getTxtid_president() {
        return Integer.parseInt(txtid_president.getText());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            data.addAll(Sc.readAll());
            this.id_club.setCellValueFactory(new PropertyValueFactory<>("id_club"));
            this.nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            this.date.setCellValueFactory(new PropertyValueFactory<>("date"));
            this.email.setCellValueFactory(new PropertyValueFactory<>("email"));
            this.numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
            this.description.setCellValueFactory(new PropertyValueFactory<>("description"));
            this.etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            this.id_president.setCellValueFactory(new PropertyValueFactory<>("id_president"));

            this.clubtv.setItems(data);

            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ClubpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AddClub(ActionEvent event) throws SQLException {
        String date =datetxt.getValue().format(DateTimeFormatter.ISO_DATE);
        //System.out.println(date);
        Club c;
        c = new Club(nom.getText(),date, email.getText(), getTxtnumero(), description.getText(), getTxtetat(), getTxtid_president());
        Sc.ajouterClub(c);
           Alert succAddBookAlert = new Alert(Alert.AlertType.INFORMATION);
        succAddBookAlert.setTitle("Add Club");
        succAddBookAlert.setHeaderText("Results:");
        succAddBookAlert.setContentText("Club added successfully!");
       succAddBookAlert.showAndWait();

        data.clear();
        data.addAll(Sc.readAll());
    }

    @FXML
    private void ReturnAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
            Parent root = loader.load();
            HomepageController spc = loader.getController();
            ReturnButton.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(LibrarypageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EditClub(ActionEvent event) {
    }

    @FXML
    private void DeleteClub(ActionEvent event) {
    }

    @FXML
    private void SearchClub(ActionEvent event) {
    }

    @FXML
    private void EmailClub(ActionEvent event) {
    }

}
