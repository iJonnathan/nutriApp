/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import javax.swing.table.TableColumnModel;

/**
 *
 * @author iJona
 */
public class PanelTablaHistorial extends javax.swing.JPanel {

    /**
     * Creates new form PanelTablaHistorial
     */
    public PanelTablaHistorial() {
        initComponents();
        
        TableColumnModel molde = tablaHistorial.getColumnModel();
        
        molde.getColumn(0).setPreferredWidth(10);
        //molde.getColumn(1).setPreferredWidth(95);
        molde.getColumn(2).setPreferredWidth(146);
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Día", "Calorias Consumidas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaHistorial.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tablaHistorial);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 140));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
