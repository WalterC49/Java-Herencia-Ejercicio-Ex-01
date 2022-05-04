/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.servicios;

import ejercicio_herencia_ex_01.entidades.Barco;
import static ejercicio_herencia_ex_01.servicios.Servicio.leer;

/**
 *
 * @author Walter
 */
public class BarcoServicio {
    public static <T extends Barco> T ElegirBarco(){
        String op;
        do {
            System.out.println("Seleccione el tipo de barco que va a ingresar."
                    + "\n1- Barco común."
                    + "\n2- Velero."
                    + "\n3- Barco a motor."
                    + "\n4- Yate de lujo.");
            System.out.print("Opción: ");
            op=leer.next();
            switch (op) {
                case "1":
                    System.out.println("Barco común:");
                    return (T) CrearBarco();
                case "2":
                    System.out.println("Velero:");
                    return (T) VeleroServicio.CrearVelero();
                case "3":
                    System.out.println("Barco a motor:");
                    return (T) BarcoAMotorServicio.CrearBarcoAMotor();
                case "4":
                    System.out.println("Yate de lujo:");
                    return (T) YateDeLujoServicio.CrearYateDeLujo();
                default:
                    System.out.println("Ingreso no valido.");
            }
        } while (true);        
    }
    
    protected static Barco CrearBarco(){
        String matricula;
        String eslora;
        int anio;
        System.out.print("Ingrese su matricula: ");
        matricula=leer.next();
        System.out.print("Ingrese el tamaño de la eslora en metros: ");
        eslora=leer.next();
        eslora=eslora.replace(".", ",");
        System.out.print("Ingrese el año de fabricación: ");
        anio=leer.nextInt();
        return new Barco(matricula,Float.parseFloat(eslora),anio);
    }
    
}
