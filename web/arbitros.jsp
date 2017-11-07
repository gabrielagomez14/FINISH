<%-- 
    Document   : arbitros
    Created on : Nov 4, 2017, 7:40:59 PM
    Author     : fam Gomez
--%>

<%@page import="org.modelo.CrudEquipo"%>
<%@page import="org.modelo.Equipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.modelo.Arbitro"%>
<%@page import="java.util.List"%>
<%@page import="org.modelo.CrudArbitro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arbitro</title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="Imagenes/2.jpg"/>
        <meta name="viewport" content="width=device-width, initial-scale=no , user-scalable=no">

        <!-- complementos de javascrip-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="REFRESH" content="3; URL=http://localhost:8080/Proyecto-multi-master/faces/arbitros.jsp">
        <link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/tables.css" />
        <link rel="stylesheet"  type=" text/css" href="css/MeStyle.css" >
    </head>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <font color="white" size="5" face="Arial black">Liga Sivar</font>
                </a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="Jugador.jsp"> Jugador</a></li>
                <li><a href="Arbitro.jsp"> Arbitro</a></li>
                <li><a href="Partidos.jsp">Partidos</a></li>
                <li><a href="Jornada.jsp">Jornada</a></li>
                <li><a href="Torneo.jsp">Torneo</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" >
                <li><a href="login.jsp"><font color="white"><span class="glyphicon glyphicon-log-in"></span>
                        Iniciar Sesi&oacute;n</font>
                    </a>
                </li>
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
                            <img src="../Imagenes/caro1.1.jpg" alt="">
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
    <body>
        <div class="container">
            <hr>
            <center>
                <font face="Arial black" size="5">!!CONOCE LOS MEJORES ARBITROS DE NUESTROS EQUIPO!!</font>
                <table class="table table-striped table-hover table-condensed">
                    <tr>
                        <th class="danger" >Nombre de Arbitro</th>
                        <th class="danger">Apellido de Arbitro</th>
                        <th class="danger" >Categoria</th>
                        <th class="danger">Rol de Arbitro</th>
                        <th class="danger">Equipo</th>
                    </tr>

                    <%
                        CrudArbitro car = new CrudArbitro();
                        List<Arbitro> lst2 = car.view();
                        for (Arbitro ar : lst2) {
                    %>
                    <tr>
                        <td ><%=ar.getNombre()%></td>
                        <td ><%=ar.getApellido() %></td>
                        <td ><%=ar.getCategoria() %></td>
                        <td ><%=ar.getRolArbi() %></td>
                        <td ><%=ar.getIdEquipo() %></td>

                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table></center>
                
                
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
