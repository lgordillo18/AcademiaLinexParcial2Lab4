/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import DTOs.DtoReporte;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GestorReporte extends GestorDB {
    
    public ArrayList<DtoReporte> obtenerReporte1()
    {
        ArrayList<DtoReporte> reporte = new ArrayList<DtoReporte>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT c.nombre as nombre, SUM(c.precio - ((c.precio * ali.descuento) / 100)) as total FROM AlumnosInscriptos ali JOIN Cursos c ON c.id = ali.idCurso GROUP BY c.nombre, c.precio;");
            while(rs.next())
            {
                String nombre = rs.getString("nombre");
                double total = rs.getDouble("total");
                
                DtoReporte r = new DtoReporte(nombre, total);
                reporte.add(r);
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
        
        return reporte;
    }
    
    public ArrayList<DtoReporte> obtenerReporte4()
    {
        ArrayList<DtoReporte> reporte = new ArrayList<DtoReporte>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT TOP 5 p.nombre as nombre, COUNT(*) as total FROM RegistroDescargas rd JOIN Programas p ON p.id = rd.idPrograma GROUP BY p.nombre ORDER BY total DESC;");
            while(rs.next())
            {
                String nombre = rs.getString("nombre");
                double total = rs.getDouble("total");
                
                DtoReporte r = new DtoReporte(nombre, total);
                reporte.add(r);
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
        
        return reporte;
    }
    
    public double sumatoriaTotalDtos() {
        double total = 0;
        
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM((c.precio * ali.descuento) / 100) as total FROM AlumnosInscriptos ali JOIN Cursos c ON c.id = ali.idCurso;");
            while(rs.next())
            {
                total = rs.getDouble("total");
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
        
        return total;
    }
    
}
