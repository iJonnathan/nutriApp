/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import Clases.Usuario;
import static CapaPresentacion.InterfazLogin.rutaImagPerfil;

/**
 *
 * @author iJona
 */
public class NutriAppMain {
    
    public static InterfazLogin interfazLogin;
    public static Usuario usuario;
    public static InterfazPrincipal1 interfazPrincipal1;
    public static InterfazPrincipal2 interfazPrincipal2;
    public static String fechaActual;
    public static String diaActual;
    public static String rutaDBUsuarios;
    
    
    public static void main(String args[]){
        rutaDBUsuarios ="jdbc:ucanaccess://"+System.getProperty("user.dir") +"\\src\\BaseDatos\\Usuarios.accdb";
        rutaImagPerfil = System.getProperty("user.dir") +"\\src\\Imagenes\\perfilDefecto.jpg";
        InterfazLogin.main(null);
                
    }
}
