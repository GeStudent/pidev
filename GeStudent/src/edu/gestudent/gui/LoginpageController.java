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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ayadi
 */
public class LoginpageController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("Homepage.fxml"));
            Parent root =loader.load();
            HomepageController spc = loader.getController();
           username.getScene().setRoot(root);
           // spc.setLpmessage("Binvenue mr / mss "+txtprenom.getText()+" "+txtnom.getText());
        } catch (IOException ex) {
            Logger.getLogger(LoginpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
