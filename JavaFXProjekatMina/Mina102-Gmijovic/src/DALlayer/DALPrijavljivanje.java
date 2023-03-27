/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DALPrijavljivanje {
    
    /**
     * //Proverava iz tabele korisnici podatke na mestima username i password; ako se podudaraju moze se dalje pristupiti projektu
     * @param username
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    
    public int Login(String username, String password) throws ClassNotFoundException, SQLException{
        Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();
        
        String upit = "Select * From korisnici Where Username = ? and Password = ? ";
        PreparedStatement ps = kon.prepareStatement(upit);
        ps.setString(1, username);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        int count = 0;
        int id = 0;
        while(rs.next()){
            count ++;
            id = rs.getInt("IDkorisnika");
        }
        return id;
    }
    
}
