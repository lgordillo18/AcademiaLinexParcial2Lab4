/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Alumno;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GestorAlumno extends GestorDB {
    
    public void nuevo(Alumno al)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Alumnos (nombre, apellido, dni, fechaNacimiento, sexo, email) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, al.getNombre());
            ps.setString(2, al.getApellido());
            ps.setString(3, al.getDni());
            ps.setDate(4, al.getFechaNac());
            ps.setInt(5, al.getSexo());
            ps.setString(6, al.getEmail());
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
    
    public ArrayList<Alumno> obtenerListado()
    {
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Alumnos");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                Date fechaNac = rs.getDate("fechaNacimiento");
                int sexo = rs.getInt("sexo");
                String email = rs.getString("email");
                
                Alumno al = new Alumno(nombre, apellido, dni, fechaNac, sexo, email);
                al.setId(id);
                lista.add(al);
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
    
    public Alumno buscarPorId(int idAlumno)
    {
        Alumno al = null;
        
        try
        {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Alumnos WHERE id = ?");
            st.setInt(1, idAlumno);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                Date fechaNac = rs.getDate("fechaNacimiento");
                int sexo = rs.getInt("sexo");
                String email = rs.getString("email");
                
                al = new Alumno(nombre, apellido, dni, fechaNac, sexo, email);
                al.setId(id);
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
        
        return al;
    }
    
    public void actualizar(Alumno al)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Alumnos SET nombre = ?, apellido = ?, dni = ?, fechaNacimiento = ?, sexo = ?, email = ? WHERE id = ?");
            ps.setString(1, al.getNombre());
            ps.setString(2, al.getApellido());
            ps.setString(3, al.getDni());
            ps.setDate(4, al.getFechaNac());
            ps.setInt(5, al.getSexo());
            ps.setString(6, al.getEmail());
            ps.setInt(7, al.getId());
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
    
    public void eliminar(int idAlumno)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE Alumnos WHERE id = ?");
            ps.setInt(1, idAlumno);
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
