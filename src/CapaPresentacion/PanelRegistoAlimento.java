/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.ConexionDB;
import CapaLogica.ManejoDeDiarios;
import CapaLogica.ManejoDeFecha;
import static CapaPresentacion.InterfazPrincipal2.panelTiemposComida;
import static CapaPresentacion.NutriAppMain.diaActual;
import static CapaPresentacion.NutriAppMain.fechaActual;
import static CapaPresentacion.NutriAppMain.usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import Clases.DiarioDietetico;
import Clases.Registro;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static CapaPresentacion.NutriAppMain.interfazPrincipal2;

/**
 *
 * @author iJona
 */
public class PanelRegistoAlimento extends javax.swing.JPanel {

    /**
     * Creates new form PanelRegistoAlimento
     */
    ConexionDB conexion=null ;
    public PanelRegistoAlimento() {
        initComponents();
        botonAgregar.setContentAreaFilled(false);
        AutoCompleteDecorator.decorate(selecAlimento);
        Calendar fecha = new GregorianCalendar();
        
         if (usuario.Diarios.isEmpty()){ //  si la pila de diarios esta vacia...
            DiarioDietetico diario = new DiarioDietetico(fechaActual, diaActual);
            diario.setDd(fecha.get(Calendar.DAY_OF_MONTH));
            diario.setMm(fecha.get(Calendar.MONTH)+1);
            diario.setAa(fecha.get(Calendar.YEAR));
            usuario.Diarios.add(diario);
        }
        else{
            DiarioDietetico auxDiario = usuario.Diarios.peek();
            if (!auxDiario.getFecha().equals(fechaActual)){
                //  agrego un nuevo diario
                DiarioDietetico diario = new DiarioDietetico(fechaActual, diaActual);
                diario.setDd(fecha.get(Calendar.DAY_OF_MONTH));
                diario.setMm(fecha.get(Calendar.MONTH)+1);
                diario.setAa(fecha.get(Calendar.YEAR));
                usuario.Diarios.add(diario);
            }
        }
        String f = ManejoDeFecha.calcularDescripcionFecha();
        labelFecha.setText(f);
        labelRqCalorico.setText(String.valueOf(usuario.getRequerimientoEnergetico()));//    cargo fecha yy cuadro de calorias
        labelCalConsumidas.setText(String.valueOf(usuario.Diarios.peek().getNumeroCalorias()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selecMedida = new javax.swing.JComboBox<>();
        botonAgregar = new javax.swing.JButton();
        entryCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        selecTiempo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelCalConsumidas = new javax.swing.JLabel();
        labelRqCalorico = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        selecAlimento = new javax.swing.JComboBox<>();
        labelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selecMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "taza", "cucharada", "plato", "onza", "unidad", "rebanada", "vaso", "cucharadita" }));
        add(selecMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonAgregar.png"))); // NOI18N
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 80, 40));

        entryCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryCantidadActionPerformed(evt);
            }
        });
        add(entryCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 40, -1));

        jLabel9.setText("Cantidad:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel10.setText("Alimento:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        selecTiempo.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        selecTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Almuerzo", "Cena", "Refrigerio" }));
        add(selecTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel1.setText("Tiempo:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        labelFecha.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(0, 51, 51));
        labelFecha.setText("15 de Octubre de 2016");
        add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 30));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Requerimiento calórico:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 20));

        jLabel11.setFont(new java.awt.Font("Hobo Std", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setText("Registro del Diario");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, 20));

        labelCalConsumidas.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        labelCalConsumidas.setForeground(new java.awt.Color(0, 51, 51));
        labelCalConsumidas.setText("1200");
        add(labelCalConsumidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        labelRqCalorico.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        labelRqCalorico.setForeground(new java.awt.Color(0, 51, 51));
        labelRqCalorico.setText("1200");
        add(labelRqCalorico, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, 20));

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel12.setText("Total calorias consumidas:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        selecAlimento.setEditable(true);
        selecAlimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aceite", "Acelga", "Aguacate", "Albaricoque", "Apio", "Arroz", "Arroz con pollo", "Arroz integral", "Arveja seca", "Arveja tierna", "Atún", "Avena", "Azúcar", "Azúcar morena", "Babaco", "Berenjena", "Brocoli", "Café", "Café con leche", "Café con leche descremada", "Caldo de res", "Camarón", "Camarones apanados", "Camote", "Canguil", "Carne asada", "Cebada de arroz", "Cebolla", "Cerdo", "Cereal corn flakes", "Cereal Fitness", "Cereal Zucaritas Kelloggs", "Champiñones", "Chirimoya", "Choclo", "Coco", "Col morada", "Col verde", "Coliflor", "Consomé de pollo", "Corvina", "Crema de espinacas", "Crema de zanahoria", "Crema Pasteurizada", "Culantro", "Durazno", "Ensalada de frutas", "Ensalada de lechuga con verduras", "Espinaca", "Estofado de carne", "Fideos", "Frejol seco", "Frejol tierno", "Frutilla", "Galletas de avena", "Galletas de dulce", "Galletas de sal", "Gaseosa", "Gelatina", "Granadilla", "Guanabana", "Guayaba", "Guineo", "Haba", "Hamburguesa", "Harina de Trigo", "Higo", "Hot dog", "Huevo", "Huevo revuelto", "Jugo de guayaba", "Jugo de limón", "Jugo de maracuyá", "Jugo de mora", "Jugo de naranja", "Jugo de naranjilla", "Jugo de papaya", "Jugo de piña", "Jugo de tomate", "Jugo de toronja", "Jugo de zanahoria", "Kiwi", "Leche con avena", "Leche con chocolate", "Leche condensada", "Leche descremada", "Leche en polvo", "Leche Pasteurizada", "Lechuga", "Lenteja", "Limón", "Mandarina", "Mango", "Manteca de cerdo", "Mantequilla", "Manzana", "Maracuyá", "Margarina", "Mayonesa", "Melloco", "Melón", "Menestra", "Mermelada", "Miel de abeja", "Mora", "Mortadela", "Mostaza", "Nabo", "Naranja", "Naranjilla", "Pan", "Pan blanco", "Pan con jamón y queso", "Pan integral", "Panela", "Papa", "Papaya", "Pepino", "Pera", "Perejil", "Pescado apanado", "Pescado frito", "Pimiento", "Piña", "Pizza", "Plátano maduro", "Plátano verde", "Pollo", "Pollo a la plancha", "Pollo apanado", "Pollo asado", "Pollo frito", "Queso", "Queso Crema", "Quinoa", "Remolacha", "Res", "Salchipapa", "Salsa de tomate", "Sandía", "Seco de carne", "Sopa de fideo", "Sopa de frejól", "Sopa de habas", "Sopa de lentejas", "Sopa de papas", "Sopa de pollo con verduras", "Sopa de verduras", "Soya", "Tallarines", "Tamarindo", "Tomate de árbol", "Tomate riñon", "Toronja", "Tuna", "Uva", "Vainita", "Vinesa", "Yogurt", "Yogurth con frutas", "Yuca", "Zambo tierno", "Zanahoria", "Zapallo", "Zapote", " " }));
        selecAlimento.setSelectedIndex(165);
        selecAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecAlimentoActionPerformed(evt);
            }
        });
        add(selecAlimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 170, -1));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoRegistroDiario.png"))); // NOI18N
        add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        String tiempo = (String) selecTiempo.getSelectedItem();
        String medida = (String) selecMedida.getSelectedItem();
        String alimento = (String) selecAlimento.getSelectedItem();
        String cant = entryCantidad.getText();
        if ( ManejoDeDiarios.validarRegistroAliemento(alimento,cant,medida)){
            String url = "jdbc:ucanaccess://"+usuario.getUrl();
            conexion = new ConexionDB(url);
            DiarioDietetico auxDiario = usuario.Diarios.pop();

            int cantidad = Integer.parseInt(cant);
            String porcion = String.valueOf(cantidad)+" "+medida;

            Registro registro = new Registro(porcion, alimento, ManejoDeDiarios.calcularCalorias(alimento, cantidad, medida), tiempo);
            ManejoDeDiarios.agregarRegistro(auxDiario, registro);
            
            panelTiemposComida = new PanelDiarios();
            interfazPrincipal2.cargarPanel1();
            panelTiemposComida.actualizarTablaDiarios(auxDiario);
            
            usuario.Diarios.push(auxDiario);
            conexion.registrarDiario(usuario,registro,medida,cantidad);
            labelCalConsumidas.setText(String.valueOf(auxDiario.getNumeroCalorias()));
        }
        else JOptionPane.showMessageDialog(this, "Los Datos están incorrectos");
            
                

    }//GEN-LAST:event_botonAgregarActionPerformed

    private void entryCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryCantidadActionPerformed

    }//GEN-LAST:event_entryCantidadActionPerformed

    private void selecAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecAlimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecAlimentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JTextField entryCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelCalConsumidas;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelRqCalorico;
    private javax.swing.JComboBox<String> selecAlimento;
    private javax.swing.JComboBox<String> selecMedida;
    private javax.swing.JComboBox<String> selecTiempo;
    // End of variables declaration//GEN-END:variables
   
}
