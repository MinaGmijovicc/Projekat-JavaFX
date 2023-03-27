/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesto;

import DALlayer.DALModeliAuta;
import EntitySloj.BrendAuta;
import EntitySloj.ModelBrend;
import EntitySloj.StaticniPodaci;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class IzmenaAutaController implements Initializable {

    @FXML
    private ComboBox<BrendAuta> cmbbrendovi;
    @FXML
    private TextField txtmodel;
    @FXML
    private TextField txtboja;
    @FXML
    private TextField txtcena;
    @FXML
    private Button btnizmenipodatke;
   

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cmbbrendovi.getSelectionModel().selectFirst();
            popuniComboBox();
            popuniPolja();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IzmenaAutaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IzmenaAutaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popuniComboBox() throws ClassNotFoundException, SQLException {
        DALModeliAuta modeli = new DALModeliAuta();

        ArrayList<BrendAuta> lista = modeli.dajSveBrendove();
        ObservableList<BrendAuta> list = FXCollections.observableArrayList(lista);

        cmbbrendovi.setItems(list);

    }

    /**
     * //Prikazuje podatke selektovanog automobila u textfield-ovima, spremne za izmenu 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void popuniPolja() throws ClassNotFoundException, SQLException {
        DALModeliAuta modeli = new DALModeliAuta();
        ModelBrend mb = modeli.dajAutoPrekoID(StaticniPodaci.IDautomobila);
        txtmodel.setText(mb.getModelAuta());
        txtboja.setText(mb.getBojaAuta());
        txtcena.setText(mb.getCena());

    }

    /**
     * //Uzima iz textfield-ova izmenjene podatke i cuva ih u bazi
     * @param event
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @FXML
    private void btnIzmeniOnKlik(ActionEvent event) throws ClassNotFoundException, SQLException {
        DALModeliAuta modeli = new DALModeliAuta();
        modeli.izmeniAuto(StaticniPodaci.IDautomobila, cmbbrendovi.getSelectionModel().getSelectedItem().getIDbrendAuta(), txtmodel.getText(), txtboja.getText(), txtcena.getText());
         Alert poruka=new Alert(Alert.AlertType.INFORMATION,"USPESNO STE IZMENILI AUTO!");
        poruka.showAndWait();
        
    }
}
