/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martinez
 */
public class IngresoElementos extends BaseDeDatos
{
    private DefaultListModel modelo = null;
    public void llenadoTabla(String sql, DefaultTableModel dt)
    {
        String serie = "";
        boolean verif = true;
        ResultSet rs;
        rs = getBase(sql);
        try
        {
            Object datos[] = new Object[11];
            while(rs.next())
            {
                if(verif)
                {
                    for(byte i = 0; i < 11; i++)
                    {
                        datos[i] = rs.getString(i + 1);
                    }
                    serie = rs.getString(1);
                    verif = false;
                }
                else
                {
                    if(rs.getString(1).equals(serie))
                    {
                        if((datos[6].toString().indexOf(rs.getString(7))) == -1)
                        {
                            datos[6] += "," + rs.getString(7);
                        }
                        if((datos[7].toString().indexOf(rs.getString(8))) == -1)
                        {
                            datos[7] += "," + rs.getString(8);
                        }
                        if((datos[9].toString().indexOf(rs.getString(10))) == -1)
                        {
                            datos[9] += "," + rs.getString(10);
                        }
                    }
                    else
                    {
                        dt.addRow(datos);
                        for(byte i = 0; i < 11; i++)
                        {
                            datos[i] = rs.getString(i + 1);
                        }
                        serie = rs.getString(1);
                    }
                }
            }
            dt.addRow(datos);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    public void llenadoTablaSimple(String sql, DefaultTableModel dt, int rango)
    {
        ResultSet rs;
        rs = getBase(sql);
        try
        {
            Object datos[] = new Object[rango];
            while(rs.next())
            {
                for(byte i = 0; i < rango; i++)
                {
                    datos[i] = rs.getString(i + 1);
                }
                dt.addRow(datos);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void limpiarTabla(JTable t, DefaultTableModel dt)
    {
       for (int i = 0; i < t.getRowCount(); i++)
       {
           dt.removeRow(i);
           i-=1;
       }
   }
    
    public void llenadoCombo(String sql, JComboBox cmb)
    {
        try
        {
            ResultSet rs;
            rs = getBase(sql);
            while(rs.next())
            {
                cmb.addItem(rs.getString(1));
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void llenadoListado(String sql, JList lst)
    {
        try
        { 
            modelo = new DefaultListModel();
            ResultSet rs;
            rs = getBase(sql);
            while(rs.next())
            {
                modelo.addElement(rs.getString(1));
            }
            lst.setModel(modelo);
            modelo = new DefaultListModel();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public String seleccionTXT(int index, int posTabla, DefaultTableModel dt)
    {
        String info;
        info = dt.getValueAt(index, posTabla).toString();
        return info;
    }
    
    public void seleccionCombo(int index, int posTabla, DefaultTableModel dt, JComboBox cmb, String sql)
    {
        cmb.setSelectedItem(dt.getValueAt(index, posTabla).toString());
    }
    
    
    /**
     * Realiza la seleccion de JList con los elementos muchos a muchos de SQL
     * @param index objeto de tipo int donde indica la fila seleccionada
     * @param posTabla Pocision de la columna de la tabla para consultar sus elemento comenzando desde cero
     * @param dt Objeto de tipo DefaultTableModel
     * @param lst Objeto de tipo JList que corresponde a la lista a seleccionar
     * @param sqlLlenado Consulta SQL usado consultas elementos totales
     * @param sqlBuscado Consulta SQL usado para buscar seleccion
     */
    public void seleccionListado(int index, int posTabla, DefaultTableModel dt, JList lst, String sqlLlenado, String sqlBuscado)
    {
        try
        {
            int i = 0, j = 0;
            int[] elementos;
            sqlBuscado += " ("+ dt.getValueAt(index, posTabla).toString() +")";
            ResultSet rsLlenado, rsBuscado;
            rsBuscado = getBase(sqlBuscado);
            while(rsBuscado.next()){i++;}
            rsLlenado = getBase(sqlLlenado);
            elementos = new int[i];
            i = 0;
            while(rsLlenado.next())
            {
                rsBuscado = getBase(sqlBuscado);
                while(rsBuscado.next())
                {
                    if(rsBuscado.getString(1).equals(rsLlenado.getString(1)))
                    {
                        elementos[i] = j;
                        i++;
                    }
                }
                j++;
            }
            lst.setSelectedIndices(elementos);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void seleccionListadoConIndice(int index, int posTabla, DefaultTableModel dt, JList lst, String sqlLlenado, String sqlBuscado)
    {
        try
        {
            int i = 0, j = 0;
            int[] elementos;
            sqlBuscado += " ("+ dt.getValueAt(index, posTabla).toString() +")";
            ResultSet rsLlenado, rsBuscado;
            rsBuscado = getBase(sqlBuscado);
            while(rsBuscado.next()){i++;}
            rsLlenado = getBase(sqlLlenado);
            elementos = new int[i];
            i = 0;
            while(rsLlenado.next())
            {
                rsBuscado = getBase(sqlBuscado);
                while(rsBuscado.next())
                {
                    if((rsBuscado.getString(1).substring(0,1)).equals(rsLlenado.getString(1)))
                    {
                        elementos[i] = j;
                        i++;
                    }
                }
                j++;
            }
            lst.setSelectedIndices(elementos);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public int verificarClavePrimaria(String NomTabla, String colPrim, String pk)
    {
        try
        {
            ResultSet rs;
            String sql;
            sql = "select "+ colPrim +" from "+ NomTabla +" where "+ colPrim +"="+ pk +"";
            rs = getBase(sql);
            while(rs.next())
            {
                return 0;
            }
            return 1;
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
            return -1;
        }
    }
    
    public int verificarClavePrimariaString(String NomTabla, String colPrim, String pk)
    {
        try
        {
            ResultSet rs;
            String sql;
            sql = "select "+ colPrim +" from "+ NomTabla +" where "+ colPrim +"='"+ pk +"'";
            rs = getBase(sql);
            while(rs.next())
            {
                return 0;
            }
            return 1;
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
            return -1;
        }
    }
    
    public String getClavePrimariaCmb(JComboBox cmb, String pkTa, String colDesc, String t)
    {
        try
        {
            String dato, pkCmb = "", sql;
            ResultSet rs;
            dato = (String)cmb.getSelectedItem();
            sql = "select "+ pkTa +" from " + t + " where " + colDesc + "='" + dato + "'";
            rs = getBase(sql);
            while(rs.next())
            {
                pkCmb = rs.getString(1);
            }
            return pkCmb;
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public void AutoresLibro(String serieLibro, JList aut)
    {
        try
        {
            String sql, itemLibro;
            ResultSet rs;
            ArrayList<String> autores = new ArrayList<String>();
            ArrayList<String> nombAu = new ArrayList<String>(); 
            autores = (ArrayList<String>)(aut.getSelectedValuesList());
            sql = "select * from autor";
            rs = getBase(sql);
            while(rs.next())
            {
                itemLibro = rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
                for(int i = 0; i < autores.size(); i++)
                {
                    if(itemLibro.equals(autores.get(i)))
                    {
                        nombAu.add(rs.getString(1));
                    }
                }
            }
            for(int i = 0; i < nombAu.size(); i++)
            {
                sql = "insert into autor_libro values("+ serieLibro +","+ nombAu.get(i) +")";
                updateDeleteInsertBase(sql);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    /**
     * Llenado de las tablas muchos a muchos (btnGuardar) que tienen relacion con la tabla Libro (con orden de tablas "pkTabla" - "pkLibro")
     * @param serieLibro txt de serie
     * @param lst JList a usar
     * @param pkCol columna que contiene la clave primaria de la tabla a comparar con sus nombres
     * @param ta nombre de la tabla a comparar por sus nombres
     * @param nomDes nombre de la columna que contiene la descripcion
     * @param tablaMM nombre de la tabla de cardinalidad mucho a muchos
     */
    public void llenadoMuchosAMuchos(String serieLibro, JList lst, String pkCol, String ta, String nomDes, String tablaMM)
    {
        try
        {
            String sql = "";
            ResultSet rs;
            ArrayList<String> datos = new ArrayList<String>();
            ArrayList<String> pkDatos = new ArrayList<String>();
            datos = (ArrayList<String>)(lst.getSelectedValuesList());
            for(int i = 0; i < datos.size(); i++)
            {
                sql = "select "+ pkCol +" from "+ ta +" where "+ nomDes +"='"+ datos.get(i) +"'";
                rs = getBase(sql);
                while(rs.next())
                {
                    pkDatos.add(rs.getString(1));
                }
            }
            for(int i = 0; i < pkDatos.size(); i++)
            {
                sql = "insert into "+ tablaMM +" values("+ pkDatos.get(i) +","+ serieLibro +")";
                updateDeleteInsertBase(sql);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion, contacte al administrador!","Error Excepcion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void soloNumeros(KeyEvent evt, JTextField text)
    {
        char c = evt.getKeyChar();
        if((c < '0' || c > '9') || Character.isWhitespace(c))
        {
            evt.consume();
        }
        if(text.getText().length() == 9)
        {
            evt.consume();
        }
    }
    
    public void limiteCaracteres(KeyEvent evt, JTextField text, int max)
    {
        if(text.getText().length() == max)
        {
            evt.consume();
        }
    }
    
    public boolean verificarJListSinSeleccionar(JList lst)
    {
        if(lst.getSelectedIndex() == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
