/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidor;

import Libro.AgregarLibro;
import conexion.BaseDeDatos;
import conexion.IngresoElementos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.InicioGestion;

/**
 *
 * @author Martinez
 */
public class GestionDistribuidor extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;
    BaseDeDatos bd = new BaseDeDatos();
    public GestionDistribuidor()
    {
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
            String sql = "select * from distribuidor";
            ingE.llenadoTablaSimple(sql, modeloTabla, 8);
        }
        catch(NullPointerException ex)
        {
            System.out.println("Error null: " +ex.getMessage());
        }
    }
    
    private String[] getColumnas()
    {
        String columnas[] = new String[]{"RUT Distribuidor","Nombre","Calle","Numero","Comuna","Pais","Fono","Año Contrato"};
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
        rbtnRutDistribuidor = new javax.swing.JRadioButton();
        rbtnCalle = new javax.swing.JRadioButton();
        rbtnComuna = new javax.swing.JRadioButton();
        rbtnNumero = new javax.swing.JRadioButton();
        rbtnNombre = new javax.swing.JRadioButton();
        rbtnAnoContrato = new javax.swing.JRadioButton();
        rbtnPais = new javax.swing.JRadioButton();
        rbtnFono = new javax.swing.JRadioButton();
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
        setTitle("Gestion Distribuidor");

        tabla.setModel(modeloTabla);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Buscar por:");

        buttonGroup1.add(rbtnRutDistribuidor);
        rbtnRutDistribuidor.setText("RUT Distribuidor");
        rbtnRutDistribuidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnRutDistribuidorMousePressed(evt);
            }
        });
        rbtnRutDistribuidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRutDistribuidorActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnCalle);
        rbtnCalle.setText("Calle");
        rbtnCalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnCalleMousePressed(evt);
            }
        });
        rbtnCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCalleActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnComuna);
        rbtnComuna.setText("Comuna");
        rbtnComuna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnComunaMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnNumero);
        rbtnNumero.setText("Numero Domicilio");
        rbtnNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnNumeroMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnNombre);
        rbtnNombre.setText("Nombre");
        rbtnNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnNombreMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnAnoContrato);
        rbtnAnoContrato.setText("Año Contrato");
        rbtnAnoContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnAnoContratoMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnPais);
        rbtnPais.setText("Pais");
        rbtnPais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnPaisMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnFono);
        rbtnFono.setText("Fono");
        rbtnFono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnFonoMousePressed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1))
                                .addComponent(jSeparator1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(rbtnRutDistribuidor)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(rbtnNombre))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(rbtnNumero)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(rbtnComuna)))
                                            .addGap(9, 9, 9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rbtnPais)
                                                .addComponent(rbtnCalle)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbtnFono)
                                            .addGap(56, 56, 56)
                                            .addComponent(rbtnAnoContrato)
                                            .addGap(0, 0, 0))))
                                .addComponent(jSeparator2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator3)
                        .addComponent(jSeparator4)
                        .addComponent(jSeparator5)
                        .addComponent(jSeparator6)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnRutDistribuidor)
                    .addComponent(rbtnNombre)
                    .addComponent(rbtnCalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnNumero)
                    .addComponent(rbtnComuna)
                    .addComponent(rbtnPais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnFono)
                    .addComponent(rbtnAnoContrato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnRutDistribuidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRutDistribuidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnRutDistribuidorActionPerformed

    private void rbtnCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnCalleActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String busq = "", sql = "", opBusq;
        opBusq = txtBuscar.getText();
        ingE.limpiarTabla(tabla, modeloTabla); 
        if(rbtnRutDistribuidor.isSelected() || rbtnNombre.isSelected() || rbtnAnoContrato.isSelected()
                || rbtnCalle.isSelected() || rbtnFono.isSelected() || rbtnComuna.isSelected()
                || rbtnNumero.isSelected() || rbtnPais.isSelected())
        {
            if(rbtnAnoContrato.isSelected())
            {
                busq = "año_contrato";
            }
            if(rbtnCalle.isSelected())
            {
                busq = "calle";
            }
            if(rbtnComuna.isSelected())
            {
                busq = "comuna";
            }
            if(rbtnFono.isSelected())
            {
                busq = "fono";
            }
            if(rbtnNombre.isSelected())
            {
                busq = "nombre";
            }
            if(rbtnNumero.isSelected())
            {
                 busq = "numero";
            }
            if(rbtnPais.isSelected())
            {
                busq = "pais";
            }
            if(rbtnRutDistribuidor.isSelected())
            {
                busq = "rut_dis";
            }
            sql = "select * from distribuidor where "+ busq +" like '%"+ opBusq +"%'";
            ingE.llenadoTablaSimple(sql, modeloTabla, 8);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion a buscar","Advertencia",JOptionPane.WARNING_MESSAGE);
            sql = "select * from distribuidor";
            ingE.llenadoTablaSimple(sql, modeloTabla, 8);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql = "select * from distribuidor";
        buttonGroup1.clearSelection();
        txtBuscar.setText("");
        ingE.limpiarTabla(tabla, modeloTabla);
        ingE.llenadoTablaSimple(sql, modeloTabla, 8); 
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void rbtnRutDistribuidorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnRutDistribuidorMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnRutDistribuidorMousePressed

    private void rbtnNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnNombreMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnNombreMousePressed

    private void rbtnCalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnCalleMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnCalleMousePressed

    private void rbtnNumeroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnNumeroMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnNumeroMousePressed

    private void rbtnComunaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnComunaMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnComunaMousePressed

    private void rbtnPaisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnPaisMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnPaisMousePressed

    private void rbtnFonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnFonoMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnFonoMousePressed

    private void rbtnAnoContratoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnAnoContratoMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnAnoContratoMousePressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if(rbtnAnoContrato.isSelected() || rbtnCalle.isSelected() || rbtnComuna.isSelected()
                || rbtnFono.isSelected() || rbtnNombre.isSelected() || rbtnNumero.isSelected()
                || rbtnPais.isSelected() || rbtnRutDistribuidor.isSelected())
        {
            if(rbtnCalle.isSelected() || rbtnComuna.isSelected() || rbtnNombre.isSelected() || rbtnPais.isSelected() || rbtnRutDistribuidor.isSelected())
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgregarDistribuidor agDis = new AgregarDistribuidor();
        agDis.desbloquearInterfaz();
        agDis.ingresoSerie();
        InicioGestion.jdVentana.add(agDis);
        agDis.show();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        AgregarDistribuidor agDis = new AgregarDistribuidor();
        InicioGestion.jdVentana.add(agDis);
        agDis.edicionElementoTabla();
        agDis.show();
        agDis.agregarFrame(tabla,modeloTabla);
    }//GEN-LAST:event_tablaMouseClicked


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
    private javax.swing.JRadioButton rbtnAnoContrato;
    private javax.swing.JRadioButton rbtnCalle;
    private javax.swing.JRadioButton rbtnComuna;
    private javax.swing.JRadioButton rbtnFono;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JRadioButton rbtnNumero;
    private javax.swing.JRadioButton rbtnPais;
    private javax.swing.JRadioButton rbtnRutDistribuidor;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
