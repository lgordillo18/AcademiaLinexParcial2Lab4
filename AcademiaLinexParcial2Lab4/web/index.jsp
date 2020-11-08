<%-- 
    Document   : index
    Created on : Nov 8, 2020, 6:08:22 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Academia de Programacion Linex</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>

<body>
    <%@include file="/componentes/navbar.jsp" %>
    <main class="page landing-page">
        <section class="clean-block clean-hero" style="background-image:url(&quot;tech/image4.jpg&quot;);color:rgba(9, 162, 255, 0.85);">
            <div class="text">
                <h2 style="font-size: 60px;">Academia Linex</h2>
                <p style="font-size: 22px;">Aprende programacion hoy!</p>
                <a href="Cursos"><button class="btn btn-outline-light btn-lg" type="button">Listado de Cursos</button></a>
                <a href="Inscripciones?section=nuevo"><button class="btn btn-outline-light btn-lg" type="button" style="margin-left: 20px;">Inscribirme hoy!</button></a>
            </div>
        </section>
        <section class="clean-block slider dark"></section>
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