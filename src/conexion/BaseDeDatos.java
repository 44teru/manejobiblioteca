/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martinez
 */

public class BaseDeDatos
{
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    
    public ResultSet getBase(String sql)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecafast","root", "");          
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Error Class" + ex.getMessage());
            return null;
        }
        catch (SQLException ex)
        {
            System.out.println("Error SQL: " + ex.getMessage());
            return null;
        }
    }
    
    public int updateDeleteInsertBase(String sql)
    {
        try
        {
            int num;
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecafast","root", "");          
            st = cn.createStatement();
            num = st.executeUpdate(sql);
            return num;
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Error Class" + ex.getMessage());
            return -1;
        }
        catch (SQLException ex)
        {
            System.out.println("Error SQL: " + ex.getMessage());
            return -1;
        }
    }
    
    public int comprobarConexion()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecafast","root", "");
            return 1;
        }
        catch (ClassNotFoundException ex)
        {
            return 0;
        }
        catch (SQLException ex)
        {
            return -1;
        }
    }
}
