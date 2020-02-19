/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.gestudent.entities.Livre;
import edu.gestudent.entities.Student;
import edu.gestudent.entities.teacher;
import edu.gestudent.services.CryptServices;
import edu.gestudent.services.ServiceStudent;
import edu.gestudent.services.ServicesTeacher;
import edu.gestudent.services.ServicesUsers;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Ayadi
 */
public class SignupController implements Initializable {

    ServiceStudent ServiceStudent = new ServiceStudent();
    ServicesTeacher ServiceTeacher = new ServicesTeacher();
    ServicesUsers ServiceUsers = new ServicesUsers();

    @FXML
    private JFXTextField txtFirstname;
    @FXML
    private JFXTextField txtlastname;
    @FXML
    private JFXComboBox<String> combotype;

    public ObservableList<String> Occupation = FXCollections.observableArrayList("student", "teacher");

    @FXML
    private JFXTextField txtemail;
    @FXML
    private JFXComboBox<String> txtgender;

    public ObservableList<String> Gender = FXCollections.observableArrayList("male", "female");
    @FXML
    private DatePicker comboDate;
    @FXML
    private JFXTextField txtphone;
    @FXML
    private JFXTextField txtCountry;
    @FXML
    private JFXTextField txtCity;
    @FXML
    private JFXTextField txtQrCode;
    @FXML
    private JFXTextField txtusername;
    @FXML
    private JFXPasswordField txtpassword;
    @FXML
    private JFXPasswordField txtconformation;
    @FXML
    private JFXTextField txtimage;
    @FXML
    private JFXButton uploadbutton;

    Alert WarningAlert = new Alert(Alert.AlertType.WARNING);
    Alert InformationAlert = new Alert(Alert.AlertType.INFORMATION);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combotype.setItems(Occupation);
        txtgender.setItems(Gender);

        // TODO
    }

    @FXML
    private void Signup(ActionEvent event) {
        WarningAlert.setTitle("Warning");
        WarningAlert.setHeaderText(null);

        InformationAlert.setTitle("Account");
        InformationAlert.setHeaderText("Results:");

        String date = comboDate.getValue().format(DateTimeFormatter.ISO_DATE);
        if (combotype.getSelectionModel().isEmpty() || txtlastname.getText().equals("") || txtFirstname.getText().equals("") || txtemail.getText().equals("") || txtphone.getText().equals("") || txtCountry.getText().equals("") || txtCity.getText().equals("") || txtgender.getValue().equals("")) {
            WarningAlert.setContentText("Please Fill out All");
            WarningAlert.showAndWait();
            return;
        }

        if ("student".equals(combotype.getValue())) {
            Student s = new Student(txtlastname.getText(), txtFirstname.getText(), txtemail.getText(), date, Integer.parseInt(txtphone.getText()), txtCountry.getText(), txtCity.getText(), txtgender.getValue());
            ServiceStudent.ajouterStudent(s);

            InformationAlert.setContentText("Wait for confirmation mail");
            InformationAlert.showAndWait();
        } else if ("teacher".equals(combotype.getValue())) {
            teacher t = new teacher(txtlastname.getText(), txtFirstname.getText(), txtemail.getText(), date, Integer.parseInt(txtphone.getText()), txtCountry.getText(), txtCity.getText(), txtgender.getValue());
            ServiceTeacher.ajouterTeacher(t);
            InformationAlert.setContentText("Wait for confirmation mail");
            InformationAlert.showAndWait();
        }
    }

    @FXML
    private void createAcount(ActionEvent event) {
        WarningAlert.setTitle("Warning");
        WarningAlert.setHeaderText(null);
        InformationAlert.setTitle("Account");
        InformationAlert.setHeaderText("Results:");
        if ("".equals(txtQrCode.getText()) || "".equals(txtimage.getText()) || "".equals(txtpassword.getText()) || "".equals(txtusername.getText())) {
            WarningAlert.setContentText("Please Fill out All");
            WarningAlert.showAndWait();
            return;
        }
        if (!txtpassword.getText().equals(txtconformation.getText()) || txtpassword.getText().equals("")) {

            WarningAlert.setContentText("Password not matched");
            WarningAlert.showAndWait();
            return;

        }

        if (ServiceUsers.QrcodeisUsed(txtQrCode.getText()) == 1) {
            WarningAlert.setContentText("Qr Code is aleardy used");
            WarningAlert.showAndWait();
            return;
        }

        if (ServiceUsers.ajouterAccount(txtusername.getText(), txtimage.getText(), CryptServices.encrypt(txtpassword.getText(), CryptServices.getSecretKey()), txtQrCode.getText())) {
            Alert succDeleteBookAlert = new Alert(Alert.AlertType.INFORMATION);

            InformationAlert.setContentText("Account created successfully!");
            InformationAlert.showAndWait();

        } else {

            WarningAlert.setContentText("Username is aleardy used");
            WarningAlert.showAndWait();
            return;

        }
    }

    @FXML
    private void Signin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Loginpage.fxml"));
            Parent root = loader.load();
            LoginpageController spc = loader.getController();
            txtpassword.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(LoginpageController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void uploadimage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String imageFile = "";
        File f = fc.showOpenDialog(null);

        if (f != null) {
            imageFile = f.getAbsolutePath();
            txtimage.setText(imageFile);
        }
    }

}
