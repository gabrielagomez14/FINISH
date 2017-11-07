<%-- 
    Document   : VJugador
    Created on : 11-02-2017, 04:40:14 PM
    Author     : carlos paniagua
--%>

<%@page import="org.modelo.CrudPartido"%>
<%@page import="org.modelo.Partido"%>
<%@page import="org.modelo.CrudJugador"%>
<%@page import="org.modelo.Jugador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="shortcut icon" href="Imagenes/2.jpg"/>
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style2.css" rel="stylesheet">
<link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
<meta http-equiv="REFRESH" content="5; URL=http://localhost:26039/Futboll/faces/Partidos.jsp">

<!DOCTYPE html>
<head>
    <title>Partidos</title>
</head>
<body style="background-color:#026593;">

    <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <font color="white" size="5" face="Arial black">Liga Sivar</font>
                    </a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="#">Partidos</a></li>
                    <li><a href="Jugador.jsp">Jugadores</a></li>
                    <li><a href="arbitros.jsp">Arbitros</a></li>
                    <li><a href="clasificaciones.jsp">Clasificaciones</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right" >
                    <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span><font> Cerrar Sesion</font></a></li>
                </ul>
            </div>
        </nav>
    <script src="http://code.jquery.com/jquery-latest.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <!-- section: team -->
    <section id="about" class="section">
        <center>
            <div class="container">
                <font face="Arial black" size="5"><h4>Los jugadores de nuestros equipos</h4></font>
                <div class="row">
                    </center>
                    <table class="table table-condensed table-hover" >
                        <tr>
                            <th bgcolor="E1DBE6">Nombre de Partido</th>
                            <th bgcolor="E1DBE6">Tipo De partido</th>
                            <th bgcolor="E1DBE6">Fecha</th>
                            <th bgcolor="E1DBE6">Visitante</th>
                            <th bgcolor="E1DBE6" colspan="2">Resultado</th>
                            <th bgcolor="E1DBE6">Local</th>
                            <th bgcolor="E1DBE6">Jornada</th>
                            <th bgcolor="E1DBE6">Arbitro</th>
                        </tr>
                        <%CrudPartido cpar= new CrudPartido();
                            List<Partido> lst2 = cpar.view();
                            for (Partido parti : lst2) {
                        %>
                        <tr>
                            <td class="success">
                                &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;

                                <%= parti.getNombre()%>

                            </td>
                            <td class="success"><%= parti.getTipoPartido()%></td>
                            <td class="success"><%= parti.getFecha()%></td>
                            <td class="success"><%=parti.getEqVisitante()%></td>
                            <td colspan="2" bgcolor="AFAEB0">
                        <center><font size="4" color="white">
                           <%=parti.getMarcadorVisi()  %>
                           -
                           <%=parti.getMarcadorLocal()%></font>
                        </center>
                        </td>
                            <td class="success"><%=parti.getEqLocal()%></td>
                            <td class="success"><%=parti.getIdjornada()%></td>
                            <td class="success"><%=parti.getIdArb()%></td>

                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table></center>

                </div>
            </div>
        </center>
        <!-- /.container -->
    </section>
    <!-- end section: team -->

    <footer>
        <!-- section: services -->
        <section id="services" class="section orange">
            <div class="container">
                <font face="Arial black" size="5"><h3>Conoce mas sobre futbol, Te presentamos nuestras p&aacute;ginas amigas</h3></font>
                <!-- Four columns -->

                <div class="row">
                    <div class="span4 animated-fast flyIn">
                        <div class="service-box">
                            <img src="Imagenes/laptop.png" alt="" />
                            <h2>Jornadas</h2>
                            <p>
                                Enterate de lo mejor de la temporada para disfrutar del mejor futbol en Sivar.com
                            </p>
                        </div>
                    </div>
                    <div class="span4 animated flyIn">
                        <div class="service-box">
                            <img src="Imagenes/lab.png" alt="" />
                            <h2>Ligas</h2>
                            <p>
                                Mira los resultados de cada Liga en nuestra nueva plataforma de Sivar
                            </p>
                        </div>
                    </div>
                    <div class="span3 animated-fast flyIn">
                        <div class="service-box">
                            <img src="Imagenes/camera.png" alt="" />
                            <h2>Copas</h2>
                            <p>
                                Encuentra la mejor informacion de los campeones por temporada.
                            </p>
                        </div>
                    </div>

                </div>

            </div>

        </section>
        <p class="copyright">
            &copy; ITCA FEPADE.
        <div class="container">
            <center><font face="Arial black" size="5" col >Sivar Liga</font>&nbsp;&nbsp;&nbsp;&nbsp;
            <img src="../Imagenes/twitter.png" alt=""  >&nbsp;&nbsp;
            <img src="../Imagenes/insta.png" alt=""  >&nbsp;&nbsp;
            <img src="../Imagenes/facebook.png" alt=""  >&nbsp;&nbsp;
            </center>
        </div>
    </div>
</div>
</div>

</footer>


</body>

</html>

