/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lucas
 */
public class GestorDB {
    protected Connection con;
    
    protected void abrirConexion()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=AcademiaProgramacion", "sa", "root");
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
    }
    
    protected void cerrarConexion()
    {
        try
        {
            if(con != null && !con.isClosed())
                con.close();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
    }
    
    public boolean verificacionSesion(String username, String password) {
        boolean iniciarSesion = false;
        
        try
        {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Usuarios WHERE username = ? AND password = ?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                iniciarSesion = true;
            } else {
                iniciarSesion = false;
            }
            rs.close();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        
        return iniciarSesion;
    }
}
