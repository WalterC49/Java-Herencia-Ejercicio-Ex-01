/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.servicios;

import ejercicio_herencia_ex_01.entidades.Velero;
import static ejercicio_herencia_ex_01.servicios.Servicio.leer;

/**
 *
 * @author Walter
 */
public class VeleroServicio extends BarcoServicio{
    public static Velero CrearVelero(){
        Velero vel = (Velero) CrearBarco();
        int cantMast;
        do {                        
            System.out.print("Ingrese la cantidad de mástiles: ");
            cantMast=leer.nextInt();
            if(cantMast<1){
                System.out.println("¿Si no tiene mástiles para que puso velero?");
            }
        } while (cantMast<1);
        vel.setCantidadMastiles(cantMast);
        return vel;
    }
}
