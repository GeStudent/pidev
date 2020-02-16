/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import edu.gestudent.entities.Livre;
import edu.gestudent.services.LivreCrud;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
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
public class LibrarypageController implements Initializable {

    LivreCrud lcr = new LivreCrud();

    @FXML
    private TextField txtname;
    @FXML
    private TextField txtimage;
    @FXML
    private TextField txtauthor;
    @FXML
    private TextField txturl;
    @FXML
    private TextField categorie;
    @FXML
    private TextField txtquantity;
    @FXML
    private Button ReturnButton;
  
    @FXML
    private TableColumn<Livre, String> name;
    @FXML
    private TableColumn<Livre, String>  image;
    @FXML
    private TableColumn<Livre, String> author;
    @FXML
    private TableColumn<Livre, String>  url;
   
    @FXML
    private TableColumn<Livre, String>  quantity;

    public ObservableList<Livre> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Livre> librarytv;
    @FXML
    private TableColumn<Livre, String>  categiries;

    

   

    public int getTxtquantity() {
        return Integer.parseInt(txtquantity.getText());
    }

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            data.addAll(lcr.afficherlivre());
            this.author.setCellValueFactory(new PropertyValueFactory<>("author"));
            this.categiries.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.quantity.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            this.image.setCellValueFactory(new PropertyValueFactory<>("image"));
            this.url.setCellValueFactory(new PropertyValueFactory<>("url"));
            
        this.librarytv.setItems(data);

        // TODO

    }

    @FXML
    private void addBook(ActionEvent event) {
        Livre l = new Livre(txtname.getText(), txtimage.getText(), txtauthor.getText(), txturl.getText(), categorie.getText(), getTxtquantity());
        lcr.ajouterLivre(l);

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

  

}
