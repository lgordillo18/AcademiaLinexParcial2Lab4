/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOs.DtoListadoInscriptos;
import Gestores.GestorAlumnoInscripto;
import Gestores.GestorPrograma;
import Modelos.Programa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author User
 */
@WebServlet(name = "Programas", urlPatterns = {"/Programas"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 5,
    maxRequestSize = 1024 * 1024 * 6,
    location = "C:\\Users\\User\\Documents\\GitHub\\Parcial2Lab4\\AcademiaLinexParcial2Lab4\\web\\subidas"
)
public class Programas extends HttpServlet {

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
        
        GestorPrograma gestor = new GestorPrograma();
        GestorAlumnoInscripto gestorIns = new GestorAlumnoInscripto();
        String section = request.getParameter("section");
        
        if(section == null || section.isEmpty())
        {
            request.setAttribute("programas", gestor.obtenerListado());
            
            RequestDispatcher rd = request.getRequestDispatcher("programas/programas.jsp");
            rd.forward(request, response);
        } else if(section.equals("nuevo")){
            ArrayList<DtoListadoInscriptos> listaAlumnos = gestorIns.obtenerListado();
            request.setAttribute("listadoAlumnos", listaAlumnos);
            
            RequestDispatcher rd = request.getRequestDispatcher("programas/altaPrograma.jsp");
            rd.forward(request, response);
        } else if (section.equals("eliminar")){
            int idPrograma = Integer.parseInt(request.getParameter("id"));
            gestor.eliminar(idPrograma);
            
            request.setAttribute("inscripciones", gestor.obtenerListado());
            RequestDispatcher rd = request.getRequestDispatcher("programas/programas.jsp");
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
        
        GestorPrograma gestor = new GestorPrograma();
        String idPrograma = request.getParameter("id");
        String action = request.getParameter("action");
         
        if (idPrograma == null) {
            String nombre = request.getParameter("txtNombre");
            int idAutor = Integer.parseInt(request.getParameter("cmbAlumno"));
            String ruta = request.getParameter("upload");
            for(Part part:  request.getParts()) {
                String fileName = getFileName(part);
                if (!fileName.isEmpty()) 
                    part.write(idAutor + fileName);
                    ruta = (idAutor + fileName);
            }
            boolean habilitar = request.getParameter("checkDescarga") == "null" ? false : true;
            
            Programa p = new Programa(nombre, habilitar, ruta, idAutor);
            gestor.nuevo(p);
            
            RequestDispatcher rd = request.getRequestDispatcher("programas/programas.jsp");
            rd.forward(request, response);
        }
        
        if (!action.isEmpty()) {
            if (action == "habilitar") {
                gestor.habilitar(Integer.parseInt(idPrograma), true);
            }
            if (action == "deshabilitar") {
                gestor.habilitar(Integer.parseInt(idPrograma), false);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("programas/programas.jsp");
            rd.forward(request, response);
        }
    }
    
    
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
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
