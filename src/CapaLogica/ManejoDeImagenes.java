/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaPresentacion.InterfazExplorador;
import static CapaPresentacion.InterfazLogin.rutaImagPerfil;
import static CapaPresentacion.NutriAppMain.usuario;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author iJona
 */
public class ManejoDeImagenes {

    public static Icon adaptarImagen(ImageIcon fotoPerfil, int ancho, int alto) {
        
        Image conversion = fotoPerfil.getImage();
        Image tamanio = conversion.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon fin = new ImageIcon(tamanio);
        return fin;
    }
    public static void cargarFoto(JLabel labelFoto) {
        int resultado;
        File fichero;
        InterfazExplorador ventana = new InterfazExplorador();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        ventana.jfchCargarfoto.setFileFilter(filtro);
        resultado= ventana.jfchCargarfoto.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado){

                fichero = ventana.jfchCargarfoto.getSelectedFile();
                rutaImagPerfil = fichero.toString();
                try {
                    ImageIcon fotoPerfil = new ImageIcon(rutaImagPerfil);
                    Icon icono = new ImageIcon(fotoPerfil.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
                    labelFoto.setIcon( icono );
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
                }
         }
    }
    
    public static void guardarFotoPerfil() {
        String url =System.getProperty("user.dir") +"\\src\\Imagenes\\"+usuario.getId()+".jpg";
        ManejoDeArchivos.duplicarArchivo(rutaImagPerfil, url);        
    }
    
}
