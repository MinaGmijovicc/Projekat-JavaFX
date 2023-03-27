/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author User
 */
public class DALDodatnaOprema {
    /**
     * //Upisuje u bazu vrednosti koje unesemo u textfield(cene za dodatnu opremu)
     * @param IDbrendAuta
     * @param letnjeGume
     * @param zimskeGume
     * @param krovniKofer
     * @param nosac
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void dodajDodatnuOpremu(int IDbrendAuta, double letnjeGume, double zimskeGume, double krovniKofer, double nosac) throws ClassNotFoundException, SQLException{
         Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();
        
        String upit = "INSERT INTO dodatnaoprema (IDbrendAuta, LetnjeGume, ZimskeGume, KrovniKofer, NosacZaBicikle) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = kon.prepareStatement(upit);
        ps.setInt(1, IDbrendAuta);
        if(letnjeGume == -1){
            ps.setNull(2, Types.DOUBLE);
        
        }else{
            ps.setDouble(2, letnjeGume);
        }
        if(zimskeGume == -1){
            ps.setNull(3, Types.DOUBLE);
        
        }else{
            ps.setDouble(3, zimskeGume);
        }
        if(krovniKofer == -1){
            ps.setNull(4, Types.DOUBLE);
        
        }else{
            ps.setDouble(4, krovniKofer);
        }
        if(nosac == -1){
            ps.setNull(5, Types.DOUBLE);
        
        }else{
            ps.setDouble(5, nosac);
        }
        
        ps.executeUpdate();
    }
    
}
