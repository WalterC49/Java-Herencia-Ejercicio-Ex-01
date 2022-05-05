/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.entidades;

import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class Puerto {
    private ArrayList<Alquiler> Alquileres;
    private ArrayList<String> PosicionesLibres;

    public Puerto() {
    }

    public Puerto(ArrayList<Alquiler> Alquileres, ArrayList<String> PosicionesLibres) {
        this.Alquileres = Alquileres;
        this.PosicionesLibres = PosicionesLibres;
    }

    public ArrayList<Alquiler> getAlquileres() {
        return Alquileres;
    }

    public void setAlquileres(ArrayList<Alquiler> Alquileres) {
        this.Alquileres = Alquileres;
    }

    public ArrayList<String> getPosicionesLibres() {
        return PosicionesLibres;
    }

    public void setPosicionesLibres(ArrayList<String> PosicionesLibres) {
        this.PosicionesLibres = PosicionesLibres;
    }
    
}
