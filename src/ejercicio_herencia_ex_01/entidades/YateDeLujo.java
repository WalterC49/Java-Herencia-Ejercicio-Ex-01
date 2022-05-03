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
public class YateDeLujo extends Barco {
    private Float CV;
    private Integer cantidadCamarotes;
    
    public YateDeLujo(){
    }

    public YateDeLujo(Float CV, Integer cantidadCamarotes) {
        this.CV = CV;
        this.cantidadCamarotes = cantidadCamarotes;
    }

    public YateDeLujo(Float CV, Integer cantidadCamarotes, String matricula, Float eslora, Integer anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.CV = CV;
        this.cantidadCamarotes = cantidadCamarotes;
    }

    public Float getCV() {
        return CV;
    }

    public void setCV(Float CV) {
        this.CV = CV;
    }

    public Integer getCantidadCamarotes() {
        return cantidadCamarotes;
    }

    public void setCantidadCamarotes(Integer cantidadCamarotes) {
        this.cantidadCamarotes = cantidadCamarotes;
    }
    
}
