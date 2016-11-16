/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import Enumeraciones.EstadoNutricional;
import Clases.Usuario;
import Enumeraciones.Sexo;
import Enumeraciones.TipoActividadFisica;

/**
 *
 * @author iJona
 */
public class ManejoDelUsuario {
    
    public static boolean ValidarDatosRegistroUsuario(String nombre, String id, String pass, String tiempoActFis, String talla, String peso) {
        if (nombre.length()<=0) return false;
        else if (id.length()<=0) return false;
        else if (pass.length()<=0) return false;
        else if (tiempoActFis.length()<=0) return false;
        else if (talla.length()<=0) return false;
        else if (peso.length()<=0) return false;
        return true;
    }
    public static boolean validarDatosLogin(String cuenta, String pass) {
        if (cuenta.length()==0) return false;
        else if (pass.length()==0) return false;
        return true;
    }
    public static EstadoNutricional calcularEstadoNutricional(Usuario cliente) {

        EstadoNutricional estado = EstadoNutricional.INICIALIZADO;
        double valor = cliente.getPeso() / Math.pow(cliente.getTalla(), 2);

           if ( valor < 18.5)
               estado = EstadoNutricional.BAJO_PESO;
           else if(valor >=18.5 && valor <25)
               estado = EstadoNutricional.NORMAL;
           else if(valor >= 25 && valor < 30)
                estado = EstadoNutricional.SOBREPESO;
           else if( valor >= 30 && valor < 35)
               estado = EstadoNutricional.OBESIDAD_GRADO_1;
           else if( valor >= 35 && valor < 40)
              estado = EstadoNutricional.OBESIDAD_GRADO_2;
           else if ( valor >= 40)
              estado = EstadoNutricional.OBESIDAD_GRADO_3;

           return estado;
    }
    public static int calcularGastoEnergetico(Usuario cliente) {

        double  CONSTANE_1;
        double  CONSTANE_2;
        double  CONSTANE_3;
        double  CONSTANE_4;

        if (cliente.getSexo() == Sexo.MASCULINO){
               CONSTANE_1 = 66.5;
               CONSTANE_2 = 13.75;
               CONSTANE_3 = 5;
               CONSTANE_4 = 6.78;

        }
        else{
               CONSTANE_1 = 655.1;
               CONSTANE_2 = 9.56;
               CONSTANE_3 = 1.85;
               CONSTANE_4 = 4.68;

        }
        double formulaMetabolismoBasal = CONSTANE_1 + CONSTANE_2*cliente.getPeso() 
                                     + CONSTANE_3*cliente.getTalla()*100
                                      - CONSTANE_4*   cliente.getEdad();

            double activFisica = cliente.getTiempoActvFisica() * (compararActividad(cliente));
            double ETA = (formulaMetabolismoBasal + activFisica )*0.1;

            return (int ) (formulaMetabolismoBasal+ activFisica +ETA);



    }
    public static int  compararActividad(Usuario cliente){

        int valor = 0;
        if (cliente.getSexo() == Sexo.FEMENINO){
            if ( cliente.getTipoActividadFisica() ==TipoActividadFisica.LIGERA)
               valor = 100;

           else if ( cliente.getTipoActividadFisica() ==TipoActividadFisica.MODERADA)
               valor = 125;

           else if ( cliente.getTipoActividadFisica() ==TipoActividadFisica.INTENSA)
               valor = 175;
        }
        else{
             if ( cliente.getTipoActividadFisica() ==TipoActividadFisica.LIGERA)
               valor = 140;

           else if ( cliente.getTipoActividadFisica() ==TipoActividadFisica.MODERADA)
               valor = 175;

           else if ( cliente.getTipoActividadFisica() ==TipoActividadFisica.INTENSA)
               valor = 240;
        }


        return valor;
    }
    
    
    
}
