/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import DTOs.DtoListadoInscriptos;
import Modelos.AlumnoInscripto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GestorAlumnoInscripto extends GestorDB {
    
    public void nuevo(AlumnoInscripto ali)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO AlumnosInscriptos (idAlumno, idCurso, descuento, fechaInscripcion) VALUES (?, ?, ?, ?)");
            ps.setInt(1, ali.getIdAlumno());
            ps.setInt(2, ali.getIdCurso());
            ps.setInt(3, ali.getDescuento());
            ps.setString(4, ali.getFechaActual());
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
    
    public ArrayList<DtoListadoInscriptos> obtenerListado()
    {
        ArrayList<DtoListadoInscriptos> lista = new ArrayList<DtoListadoInscriptos>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT ali.id as codigo, al.nombre + ' ' + al.apellido as nombreAlumno, c.nombre as nombreCurso, ali.fechaInscripcion as fechaIns FROM AlumnosInscriptos ali JOIN Alumnos al ON al.id = ali.idAlumno JOIN Cursos c ON c.id = ali.idCurso;");
            while(rs.next())
            {
                int id = rs.getInt("codigo");
                String alumno = rs.getString("nombreAlumno");
                String curso = rs.getString("nombreCurso");
                String fechaIns = rs.getString("fechaIns");
                
                DtoListadoInscriptos ali = new DtoListadoInscriptos(id, alumno, curso, fechaIns);
                lista.add(ali);
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
    
    public void eliminar(int idInscripcion)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE AlumnosInscriptos WHERE id = ?");
            ps.setInt(1, idInscripcion);
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
