/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesto;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DodavanjeAutaController implements Initializable {

    @FXML
    private ComboBox<BrendAuta> cmbbrend;
    @FXML
    private TextField txtmodel;
    @FXML
    private TextField txtboja;
    @FXML
    private TextField txtcena;
    @FXML
    private Button btndodaj;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            popuniComboBox();
            cmbbrend.getSelectionModel().selectFirst();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DodavanjeAutaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DodavanjeAutaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void popuniComboBox() throws ClassNotFoundException, SQLException {
        DALModeliAuta modeli = new DALModeliAuta();

        ArrayList<BrendAuta> lista = modeli.dajSveBrendove();
        ObservableList<BrendAuta> list = FXCollections.observableArrayList(lista);

        cmbbrend.setItems(list);

    }

    /**
     * //Dodaje vrednosti od strane korisnika u tabelu modelautomobila u bazi
     * @param event
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @FXML
    private void btndodajklik(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(txtmodel.getText().equals("") || txtboja.getText().equals("") || txtcena.getText().equals("")){
        
         Alert poruka=new Alert(Alert.AlertType.ERROR,"MORATE POPUNITI SVA POLJA!");
        poruka.showAndWait();
        }
        else{
        
        
        DALModeliAuta modeli = new DALModeliAuta();     
        modeli.dodajBrend(cmbbrend.getValue().getIDbrendAuta(), txtmodel.getText(), txtboja.getText(), txtcena.getText());
        Alert poruka=new Alert(Alert.AlertType.INFORMATION,"Uspesno ste dodali auto u bazu!");
        poruka.showAndWait();
        }
        
    }
}
