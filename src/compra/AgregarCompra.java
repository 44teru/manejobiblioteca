/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra;

import Libro.AgregarLibro;
import Libro.GestionLibro;
import conexion.BaseDeDatos;
import conexion.IngresoElementos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martinez
 */
public class AgregarCompra extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarCompra
     */
    public AgregarCompra() {
        initComponents();
        llenarComboBoxLibro();
    }

    public void edicionElementoTabla()
    {
        btnGuardar.setEnabled(false);
        btnCambios.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    
    public void desbloquearInterfaz()
    {
        txtIDCompra.setEditable(false);
        txtPrecio.setEditable(true);
        cmbTituloLibro.setEnabled(true);
        cmbFolioFactura.setEnabled(true);
    }
    
    public void ingresoSerie()
    {
        txtIDCompra.setEditable(true);
        btnGuardar.setEnabled(true);
        btnCambios.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void agregarFrame(JTable t, DefaultTableModel dt)
    {
        int i = 0, num = 0, num2 = 0;
        try
        {
            String sql, sql2;
            ResultSet rs, rsp;
            //BaseDeDatos bd = new BaseDeDatos();
            IngresoElementos ingE = new IngresoElementos();
            int index = t.getSelectedRow();
            txtIDCompra.setText(ingE.seleccionTXT(index, 0, dt));
            txtPrecio.setText(ingE.seleccionTXT(index, 1, dt));
            sql = "select titulo from libro where serie";
            ingE.seleccionCombo(index, 2, dt, cmbTituloLibro, sql);
            sql = "select folio_fac from factura where folio_fac";
            ingE.seleccionCombo(index, 3, dt, cmbFolioFactura, sql);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("error: " +ex.getMessage());
        }
    }

    public void llenarComboBoxLibro()
    {
        IngresoElementos ingE = new IngresoElementos();
        DefaultListModel modelo = new DefaultListModel();
        try
        {
            ResultSet rs;
            BaseDeDatos bd = new BaseDeDatos();
            String sql;
            sql = "select titulo from libro";
            ingE.llenadoCombo(sql, cmbTituloLibro);
            sql = "select folio_fac from factura";
            ingE.llenadoCombo(sql, cmbFolioFactura);
        }
        catch (NullPointerException ex)
        {
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDCompra = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cmbTituloLibro = new javax.swing.JComboBox<>();
        cmbFolioFactura = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnCambios = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edicion Compra");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("ID Compra:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Titulo libro:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Folio factura:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Precio:");

        txtIDCompra.setEditable(false);
        txtIDCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDCompraKeyTyped(evt);
            }
        });

        txtPrecio.setEditable(false);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        cmbTituloLibro.setEnabled(false);
        cmbTituloLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTituloLibroActionPerformed(evt);
            }
        });

        cmbFolioFactura.setEnabled(false);

        btnGuardar.setText("Añadir elemento");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCambios.setText("Guardar cambios");
        btnCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiosActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFolioFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbFolioFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCambios)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTituloLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTituloLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTituloLibroActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql, lib, folio;
        int i;
        
        if(txtIDCompra.getText().isEmpty() || txtPrecio.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Agregar Compra",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            if(ingE.verificarClavePrimaria("compra", "id", txtIDCompra.getText()) == 1)
            {
                lib = ingE.getClavePrimariaCmb(cmbTituloLibro, "serie", "titulo", "libro");
                folio = (String)cmbFolioFactura.getSelectedItem();
                sql = "insert into compra values("+ txtIDCompra.getText() +","+ txtPrecio.getText() +","+ lib +","+ folio +")";
                i = ingE.updateDeleteInsertBase(sql);
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente! (Presione \"Limpiar\" para reflejar cambios en la tabla)","Agregar compra",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ID de compra ya existe!!", "Clave Primaria",JOptionPane.WARNING_MESSAGE);   
            }
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiosActionPerformed
        String lib, folio, sql;
        int i;
        IngresoElementos ingE = new IngresoElementos();
        if(txtIDCompra.getText().isEmpty() || txtPrecio.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Agregar Compra",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            lib = ingE.getClavePrimariaCmb(cmbTituloLibro, "serie", "titulo", "libro");
            folio = (String)cmbFolioFactura.getSelectedItem();
            sql = "update compra set precio="+ txtPrecio.getText() +",libro_serie="+ lib +",factura_folio_fac="+ folio +" "
                    + "where id="+ txtIDCompra.getText() +"";
            i = ingE.updateDeleteInsertBase(sql);
            i = ingE.updateDeleteInsertBase(sql);      
            JOptionPane.showMessageDialog(null, "Registros editados correctamente! (Presione \"Limpiar\" para reflejar cambios en la tabla)","Gestion Compra",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btnCambiosActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        desbloquearInterfaz();
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCambios.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try
        {
            int seleccion;
            String sql;
            ResultSet rs;
            boolean verif = false;
            IngresoElementos ingE = new IngresoElementos();
            //GestionLibro gesLib = new GestionLibro();
            seleccion = JOptionPane.showOptionDialog(null, "¿Desea eliminar el elemento ID " + txtIDCompra.getText() + "?", "Confirmacion eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            if(seleccion == 0)
            {
                sql = "delete from compra where id="+ txtIDCompra.getText() +"";
                ingE.updateDeleteInsertBase(sql);
                JOptionPane.showMessageDialog(null, "Operacion exitosa! (Presione \"Limpiar\" para reflejar cambios en la tabla)", "Confirmacion eliminar", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
        catch (NullPointerException ex)
        {
            
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtIDCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDCompraKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.soloNumeros(evt, txtIDCompra);
    }//GEN-LAST:event_txtIDCompraKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.soloNumeros(evt, txtPrecio);
    }//GEN-LAST:event_txtPrecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambios;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbFolioFactura;
    private javax.swing.JComboBox<String> cmbTituloLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtIDCompra;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
