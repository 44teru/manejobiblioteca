/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import Libro.AgregarLibro;
import Libro.GestionLibro;
import conexion.BaseDeDatos;
import conexion.IngresoElementos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martinez
 */
public class AgregarFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarFactura
     */
    public AgregarFactura() {
        initComponents();
        llenarComboBoxAuto();
    }
    
    public ArrayList<String> getListaMes()
    {
        ArrayList<String> meses = new ArrayList<String>();
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Agosto");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");
        return meses;
    }

    public void desbloquearInterfaz()
    {
        txtFolio.setEditable(false);
        txtPrecioNeto.setEditable(true);
        txtCostoIVA.setEditable(false);
        txtPrecioTotal.setEditable(false);
        cmbAno.setEnabled(true);
        cmbDia.setEnabled(true);
        cmbHora.setEnabled(true);
        cmbMes.setEnabled(true);
        cmbMetodoPago.setEnabled(true);
        cmbMinutos.setEnabled(true);
        cmbRutDistribuidor.setEnabled(true);
        chkFechaHora.setEnabled(true);
    }
    
    public void ingresoSerie()
    {
        txtFolio.setEditable(true);
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
        int i = 0, num = 0, num2 = 0;
        try
        {
            String sql, sql2;
            ResultSet rs, rsp;
            BaseDeDatos bd = new BaseDeDatos();
            IngresoElementos ingE = new IngresoElementos();
            int index = t.getSelectedRow();
            txtFolio.setText(ingE.seleccionTXT(index, 0, dt));
            txtPrecioNeto.setText(ingE.seleccionTXT(index, 1, dt));
            txtCostoIVA.setText(ingE.seleccionTXT(index, 2, dt));
            txtPrecioTotal.setText(ingE.seleccionTXT(index, 3, dt));
            cmbAno.setSelectedItem(ingE.seleccionTXT(index, 4, dt).substring(0,4));
            seleccionMes(ingE.seleccionTXT(index, 4, dt).substring(5,7));
            cmbDia.setSelectedItem(ingE.seleccionTXT(index, 4, dt).substring(8,10));
            cmbHora.setSelectedItem(ingE.seleccionTXT(index, 5, dt).substring(0,2));
            cmbMinutos.setSelectedItem(ingE.seleccionTXT(index, 5, dt).substring(3,5));
            sql = "asdf";
            ingE.seleccionCombo(index, 6, dt, cmbRutDistribuidor, sql);
            sql = "asdf";
            ingE.seleccionCombo(index, 7, dt, cmbMetodoPago, sql);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("error: " +ex.getMessage());
        }
    }
     
    public void seleccionMes(String mes)
    {
        int numMes;
        numMes = Integer.parseInt(mes);
        ArrayList<String> recorMes = getListaMes();
        for(int i = 1; i < recorMes.size(); i++)
        {
            if(numMes == i)
            {
                cmbMes.setSelectedItem(recorMes.get(i - 1));
            }
        }
    }
    
    
    public String seleccionDiaMes(String mes)
    {
        String diaMes = "";
        ArrayList<String> recorMes = getListaMes();
        for(int i = 1; i < recorMes.size(); i++)
        {
            if(recorMes.get(i - 1).equals(mes))
            {
                if(i >= 1 || i <= 9)
                {
                    diaMes = "0" + Integer.toString(i);
                }
                else
                {
                    diaMes = Integer.toString(i);
                }
            }
        }
        return diaMes;
    }
    
    public void llenarComboBoxAuto()
    {
        String sql;
        int laFecha;
        Date datos = new Date();
        DateFormat fecha = new SimpleDateFormat("yyyy");
        laFecha = Integer.parseInt(fecha.format(datos));
        IngresoElementos ingE = new IngresoElementos();
        for(int i = 1901; i <= laFecha; i++)
        {
            cmbAno.addItem(Integer.toString(i));
        }
        for(int i = 0; i < 24; i++)
        {
            if(i >= 0 && i <= 9)
            {
                cmbHora.addItem("0" + Integer.toString(i));
            }
            else
            {
                cmbHora.addItem(Integer.toString(i));
            }
        }
        for(int i = 0; i <= 59; i++)
        {
            if(i >= 0 && i <= 9)
            {
                cmbMinutos.addItem("0" + Integer.toString(i));
            }
            else
            {
                cmbMinutos.addItem(Integer.toString(i));
            }
        }
        sql = "select nombre from distribuidor";
        ingE.llenadoCombo(sql, cmbRutDistribuidor);
        sql = "select descripcion from metodo_pago";
        ingE.llenadoCombo(sql, cmbMetodoPago);
        
    }
    
    public void anosBisiestos()
    {
        int residuo;
        residuo = Integer.parseInt((String)cmbAno.getSelectedItem()) % 4;
        if(residuo == 0)
        {
            for(int i = 1; i <= 29; i++)
            {
                if(i > 0 && i <= 9)
                {
                    cmbDia.addItem("0" + Integer.toString(i));
                }
                else
                {
                    cmbDia.addItem(Integer.toString(i));
                }
            } 
        }
        else
        {
            for(int i = 1; i <= 28; i++)
            {
                if(i > 0 && i <= 9)
                {
                    cmbDia.addItem("0" + Integer.toString(i));
                }
                else
                {
                    cmbDia.addItem(Integer.toString(i));
                }
            } 
        }
    }
    
    public void generadorFechas()
    {
        String mesSelecc = cmbMes.getSelectedItem().toString();
        cmbDia.removeAllItems();
        if(mesSelecc.equals("Febrero"))
        {
            anosBisiestos();
        }
        else
        {
            if(mesSelecc.equals("Abril") || mesSelecc.equals("Junio") || mesSelecc.equals("Septiembre") || mesSelecc.equals("Noviembre"))
            {
                for(int i = 1; i <= 30; i++)
                {
                    if(i > 0 && i <= 9)
                    {
                        cmbDia.addItem("0" + Integer.toString(i));
                    }
                    else
                    {
                        cmbDia.addItem(Integer.toString(i));
                    }
                }
            }
            else
            {
                for(int i = 1; i <= 31; i++)
                {
                    if(i > 0 && i <= 9)
                    {
                        cmbDia.addItem("0" + Integer.toString(i));
                    }
                    else
                    {
                        cmbDia.addItem(Integer.toString(i));
                    }
                }
            }
        }
    }
    
    public void calculoIVAneto()
    {
        try
        {
            int costoIVA = 0, costoNeto = 0, costoTotal = 0;
            costoNeto = Integer.parseInt(txtPrecioNeto.getText());
            if(costoNeto >= 180)
            {
                costoIVA = (int)(costoNeto * 0.19);
                costoTotal = costoIVA + costoNeto;
                txtCostoIVA.setText(Integer.toString(costoIVA));
                txtPrecioTotal.setText(Integer.toString(costoTotal));
            }
            else
            {
                txtCostoIVA.setText("0");
                txtPrecioTotal.setText(Integer.toString(costoNeto));
            }
        }
        catch(NumberFormatException ex)
        {
            // El error es por el txtPrecioNeto en blanco
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtPrecioNeto = new javax.swing.JTextField();
        txtCostoIVA = new javax.swing.JTextField();
        txtPrecioTotal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cmbDia = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbAno = new javax.swing.JComboBox<>();
        cmbHora = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbMinutos = new javax.swing.JComboBox<>();
        cmbRutDistribuidor = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnCambios = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        chkFechaHora = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edicion Factura");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Folio:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Precio neto:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Costo IVA:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Precio total:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha compra:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Hora:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Distribuidor:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Metodo pago:");

        txtFolio.setEditable(false);
        txtFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFolioKeyTyped(evt);
            }
        });

        txtPrecioNeto.setEditable(false);
        txtPrecioNeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioNetoActionPerformed(evt);
            }
        });
        txtPrecioNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioNetoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioNetoKeyTyped(evt);
            }
        });

        txtCostoIVA.setEditable(false);

        txtPrecioTotal.setEditable(false);

        cmbDia.setEnabled(false);
        cmbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiaActionPerformed(evt);
            }
        });

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cmbMes.setEnabled(false);
        cmbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMesItemStateChanged(evt);
            }
        });
        cmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesActionPerformed(evt);
            }
        });

        cmbAno.setEnabled(false);
        cmbAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAnoItemStateChanged(evt);
            }
        });
        cmbAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnoActionPerformed(evt);
            }
        });

        cmbHora.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText(":");

        cmbMinutos.setEnabled(false);
        cmbMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMinutosActionPerformed(evt);
            }
        });

        cmbRutDistribuidor.setEnabled(false);

        cmbMetodoPago.setEnabled(false);
        cmbMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetodoPagoActionPerformed(evt);
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

        chkFechaHora.setText("Fecha y hora actual");
        chkFechaHora.setEnabled(false);
        chkFechaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFechaHoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCostoIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbRutDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkFechaHora)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCostoIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cmbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbRutDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkFechaHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCambios)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioNetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioNetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioNetoActionPerformed

    private void cmbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDiaActionPerformed

    private void cmbMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMinutosActionPerformed

    private void cmbMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetodoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMetodoPagoActionPerformed

    private void cmbAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAnoActionPerformed

    private void cmbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMesItemStateChanged
        generadorFechas();
    }//GEN-LAST:event_cmbMesItemStateChanged

    private void cmbAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAnoItemStateChanged
        generadorFechas();
    }//GEN-LAST:event_cmbAnoItemStateChanged

    private void txtPrecioNetoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioNetoKeyReleased
        calculoIVAneto();
    }//GEN-LAST:event_txtPrecioNetoKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql, ano, mes, dia, hora, minutos, dis, met, horaTotal, fechaTotal;
        int i;
        if(txtCostoIVA.getText().isEmpty() || txtFolio.getText().isEmpty() || txtPrecioNeto.getText().isEmpty() || txtPrecioTotal.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Agregar Factura",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            calculoIVAneto();
            if(ingE.verificarClavePrimaria("factura", "folio_fac", txtFolio.getText()) == 1)
            {
                ano = (String)cmbAno.getSelectedItem();
                mes =  seleccionDiaMes((String)cmbMes.getSelectedItem());
                dia = (String)cmbDia.getSelectedItem();
                
                hora = (String)cmbHora.getSelectedItem();
                minutos = (String)cmbMinutos.getSelectedItem();
                
                fechaTotal = ano + "-" + mes + "-" + dia;
                horaTotal = hora + ":" + minutos + ":00";
                
                dis = ingE.getClavePrimariaCmb(cmbRutDistribuidor, "rut_dis", "nombre", "distribuidor");
                met = ingE.getClavePrimariaCmb(cmbMetodoPago, "cod_metod", "descripcion", "metodo_pago");
                
                sql = "insert into factura values("+ txtFolio.getText() +","+ txtPrecioNeto.getText() +","+ txtCostoIVA.getText() +","
                        + ""+txtPrecioTotal.getText()+",'"+ fechaTotal +"','"+ horaTotal +"','"+ dis +"',"+ met +")";
                i = ingE.updateDeleteInsertBase(sql);
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente! (Presione \"Limpiar\" para reflejar cambios en la tabla)","Agregar factura",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Folio de factura ya existe!!", "Clave Primaria",JOptionPane.WARNING_MESSAGE);   
            }
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiosActionPerformed
        IngresoElementos ingE = new IngresoElementos();
        String sql, ano, mes, dia, hora, minutos, dis, met, horaTotal, fechaTotal;
        int i;
        if(txtCostoIVA.getText().isEmpty() || txtPrecioNeto.getText().isEmpty() || txtPrecioTotal.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Agregar Factura",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            calculoIVAneto();
            ano = (String)cmbAno.getSelectedItem();
            mes =  seleccionDiaMes((String)cmbMes.getSelectedItem());
            dia = (String)cmbDia.getSelectedItem();

            hora = (String)cmbHora.getSelectedItem();
            minutos = (String)cmbMinutos.getSelectedItem();

            fechaTotal = ano + "-" + mes + "-" + dia;
            horaTotal = hora + ":" + minutos + ":00";

            dis = ingE.getClavePrimariaCmb(cmbRutDistribuidor, "rut_dis", "nombre", "distribuidor");
            met = ingE.getClavePrimariaCmb(cmbMetodoPago, "cod_metod", "descripcion", "metodo_pago");

            sql = "update factura set precio_neto="+ txtPrecioNeto.getText() +",costo_iva="+ txtCostoIVA.getText() +","
                    + "precio_total="+ txtPrecioTotal.getText() +",fecha_compra='"+ fechaTotal +"',hora='"+ horaTotal +"',"
                    + "distribuidor_rut_dis='"+ dis +"',metodo_pago_cod_metod="+ met +" "
                    + "where folio_fac="+ txtFolio.getText() +"";
            i = ingE.updateDeleteInsertBase(sql);
            JOptionPane.showMessageDialog(null, "Registros editados correctamente! (Presione \"Limpiar\" para reflejar cambios en la tabla)","Gestion Factura",JOptionPane.INFORMATION_MESSAGE);
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
            seleccion = JOptionPane.showOptionDialog(null, "¿Desea eliminar el elemento folio " + txtFolio.getText() + "?", "Confirmacion eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            if(seleccion == 0)
            {
                sql = "select * from compra where factura_folio_fac="+ txtFolio.getText() +"";
                rs = ingE.getBase(sql);
                if(rs.next())
                {
                    verif = true;
                }
                if(verif)
                {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar ya que esta ligada con identificadores en tabla compra, elimine compras con relacion y vuelva a intentarlo", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    sql = "delete from factura where folio_fac="+ txtFolio.getText() +"";
                    ingE.updateDeleteInsertBase(sql);
                    JOptionPane.showMessageDialog(null, "Operacion exitosa! (Presione \"Limpiar\" para reflejar cambios en la tabla)", "Confirmacion eliminar", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtFolioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.soloNumeros(evt, txtFolio);
    }//GEN-LAST:event_txtFolioKeyTyped

    private void txtPrecioNetoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioNetoKeyTyped
        IngresoElementos ingE = new IngresoElementos();
        ingE.soloNumeros(evt, txtPrecioNeto);
    }//GEN-LAST:event_txtPrecioNetoKeyTyped

    private void chkFechaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFechaHoraActionPerformed
        String hr, min, dia, mes, ano;
        if(chkFechaHora.isSelected())
        {
            Date datos = new Date();
            DateFormat hora = new SimpleDateFormat("HH:mm");
            DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            hr = hora.format(datos).substring(0,2);
            min = hora.format(datos).substring(3,5);
            dia = fecha.format(datos).substring(0,2);
            mes = fecha.format(datos).substring(3,5);
            ano = fecha.format(datos).substring(6,10);
            cmbHora.setSelectedItem(hr);
            cmbMinutos.setSelectedItem(min);
            cmbDia.setSelectedItem(dia);
            seleccionMes(mes);
            cmbAno.setSelectedItem(ano);
            cmbHora.setEnabled(false);
            cmbMinutos.setEnabled(false);
            cmbDia.setEnabled(false);
            cmbMes.setEnabled(false);
            cmbAno.setEnabled(false);
        }
        else
        {
            cmbHora.setEnabled(true);
            cmbMinutos.setEnabled(true);
            cmbDia.setEnabled(true);
            cmbMes.setEnabled(true);
            cmbAno.setEnabled(true);
        }
    }//GEN-LAST:event_chkFechaHoraActionPerformed

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambios;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkFechaHora;
    private javax.swing.JComboBox<String> cmbAno;
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JComboBox<String> cmbMinutos;
    private javax.swing.JComboBox<String> cmbRutDistribuidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtCostoIVA;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtPrecioNeto;
    private javax.swing.JTextField txtPrecioTotal;
    // End of variables declaration//GEN-END:variables
}
