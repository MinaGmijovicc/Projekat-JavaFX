/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesto;

import DALlayer.DALDodatnaOprema;
import DALlayer.DALModeliAuta;
import EntitySloj.BrendAuta;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DodatnaOpremaController implements Initializable {

    @FXML
    private ChoiceBox<BrendAuta> cboxbrendovi;
    @FXML
    private Button btnsacuvaj;
    @FXML
    private CheckBox chletnjegume;
    @FXML
    private CheckBox chzimskegume;
    @FXML
    private CheckBox chkrovnikofer;
    @FXML
    private CheckBox chnosac;
    @FXML
    private TextField txtletnjegume;
    @FXML
    private TextField txtzimskegume;
    @FXML
    private TextField txtkrovnikofer;
    @FXML
    private TextField txtnosac;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            popuniCombobox();
            cboxbrendovi.getSelectionModel().selectFirst();
            txtletnjegume.setDisable(true);
            txtzimskegume.setDisable(true);
            txtkrovnikofer.setDisable(true);
            txtnosac.setDisable(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DodatnaOpremaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DodatnaOpremaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    /**
     * //Popunjava combobox sa listom brendova auta
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void popuniCombobox() throws ClassNotFoundException, SQLException {
        DALModeliAuta modeli = new DALModeliAuta();

        ArrayList<BrendAuta> lista = modeli.dajSveBrendove();
        ObservableList<BrendAuta> list = FXCollections.observableArrayList(lista);

        cboxbrendovi.setItems(list);

    }
    
/**
 * //Metoda koja klikom na dugme unosi podatke o dodatnoj opremi u bazu 
 * @param event
 * @throws ClassNotFoundException
 * @throws SQLException 
 */
    @FXML
    private void btnsacujavklik(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
            
        
        DALDodatnaOprema oprema = new DALDodatnaOprema();
        double letnjeGume = -1;
        if(chletnjegume.isSelected()){
            letnjeGume = Double.parseDouble(txtletnjegume.getText());
        }
        double zimskeGume = -1;
        if(chzimskegume.isSelected()){
            zimskeGume = Double.parseDouble(txtzimskegume.getText());
        }
        double krovniKofer = -1;
        if(chkrovnikofer.isSelected()){
            krovniKofer = Double.parseDouble(txtkrovnikofer.getText());
        }
        double nosac = -1;
        if(chnosac.isSelected()){
            nosac = Double.parseDouble(txtnosac.getText());
        }
        int idBrend = cboxbrendovi.getSelectionModel().getSelectedItem().getIDbrendAuta();
        
        oprema.dodajDodatnuOpremu(idBrend, letnjeGume, zimskeGume, krovniKofer, nosac);
        Alert poruka=new Alert(Alert.AlertType.INFORMATION,"Uspesno dodato u bazu!");
        poruka.showAndWait();
        }catch(Exception ex ){
             Alert poruka=new Alert(Alert.AlertType.ERROR,"Ispravno unesite cene!");
        poruka.showAndWait();
        }
    }
    
/**
 * //Ako je checkbox selektovan-pojavljuje se text field polje dostupno za unos texta
 * @param event 
 */
    @FXML
    private void chletnjegumeklik(ActionEvent event) {
        if(chletnjegume.isSelected()){
            txtletnjegume.setDisable(false);
        }else{
            txtletnjegume.setDisable(true);
        }
    }

    @FXML
    private void chzimskegumeklik(ActionEvent event) {
        if(chzimskegume.isSelected()){
            txtzimskegume.setDisable(false);
        }else{
            txtzimskegume.setDisable(true);
        }
    }

    @FXML
    private void chkrovnikoferklik(ActionEvent event) {
        if(chkrovnikofer.isSelected()){
            txtkrovnikofer.setDisable(false);
        }else{
            txtkrovnikofer.setDisable(true);
        }
    }

    @FXML
    private void chnosacklik(ActionEvent event) {
        if(chnosac.isSelected()){
            txtnosac.setDisable(false);
        }else{
            txtnosac.setDisable(true);
        }
    }
    
}
