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
public class GestionCompra extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;
    BaseDeDatos bd = new BaseDeDatos();
    public GestionCompra() {
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
            String sql = "select compra.id,compra.precio,libro.titulo,compra.factura_folio_fac from compra "
                    + "join libro on libro.serie=compra.libro_serie";
            ingE.llenadoTablaSimple(sql, modeloTabla,4);
        }
        catch(NullPointerException ex)
        {
            System.out.println("Error null: " +ex.getMessage());
        }
    }
    
    private String[] getColumnas()
    {
        String columnas[] = new String[]{"ID Compra","Precio","Titulo libro","Folio factura"};
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
        rbtnIDCompra = new javax.swing.JRadioButton();
        rbtnPrecio = new javax.swing.JRadioButton();
        rbtnTituloLibro = new javax.swing.JRadioButton();
        rbtnFolioFactura = new javax.swing.JRadioButton();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion Compra");

        tabla.setModel(modeloTabla);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Buscar por:");

        buttonGroup1.add(rbtnIDCompra);
        rbtnIDCompra.setText("ID Compra");
        rbtnIDCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnIDCompraMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnPrecio);
        rbtnPrecio.setText("Precio");
        rbtnPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnPrecioMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnTituloLibro);
        rbtnTituloLibro.setText("Titulo libro");
        rbtnTituloLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnTituloLibroMousePressed(evt);
            }
        });

        buttonGroup1.add(rbtnFolioFactura);
        rbtnFolioFactura.setText("Folio factura");
        rbtnFolioFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnFolioFacturaMousePressed(evt);
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

        jMenu1.setText("Metodo Pago");

        jMenuItem1.setText("Gestion metodo pago");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbtnIDCompra)
                                .addComponent(rbtnPrecio))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbtnTituloLibro)
                                .addComponent(rbtnFolioFactura)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnBuscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnLimpiar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
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
                    .addComponent(rbtnIDCompra)
                    .addComponent(rbtnFolioFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnPrecio)
                    .addComponent(rbtnTituloLibro))
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
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        GestionMetodoPago gesMP = new GestionMetodoPago();
        InicioGestion.jdVentana.add(gesMP);
        gesMP.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String busq = "", sql = "", opBusq;
        opBusq = txtBuscar.getText();
        ingE.limpiarTabla(tabla, modeloTabla); 
        if(rbtnFolioFactura.isSelected() || rbtnIDCompra.isSelected() || rbtnPrecio.isSelected()
                || rbtnTituloLibro.isSelected())
        {
            if(rbtnFolioFactura.isSelected())
            {
                busq = "compra.factura_folio_fac";
            }
            if(rbtnIDCompra.isSelected())
            {
                busq = "compra.id";
            }
            if(rbtnPrecio.isSelected())
            {
                busq = "compra.precio";
            }
            if(rbtnTituloLibro.isSelected())
            {
                busq = "libro.titulo";
            }
            sql = "select compra.id,compra.precio,libro.titulo,compra.factura_folio_fac from compra "
                    + "join libro on libro.serie=compra.libro_serie "
                    + "where "+ busq +" like '%"+ opBusq +"%'";
            ingE.llenadoTablaSimple(sql, modeloTabla,4);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion a buscar","Advertencia",JOptionPane.WARNING_MESSAGE);
            sql = "select compra.id,compra.precio,libro.titulo,compra.factura_folio_fac from compra "
                    + "join libro on libro.serie=compra.libro_serie";
            ingE.llenadoTablaSimple(sql, modeloTabla,4);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql = "select compra.id,compra.precio,libro.titulo,compra.factura_folio_fac from compra "
                    + "join libro on libro.serie=compra.libro_serie";
        buttonGroup1.clearSelection();
        txtBuscar.setText("");
        ingE.limpiarTabla(tabla, modeloTabla);
        ingE.llenadoTablaSimple(sql, modeloTabla,4);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        //asdf
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if(rbtnFolioFactura.isSelected() || rbtnIDCompra.isSelected() || rbtnPrecio.isSelected()
                || rbtnTituloLibro.isSelected())
        {
            if(rbtnTituloLibro.isSelected())
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

    private void rbtnIDCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnIDCompraMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnIDCompraMousePressed

    private void rbtnFolioFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnFolioFacturaMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnFolioFacturaMousePressed

    private void rbtnPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnPrecioMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnPrecioMousePressed

    private void rbtnTituloLibroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnTituloLibroMousePressed
        txtBuscar.setText("");
    }//GEN-LAST:event_rbtnTituloLibroMousePressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        AgregarCompra agCom = new AgregarCompra();
        InicioGestion.jdVentana.add(agCom);
        agCom.edicionElementoTabla();
        agCom.show();
        agCom.agregarFrame(tabla,modeloTabla);
    }//GEN-LAST:event_tablaMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgregarCompra agCom = new AgregarCompra();
        agCom.desbloquearInterfaz();
        agCom.ingresoSerie();
        InicioGestion.jdVentana.add(agCom);
        agCom.show();
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JRadioButton rbtnFolioFactura;
    private javax.swing.JRadioButton rbtnIDCompra;
    private javax.swing.JRadioButton rbtnPrecio;
    private javax.swing.JRadioButton rbtnTituloLibro;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
