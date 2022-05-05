/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.servicios;

import ejercicio_herencia_ex_01.entidades.Alquiler;
import ejercicio_herencia_ex_01.entidades.Puerto;
import static ejercicio_herencia_ex_01.servicios.Servicio.leer;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class PuertoServicio {
    
    public static Puerto AbrirPuerto(){
        Puerto puerto = new Puerto();
        int maxBarcos;
        
        do {            
            System.out.print("¿Cuál es la capacidad máxima de barcos que se pueden amarrar? ");
            maxBarcos=leer.nextInt();
            if (maxBarcos<0) {
                System.out.println("Ingreso no valido:");
            }
        } while (maxBarcos<0);
        
        ArrayList<String> posiciones = new ArrayList();
        for(int i=0;i<maxBarcos;i++){
            posiciones.add(String.valueOf(i));
        }
        
        puerto.setPosicionesLibres(posiciones);
        
        ArrayList<Alquiler> alquileres = new ArrayList();
        
        puerto.setAlquileres(alquileres);
        return puerto;
    }
    
    public static boolean RevisarPuerto(Puerto puerto){
        return puerto.getPosicionesLibres().isEmpty();
    }
    
}
