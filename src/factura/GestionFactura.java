/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import conexion.BaseDeDatos;
import conexion.IngresoElementos;
import distribuidor.AgregarDistribuidor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.InicioGestion;

/**
 *
 * @author Martinez
 */
public class GestionFactura extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;
    BaseDeDatos bd = new BaseDeDatos();
    public GestionFactura() {
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
            String sql = "select factura.folio_fac,factura.precio_neto,factura.costo_iva,factura.precio_total,"
                    + "factura.fecha_compra,factura.hora,distribuidor.nombre,metodo_pago.descripcion from factura "
                    + "join distribuidor on distribuidor.rut_dis=factura.distribuidor_rut_dis "
                    + "join metodo_pago on metodo_pago.cod_metod=factura.metodo_pago_cod_metod";
            ingE.llenadoTablaSimple(sql, modeloTabla, 8);
        }
        catch(NullPointerException ex)
        {
            System.out.println("Error null: " +ex.getMessage());
        }
    }
    
    private String[] getColumnas()
    {
        String columnas[] = new String[]{"Folio","Precio neto","Costo IVA","Precio total","Fecha compra","Hora","RUT Distribuidor","Metodo pago"};
        return columnas;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        rbtnFolio = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        rbtnPrecioTotal = new javax.swing.JRadioButton();
        rbtnFechaCompra = new javax.swing.JRadioButton();
        rbtnMetodoPago = new javax.swing.JRadioButton();
        rbtnRutDistribuidor = new javax.swing.JRadioButton();
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
        setTitle("Gestion Factura");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Buscar por:");

        tabla.setModel(modeloTabla);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        buttonGroup1.add(rbtnFolio);
        rbtnFolio.setText("Folio");
        rbtnFolio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnFolioMousePressed(evt);
            }
        });
        rbtnFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFolioActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnPrecioTotal);
        rbtnPrecioTotal.setText("Precio total");
        rbtnPrecioTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnPrecioTotalMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnFechaCompra);
        rbtnFechaCompra.setText("Fecha compra");
        rbtnFechaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnFechaCompraMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnMetodoPago);
        rbtnMetodoPago.setText("Metodo pago");
        rbtnMetodoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnMetodoPagoMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnRutDistribuidor);
        rbtnRutDistribuidor.setText("Rut distribuidor");
        rbtnRutDistribuidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnRutDistribuidorMousePressed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbtnFechaCompra)
                                            .addComponent(rbtnFolio)
                                            .addComponent(rbtnMetodoPago))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbtnPrecioTotal)
                                            .addComponent(rbtnRutDistribuidor)))
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAgregar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimpiar))))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnFolio)
                    .addComponent(rbtnPrecioTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnFechaCompra)
                    .addComponent(rbtnRutDistribuidor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnMetodoPago)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnFolioActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgregarFactura agFac = new AgregarFactura();
        agFac.desbloquearInterfaz();
        agFac.ingresoSerie();
        InicioGestion.jdVentana.add(agFac);
        agFac.show();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String busq = "", sql = "", opBusq;
        opBusq = txtBuscar.getText();
        ingE.limpiarTabla(tabla, modeloTabla); 
        if(rbtnRutDistribuidor.isSelected() || rbtnFechaCompra.isSelected() || rbtnFolio.isSelected()
                || rbtnMetodoPago.isSelected() || rbtnPrecioTotal.isSelected())
        {
            if(rbtnFechaCompra.isSelected())
            {
                busq = "factura.fecha_compra";
            }
            if(rbtnFolio.isSelected())
            {
                busq = "factura.folio_fac";
            }
            if(rbtnMetodoPago.isSelected())
            {
                busq = "metodo_pago.descripcion";
            }
            if(rbtnPrecioTotal.isSelected())
            {
                busq = "factura.precio_total";
            }
            if(rbtnRutDistribuidor.isSelected())
            {
                busq = "distribuidor.nombre";
            }
            sql = "select factura.folio_fac,factura.precio_neto,factura.costo_iva,factura.precio_total,"
                    + "factura.fecha_compra,factura.hora,distribuidor.nombre,metodo_pago.descripcion from factura "
                    + "join distribuidor on distribuidor.rut_dis=factura.distribuidor_rut_dis "
                    + "join metodo_pago on metodo_pago.cod_metod=factura.metodo_pago_cod_metod "
                    + "where "+ busq +" like '%"+ opBusq +"%'";
            ingE.llenadoTablaSimple(sql, modeloTabla, 8);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion a buscar","Advertencia",JOptionPane.WARNING_MESSAGE);
            sql = "select factura.folio_fac,factura.precio_neto,factura.costo_iva,factura.precio_total,"
                    + "factura.fecha_compra,factura.hora,distribuidor.nombre,metodo_pago.descripcion from factura "
                    + "join distribuidor on distribuidor.rut_dis=factura.distribuidor_rut_dis "
                    + "join metodo_pago on metodo_pago.cod_metod=factura.metodo_pago_cod_metod";
            ingE.llenadoTablaSimple(sql, modeloTabla, 8);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql = "select factura.folio_fac,factura.precio_neto,factura.costo_iva,factura.precio_total,"
                    + "factura.fecha_compra,factura.hora,distribuidor.nombre,metodo_pago.descripcion from factura "
                    + "join distribuidor on distribuidor.rut_dis=factura.distribuidor_rut_dis "
                    + "join metodo_pago on metodo_pago.cod_metod=factura.metodo_pago_cod_metod";
        buttonGroup1.clearSelection();
        txtBuscar.setText("");
        ingE.limpiarTabla(tabla, modeloTabla);
        ingE.llenadoTablaSimple(sql, modeloTabla, 8); 
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if(rbtnFechaCompra.isSelected() || rbtnFolio.isSelected() || rbtnMetodoPago.isSelected()
                || rbtnPrecioTotal.isSelected() || rbtnRutDistribuidor.isSelected())
        {
            if(rbtnFechaCompra.isSelected() || rbtnMetodoPago.isSelected() || rbtnRutDistribuidor.isSelected())
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

    private void rbtnFolioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnFolioMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnFolioMousePressed

    private void rbtnPrecioTotalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnPrecioTotalMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnPrecioTotalMousePressed

    private void rbtnFechaCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnFechaCompraMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnFechaCompraMousePressed

    private void rbtnRutDistribuidorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnRutDistribuidorMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnRutDistribuidorMousePressed

    private void rbtnMetodoPagoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMetodoPagoMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnMetodoPagoMousePressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        AgregarFactura agFac = new AgregarFactura();
        InicioGestion.jdVentana.add(agFac);
        agFac.edicionElementoTabla();
        agFac.show();
        agFac.agregarFrame(tabla,modeloTabla);
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
    private javax.swing.JRadioButton rbtnFechaCompra;
    private javax.swing.JRadioButton rbtnFolio;
    private javax.swing.JRadioButton rbtnMetodoPago;
    private javax.swing.JRadioButton rbtnPrecioTotal;
    private javax.swing.JRadioButton rbtnRutDistribuidor;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
