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
                    System.out.println("\nBarco común:");
                    return CrearBarco(op);
                case "2":
                    System.out.println("\nVelero:");
                    return CrearBarco(op);
                case "3":
                    System.out.println("\nBarco a motor:");
                    return CrearBarco(op);
                case "4":
                    System.out.println("\nYate de lujo:");
                    return CrearBarco(op);
                default:
                    System.out.println("Ingreso no valido.");
            }
        } while (true);        
    }
    
    protected static<T extends Barco> T CrearBarco(String op){
        String matricula;
        String eslora;
        int anio;
        System.out.print("Ingrese su matricula: ");
        matricula=leer.next();
        System.out.print("Ingrese el tamaño de la eslora en metros: ");
        eslora=leer.next();
        eslora=eslora.replace(",", ".");
        System.out.print("Ingrese el año de fabricación: ");
        anio=leer.nextInt();
        switch (op) {
            case "1":
                return (T) new Barco(matricula, Float.parseFloat(eslora), anio);
            case "2":
                return (T) VeleroServicio.CrearVelero(matricula, Float.parseFloat(eslora), anio);
            case "3":
                return (T) BarcoAMotorServicio.CrearBarcoAMotor(matricula,Float.parseFloat(eslora),anio);
            default:
                return (T) YateDeLujoServicio.CrearYateDeLujo(matricula,Float.parseFloat(eslora),anio);
        }
    }
    
}
