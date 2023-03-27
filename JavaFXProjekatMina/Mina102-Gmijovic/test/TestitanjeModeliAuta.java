/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DALlayer.DALModeliAuta;
import EntitySloj.ModeliAuta;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TestitanjeModeliAuta {

    public TestitanjeModeliAuta() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    /**
     * //Proverava da li se u listi nalazi zadati br automobila
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test
    public void testiranjeListeVozila() throws ClassNotFoundException, SQLException {
        DALModeliAuta modeli = new DALModeliAuta();
        ArrayList<ModeliAuta> lista = modeli.listaAutomobila();
        assertEquals(8, lista.size());
        
    }
    
    /**
     * //Testira rad metode koja dodaje vozilo u listu sa vozilima
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test
    public void testDodajVozilo() throws ClassNotFoundException, SQLException{
        DALModeliAuta modeli = new DALModeliAuta();
        modeli.dodajBrend(2, "X1", "Plava", "10000");
        ArrayList<ModeliAuta> lista = modeli.listaAutomobila();
        assertEquals(9, lista.size());
        int poslednjiID = modeli.dajPoslednjiID();
        modeli.obrisiVozilo(poslednjiID);
    }
    
    /**
     * //Testira rad metode koja brise vozila iz liste automobila
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test
    public void testObrisiVozilo() throws ClassNotFoundException, SQLException{
        DALModeliAuta modeli = new DALModeliAuta();
        modeli.obrisiVozilo(modeli.dajPoslednjiID());
        ArrayList<ModeliAuta> lista = modeli.listaAutomobila();
        assertEquals(7, lista.size());
        modeli.dodajBrend(2, "X1", "Plava", "10000");
    }
    
}
