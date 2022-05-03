/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.servicios;

import ejercicio_herencia_ex_01.entidades.Alquiler;
import ejercicio_herencia_ex_01.entidades.Barco;
import ejercicio_herencia_ex_01.entidades.BarcoAMotor;
import ejercicio_herencia_ex_01.entidades.Puerto;
import ejercicio_herencia_ex_01.entidades.Velero;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class PuertoServicio {
    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private static Puerto puerto = new Puerto();
    
    public static void AbrirPuerto(){
        System.out.println("Este programa sirve para calcular el alquiler de barcos en un puerto.");
        
        int maxBarcos;
        do {            
            System.out.println("¿Cuál es la capacidad máxima de barcos que se pueden amarrar?");
            maxBarcos=leer.nextInt();
            if (maxBarcos<0) {
                System.out.println("Ingreso no valido:");
            }
        } while (maxBarcos<0);
        
        ArrayList<Integer> posiciones = new ArrayList();
        for(int i=0;i<maxBarcos;i++){
            posiciones.add(i);
        }
        
        puerto.setPosicionesLibres(posiciones);
        
        ArrayList<Alquiler> alquileres = new ArrayList();
        
        puerto.setAlquileres(alquileres);
    }
    
    private static void AgregarAlquiler(){
        String nombre;
        int dni;
        int pos;
        System.out.print("\nIngrese el nombre del cliente: ");
        nombre=leer.next();
        System.out.print("Ingrese el DNI del cliente: ");
        dni=leer.nextInt();
        
        boolean repetir=false;
        String fecha;
        do {    
            System.out.print("Ingrese la fecha del alquiler (DD.MM.AAAA): ");
            fecha=leer.next();
            for(char i='A';i<='z';i++){
                if(fecha.contains(String.valueOf(i))){
                    System.out.println("Vuelva a ingresar la fecha.");
                    break;
                } else {
                    repetir=true;
                }
            }
        } while (repetir);
        
        do {    
            System.out.print("Ingrese la fecha de devolución (DD.MM.AAAA): ");
            fecha=leer.next();
            for(char i='A';i<='z';i++){
                if(fecha.contains(String.valueOf(i))){
                    System.out.println("Vuelva a ingresar la fecha.");
                    break;
                } else {
                    repetir=true;
                }
            }
        } while (repetir);
        
        pos=(int)(Math.random()*puerto.getPosicionesLibres().size());
        puerto.getPosicionesLibres().remove(pos);
        
        
        
        //IngresarFecha(fecha);
        
        
    }
    
    private LocalDate IngresarFecha(String fecha){
        fecha=fecha.replace(".", "-");
        String LDfecha[]= fecha.split("-");
        return LocalDate.of(Integer.parseInt(LDfecha[2]),Integer.parseInt(LDfecha[1]),Integer.parseInt(LDfecha[0]));
    }
    
    private Barco ElegirBarco(){
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
                    return CrearBarco();
                case "2":
                    System.out.println("Velero:");
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
                case "3":
                    System.out.println("Barco a motor:");
                    BarcoAMotor barMot = (BarcoAMotor) CrearBarco();
                    
                    
                    
                default:
                    System.out.println("Ingreso no valido.");
            }
        } while (true);        
    }
    
    private Barco CrearBarco(){
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
    
    
    public static void Menu(){
        System.out.println("");
        System.out.println("Puerto menú."
                + "\n1- Amarrar un barco."
                + "\n2- Salir.");
        System.out.print("Opción: ");
        String op=leer.next();
        switch (op) {
            case "1":
                AgregarAlquiler();
                Menu();
                break;
            case "2":
                System.out.println("Hasta prontos.");
                break;
            default:
                Menu();
                System.out.println("Opción no valida.");
        }
    }
}
