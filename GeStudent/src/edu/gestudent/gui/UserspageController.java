/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import edu.gestudent.entities.Email;
import edu.gestudent.entities.Student;
import edu.gestudent.entities.teacher;
import edu.gestudent.services.ServiceStudent;
import edu.gestudent.services.ServicesTeacher;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Ayadi
 */
public class UserspageController implements Initializable {

    public ObservableList<Student> Studentdata = FXCollections.observableArrayList();
    public ObservableList<teacher> Teacherdata = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Student, String> firstname;
    @FXML
    private TableColumn<Student, String> lastname;
    @FXML
    private TableColumn<Student, String> email;
    @FXML
    private TableColumn<Student, String> birthday;

    @FXML
    private TableColumn<Student, Integer> phone;
    @FXML
    private TableColumn<Student, String> pays;
    @FXML
    private TableColumn<Student, String> gender;
    @FXML
    private TableView<Student> StudentTv;

    ServiceStudent ss = new ServiceStudent();
    ServicesTeacher st = new ServicesTeacher();
    @FXML
    private TableColumn<teacher, String> firstnameT;
    @FXML
    private TableColumn<teacher, String> lastnameT;
    @FXML
    private TableColumn<teacher, String> emailT;
    @FXML
    private TableColumn<teacher, String> birthdayT;
    @FXML
    private TableColumn<teacher, String> phoneT;
    @FXML
    private TableColumn<teacher, String> paysT;
    @FXML
    private TableColumn<teacher, String> genderT;
    @FXML
    private TableColumn<teacher, String> SalaryT;
    @FXML
    private TableView<teacher> teacherTv;
    @FXML
    private JFXComboBox<String> StudentComboBox;
    public ObservableList<String> StudentRegistred = FXCollections.observableArrayList("Restrieted Student", "None Sign Up Student");
    @FXML
    private JFXButton clickb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StudentComboBox.setItems(StudentRegistred);
        Studentdata.addAll(ss.readAllStudentRegistrated());
        Teacherdata.addAll(st.readAllTeachers());

        this.firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        this.lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.email.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.birthday.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        this.phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        this.pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        this.gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        System.err.println("StudentComboBox.getValue()");
       
        this.StudentTv.setItems(Studentdata);

        this.firstnameT.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        this.lastnameT.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.emailT.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.birthdayT.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        this.phoneT.setCellValueFactory(new PropertyValueFactory<>("phone"));
        this.paysT.setCellValueFactory(new PropertyValueFactory<>("pays"));
        this.genderT.setCellValueFactory(new PropertyValueFactory<>("gender"));
        this.SalaryT.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        this.teacherTv.setItems(Teacherdata);

        // TODO
    }

    @FXML
    private void decline(ActionEvent event) {
    }

    @FXML
    private void accpetStudent(ActionEvent event) {

        Email email = new Email();
        HashMap<String, String> message = new HashMap<String, String>();
        message.put("Title", "bg.getTitle()");
        message.put("UpdatedAt", "bg.getUpdatedAt().toString()");
        message.put("Description", "bg.getDescription()");
        message.put("Content", "bg.getContent()");
        try {

            email.sendEmail("ayadiyassine21@gmail.com", "Nouveau Blog", message);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void clickb(ActionEvent event) {
         if (StudentComboBox.getValue().equals("Restrieted Student")) {
            Studentdata.clear();
            Studentdata.addAll(ss.readAllStudentRegistrated());
            System.out.println("0");
            this.StudentTv.setItems(Studentdata);

        } else if (StudentComboBox.getValue().equals("None Sign Up Student")) {

            Studentdata.clear();
            System.out.println("1");
            Studentdata.addAll(ss.readAllStudentNotRegistrated());
            this.StudentTv.setItems(Studentdata);

        }
    }

}
