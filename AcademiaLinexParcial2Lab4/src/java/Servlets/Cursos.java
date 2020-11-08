/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorCurso;
import Modelos.Curso;
import Modelos.TipoCurso;
import Modelos.TipoTurnoCurso;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Cursos", urlPatterns = {"/Cursos"})
public class Cursos extends HttpServlet {

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
        
        GestorCurso gestor = new GestorCurso();
        String section = request.getParameter("section");
        
        if(section == null || section.isEmpty())
        {
            request.setAttribute("cursos", gestor.obtenerListado());
            
            RequestDispatcher rd = request.getRequestDispatcher("cursos/cursos.jsp");
            rd.forward(request, response);
        } else if(section.equals("nuevo")){
            ArrayList<TipoCurso> listaTipos = gestor.obtenerTipos();
            request.setAttribute("listaTipos", listaTipos);
            ArrayList<TipoTurnoCurso> listaTurnos = gestor.obtenerTurnos();
            request.setAttribute("listaTurnos", listaTurnos);
            
            RequestDispatcher rd = request.getRequestDispatcher("cursos/altaCurso.jsp");
            rd.forward(request, response);
            
        } else if(section.equals("editar")) {
            int idCurso = Integer.parseInt(request.getParameter("id"));
            
            Curso c = gestor.buscarPorId(idCurso);
            request.setAttribute("cursoModel", c);
            ArrayList<TipoCurso> listaTipos = gestor.obtenerTipos();
            request.setAttribute("listaTipos", listaTipos);
            ArrayList<TipoTurnoCurso> listaTurnos = gestor.obtenerTurnos();
            request.setAttribute("listaTurnos", listaTurnos);
            
            RequestDispatcher rd = request.getRequestDispatcher("cursos/editarCurso.jsp");
            rd.forward(request, response);
            
        } else if (section.equals("eliminar")){
            int idCurso = Integer.parseInt(request.getParameter("id"));
            gestor.eliminar(idCurso);
            
            request.setAttribute("cursos", gestor.obtenerListado());
            RequestDispatcher rd = request.getRequestDispatcher("cursos/cursos.jsp");
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
        
        GestorCurso gestor = new GestorCurso();
        String idCurso = request.getParameter("idCurso");
         
        if (idCurso == null) {
            String nombre = request.getParameter("txtNombre");
            String precio = request.getParameter("txtPrecio");
            int tipoCursoId = Integer.parseInt(request.getParameter("cmbTipoCurso"));
            int tipoTurnoId = Integer.parseInt(request.getParameter("cmbHorario"));
            
            Curso c = new Curso(nombre, Double.parseDouble(precio), tipoCursoId, tipoTurnoId);
            gestor.nuevoCurso(c);
            
            RequestDispatcher rd = request.getRequestDispatcher("cursos/cursos.jsp");
            rd.forward(request, response);
        } else {
            String nombre = request.getParameter("txtNombre");
            String precio = request.getParameter("txtPrecio");
            int tipoCursoId = Integer.parseInt(request.getParameter("cmbTipoCurso"));
            int tipoTurnoId = Integer.parseInt(request.getParameter("cmbHorario"));
            
            Curso c = new Curso(nombre, Double.parseDouble(precio), tipoCursoId, tipoTurnoId);
            c.setId(Integer.parseInt(idCurso));
            gestor.actualizar(c);
            
            request.setAttribute("cursos", gestor.obtenerListado());
            RequestDispatcher rd = request.getRequestDispatcher("cursos/cursos.jsp");
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
