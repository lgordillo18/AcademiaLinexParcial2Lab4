<%-- 
    Document   : reportes
    Created on : Nov 9, 2020, 3:38:41 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Reportes - Academia de Programacion Linex</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>

<body>
    <%@include file="/componentes/navbar.jsp" %>
    <main class="page catalog-page">
        <section class="clean-block clean-catalog dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Reportes</h2>
                    <p></p>
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Accion</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Total facturado por cada curso</td>
                                            <td>
                                                <form method="post" action="Reporte?reporte=1">
                                                    <button class="btn btn-primary" type="submit" style="margin-left: 6px;">Ver</button>
                                                </form>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Sumatoria total de los descuentos realizados</td>
                                            <td> ${ totalReporte2 } </td>
                                        </tr>
                                        <tr>
                                            <td>Listado de alumnos de algún curso seleccionado</td>
                                            <td>
                                                <form method="post" action="Reporte?reporte=3">
                                                    <button class="btn btn-primary" type="submit" style="margin-left: 6px;">Ver</button>
                                                </form>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Listado de los 5 programas más descargados</td>
                                            <td>
                                                <form method="post" action="Reporte?reporte=4">
                                                    <button class="btn btn-primary" type="submit" style="margin-left: 6px;">Ver</button>
                                                </form>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Listado de todos los alumnos que accedieron a algún descuento</td>
                                            <td>
                                                <form method="post" action="Reporte?reporte=5">
                                                    <button class="btn btn-primary" type="submit" style="margin-left: 6px;">Ver</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
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
