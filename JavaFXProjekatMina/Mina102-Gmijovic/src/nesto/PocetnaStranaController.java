/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesto;

import DALlayer.DALModeliAuta;
import EntitySloj.ModeliAuta;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PocetnaStranaController implements Initializable {

    @FXML
    private ListView<ModeliAuta> listviewpocetna;
    @FXML
    private Button btnosvezi;
    @FXML
    private Button btnulogujse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            prikazi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PocetnaStranaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PocetnaStranaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    /**
     * //Klikom na dugme otvara Login karticu
     * @param event 
     */
    @FXML
    private void ulogujse(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Login.fxml"));

                Scene scene = new Scene(fxmlLoader.load(), 400, 300);
                Stage stage = new Stage();
                stage.setTitle("Ulogujte se");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {

            }
    }

    /**
     * 
     * @param event
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @FXML
    private void prikaziSve(ActionEvent event) throws ClassNotFoundException, SQLException {
       prikazi();
      
    }
         public void prikazi() throws ClassNotFoundException, SQLException{
        DALModeliAuta modeli = new DALModeliAuta();
       
       
       listviewpocetna.getItems().clear();
       ArrayList<ModeliAuta> lista = modeli.listaAutomobila();
      ObservableList<ModeliAuta> olista = FXCollections.observableArrayList(lista);
       
       listviewpocetna.setItems(olista);
    }
    }
    

