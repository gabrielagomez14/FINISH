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
        <title>Sivar liga</title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="../Imagenes/2.jpg"/>
        <meta name="viewport" content="width=device-width, initial-scale=no , user-scalable=no">
        <!-- complementos de javascrip-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
                    <li><a href="Jugador.jsp">Jugadores</a></li>
                    <li><a href="Partidos.jsp">Partidos</a></li>
                    <li><a href="arbitros.jsp">Arbitros</a></li>
                    <li><a href="clasificaciones.jsp">Clasificaciones</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right" >
                    <li><a href="login.jsp"><font color="white" face="Arial Black"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesion</font></a></li>
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
                <center><marquee><font face="Arial black" size="5" col >!!!no te lo puedes perder!!!</font></marquee></center>
                <center><img src="../Imagenes/cj.jpg" ></center>
                <center><font face="Ar Julian" size="5" col >
                    <p>
                        Te presentaremos resultados en tiempo real a segundo exactos del partido
                        no te pierdas ningun detalle de tu equipo favoritos, con nosotros te sentiras muy cerca 
                        de tus jugadores y equipos favoritos
                    
                        <br>
                        !!QUE ESPERAS APOYELOS!!
                    </p>
                    </font></center>
                
                <br>
            </article>

        </section>
        <div class="row">
            <div class="color1 col-xs-12 col-sm-6  col-md-3">
                <center><font face="Arial black" size="5" col >Misi&oacute;n</font></center>
                <font size="3">
                <center><img src="Imagenes/wowo.png" width="75" height="75"></center>
                <p>
                    Proveer a nuestros clientes la informacion actualizada del deporte con alta calidad
                    que les permitan disfrutar al maximo los mejores momentos de su equipo
                </p>
                </font>
            </div>
            <div class="color2 col-xs-12 col-sm-6 col-md-3">
                <center><font face="Arial black" size="5" col >Visi&oacute;n</font></center>
                <center><img src="Imagenes/wowo.png" width="75" height="67"></center>
                <p>
                    
                    Ser una de los mas solicitados al momento de hablar de deporte
                    y estar en el 1° de los liga top,presentar los resultados 
                    detalladamente y estar a la disponiblidad del client 
                    al momento que desean
                </p>
            </div>
            <div class="color1 col-xs-12 col-sm-6 col-md-3">
                <center><font face="Arial black" size="5" col > Valores</font></center>
                <center><img src="Imagenes/wowo.png" width="75" height="87"></center>
                <ul>
                    <li>Innovación.</li>
                    <li>Responsabilidad.</li>
                    <li>Compromiso.</li>
                    <li>Calidad.</li>
                    <li>Seguridad.</li>
                    <li>Confiabilidad.</li>
                </ul>
            </div>
            <div class="color2 col-xs-12 col-sm-6 col-md-3">
                <center><font face="Arial black" size="5" col > Objetivos</font></center>
                <center><img src="Imagenes/wowo.png" width="75" height="75"></center>
                <font size="3">
                <ul>
                    <li> Presentarle lo ultimo en la informacion de futbol</li>
                    <br>
                    <li> Mostrarle al segundo exacto los resultados de cada partido</li>
                </ul>
                </font>
            </div>
        </div>
    </div>
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
