/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaDatos.ConexionDB;
import javax.swing.JOptionPane;
import Clases.DiarioDietetico;
import Clases.Registro;

/**
 *
 * @author iJona
 */
public class ManejoDeDiarios {
    
    public static boolean validarRegistroAliemento(String alimento, String cantidad, String medida) {
        if ( alimento.length()>0){
            try {
                Integer.parseInt(cantidad);
            } 
            catch (NumberFormatException nfe){
                return false;
            }
        }
        
        if (medida.equals("unidad")){
            String ruta = "jdbc:ucanaccess://"+System.getProperty("user.dir") +"\\src\\BaseDatos\\Alimentos.accdb";
            ConexionDB conexion = new ConexionDB(ruta);
            
            if (! conexion.verificarMedida(alimento)){
                JOptionPane.showMessageDialog(null, "Medida no valida para el alimento\nVuelva a seleccionar otra medida");
                return false;
            }
                    
        }
        return true;
    }


    public static int calcularCalorias( String alimento, int cantidad, String medida){
        
        String ruta = "jdbc:ucanaccess://"+System.getProperty("user.dir") +"\\src\\BaseDatos\\Alimentos.accdb";
        
        ConexionDB conexion = new ConexionDB(ruta);
        
        int calorias100gramos = conexion.buscarNumeroCalorias(alimento, medida);
        
            int pesoMedida=0;
            if (medida.equals("taza"))
                pesoMedida =250;
            else if (medida.equals("plato"))
                pesoMedida =225;
            else if (medida.equals("onza"))
                pesoMedida =28;
            else if (medida.equals("rebanada"))
                pesoMedida =30;
            else if (medida.equals("vaso"))
                pesoMedida =200;
            else if (medida.equals("cucharada"))
                pesoMedida =15;
            else if (medida.equals("cucharadita"))
                pesoMedida =5;
            else
                pesoMedida=100;
            
            return (cantidad*pesoMedida*calorias100gramos/100);
        
        
        
    }

 
     public static void agregarRegistro(DiarioDietetico diario, Registro registro){
        if (registro.getTiempo().equals("Desayuno"))
            diario.desayuno.agregarRegistro(registro);
        else if (registro.getTiempo().equals("Almuerzo"))
            diario.almuerzo.agregarRegistro(registro);
        else if (registro.getTiempo().equals("Cena"))
            diario.cena.agregarRegistro(registro);
        else if (registro.getTiempo().equals("Refrigerio"))
            diario.refrigerio.agregarRegistro(registro);
        
        diario.numeroCalorias += registro.getCalorias();
    }
     
     
     
     
}
