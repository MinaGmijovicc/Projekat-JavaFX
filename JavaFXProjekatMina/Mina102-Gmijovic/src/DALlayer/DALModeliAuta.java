/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALlayer;

import EntitySloj.BrendAuta;
import EntitySloj.ModelBrend;
import EntitySloj.ModeliAuta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class DALModeliAuta {

    /**
     * //Ispisuje listu automobila u listview-u uzimajuci podatke iz baze koji su zadati u SQL upitu
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public ArrayList<ModeliAuta> listaAutomobila() throws ClassNotFoundException, SQLException {
        Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();

        String upit = "Select mo.IDmodelAuta, br.NazivBrenda, mo.modelauta, mo.BojaAuta, mo.Cena From modeliauta as mo inner join brendauta as br on mo.IDbrendAuta = br.IDbrendAuta ";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<ModeliAuta> lista = new ArrayList<>();
        while (rs.next()) {
            int idModela = rs.getInt("IDmodelAuta");

            String nazivBrenda = rs.getString("NazivBrenda");
            String model = rs.getString("modelauta");
            String Boja = rs.getString("BojaAuta");
            String Cena = rs.getString("Cena");

            ModeliAuta mo = new ModeliAuta(idModela, nazivBrenda, model, Boja, Cena);
            lista.add(mo);

        }
        kon.close();
        return lista;
    }

    /**
     * //Brise selektovano vozilo preko IDmodelAuta iz baze 
     * @param IDbrendAuta
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void obrisiVozilo(int IDbrendAuta) throws ClassNotFoundException, SQLException {
        Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();

        String upit = "Delete FROM modeliauta where IDmodelAuta = ? ";
        PreparedStatement ps = kon.prepareStatement(upit);
        ps.setInt(1, IDbrendAuta);
        ps.executeUpdate();
        kon.close();

    }

    /**
     * //Metoda koja sluzi za popunjavanje combobox-ova sa brendovima automobila
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public ArrayList<BrendAuta> dajSveBrendove() throws ClassNotFoundException, SQLException {
        Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();

        String upit = "Select IDbrendAuta, NazivBrenda From brendauta";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<BrendAuta> lista = new ArrayList<>();

        while (rs.next()) {
            int IDbrendAuta = rs.getInt("IDbrendAuta");
            String NazivBrenda = rs.getString("NazivBrenda");

            lista.add(new BrendAuta(IDbrendAuta, NazivBrenda));

        }
        kon.close();
        return lista;
    }
    
    /**
     * //Dodaje novo vozilo u tabelu modelauta
     * @param IDbrendAuta
     * @param ModelAuta
     * @param BojaAuta
     * @param Cena
     * @throws ClassNotFoundException
     * @throws SQLException 
     */

    public void dodajBrend(int IDbrendAuta, String ModelAuta, String BojaAuta, String Cena) throws ClassNotFoundException, SQLException {
        Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();

        String upit = "INSERT INTO modeliauta (IDbrendAuta, ModelAuta, BojaAuta, Cena) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = kon.prepareStatement(upit);

        ps.setInt(1, IDbrendAuta);
        ps.setString(2, ModelAuta);
        ps.setString(3, BojaAuta);
        ps.setString(4, Cena);

        ps.executeUpdate();
        kon.close();

    }
    
    /**
     * //Metoda za pribavljanje IDmodelAuta koja mi sluzi za pozivanje u drugim klasama
     * @param IDmodelAuta
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */

    public ModelBrend dajAutoPrekoID(int IDmodelAuta) throws ClassNotFoundException, SQLException {
        Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();

        String upit = "SELECT IDmodelAuta, IDbrendAuta, ModelAuta, BojaAuta, Cena FROM modeliauta WHERE IDmodelAuta = ? ";
        PreparedStatement ps = kon.prepareStatement(upit);
        ps.setInt(1, IDmodelAuta);
        ResultSet rs = ps.executeQuery();
        ModelBrend novi = null;
        while (rs.next()) {

            int IDbrendAuta = rs.getInt("IDbrendAuta");
            String ModelAuta = rs.getString("ModelAuta");
            String BojaAuta = rs.getString("BojaAuta");
            String Cena = rs.getString("Cena");

            novi = new ModelBrend(IDmodelAuta, IDbrendAuta, ModelAuta, BojaAuta, Cena);
        }
        kon.close();
        return novi;

    }
/**
 * //Metoda koja update-uje tabelu modelauta u bazi tako sto uzima postojece podatke, menja ih i opet cuva u bazi
 * @param IDmodelAuta
 * @param IDbrendAuta
 * @param ModelAuta
 * @param BojaAuta
 * @param Cena
 * @throws ClassNotFoundException
 * @throws SQLException 
 */
    public void izmeniAuto(int IDmodelAuta, int IDbrendAuta, String ModelAuta, String BojaAuta, String Cena) throws ClassNotFoundException, SQLException {
        Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();

        String upit = "UPDATE modeliauta SET IDbrendAuta = ?, ModelAuta = ?, BojaAuta = ?, Cena = ? WHERE IDmodelAuta = ? ";
        PreparedStatement ps = kon.prepareStatement(upit);
        ps.setInt(1, IDbrendAuta);
        ps.setString(2, ModelAuta);
        ps.setString(3, BojaAuta);
        ps.setString(4, Cena);
        ps.setInt(5, IDmodelAuta);

        ps.executeUpdate();
        kon.close();
    }
/**
 * //Metoda za JUnit testove koja pribavlja ID poslednjeg ubacenog modela auta u bazu
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException 
 */
    public int dajPoslednjiID() throws ClassNotFoundException, SQLException {
        Konekcija konekcija = new Konekcija();
        Connection kon = konekcija.openConnection();
        String upit = "SELECT MAX(IDmodelAuta) AS ID FROM modeliauta";
        PreparedStatement ps = kon.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        int ID = 0;
        while (rs.next()) {
            ID = rs.getInt("ID");
        }
        kon.close();
        return ID;
    }
}
