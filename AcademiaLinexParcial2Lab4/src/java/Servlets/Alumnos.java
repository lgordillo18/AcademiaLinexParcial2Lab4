/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorAlumno;
import Modelos.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "Alumnos", urlPatterns = {"/Alumnos"})
public class Alumnos extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorAlumno gestor = new GestorAlumno();
        String section = request.getParameter("section");
        
        if(section == null || section.isEmpty())
        {
            request.setAttribute("alumnos", gestor.obtenerListado());
            
            RequestDispatcher rd = request.getRequestDispatcher("alumnos/alumnos.jsp");
            rd.forward(request, response);
        } else if(section.equals("nuevo")){
            
            RequestDispatcher rd = request.getRequestDispatcher("alumnos/altaAlumno.jsp");
            rd.forward(request, response);
        } else if(section.equals("editar")) {
            int idAlumno = Integer.parseInt(request.getParameter("id"));
            
            Alumno al = gestor.buscarPorId(idAlumno);
            request.setAttribute("alumnoModel", al);
            
            RequestDispatcher rd = request.getRequestDispatcher("alumnos/editarAlumno.jsp");
            rd.forward(request, response);
            
        } else if (section.equals("eliminar")){
            int idAlumno = Integer.parseInt(request.getParameter("id"));
            gestor.eliminar(idAlumno);
            
            request.setAttribute("alumnos", gestor.obtenerListado());
            RequestDispatcher rd = request.getRequestDispatcher("alumnos/alumnos.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorAlumno gestor = new GestorAlumno();
        String idAlumno = request.getParameter("idAlumno");
        
        if (idAlumno == null) {
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String dni = request.getParameter("txtDni");
            String fechaNac = request.getParameter("cmbFechaNac");
            int sexo = Integer.parseInt(request.getParameter("cmbSexo"));
            String email = request.getParameter("txtEmail");
            
            Alumno al = new Alumno(nombre, apellido, dni, fechaNac, sexo, email);
            gestor.nuevo(al);
            
            request.setAttribute("alumnos", gestor.obtenerListado());
            RequestDispatcher rd = request.getRequestDispatcher("alumnos/alumnos.jsp");
            rd.forward(request, response);
        } else {
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String dni = request.getParameter("txtDni");
            String fechaNac = request.getParameter("cmbFechaNac");
            int sexo = Integer.parseInt(request.getParameter("cmbSexo"));
            String email = request.getParameter("txtEmail");
            
            Alumno al = new Alumno(nombre, apellido, dni, fechaNac, sexo, email);
            al.setId(Integer.parseInt(idAlumno));
            gestor.actualizar(al);
            
            request.setAttribute("alumnos", gestor.obtenerListado());
            RequestDispatcher rd = request.getRequestDispatcher("alumnos/alumnos.jsp");
            rd.forward(request, response);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
