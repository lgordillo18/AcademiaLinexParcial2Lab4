/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import DTOs.DtoListadoProgramas;
import Modelos.Programa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GestorPrograma extends GestorDB {
    
    public void nuevo(Programa p)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Programas (nombre, descargaHabilitada, ruta, idAutor) VALUES (?, ?, ?, ?)");
            ps.setString(1, p.getNombre());
            ps.setBoolean(2, p.isHabilitado());
            ps.setString(3, p.getRuta());
            ps.setInt(4, p.getIdAutor());
            ps.executeUpdate();
            
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
    }
    
    public ArrayList<DtoListadoProgramas> obtenerListado()
    {
        ArrayList<DtoListadoProgramas> lista = new ArrayList<DtoListadoProgramas>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT p.id, p.nombre as nombre, al.nombre + ' ' + al.apellido as nombreAutor, p.descargaHabilitada as habilitada, p.ruta as ruta FROM Programas p JOIN Alumnos al ON al.id = p.idAutor;");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String nombreAutor = rs.getString("nombreAutor");
                boolean habilitada = rs.getBoolean("habilitada");
                String ruta = rs.getString("ruta");
                
                DtoListadoProgramas p = new DtoListadoProgramas(id, nombre, nombreAutor, habilitada, ruta);
                lista.add(p);
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
        
        return lista;
    }
    
    public void habilitar(int programaId, boolean habilitar)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Programas SET descargaHabilitada = ? WHERE id = ?");
            ps.setBoolean(1, habilitar);
            ps.setInt(2, programaId);
            ps.executeUpdate();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
    }
    
    public void eliminar(int idPrograma)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE Programas WHERE id = ?");
            ps.setInt(1, idPrograma);
            ps.executeUpdate();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
    }
}
