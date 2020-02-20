/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import edu.gestudent.entities.Livre;
import edu.gestudent.services.LivreCrud;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

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
    private TextField categorie;
    @FXML
    private TextField txtquantity;
    @FXML
    private Button ReturnButton;

    @FXML
    private TableColumn<Livre, String> name;
    @FXML
    private TableColumn<Livre, String> image;
    @FXML
    private TableColumn<Livre, String> author;
    @FXML
    private TableColumn<Livre, String> url;
    @FXML
    private TableColumn<Livre, Integer> quantity;

    public ObservableList<Livre> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Livre> librarytv;
    @FXML
    private TableColumn<Livre, String> categiries;
    @FXML
    private ComboBox<String> combocategorie;
    public ObservableList<String> categorieff = FXCollections.observableArrayList("Comedy", "Drama", "Action", "History", "Thriller", "Romantic", "Biography");
    @FXML
    private TextField searchTF;

    public int getTxtquantity() {
        return Integer.parseInt(txtquantity.getText());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combocategorie.setItems(categorieff);
        data.addAll(lcr.afficherlivre());
        this.author.setCellValueFactory(new PropertyValueFactory<>("author"));
        this.categiries.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.quantity.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        this.image.setCellValueFactory(new PropertyValueFactory<>("image"));
        this.url.setCellValueFactory(new PropertyValueFactory<>("url"));

        this.librarytv.setItems(data);

        //this for edit
        this.librarytv.setEditable(true);
        this.categiries.setCellFactory(TextFieldTableCell.forTableColumn());
        this.quantity.setCellFactory(TextFieldTableCell.<Livre, Integer>forTableColumn(new IntegerStringConverter()));
        this.image.setCellFactory(TextFieldTableCell.forTableColumn());
        this.url.setCellFactory(TextFieldTableCell.forTableColumn());

        // TODO
    }

    @FXML
    private void addBook(ActionEvent event) {
        Livre l = new Livre(txtname.getText(), txtimage.getText(), txtauthor.getText(), txturl.getText(), combocategorie.getValue(), getTxtquantity());
        lcr.ajouterLivre(l);
        Alert succAddBookAlert = new Alert(Alert.AlertType.INFORMATION);
        succAddBookAlert.setTitle("Add book");
        succAddBookAlert.setHeaderText("Results:");
        succAddBookAlert.setContentText("Book added successfully!");
        succAddBookAlert.showAndWait();

        data.clear();
        data.addAll(lcr.afficherlivre());

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
    private void select(ActionEvent event) {
        Livre L = librarytv.getSelectionModel().getSelectedItem();
        txtname.setText(L.getName());
        txtimage.setText(L.getImage());
        txtauthor.setText(L.getAuthor());
        txturl.setText(L.getUrl());
        categorie.setText(L.getCategorie());
        txtquantity.setText(String.valueOf(L.getQuantite()));
    }

    @FXML
    private void DeleteAction(ActionEvent event) {

        if (librarytv.getSelectionModel().getSelectedItem() != null) {
            Alert deleteBookAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteBookAlert.setTitle("Delete book");
            deleteBookAlert.setHeaderText(null);
            deleteBookAlert.setContentText("Are you sure that you want to delete this book ?");
            Optional<ButtonType> optionDeleteBookAlert = deleteBookAlert.showAndWait();
            if (optionDeleteBookAlert.get() == ButtonType.OK) {
                Livre L = librarytv.getSelectionModel().getSelectedItem();
                lcr.supprimerlivre(L);
                data.clear();
                data.addAll(lcr.afficherlivre());

                //Alert Delete Blog :
                Alert succDeleteBookAlert = new Alert(Alert.AlertType.INFORMATION);
                succDeleteBookAlert.setTitle("Delete Blog");
                succDeleteBookAlert.setHeaderText("Results:");
                succDeleteBookAlert.setContentText("Book deleted successfully!");

                succDeleteBookAlert.showAndWait();
            } else if (optionDeleteBookAlert.get() == ButtonType.CANCEL) {

            }

        } else {

            //Alert Select BOOK :
            Alert selectBookAlert = new Alert(Alert.AlertType.WARNING);
            selectBookAlert.setTitle("Select a book");
            selectBookAlert.setHeaderText(null);
            selectBookAlert.setContentText("You need to select a book first!");
            selectBookAlert.showAndWait();
            //Alert Select Book !

        }
    }

    @FXML
    private void EditAction(ActionEvent event) {

        if (librarytv.getSelectionModel().getSelectedItem() != null) {

            Livre l = librarytv.getSelectionModel().getSelectedItem();

            lcr.Update(l.getName(), l.getImage(), l.getUrl(), l.getCategorie(), l.getQuantite());
            Alert BookAlert = new Alert(Alert.AlertType.INFORMATION);
            BookAlert.setTitle("edit");
            BookAlert.setHeaderText(null);
            BookAlert.setContentText("The book was successfully edit");
            BookAlert.showAndWait();

        } else {
            //Alert Select BOOK :
            Alert selectBookAlert = new Alert(Alert.AlertType.WARNING);
            selectBookAlert.setTitle("Select a book");
            selectBookAlert.setHeaderText(null);
            selectBookAlert.setContentText("You need to select a book first!");
            selectBookAlert.showAndWait();
            //Alert Select Book !
        }
    }

    @FXML
    public void changeImageCellEvent(CellEditEvent edittedCell
    ) {
        Livre LivreSelected = librarytv.getSelectionModel().getSelectedItem();
        LivreSelected.setImage(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeCategoriesCellEvent(CellEditEvent edittedCell
    ) {
        Livre LivreSelected = librarytv.getSelectionModel().getSelectedItem();
        LivreSelected.setCategorie(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeAuthorCellEvent(CellEditEvent edittedCell
    ) {
        Livre LivreSelected = librarytv.getSelectionModel().getSelectedItem();
        LivreSelected.setAuthor(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeUrlCellEvent(CellEditEvent edittedCell
    ) {
        Livre LivreSelected = librarytv.getSelectionModel().getSelectedItem();
        LivreSelected.setUrl(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeQuantityCellEvent(CellEditEvent edittedCell
    ) {
        Livre LivreSelected = librarytv.getSelectionModel().getSelectedItem();
        LivreSelected.setQuantite(Integer.parseInt(edittedCell.getNewValue().toString()));
    }

    @FXML
    private void upload(ActionEvent event) {

        FileChooser fc = new FileChooser();
        String imageFile = "";
        File f = fc.showOpenDialog(null);

        if (f != null) {
            imageFile = f.getAbsolutePath();
            txtimage.setText(imageFile);
        }
    }

    @FXML
    private void filter(ActionEvent event) {
        data.clear();
        // System.out.println("heyy yuuu");
        data.addAll(lcr.afficherlivre().stream().filter((art)
                -> art.getName().toLowerCase().contains(searchTF.getText().toLowerCase())
                || art.getAuthor().toLowerCase().contains(searchTF.getText().toLowerCase())
                || art.getCategorie().toLowerCase().contains(searchTF.getText().toLowerCase())
        //                || Integer.toString(art.getPrixAchat()).equals(searchTF.getText())
        //                || Integer.toString(art.getPrixVente()).equals(searchTF.getText())

        //kahaw naamel recherche keen aala 3 hedhoukom wel be9i ?zeyed  okk
        ).collect(Collectors.toList()));
    }

}
