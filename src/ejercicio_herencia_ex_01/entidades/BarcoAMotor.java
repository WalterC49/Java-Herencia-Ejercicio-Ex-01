/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.entidades;

/**
 *
 * @author Walter
 */
public class BarcoAMotor extends Barco {
    private Float CV;

    public BarcoAMotor() {
    }

    public BarcoAMotor(Float CV) {
        this.CV = CV;
    }

    public BarcoAMotor(Float CV, String matricula, Float eslora, Integer anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.CV = CV;
    }

    public Float getCV() {
        return CV;
    }

    public void setCV(Float CV) {
        this.CV = CV;
    }
    
}
