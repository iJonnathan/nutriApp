/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import static CapaPresentacion.NutriAppMain.diaActual;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author iJona
 */
public class ManejoDeFecha {
    
     public static String calcularFechaActual() {
        
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return (String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(anio));
    }

    public static  String calcularDiaActual() {
        Calendar fecha = new GregorianCalendar();
        int Dia = fecha.get(Calendar.DAY_OF_WEEK);
        if (Dia == 1) return "Domingo";
        else if (Dia == 2) return "Lunes";
        else if (Dia == 3) return "Martes";
        else if (Dia == 4) return "Miercoles";
        else if (Dia == 5) return "Juevez";
        else if (Dia == 6) return "Viernes";
        else if (Dia == 7) return "Sabado";
        return "";
    }
    public static String calcularDescripcionFecha() {
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
   
        return (String.valueOf(diaActual)+" "+String.valueOf(dia)+" de "+calcularMes(mes)+" del "+String.valueOf(anio));
    }

    public static String calcularMes(int mes) {
        if (mes == 1) return "Enero";
        else if (mes == 2) return "Febrero";
        else if (mes == 3) return "Marzo";
        else if (mes == 4) return "Abril";
        else if (mes == 5) return "Mayo";
        else if (mes == 6) return "Junio";
        else if (mes == 7) return "Julio";
        else if (mes == 8) return "Agosto";
        else if (mes == 9) return "Septiembre";
        else if (mes == 10) return "Octubre";
        else if (mes == 11) return "Noviembre";
        else if (mes == 12) return "Diciembre";
        return "";
    }
    public static int calcularEdad(String dia, String mes, String anio) {


            String fecha_nac = dia+"/"+mes+"/"+anio;
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String hoy = formato.format(fechaActual);

            String [] dat1 = fecha_nac.split("/");
            String [] dat2 = hoy.split("/");
            int edad=  Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
            int mess = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);

            if (mess < 0 ){
                edad=edad-1;
            }else if (mess == 0){
                int d = Integer.parseInt(dat2[0]) -Integer.parseInt(dat1[0]);
                if (d > 0 ){
                    edad = edad -1 ;
                }
            }
                System.out.println("edad "+edad);
                return edad;

        }

}
