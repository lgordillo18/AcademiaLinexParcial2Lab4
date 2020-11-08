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
                    <h2 class="text-info">Editar Alumno</h2>
                </div>
                <form method="post" action="Alumnos">
                    <input type="hidden" name="idCurso" value="<jsp:getProperty name="alumnoModel" property="id"></jsp:getProperty>" />
                    <div class="form-group">
                        <label>Nombre</label>
                        <input class="form-control item" type="text" name="txtNombre" required="" value="<jsp:getProperty name="alumnoModel" property="nombre"></jsp:getProperty>">
                    </div>
                    <div class="form-group">
                        <label>Apellido</label>
                        <input class="form-control item" type="text" name="txtApellido" required="" value="<jsp:getProperty name="alumnoModel" property="apellido"></jsp:getProperty>">
                    </div>
                    <div class="form-group">
                        <label>DNI</label>
                        <input class="form-control item" type="text" name="txtDni" value="<jsp:getProperty name="alumnoModel" property="dni"></jsp:getProperty>">
                    </div>
                    <div class="form-group">
                        <label>Fecha de Nacimiento</label>
                        <input class="form-control" name="cmbFechaNac" type="date" value="<jsp:getProperty name="alumnoModel" property="fechaNac"></jsp:getProperty>">
                    </div>
                    <div class="form-group">
                        <label>Sexo</label>
                        <select class="form-control" name="cmbSexo">
                            <option value="1" <c:if test="${ item.sexo == alumnoModel.sexo}">selected</c:if>>Masculino</option>
                            <option value="2" <c:if test="${ item.sexo == alumnoModel.sexo}">selected</c:if>>Femenino</option>
                            <option value="3" <c:if test="${ item.sexo == alumnoModel.sexo}">selected</c:if>>Otro</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control item" type="email" name="txtEmail" required="" value="<jsp:getProperty name="alumnoModel" property="email"></jsp:getProperty>">
                    </div>
                    <button class="btn btn-primary btn-block" type="submit" style="padding: 6px;margin-top: 70px;">Guardar cambios</button>
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