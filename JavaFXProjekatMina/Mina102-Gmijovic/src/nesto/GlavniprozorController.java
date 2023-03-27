/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesto;

import DALlayer.DALModeliAuta;
import EntitySloj.ModeliAuta;
import EntitySloj.StaticniPodaci;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
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
public class GlavniprozorController implements Initializable {
    
    @FXML
    private Button btnautomobili;
    @FXML
    private ListView<ModeliAuta> listavozila;
    @FXML
    private Button btnbrisanje;
    @FXML
    private Button btndodajbrend;
    @FXML
    private Button btnizmeni;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            prikazi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GlavniprozorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GlavniprozorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // btnautomobili = new Button("Prikazi");
    //btn.setOnAction(e -> buttonClicked());

    @FXML
    private void prikaziautomobile(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        prikazi();
        
    }
/**
 * //Omogucava prikazivanje liste automobila u listview-u
 * @throws ClassNotFoundException
 * @throws SQLException 
 */
    public void prikazi() throws ClassNotFoundException, SQLException {
        DALModeliAuta modeli = new DALModeliAuta();
        
        listavozila.getItems().clear();
        ArrayList<ModeliAuta> lista = modeli.listaAutomobila();
        ObservableList<ModeliAuta> list = FXCollections.observableArrayList(lista);
        
        listavozila.setItems(list);
    }
    
    /**
     * //Omogucava brisanje selektovanog automobila iz baze klikom na dugme preko ID-a
     * @param event
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @FXML
    private void btnbrisanjeklik(ActionEvent event) throws ClassNotFoundException, SQLException {
        int ID = listavozila.getSelectionModel().getSelectedItem().getIDmodelAuta();
        
        DALModeliAuta modeli = new DALModeliAuta();
        modeli.obrisiVozilo(ID);
        prikazi();
    }
    
    /**
     * //Omogucava otvaranje novog prozora DodavanjeAuta.fxml
     * @param event 
     */
    @FXML
    private void btndodajbrendklik(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("DodavanjeAuta.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load(), 420, 350);
            Stage stage = new Stage();
            stage.setTitle("Dodaj auto");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            
        }
    }
    
    /**
     * //Omogucava otvaranje novog prozora IzmenaAuta.fxml
     * @param event 
     */
    @FXML
    private void btnizmeniklik(ActionEvent event) {
        
        try {
            StaticniPodaci.IDautomobila = listavozila.getSelectionModel().getSelectedItem().getIDmodelAuta();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("IzmenaAuta.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load(), 480, 400);
            Stage stage = new Stage();
            stage.setTitle("Izmenite auto");
            stage.setScene(scene);
           // IzmenaAutaController temp = fxmlLoader.getController();
           // temp.setIDmodela(listavozila.getSelectionModel().getSelectedItem().getIDmodelAuta());
            stage.show();
        } catch (IOException e) {
            
        }
    }
    
    
}
