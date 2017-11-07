<%-- 
    Document   : Principal
    Created on : Nov 1, 2017, 11:12:07 AM
    Author     : Ale Gomez
--%>

<%@page import="org.modelo.CrudJugador"%>
<%@page import="org.modelo.Jugador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jugadores</title>
        <meta charset="utf-8">s
        <link rel="shortcut icon" href="../Imagenes/2.jpg"/>
        <meta name="viewport" content="width=device-width, initial-scale=no , user-scalable=no">
        <!-- complementos de javascrip-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="REFRESH" content="5; URL=http://localhost:26039/Futboll/faces/Jugador.jsp">
        <link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/tables.css" />
        <link rel="stylesheet"  type=" text/css" href="css/MeStyle.css" >
    </head>
    <body >
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <font color="white" size="5" face="Arial black">Liga Sivar</font>
                    </a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="Partidos.jsp">Partidos</a></li>
                    <li><a href="arbitros.jsp">Arbitros</a></li>
                    <li><a href="clasificaciones.jsp">Clasificaciones</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right" >
                    <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span><font> Cerrar Sesion</font></a></li>
                </ul>
            </div>
        </nav>
    <header>
        <div class="container">
            <div class="col-md-12">
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- Contenedor de slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="../Imagenes/caro1.1.jpg" alt="" height="200" width="1200" >
                        </div>

                        <div class="item">
                            <img src="../Imagenes/caro1.2.jpg" alt="">
                        </div>

                        <div class="item">
                            <img src="../Imagenes/caro5.jpg" alt="">
                        </div>
                    </div>

                    <!-- Controles -->
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <section class="main row ">
            <article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <font face="Arial black" size="5">Los mejores jugadores de nuestros Equipo !!QUE LO DIFRUTES!!</font>
                <table class="table table-striped table-hover table-condensed">
                    <tr>
                        <th class="danger" hidden="true">Codigo de Jugador</th>
                        <th class="danger">Nombre</th>
                        <th class="danger" hidden="true">DUI</th>
                        <th class="danger">Posicion</th>
                        <th class="danger">Pais</th>
                        <th class="danger" hidden="true">Telefono</th>
                        <th class="danger">Correo</th>
                    </tr>

                    <%
                        CrudJugador cju = new CrudJugador();
                        List<Jugador> lst2 = cju.view();
                        for (Jugador ju : lst2) {
                    %>
                    <tr>
                        <td hidden="true"><%= ju.getIdJugador()%></td>
                        <td ><%= ju.getNombre()%></td>
                        <td hidden="true"><%= ju.getDui()%></td>
                        <td ><%= ju.getPosicion()%></td>
                        <td ><%= ju.getPais()%></td>
                        <td hidden="true"><%= ju.getTelefono()%></td>
                        <td ><%=ju.getEmail()%></td>

                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </article>
        </section>
        
    <footer>
        <div class="container">
            <center><font face="Arial black" size="5" col >Sivar Liga</font>&nbsp;&nbsp;&nbsp;&nbsp;
            <img src="../Imagenes/twitter.png" alt=""  >&nbsp;&nbsp;
            <img src="../Imagenes/insta.png" alt=""  >&nbsp;&nbsp;
            <img src="../Imagenes/facebook.png" alt=""  >&nbsp;&nbsp;
            </center>
        </div>
    </footer>

    <script src="http://code.jquery.com/jquery-latest.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
