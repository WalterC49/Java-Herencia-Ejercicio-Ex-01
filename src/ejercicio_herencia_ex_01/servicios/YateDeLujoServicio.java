/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_01.servicios;

import ejercicio_herencia_ex_01.entidades.YateDeLujo;
import static ejercicio_herencia_ex_01.servicios.Servicio.leer;

/**
 *
 * @author Walter
 */
public class YateDeLujoServicio extends BarcoServicio{
    public static YateDeLujo CrearYateDeLujo(){
        YateDeLujo yate = (YateDeLujo) CrearBarco();
        String cv;
        do {                        
            System.out.print("Ingrese su potencia en CV: ");
            cv=leer.next();
            cv=cv.replace(".",",");
        } while (Float.parseFloat(cv)<0);
        yate.setCV(Float.parseFloat(cv));
        int camarotes;
        do {            
            System.out.print("Ingrese la cantidad de camarotes que posee: ");
            camarotes=leer.nextInt();
        } while (camarotes<0);
        yate.setCantidadCamarotes(camarotes);
        return yate;
    }
}
