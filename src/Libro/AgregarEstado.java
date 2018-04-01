/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libro;

import conexion.BaseDeDatos;
import conexion.IngresoElementos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martinez
 */
public class AgregarEstado extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarEstado
     */
    public AgregarEstado() {
        initComponents();
    }

    public void desbloquearInterfaz()
    {
        txtCodEstado.setEditable(false);
        txtDescripcion.setEditable(true);
    }
    
    public void ingresoSerie()
    {
        txtCodEstado.setEditable(true);
        btnGuardar.setEnabled(true);
        btnCambios.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void edicionElementoTabla()
    {
        btnGuardar.setEnabled(false);
        btnCambios.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    
    public void agregarFrame(JTable t, DefaultTableModel dt)
    {
        try
        {
            BaseDeDatos bd = new BaseDeDatos();
            IngresoElementos ingE = new IngresoElementos();
            int index = t.getSelectedRow();
            txtCodEstado.setText(ingE.seleccionTXT(index, 0, dt));
            txtDescripcion.setText(ingE.seleccionTXT(index, 1, dt));
        }
        catch (NumberFormatException ex)
        {
            System.out.println("error: " +ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodEstado = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnCambios = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edicion Estado");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Codigo Estado:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Descripcion:");

        txtCodEstado.setEditable(false);
        txtCodEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodEstadoKeyTyped(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel2)
                    .addComponent(txtCodEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql, ano, edi, est;
        int i;
        
        if(txtCodEstado.getText().isEmpty() || txtDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Agregar Estado",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            if(ingE.verificarClavePrimaria("estado", "cod_estado", txtCodEstado.getText()) == 1)
            {
                sql = "insert into estado values("+ txtCodEstado.getText() +",'"+ txtDescripcion.getText() +"')";
                i = ingE.updateDeleteInsertBase(sql);
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente! (Presione \"Limpiar\" para reflejar cambios en la tabla)","Agregar estado",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Codigo estado ya existe!!", "Clave Primaria",JOptionPane.WARNING_MESSAGE);   
            }
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiosActionPerformed
        String ano, edi, est, sql;
        int i;
        IngresoElementos ingE = new IngresoElementos();
        if(txtDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Agregar Estado",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            sql = "update estado set descripcion='"+ txtDescripcion.getText() +"' "
                    + "where cod_estado="+ txtCodEstado.getText() +"";
            i = ingE.updateDeleteInsertBase(sql);
            JOptionPane.showMessageDialog(null, "Registros editados correctamente! (Presione \"Limpiar\" para reflejar cambios en la tabla)","Gestion Estado",JOptionPane.INFORMATION_MESSAGE);
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
            seleccion = JOptionPane.showOptionDialog(null, "¿Desea eleminar el elemento cod_estado " + txtCodEstado.getText() + "?", "Confirmacion eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            if(seleccion == 0)
            {
                sql = "select * from libro where estado_cod_estado="+ txtCodEstado.getText() +"";
                rs = ingE.getBase(sql);
                if(rs.next())
                {
                    verif = true;
                }
                if(verif)
                {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar ya que esta ligada con identificadores en tabla libro, elimine libros con relacion y vuelva a intentarlo", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    sql = "delete from estado where cod_estado="+ txtCodEstado.getText() +"";
                    ingE.updateDeleteInsertBase(sql);
                    JOptionPane.showMessageDialog(null, "Operacion exitosa! (Presione \"Limpiar\" para reflejar cambios en la tabla)", "Confirmacion eliminar", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } 
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCodEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodEstadoKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.soloNumeros(evt, txtCodEstado);
    }//GEN-LAST:event_txtCodEstadoKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.limiteCaracteres(evt, txtDescripcion, 29);
    }//GEN-LAST:event_txtDescripcionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambios;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtCodEstado;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
