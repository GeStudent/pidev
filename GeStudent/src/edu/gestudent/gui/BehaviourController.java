/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import edu.gestudent.entities.Behaviour;
import edu.gestudent.services.behaviourCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ToolBar;
import javax.swing.JFrame;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class BehaviourController implements Initializable {

    @FXML
    private ToolBar ToolBar;

    /**
     * Initializes the controller class.
     */
     static JFrame f;
    behaviourCRUD bhcr = new behaviourCRUD();
        public ObservableList<Behaviour> data = FXCollections.observableArrayList();
    @FXML


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //  data.addAll(bhcr.afficherBehaviour());
        
    }

    @FXML
    private void Timer(ActionEvent event) throws IOException {
        Timer6 t=new Timer6();
 //f=new JFrame();
 t.setVisible(true);
    }
    @FXML
    private void Award(ActionEvent event) {
    }
    
}
