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
public class BrendAuta {
    private int IDbrendAuta;
    private String NazivBrenda;

    public BrendAuta() {
    }

    public BrendAuta(int IDbrendAuta, String NazivBrenda) {
        this.IDbrendAuta = IDbrendAuta;
        this.NazivBrenda = NazivBrenda;
    }

    public int getIDbrendAuta() {
        return IDbrendAuta;
    }

    public void setIDbrendAuta(int IDbrendAuta) {
        this.IDbrendAuta = IDbrendAuta;
    }

    public String getNazivBrenda() {
        return NazivBrenda;
    }

    public void setNazivBrenda(String NazivBrenda) {
        this.NazivBrenda = NazivBrenda;
    }

    @Override
    public String toString() {
        return  NazivBrenda;
    }
    
    
    
}
