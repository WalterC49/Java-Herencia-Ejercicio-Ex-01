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
public class Velero extends Barco {
    private Integer cantidadMastiles;
    
    public Velero(){
    }

    public Velero(Integer cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }
    
    public Velero(Integer cantidadMastiles, String matricula, Float eslora, Integer anioFabricacion){
        super(matricula,eslora,anioFabricacion);
        this.cantidadMastiles = cantidadMastiles;
    }

    public Integer getCantidadMastiles() {
        return cantidadMastiles;
    }

    public void setCantidadMastiles(Integer cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }
    
}
