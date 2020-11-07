<%-- 
    Document   : altacurso
    Created on : Nov 6, 2020, 10:02:58 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Editar Curso - Academia de Programacion Linex</title>
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
                    <h2 class="text-info">Editar Curso</h2>
                </div>
                <form method="post" action="Cursos">
                    <input type="hidden" name="idCurso" value="<jsp:getProperty name="cursoModel" property="id"></jsp:getProperty>" />
                    <div class="form-group">
                        <label>Nombre</label>
                        <input class="form-control item" type="text" name="txtNombre" required="" value="<jsp:getProperty name="cursoModel" property="nombre"></jsp:getProperty>"></div>
                    <div class="form-group">
                        <label>Precio</label>
                        <input class="form-control item" type="text" name="txtPrecio"  required="" value="<jsp:getProperty name="cursoModel" property="precio"></jsp:getProperty>"></div>
                    <div class="form-group">
                        <label>Tipo de Curso</label>
                        <select class="form-control" id="cmbTipoCurso" name="cmbTipoCurso" required="">
                            <c:forEach items="${ listaTipos }" var="item">
                                <option value="${ item.id }" <c:if test="${ item.id == cursoModel.tipoTurnoId}">selected</c:if>>${ item.nombre }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Horario del Curso</label>
                        <select class="form-control" name="cmbHorario" id="cmbHorario" required="">
                            <c:forEach items="${ listaTurnos }" var="item">
                                <option value="${ item.id }">${ item.nombre }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button class="btn btn-primary btn-block" type="submit" value="Aceptar" style="padding: 6px;margin-top: 70px;">Guardar cambios</button>
                </form>
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