/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
