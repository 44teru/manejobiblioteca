/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra;

import conexion.BaseDeDatos;
import conexion.IngresoElementos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.InicioGestion;

/**
 *
 * @author Martinez
 */
public class GestionMetodoPago extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;
    BaseDeDatos bd = new BaseDeDatos();
    public GestionMetodoPago() {
        inicioTabla();
        initComponents();
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
            String sql = "select * from metodo_pago";
            ingE.llenadoTablaSimple(sql, modeloTabla,2);
        }
        catch(NullPointerException ex)
        {
            System.out.println("Error null: " +ex.getMessage());
        }
    }
    
    private String[] getColumnas()
    {
        String columnas[] = new String[]{"Codigo metodo","Descripcion"};
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
        rbtnCodigoMetodo = new javax.swing.JRadioButton();
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
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion Metodo Pago");

        tabla.setModel(modeloTabla);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Buscar por:");

        buttonGroup1.add(rbtnCodigoMetodo);
        rbtnCodigoMetodo.setText("Codigo Metodo Pago");
        rbtnCodigoMetodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnCodigoMetodoMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnDescripcion);
        rbtnDescripcion.setText("Descripcion");
        rbtnDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnDescripcionMousePressed(evt);
            }
        });
        rbtnDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDescripcionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Buscar:");

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rbtnCodigoMetodo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbtnDescripcion))
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnBuscar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAgregar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnLimpiar))
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnCodigoMetodo)
                    .addComponent(rbtnDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String busq = "", sql = "", opBusq;
        opBusq = txtBuscar.getText();
        ingE.limpiarTabla(tabla, modeloTabla); 
        if(rbtnCodigoMetodo.isSelected() || rbtnDescripcion.isSelected())
        {
            if(rbtnCodigoMetodo.isSelected())
            {
                busq = "cod_metod";
            }
            if(rbtnDescripcion.isSelected())
            {
                busq = "descripcion";
            }
            sql = "select * from metodo_pago where "+ busq +" like '%"+ opBusq +"%'";
            ingE.llenadoTablaSimple(sql, modeloTabla,2);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion a buscar","Advertencia",JOptionPane.WARNING_MESSAGE);
            sql = "select * from metodo_pago";
            ingE.llenadoTablaSimple(sql, modeloTabla,2);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql = "select * from metodo_pago";
        buttonGroup1.clearSelection();
        txtBuscar.setText("");
        ingE.limpiarTabla(tabla, modeloTabla);
        ingE.llenadoTablaSimple(sql, modeloTabla,2);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgregarMetodoPago agMP = new AgregarMetodoPago();
        agMP.desbloquearInterfaz();
        agMP.ingresoSerie();
        InicioGestion.jdVentana.add(agMP);
        agMP.show();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        AgregarMetodoPago agMP = new AgregarMetodoPago();
        InicioGestion.jdVentana.add(agMP);
        agMP.edicionElementoTabla();
        agMP.show();
        agMP.agregarFrame(tabla,modeloTabla);
    }//GEN-LAST:event_tablaMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if(rbtnCodigoMetodo.isSelected() || rbtnDescripcion.isSelected())
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

    private void rbtnCodigoMetodoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnCodigoMetodoMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnCodigoMetodoMousePressed

    private void rbtnDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnDescripcionActionPerformed

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
    private javax.swing.JRadioButton rbtnCodigoMetodo;
    private javax.swing.JRadioButton rbtnDescripcion;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
