/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALlayer;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Connection;


/**
 *
 * @author User
 */
public class Konekcija {
    public Connection kon1 = null;

    public Konekcija() {
    }
    
    /**
     * //Metoda koja omogucava konekciju sa bazom podataka 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Connection openConnection () throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        kon1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/salonautomobila", "root", "");
        return kon1;
    }
    public void CloseConnection() throws SQLException{
        kon1.close();
    }
}
