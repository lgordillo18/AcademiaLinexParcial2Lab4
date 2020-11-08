<%-- 
    Document   : altaInscripcion
    Created on : Nov 8, 2020, 4:38:53 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Nueva Inscripcion - Academia de Programacion Linex</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>

<body>
    <%@include file="/componentes/navbar.jsp" %>
    <main class="page registration-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Nueva Inscripcion</h2>
                    <p>El alumno debe estar registrado antes de inscribirse! Si aun no esta registrado como Alumno toque <a href="Alumnos?section=nuevo">click aqui!</a></p>
                </div>
                <div>
                    <div class="row">
                        <div class="col-7">
                            <form method="post" action="Inscripciones">
                                <div class="form-group">
                                    <label>Alumno</label>
                                    <select class="form-control" name="cmbAlumno" required="">
                                        <c:forEach items="${ listadoAlumnos }" var="item">
                                            <option value="${ item.id }">${ item.nombre } ${ item.apellido }</option>
                                        </c:forEach>
                                    </select>
                                <div class="form-group">
                                    <label>Curso</label>
                                    <select class="form-control" name="cmbCurso" required="">
                                        <c:forEach items="${ listadoCursos }" var="item">
                                            <option value="${ item.id }">${ item.nombre } - $ ${ item.precio }</option>
                                        </c:forEach>
                                    </select>
                                <div class="form-group">
                                    <label>Descuento</label>
                                    <input class="form-control item" type="text" name="txtDesc" style="width: 91px;" value="0">
                                </div>
                                <button class="btn btn-primary btn-block" type="submit" style="padding: 6px;margin-top: 70px;">Inscribir</button></form>
                        </div>
                        <div class="col-md-12 col-lg-4 text-center">
                            <div class="summary">
                                <h3></h3>
                                <h4><span class="text">Subtotal:&nbsp;</span><span class="price">$0</span></h4>
                                <h4><span class="text">Descuento:&nbsp;</span><span class="price">$0</span></h4>
                                <h4 style="margin-top: 37px;"><span class="text">Total:&nbsp;</span><span class="price">$0</span></h4>
                            </div>
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
