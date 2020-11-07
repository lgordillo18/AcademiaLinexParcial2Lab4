<%-- 
    Document   : cursos
    Created on : Nov 6, 2020, 10:02:11 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Listado de Cursos - Academia Linex</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>

<body>
    <%@include file="navbar.jsp" %>
    <main class="page catalog-page">
        <section class="clean-block clean-catalog dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Cursos Disponibles</h2>
                    <p>Cursos que dictamos en nuestra academia de programadores</p>
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Codigo Curso</th>
                                            <th class="text-center">Nombre</th>
                                            <th class="text-center">Turno</th>
                                            <th class="text-center">Tipo de Dictado</th>
                                            <th class="text-center">Precio</th>
                                            <th style="text-align: right;">Opciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${ cursos }" var="item">
                                            <tr>
                                                <td>${ item.id }</td>
                                                <td class="text-center">${ item.nombre }</td>
                                                <td class="text-center">${ item.turno}</td>
                                                <td class="text-center">${ item.horario }</td>
                                                <td class="text-center">${ item.precio }</td>
                                                <td style="text-align: right;">
                                                    <a href="Cursos?section=editar&id=${ item.id }"><button class="btn btn-primary bg-warning" type="button">Editar</button></a>
                                                    <a href="Cursos?section=eliminar&id=${ item.id }"><button class="btn btn-primary bg-danger" type="button" style="margin-left: 6px;">Eliminar</button></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="row text-right" style="padding-top: 12px;">
                        <div class="col">
                            <a href="Cursos?section=nuevo"><button class="btn btn-primary" type="button" style="width: 107px;">Nuevo</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <footer class="page-footer dark" style="height: 237px;">
        <div class="footer-copyright">
            <p>© 2020 Copyright Text</p>
        </div>
    </footer>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>
