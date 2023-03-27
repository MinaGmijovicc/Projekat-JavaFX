/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesto;

import DALlayer.DALPrijavljivanje;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnlogin;
    @FXML
    private TextField txtusername;
    @FXML
    private TextField txtpassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * //Proverava ispravnost user-a i pass-a sa podacima iz baze i omogucava otvaranje novog prozora ako su ispravni
     * @param event
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException 
     */
    @FXML
    private void btnloginclick(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        DALPrijavljivanje dal = new DALPrijavljivanje();
        int id = dal.Login(txtusername.getText(), txtpassword.getText());

        if (id == 0) {
            Alert obavestenje = new Alert(Alert.AlertType.INFORMATION, "Pogresili ste username/password!");
            obavestenje.show();
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Meni.fxml"));

                Scene scene = new Scene(fxmlLoader.load(), 600, 370);
                Stage stage = new Stage();
                stage.setTitle("Meni");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {

            }

        }
    }
}

