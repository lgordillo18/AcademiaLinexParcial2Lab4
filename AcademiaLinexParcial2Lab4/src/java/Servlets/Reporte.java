/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorReporte;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Reporte", urlPatterns = {"/Reporte"})
public class Reporte extends HttpServlet {

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
        
        String reporte = request.getParameter("reporte");
        GestorReporte gestorR = new GestorReporte(); 
        
        if (reporte.equals("1")) {
            request.setAttribute("reporte", gestorR.obtenerReporte1());
            request.setAttribute("nombreReporte", "Total facturado por cada curso");
            request.setAttribute("columna1", "Curso");
            request.setAttribute("columna2", "Total facturado");

            RequestDispatcher rd = request.getRequestDispatcher("reportes/reporte.jsp");
            rd.forward(request, response);
        } else if (reporte.equals("4")) {
            request.setAttribute("reporte", gestorR.obtenerReporte4());
            request.setAttribute("nombreReporte", "Listado de los 5 programas más descargados");
            request.setAttribute("columna1", "Nombre del Programa");
            request.setAttribute("columna2", "Cantidad de Descargas");

            RequestDispatcher rd = request.getRequestDispatcher("reportes/reporte.jsp");
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
