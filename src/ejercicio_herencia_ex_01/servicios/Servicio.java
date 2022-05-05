/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.servicios;

import ejercicio_herencia_ex_01.entidades.Puerto;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class Servicio {
    public static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public static void Menu(Puerto puerto){
        System.out.println("");
        System.out.println("Puerto menú."
                + "\n1- Amarrar un barco."
                + "\n2- Salir.");
        System.out.print("Opción: ");
        String op=leer.next();
        switch (op) {
            case "1":
                if(PuertoServicio.RevisarPuerto(puerto)){
                    System.out.println("Ya no queda lugar para amarrar en el puerto."
                            + "\nDebería salir del programa.");
                }else{
                    AlquilerServicio.AgregarAlquiler(puerto);
                }
                Menu(puerto);
                break;
            case "2":
                System.out.println("Hasta prontos.");
                break;
            default:
                Menu(puerto);
                System.out.println("Opción no valida.");
        }
    }
}
