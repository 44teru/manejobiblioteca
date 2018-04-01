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
public class AgregarAutor extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarAutor
     */
    public AgregarAutor() {
        initComponents();
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
        txtCodAutor.setEditable(false);
        txtNombre.setEditable(true);
        txtAPaterno.setEditable(true);
        txtAMaterno.setEditable(true);
    }
    
    public void ingresoSerie()
    {
        txtCodAutor.setEditable(true);
        btnGuardar.setEnabled(true);
        btnCambios.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void agregarFrame(JTable t, DefaultTableModel dt)
    {
        try
        {
            BaseDeDatos bd = new BaseDeDatos();
            IngresoElementos ingE = new IngresoElementos();
            int index = t.getSelectedRow();
            txtCodAutor.setText(ingE.seleccionTXT(index, 0, dt));
            txtNombre.setText(ingE.seleccionTXT(index, 1, dt));
            txtAPaterno.setText(ingE.seleccionTXT(index, 2, dt));
            txtAMaterno.setText(ingE.seleccionTXT(index, 3, dt));
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodAutor = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtAPaterno = new javax.swing.JTextField();
        txtAMaterno = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnCambios = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Edicion Autor");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Cod Autor:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Materno:");

        txtCodAutor.setEditable(false);
        txtCodAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodAutorKeyTyped(evt);
            }
        });

        txtNombre.setEditable(false);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtAPaterno.setEditable(false);
        txtAPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAPaternoKeyTyped(evt);
            }
        });

        txtAMaterno.setEditable(false);
        txtAMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAMaternoKeyTyped(evt);
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
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAPaterno)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql, ano, edi, est;
        int i;
        
        if(txtCodAutor.getText().isEmpty() || txtNombre.getText().isEmpty() || txtAPaterno.getText().isEmpty() || txtAMaterno.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Agregar Autor",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            if(ingE.verificarClavePrimaria("autor", "cod_autor", txtCodAutor.getText()) == 1)
            {
                sql = "insert into autor values("+ txtCodAutor.getText() +",'"+ txtNombre.getText() +"','"+ txtAPaterno.getText() +"','"+ txtAMaterno.getText() +"')";
                i = ingE.updateDeleteInsertBase(sql);
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente! (Presione \"Limpiar\" para reflejar cambios en la tabla)","Agregar autor",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Codigo autor ya existe!!", "Clave Primaria",JOptionPane.WARNING_MESSAGE);   
            }
            
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiosActionPerformed
        String ano, edi, est, sql;
        int i;
        IngresoElementos ingE = new IngresoElementos();
        if(txtNombre.getText().isEmpty() || txtAPaterno.getText().isEmpty() || txtAMaterno.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Agregar Autor",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            sql = "update autor set nombre='"+ txtNombre.getText() +"',ape_paterno='"+ txtAPaterno.getText() +"',ape_materno='"+ txtAMaterno.getText() +"' "
                    + "where cod_autor="+ txtCodAutor.getText() +"";
            i = ingE.updateDeleteInsertBase(sql);
            JOptionPane.showMessageDialog(null, "Registros editados correctamente! (Presione \"Limpiar\" para reflejar cambios en la tabla)","Gestion Autor",JOptionPane.INFORMATION_MESSAGE);
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
            seleccion = JOptionPane.showOptionDialog(null, "¿Desea eliminar el elemento cod_autor " + txtCodAutor.getText() + "?", "Confirmacion eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            if(seleccion == 0)
            {
                sql = "select * from autor_libro where autor_cod_autor="+ txtCodAutor.getText() +"";
                rs = ingE.getBase(sql);
                if(rs.next())
                {
                    verif = true;
                }
                if(verif)
                {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar ya que esta ligada con identificadores en tabla libro, elemine libros con relacion y vuelva a intentarlo", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    sql = "delete from autor where cod_autor="+ txtCodAutor.getText() +"";
                    ingE.updateDeleteInsertBase(sql);
                    JOptionPane.showMessageDialog(null, "Operacion exitosa! (Presione \"Limpiar\" para reflejar cambios en la tabla)", "Confirmacion eliminar", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } 
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCodAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodAutorKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.soloNumeros(evt, txtCodAutor);
    }//GEN-LAST:event_txtCodAutorKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.limiteCaracteres(evt, txtNombre, 29);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAPaternoKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.limiteCaracteres(evt, txtAPaterno, 19);
    }//GEN-LAST:event_txtAPaternoKeyTyped

    private void txtAMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAMaternoKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.limiteCaracteres(evt, txtAMaterno, 19);
    }//GEN-LAST:event_txtAMaternoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambios;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JTextField txtCodAutor;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
