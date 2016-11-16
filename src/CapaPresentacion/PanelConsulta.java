/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.ConexionDB;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author iJona
 */
public class PanelConsulta extends javax.swing.JPanel {

    /**
     * Creates new form PanelConsulta
     */
    public PanelConsulta() {
        initComponents();
        AutoCompleteDecorator.decorate(entryAlimento);
        textoDescripcion.setVisible(false);
        labelAlimento.setVisible(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextPane();
        labelAlimento = new javax.swing.JLabel();
        fotoAlimento = new javax.swing.JLabel();
        entryAlimento = new javax.swing.JComboBox<>();
        labelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));

        textoDescripcion.setEditable(false);
        textoDescripcion.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane1.setViewportView(textoDescripcion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 270, 180));

        labelAlimento.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        add(labelAlimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        add(fotoAlimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 140, 130));

        entryAlimento.setBackground(new java.awt.Color(204, 255, 204));
        entryAlimento.setEditable(true);
        entryAlimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aceite", "Acelga", "Aguacate", "Albaricoque", "Apio", "Arroz", "Arroz con pollo", "Arroz integral", "Arveja seca", "Arveja tierna", "Atún", "Avena", "Azúcar", "Azúcar morena", "Babaco", "Berenjena", "Brocoli", "Café", "Café con leche", "Café con leche descremada", "Caldo de res", "Camarón", "Camarones apanados", "Camote", "Canguil", "Carne asada", "Cebada de arroz", "Cebolla", "Cerdo", "Cereal corn flakes", "Cereal Fitness", "Cereal Zucaritas Kelloggs", "Champiñones", "Chirimoya", "Choclo", "Coco", "Col morada", "Col verde", "Coliflor", "Consomé de pollo", "Corvina", "Crema de espinacas", "Crema de zanahoria", "Crema Pasteurizada", "Culantro", "Durazno", "Ensalada de frutas", "Ensalada de lechuga con verduras", "Espinaca", "Estofado de carne", "Fideos", "Frejol seco", "Frejol tierno", "Frutilla", "Galletas de avena", "Galletas de dulce", "Galletas de sal", "Gaseosa", "Gelatina", "Granadilla", "Guanabana", "Guayaba", "Guineo", "Haba", "Hamburguesa", "Harina de Trigo", "Higo", "Hot dog", "Huevo", "Huevo revuelto", "Jugo de guayaba", "Jugo de limón", "Jugo de maracuyá", "Jugo de mora", "Jugo de naranja", "Jugo de naranjilla", "Jugo de papaya", "Jugo de piña", "Jugo de tomate", "Jugo de toronja", "Jugo de zanahoria", "Kiwi", "Leche con avena", "Leche con chocolate", "Leche condensada", "Leche descremada", "Leche en polvo", "Leche Pasteurizada", "Lechuga", "Lenteja", "Limón", "Mandarina", "Mango", "Manteca de cerdo", "Mantequilla", "Manzana", "Maracuyá", "Margarina", "Mayonesa", "Melloco", "Melón", "Menestra", "Mermelada", "Miel de abeja", "Mora", "Mortadela", "Mostaza", "Nabo", "Naranja", "Naranjilla", "Pan", "Pan blanco", "Pan con jamón y queso", "Pan integral", "Panela", "Papa", "Papaya", "Pepino", "Pera", "Perejil", "Pescado apanado", "Pescado frito", "Pimiento", "Piña", "Pizza", "Plátano maduro", "Plátano verde", "Pollo", "Pollo a la plancha", "Pollo apanado", "Pollo asado", "Pollo frito", "Queso", "Queso Crema", "Quinoa", "Remolacha", "Res", "Salchipapa", "Salsa de tomate", "Sandía", "Seco de carne", "Sopa de fideo", "Sopa de frejól", "Sopa de habas", "Sopa de lentejas", "Sopa de papas", "Sopa de pollo con verduras", "Sopa de verduras", "Soya", "Tallarines", "Tamarindo", "Tomate de árbol", "Tomate riñon", "Toronja", "Tuna", "Uva", "Vainita", "Vinesa", "Yogurt", "Yogurth con frutas", "Yuca", "Zambo tierno", "Zanahoria", "Zapallo", "Zapote", " " }));
        entryAlimento.setSelectedIndex(165);
        add(entryAlimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 250, -1));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoConsulta.png"))); // NOI18N
        add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
         String ruta = "jdbc:ucanaccess://"+System.getProperty("user.dir") +"\\src\\BaseDatos\\Alimentos.accdb";
        
         ConexionDB conexion = new ConexionDB(ruta);
         textoDescripcion.setVisible(true);
         labelAlimento.setVisible(true);
         this.labelAlimento.setText((String)entryAlimento.getSelectedItem());
         
         this.textoDescripcion.setText(conexion.buscarAlimento((String)entryAlimento.getSelectedItem()));
         
          
        String rutaAlimento = "/imagenes/imagAlimentos/"+(String)entryAlimento.getSelectedItem()+".jpg";
        URL urlImag = getClass().getResource(rutaAlimento);
                
        ImageIcon icon = new ImageIcon(urlImag);  
        Image conversion = icon.getImage();
        Image tamanio = conversion.getScaledInstance(140, 130, Image.SCALE_SMOOTH);
        ImageIcon fin = new ImageIcon(tamanio);
        fotoAlimento.setIcon(fin); 
        
        //  URL url = getClass().getResource("/BaseDatos/Alimentos.accdb");
       //    String ruta = "jdbc:ucanaccess://"+url;
        
        
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JComboBox<String> entryAlimento;
    private javax.swing.JLabel fotoAlimento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAlimento;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JTextPane textoDescripcion;
    // End of variables declaration//GEN-END:variables
}