/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.servicios;

import ejercicio_herencia_ex_01.entidades.BarcoAMotor;
import static ejercicio_herencia_ex_01.servicios.Servicio.leer;

/**
 *
 * @author Walter
 */
public class BarcoAMotorServicio extends BarcoServicio {
    public static BarcoAMotor CrearBarcoAMotor(String matricula,float eslora,int anio){
        String cv;
        do {                        
            System.out.print("Ingrese su potencia en CV: ");
            cv=leer.next();
            cv=cv.replace(",",".");
        } while (Float.parseFloat(cv)<0);
        return new BarcoAMotor(Float.parseFloat(cv), matricula, eslora, anio);
    }
    
}
