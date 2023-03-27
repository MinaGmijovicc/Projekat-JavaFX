/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitySloj;

/**
 *
 * @author User
 */
public class ModeliAuta {
    private int IDmodelAuta;
    private String ImeBrenda;
    private String ModelAuta;
    private String Boja, Cena;

    public String getBoja() {
        return Boja;
    }

    public void setBoja(String Boja) {
        this.Boja = Boja;
    }

    public String getCena() {
        return Cena;
    }

    public void setCena(String Cena) {
        this.Cena = Cena;
    }

    public ModeliAuta() {
    }

    public ModeliAuta(int IDmodelAuta, String ImeBrenda, String ModelAuta, String Boja, String Cena) {
        this.IDmodelAuta = IDmodelAuta;
        this.ImeBrenda = ImeBrenda;
        this.ModelAuta = ModelAuta;
        this.Boja = Boja;
        this.Cena = Cena;
    }

    public int getIDmodelAuta() {
        return IDmodelAuta;
    }

    public void setIDmodelAuta(int IDmodelAuta) {
        this.IDmodelAuta = IDmodelAuta;
    }

    public String getImeBrenda() {
        return ImeBrenda;
    }

    public void setImeBrenda(String ImeBrenda) {
        this.ImeBrenda = ImeBrenda;
    }

    public String getModelAuta() {
        return ModelAuta;
    }

    public void setModelAuta(String ModelAuta) {
        this.ModelAuta = ModelAuta;
    }

    @Override
    public String toString() {
        return "ID: " + IDmodelAuta + ", Auto: " + ImeBrenda + " " + ModelAuta + ", Boja: " + Boja + ", Cena: " + Cena ;
    }
    
    
}
