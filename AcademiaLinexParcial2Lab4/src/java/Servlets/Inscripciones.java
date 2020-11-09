/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOs.DtoListadoCursos;
import Gestores.GestorAlumno;
import Gestores.GestorAlumnoInscripto;
import Gestores.GestorCurso;
import Modelos.Alumno;
import Modelos.AlumnoInscripto;
import java.io.IOException;
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
@WebServlet(name = "Inscripciones", urlPatterns = {"/Inscripciones"})
public class Inscripciones extends HttpServlet {

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
        
        if ((String)request.getSession().getAttribute("user") == null || (String)request.getSession().getAttribute("user") == "") {
            RequestDispatcher rd = request.getRequestDispatcher("componentes/errorSession.jsp");
            rd.forward(request, response);
        }
        
        GestorAlumnoInscripto gestorIns = new GestorAlumnoInscripto();
        GestorAlumno gestorAl = new GestorAlumno();
        GestorCurso gestorC = new GestorCurso();
        String section = request.getParameter("section");
        
        if(section == null || section.isEmpty())
        {
            request.setAttribute("inscripciones", gestorIns.obtenerListado());
            
            RequestDispatcher rd = request.getRequestDispatcher("inscripciones/inscripciones.jsp");
            rd.forward(request, response);
        } else if(section.equals("nuevo")){
            ArrayList<Alumno> listaAlumnos = gestorAl.obtenerListado();
            request.setAttribute("listadoAlumnos", listaAlumnos);
            ArrayList<DtoListadoCursos> listaCursos = gestorC.obtenerListado();
            request.setAttribute("listadoCursos", listaCursos);
            
            RequestDispatcher rd = request.getRequestDispatcher("inscripciones/altaInscripcion.jsp");
            rd.forward(request, response);
        } else if (section.equals("eliminar")){
            int idInscripcion = Integer.parseInt(request.getParameter("id"));
            gestorIns.eliminar(idInscripcion);
            
            request.setAttribute("inscripciones", gestorIns.obtenerListado());
            RequestDispatcher rd = request.getRequestDispatcher("inscripciones/inscripciones.jsp");
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

        GestorAlumnoInscripto gestorIns = new GestorAlumnoInscripto();
         
        int idAlumno = Integer.parseInt(request.getParameter("cmbAlumno"));
        int idCurso = Integer.parseInt(request.getParameter("cmbCurso"));
        int descuento = Integer.parseInt(request.getParameter("txtDesc"));
        
        AlumnoInscripto ali = new AlumnoInscripto(idAlumno, idCurso, descuento);
        gestorIns.nuevo(ali);
        
        request.setAttribute("inscripciones", gestorIns.obtenerListado());
        RequestDispatcher rd = request.getRequestDispatcher("inscripciones/inscripciones.jsp");
        rd.forward(request, response);
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
