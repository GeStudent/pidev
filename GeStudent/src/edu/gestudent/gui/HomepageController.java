/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Ayadi
 */
public class HomepageController implements Initializable {

    @FXML
    private Button librarybutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void InterfaceLibrary(ActionEvent event) {
        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("Librarypage.fxml"));
            Parent root =loader.load();
            LibrarypageController spc = loader.getController();
            librarybutton.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClubAction(ActionEvent event) {
    }

    @FXML
    private void UsersAction(ActionEvent event) {
          try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("Userspage.fxml"));
            Parent root =loader.load();
            UserspageController spc = loader.getController();
            librarybutton.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RestaurantsAction(ActionEvent event) {
    }
    
    
}
