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
public class ModelBrend {
    int IDmodelAuta;
    int IDbrendAuta;
    String ModelAuta;
    String BojaAuta;
    String Cena;

    public ModelBrend() {
    }

    public ModelBrend(int IDmodelAuta, int IDbrendAuta, String ModelAuta, String BojaAuta, String Cena) {
        this.IDmodelAuta = IDmodelAuta;
        this.IDbrendAuta = IDbrendAuta;
        this.ModelAuta = ModelAuta;
        this.BojaAuta = BojaAuta;
        this.Cena = Cena;
    }

    public int getIDmodelAuta() {
        return IDmodelAuta;
    }

    public void setIDmodelAuta(int IDmodelAuta) {
        this.IDmodelAuta = IDmodelAuta;
    }

    public int getIDbrendAuta() {
        return IDbrendAuta;
    }

    public void setIDbrendAuta(int IDbrendAuta) {
        this.IDbrendAuta = IDbrendAuta;
    }

    public String getModelAuta() {
        return ModelAuta;
    }

    public void setModelAuta(String ModelAuta) {
        this.ModelAuta = ModelAuta;
    }

    public String getBojaAuta() {
        return BojaAuta;
    }

    public void setBojaAuta(String BojaAuta) {
        this.BojaAuta = BojaAuta;
    }

    public String getCena() {
        return Cena;
    }

    public void setCena(String Cena) {
        this.Cena = Cena;
    }

    @Override
    public String toString() {
        return "ModelBrend{" + "IDmodelAuta=" + IDmodelAuta + ", IDbrendAuta=" + IDbrendAuta + ", ModelAuta=" + ModelAuta + ", BojaAuta=" + BojaAuta + ", Cena=" + Cena + '}';
    }
    
    
}
