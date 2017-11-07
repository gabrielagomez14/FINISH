<%-- 
    Document   : Entrenador
    Created on : Oct 18, 2017, 10:07:30 AM
    Author     :  Ale Gomez
--%>

<%@page import="org.modelo.Jugador"%>
<%@page import="org.modelo.CrudJugador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
HttpSession sesion = request.getSession();
    if (sesion.getAttribute("nivel")==null) 
    {
        response.sendRedirect("../login.jsp");
    }else
    {
        String nivel= sesion.getAttribute("nivel").toString();
        if (!nivel.equals("2")) 
        {
                response.sendRedirect("login.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/tables.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="REFRESH" content="5; URL=http://localhost:8080/Proyecto-multi-master/faces/Entrenador/jugador.jsp">
        <title>Mantenimiento de Jugador</title>
        <script Language='JavaScript'>
            function cargar(id, nom, dui, posi, pais, tel, correo)
            {
                document.frmJugador.id.value = id;
                document.frmJugador.nombre.value = nom;
                document.frmJugador.dui.value = dui;
                document.frmJugador.posicion.value = posi;
                document.frmJugador.pais.value = pais;
                document.frmJugador.telefono.value = tel;
                document.frmJugador.correo.value = correo;
            }
        </script>
        <%
            if (request.getAttribute("valor") != null) {%>
        <script>
            alert('<%= request.getAttribute("valor")%>');
        </script>
        <%
            }
        %>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <font color="white" size="5" face="Arial black">Liga Sivar</font>
                </a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="jugador.jsp">Gestionar Jugador</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Gestionar Partidos
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="Partido.jsp">Partido</a></li>
                        <li><a href="Equipo.jsp">Equipo</a></li>
                        <li><a href="Detalle.jsp">Detalle de Partido</a></li>
                        <li><a href="Incidencias.jsp">Incidencias</a></li>
                        <li><a href="Entrenador.jsp">Entrenador</a></li>
                    </ul>
                </li>
                <li><a href="Arbitro.jsp">Gestionar Arbitro</a></li>
                <li><a href="usuarios.jsp">Usuarios</a></li>
                <li><a href="Jornada.jsp">Jornada</a></li>
                <li><a href="Torneo.jsp">Torneo</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" >
                <li><a href="../login.jsp?cerrar=true"><span class="glyphicon glyphicon-log-in"></span><font> Cerrar Sesion</font></a></li>
            </ul>
        </div>
    </nav>             
</header>
<script src="js/jquery-latest.js"></script> 
<script src="../bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<%
    CrudJugador cju = new CrudJugador();

%>
<body ><div class="well">
        <div class="container">
            <center>
                <table  border="1" class="table table-striped table-bordered table-hover table-condensed">

                    <tr>
                        <th class="danger">Codigo de Jugador</th>
                        <th class="danger">Nombre</th>
                        <th class="danger">DUI</th>
                        <th class="danger">Posicion</th>
                        <th class="danger">Pais</th>
                        <th class="danger">Telefono</th>
                        <th class="danger">Correo</th>

                    </tr>

                    <%            List<Jugador> lst2 = cju.view();
                        for (Jugador ju : lst2) {
                    %>
                    <tr>
                        <td class="success"><%= ju.getIdJugador()%></td>
                        <td class="success"><%= ju.getNombre()%></td>
                        <td class="success"><%= ju.getDui()%></td>
                        <td class="success"><%= ju.getPosicion()%></td>
                        <td class="success"><%= ju.getPais()%></td>
                        <td class="success"><%= ju.getTelefono()%></td>
                        <td class="success"><%=ju.getEmail()%></td>

                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </center>     
        </div>
    </div>
            </body>
            </html>
