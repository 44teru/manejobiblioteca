/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libro;

import conexion.BaseDeDatos;
import conexion.IngresoElementos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.InicioGestion;

/**
 *
 * @author Martinez
 */
public class GestionEstado extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;
    BaseDeDatos bd = new BaseDeDatos();
    public GestionEstado() {
        inicioTabla();
        initComponents();
    }

    public DefaultTableModel getDefaultTable()
    {
        return modeloTabla;
    }
    
    private void inicioTabla()
    {
        try
        {
            IngresoElementos ingE = new IngresoElementos();
            modeloTabla = new DefaultTableModel(null,getColumnas())
            {
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            String sql = "select * from estado";
            ingE.llenadoTablaSimple(sql, modeloTabla, 2);
        }
        catch(NullPointerException ex)
        {
            System.out.println("Error null: " +ex.getMessage());
        }
    }
    
    private String[] getColumnas()
    {
        String columnas[] = new String[]{"Cod_estado","Descripcion"};
        return columnas;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rbtnCodEstado = new javax.swing.JRadioButton();
        rbtnDescripcion = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestion Estado");

        tabla.setModel(modeloTabla);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Buscar por:");

        buttonGroup1.add(rbtnCodEstado);
        rbtnCodEstado.setText("Cod. Estado");
        rbtnCodEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnCodEstadoMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnDescripcion);
        rbtnDescripcion.setText("Descripcion");
        rbtnDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnDescripcionMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Buscar:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnCodEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnDescripcion)
                                .addGap(15, 15, 15)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnCodEstado)
                    .addComponent(rbtnDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String busq = "", sql = "", opBusq;
        opBusq = txtBuscar.getText();
        ingE.limpiarTabla(tabla, modeloTabla); 
        if(rbtnCodEstado.isSelected() || rbtnDescripcion.isSelected())
        {
            if(rbtnCodEstado.isSelected())
            {
                busq = "cod_estado";
            }
            if(rbtnDescripcion.isSelected())
            {
                busq = "descripcion";
            }
            sql = "select * from estado where "+ busq +" like '%"+ opBusq +"%'";
            ingE.llenadoTablaSimple(sql, modeloTabla, 2);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion a buscar","Advertencia",JOptionPane.WARNING_MESSAGE);
            sql = "select * from estado";
            ingE.llenadoTablaSimple(sql, modeloTabla, 2);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgregarEstado agEs = new AgregarEstado();
        agEs.desbloquearInterfaz();
        agEs.ingresoSerie();
        InicioGestion.jdVentana.add(agEs);
        agEs.show();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql = "select * from estado";
        buttonGroup1.clearSelection();
        txtBuscar.setText("");
        ingE.limpiarTabla(tabla, modeloTabla);
        ingE.llenadoTablaSimple(sql, modeloTabla, 2);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        AgregarEstado agEs = new AgregarEstado();
        InicioGestion.jdVentana.add(agEs);
        agEs.edicionElementoTabla();
        agEs.show();
        agEs.agregarFrame(tabla, modeloTabla);
    }//GEN-LAST:event_tablaMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if(rbtnCodEstado.isSelected() || rbtnDescripcion.isSelected())
        {
            if(rbtnDescripcion.isSelected())
            {
                IngresoElementos ingE = new IngresoElementos();
                ingE.limiteCaracteres(evt, txtBuscar, 29);
            }
            else
            {
                IngresoElementos ingE = new IngresoElementos();
                ingE.soloNumeros(evt, txtBuscar);
            }
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void rbtnCodEstadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnCodEstadoMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnCodEstadoMousePressed

    private void rbtnDescripcionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnDescripcionMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnDescripcionMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JRadioButton rbtnCodEstado;
    private javax.swing.JRadioButton rbtnDescripcion;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
