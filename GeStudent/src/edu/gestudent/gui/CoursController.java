/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import edu.gestudent.entities.classe;
import edu.gestudent.entities.cours;
import edu.gestudent.services.classCRUD;
import edu.gestudent.services.coursCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author CHIKHAOUI NOUHA 1
 */
public class CoursController implements Initializable {

    coursCRUD cr = new coursCRUD();
    classCRUD c = new classCRUD();
    @FXML
    private TextField nametxt;
    @FXML
    private TextField lessontxt;
    @FXML
    private TextField durationtxt;
    @FXML
    private TableView<cours> tabviewcours;
    @FXML
    private TableColumn<cours, String> name;
    @FXML
    private TableColumn<cours, String> lesson;
    @FXML
    private TableColumn<cours, Integer> duration;
    public ObservableList<cours> data = FXCollections.observableArrayList();
       public ObservableList<classe> dataa = FXCollections.observableArrayList();
    @FXML
    private TextField namectxt;
    @FXML
    private TableView<classe> tableviewclass;
    @FXML
    private TableColumn<classe, String> nameC;
    @FXML
    private Button coursclasse;

    
    
    
    /*public coursCRUD getCr() {
        return cr;
    }

    public void setCr(coursCRUD cr) {
        this.cr = cr;
    }

    public TextField getNametxt() {
        return nametxt;
    }

    public void setNametxt(TextField nametxt) {
        this.nametxt = nametxt;
    }

    public TextField getLessontxt() {
        return lessontxt;
    }

    public void setLessontxt(TextField lessontxt) {
        this.lessontxt = lessontxt;
    }

    public TextField getDurationtxt() {
        return durationtxt;
    }

    public void setDurationtxt(TextField durationtxt) {
        this.durationtxt = durationtxt;
    }

    public TableView<cours> getTabviewcours() {
        return tabviewcours;
    }

    public void setTabviewcours(TableView<cours> tabviewcours) {
        this.tabviewcours = tabviewcours;
    }

    public TableColumn<cours, String> getName() {
        return name;
    }

    public void setName(TableColumn<cours, String> name) {
        this.name = name;
    }

    public TableColumn<cours, String> getLesson() {
        return lesson;
    }

    public void setLesson(TableColumn<cours, String> lesson) {
        this.lesson = lesson;
    }

    public TableColumn<cours, Integer> getDuration() {
        return duration;
    }

    public void setDuration(TableColumn<cours, Integer> duration) {
        this.duration = duration;
    }

    public ObservableList<cours> getData() {
        return data;
    }

    /**
     * Initializes the controller class.
     *
     * @return
     */
   

    public int getdurationtxt() {
        return Integer.parseInt(durationtxt.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data.addAll(cr.readAll());

        this.name.setCellValueFactory(new PropertyValueFactory<>("name"));

        this.lesson.setCellValueFactory(new PropertyValueFactory<>("lesson"));

        this.duration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        this.tabviewcours.setItems(data);
      //  System.out.println(data.get(1).getlesson());
        
        try {
            dataa.addAll(c.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.nameC.setCellValueFactory(new PropertyValueFactory<>("nameC"));

      

        this.tableviewclass.setItems(dataa);
      //  System.out.println(data.get(1).getName());

        // TODO
    }

    @FXML
    private void Addcours(ActionEvent event) throws SQLException {
        cours c = new cours(nametxt.getText(), lessontxt.getText(), getdurationtxt());
        cr.ajouter(c);
    }

    @FXML
    private void addclass(ActionEvent event) throws SQLException {
             classe cl = new classe(namectxt.getText());
        c.ajouter(cl);
    }
    
    
    
    
     /*  private void Interfacecoursclass(ActionEvent event) {
        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("Librarypage.fxml"));
            Parent root =loader.load();
            LibrarypageController spc = loader.getController();
            librarybutton.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */

  
    
}

