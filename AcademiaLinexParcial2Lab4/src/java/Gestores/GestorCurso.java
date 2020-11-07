/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Curso;
import Modelos.DtoListadoCursos;
import Modelos.TipoCurso;
import Modelos.TipoTurnoCurso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GestorCurso extends GestorDB {
    
    public void nuevoCurso(Curso curso)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cursos (nombre, precio, turnoId, tipoCursoId) VALUES (?,?,?,?)");
            ps.setString(1, curso.getNombre());
            ps.setDouble(2, curso.getPrecio());
            ps.setInt(3, curso.getTipoTurnoId());
            ps.setInt(4, curso.getTipoCursoId());
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
    
    public ArrayList<TipoCurso> obtenerTipos()
    {
        ArrayList<TipoCurso> combo = new ArrayList<TipoCurso>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TiposDeCurso");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                
                TipoCurso tc = new TipoCurso(id, nombre);
                combo.add(tc);
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
        
        return combo;
    }
    
    public ArrayList<TipoTurnoCurso> obtenerTurnos()
    {
        ArrayList<TipoTurnoCurso> combo = new ArrayList<TipoTurnoCurso>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TurnosDeCurso");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                
                TipoTurnoCurso tc = new TipoTurnoCurso(id, nombre);
                combo.add(tc);
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
        
        return combo;
    }
    
    public ArrayList<DtoListadoCursos> obtenerListado()
    {
        ArrayList<DtoListadoCursos> lista = new ArrayList<DtoListadoCursos>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT c.id, c.nombre, ct.nombre as turno, ch.nombre as horario, c.precio FROM Cursos c JOIN TiposDeCurso ct on c.tipoCursoId = ct.id JOIN TurnosDeCurso ch on c.turnoId = ch.id;");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String turno = rs.getString("turno");
                String horario = rs.getString("horario");
                double precio = rs.getDouble("precio");
                
                DtoListadoCursos curso = new DtoListadoCursos(id, nombre, turno, horario, precio);
                lista.add(curso);
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
    
    public Curso buscarPorId(int idCurso)
    {
        Curso c = null;
        
        try
        {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Cursos WHERE id = ?");
            st.setInt(1, idCurso);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int tipoTurnoId = rs.getInt("turnoId");
                int tipoCursoId = rs.getInt("tipoCursoId");
                
                c = new Curso(nombre, precio, tipoTurnoId, tipoCursoId);
                c.setId(id);
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
        
        return c;
    }
    
    public void actualizar(Curso c)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Cursos SET nombre = ?, precio = ?, turnoId = ?, tipoCursoId = ? WHERE id = ?");
            ps.setString(1, c.getNombre());
            ps.setDouble(2, c.getPrecio());
            ps.setInt(3, c.getTipoTurnoId());
            ps.setInt(4, c.getTipoCursoId());
            ps.setInt(5, c.getId());
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
    
    public void eliminar(int idCurso)
    {
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE Cursos WHERE id = ?");
            ps.setInt(1, idCurso);
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
