<%-- 
    Document   : navbar
    Created on : Nov 7, 2020, 3:18:12 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="#">Academia Linex</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
            id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="Programas">Programas</a></li>
                <% if ((String)request.getSession().getAttribute("user") != null && (String)request.getSession().getAttribute("user") != "") { %>
                    <li class="nav-item"><a class="nav-link" href="Cursos">Cursos</a></li>
                    <li class="nav-item"><a class="nav-link" href="Alumnos">Alumnos</a></li>
                    <li class="nav-item"><a class="nav-link" href="Inscripciones">Inscripciones</a></li>
                    <li class="nav-item"><a class="nav-link" href="Reportes">Reportes</a></li> 
                <% } %>
                <li class="nav-item"><a class="nav-link" href="Login">Iniciar Sesion</a></li>
            </ul>
        </div>
    </div>
</nav>
