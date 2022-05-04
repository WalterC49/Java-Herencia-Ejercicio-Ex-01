/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.servicios;

import ejercicio_herencia_ex_01.entidades.Alquiler;
import ejercicio_herencia_ex_01.entidades.Puerto;
import static ejercicio_herencia_ex_01.servicios.Servicio.leer;
import java.time.LocalDate;

/**
 *
 * @author Walter
 */
public class AlquilerServicio {
    
    public static void AgregarAlquiler(Puerto puerto){
        String nombre;
        int dni;
        LocalDate fecha1,fecha2;
        int pos;
        
        System.out.print("\nIngrese el nombre del cliente: ");
        nombre=leer.next();
        System.out.print("Ingrese el DNI del cliente: ");
        dni=leer.nextInt();
        
        boolean repetir;
        String fecha;
        do {
            repetir=false;
            System.out.print("Ingrese la fecha del alquiler (DD.MM.AAAA): ");
            fecha=leer.next();
            for(char i='A';i<='z';i++){
                if(fecha.contains(String.valueOf(i))){
                    System.out.println("Vuelva a ingresar la fecha.");
                    repetir=true;
                    break;
                }
            }
        } while (repetir);
        fecha1=IngresarFecha(fecha);
        
        do {    
            repetir=false;
            System.out.print("Ingrese la fecha de devolución (DD.MM.AAAA): ");
            fecha=leer.next();
            for(char i='A';i<='z';i++){
                if(fecha.contains(String.valueOf(i))){
                    System.out.println("Vuelva a ingresar la fecha.");
                    repetir=true;
                    break;
                }
                
            }
        } while (repetir);
        fecha2=IngresarFecha(fecha);
        
        pos=(int)(Math.random()*puerto.getPosicionesLibres().size());
        puerto.getPosicionesLibres().remove(pos);
        
        Alquiler alquiler = new Alquiler(nombre,dni,fecha1,fecha2,pos,BarcoServicio.ElegirBarco());
        PrecioAlquiler(alquiler);
        
        puerto.getAlquileres().add(alquiler);
    }
    
    private static void PrecioAlquiler(Alquiler alquiler){
    
    }
    
    private static LocalDate IngresarFecha(String fecha){
        fecha=fecha.replace(".", "-");
        String LDfecha[]= fecha.split("-");
        return LocalDate.of(Integer.parseInt(LDfecha[2]),Integer.parseInt(LDfecha[1]),Integer.parseInt(LDfecha[0]));
    }
    
}
