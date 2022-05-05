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
import ejercicio_herencia_ex_01.entidades.YateDeLujo;
import static ejercicio_herencia_ex_01.servicios.Servicio.leer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author Walter
 */
public class AlquilerServicio {
    
    public static void AgregarAlquiler(Puerto puerto){
        String nombre;
        int dni;
        LocalDate fecha1,fecha2;
        
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

        int numA=(int)(Math.random()*puerto.getPosicionesLibres().size());
        String pos=puerto.getPosicionesLibres().get(numA);
        puerto.getPosicionesLibres().remove(numA);
        
        Alquiler alquiler = new Alquiler(nombre,dni,fecha1,fecha2,pos,BarcoServicio.ElegirBarco());
        PrecioAlquiler(alquiler);
        
        puerto.getAlquileres().add(alquiler);
    }
    
    private static void PrecioAlquiler(Alquiler alquiler){
        int dias=CalcularDias(alquiler);
        float modulo=alquiler.getBarco().getEslora()*10;
        
        if(alquiler.getBarco() instanceof Velero){
            Velero vel = (Velero) alquiler.getBarco();
            modulo+=vel.getCantidadMastiles();
            System.out.println("\nEl barco está en el amarre Nº "+alquiler.getPosicion());
            System.out.println("El precio del alquiler es $"+modulo*dias);
            return;
        }
        
        if(alquiler.getBarco() instanceof BarcoAMotor){
            BarcoAMotor barMot = (BarcoAMotor) alquiler.getBarco();
            modulo+=barMot.getCV();
            System.out.println("\nEl barco está en el amarre Nº "+alquiler.getPosicion());
            System.out.println("El precio del alquiler es $"+modulo*dias);
            return;
        }
        
        if(alquiler.getBarco() instanceof YateDeLujo){
            YateDeLujo yate = (YateDeLujo) alquiler.getBarco();
            modulo+=yate.getCV()+yate.getCantidadCamarotes();
            System.out.println("\nEl barco está en el amarre Nº "+alquiler.getPosicion());
            System.out.println("El precio del alquiler es $"+modulo*dias);
            return;
        }
        
        if(alquiler.getBarco() instanceof Barco){
            System.out.println("\nEl barco está en el amarre Nº "+alquiler.getPosicion());
            System.out.println("El precio del alquiler es $"+modulo*dias);
        }
    }
    
    private static LocalDate IngresarFecha(String fecha){
        fecha=fecha.replace(".", "-");
        String LDfecha[]= fecha.split("-");
        return LocalDate.of(Integer.parseInt(LDfecha[2]),Integer.parseInt(LDfecha[1]),Integer.parseInt(LDfecha[0]));
    }
    
    private static int CalcularDias(Alquiler alquiler){
        //Convierto los LocalDate a LocalDateTime
        LocalDateTime fecha1 = alquiler.getFechaAlquiler().atStartOfDay();
        LocalDateTime fecha2 = alquiler.getFechaDevolucion().atStartOfDay();
        
        //Le agrego la zone horaria a las fechas
        ZonedDateTime zona1 = ZonedDateTime.of(fecha1, ZoneId.systemDefault());
        ZonedDateTime zona2 = ZonedDateTime.of(fecha2, ZoneId.systemDefault());
        
        //Convierto los ZonedDateTime a milisegundos
        long mili1 = zona1.toInstant().toEpochMilli();
        long mili2 = zona2.toInstant().toEpochMilli();
        
        //Devuelvo la diferencia dividida en la cantidad de milisegundos que hay en un día
        return (int) ((mili2-mili1)/86400000);
    }
}
