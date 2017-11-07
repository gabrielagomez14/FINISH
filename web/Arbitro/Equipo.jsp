<%-- 
    Document   : Equipo
    Created on : Oct 18, 2017, 10:54:16 AM
    Author     :  Ale Gomez
--%>

<%@page import="org.modelo.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("nivel") == null) 
    {
        response.sendRedirect("../login.jsp");
    } else 
    {
        String nivel = sesion.getAttribute("nivel").toString();
        if (!nivel.equals("3")) 
        {
            response.sendRedirect("login.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="../Imagenes/2.jpg"/>
        <link rel="stylesheet"  type=" text/css" href="../css/MeStyle.css" >
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/tables.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="REFRESH" content="3; URL=http://localhost:8080/Proyecto-multi-master/faces/Arbitro/Equipo.jsp">
        <title>Mantenimiento de Equipo</title>
        <script Language='JavaScript'>
            function cargar(id, nom, ju, amo, correo, eq, tipo, tele, cat, puntos, nombreE, juga)
            {
                document.frmEquipo.id.value = id;
                document.frmEquipo.nombre.value = nom;
                document.frmEquipo.numJug.value = ju;
                document.frmEquipo.numAmon.value = amo;
                document.frmEquipo.correo.value = correo;
                document.frmEquipo.direccion.value = eq;
                document.frmEquipo.tipoEq.value = tipo;
                document.frmEquipo.telefono.value = tele;
                document.frmEquipo.cantg.value = cat;
                document.frmEquipo.entrenador.value = nombreE;
                document.frmEquipo.Jugador.value = juga;
                document.frmEquipo.puntaje.value = puntos;
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
                <li><a href="#">Equipo</a></li>
                <li><a href="ArbitroA"> Arbitro</a></li>
                <li><a href="Incidencias.jsp">Inicidencias</a></li>
                <li><a href="Jornada.jsp">Jornada</a></li>
                <li><a href="Partido.jsp">Partidos</a></li>
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
    CrudEquipo ceq = new CrudEquipo();

%>
<body><center>
    <div class="well well-lg">
        <div class="container"><br>
            
<table  border="1" class="table table-striped table-bordered table-hover table-condensed">

        <tr>
            <th class="danger">Nombre</th>
            <th class="danger">Numero Jugadores</th>
            <th class="danger">Numero Amonestados</th>
            <th class="danger">Tipo Equipo</th>
            <th class="danger">Cantidad Goles</th>
            <th class="danger">Nombre de Entrenador</th>
            <th class="danger">Capitan de Equipo</th>
            <th class="danger">Puntaje</th>
        </tr>
        <%
            List<Equipo> lst2 = ceq.view();
            for (Equipo eq : lst2) {
        %>
        <tr>
            <td class="success"><%= eq.getNombre()%></td>
            <td class="success"><%= eq.getNumJugadores()%></td>
            <td class="success"><%= eq.getNumAmonestado()%></td>
            <td class="success"><%=eq.getTipoEq()%></td>
            <td class="success"><%=eq.getCantGoles()%></td>
            <td class="success"><%=eq.getIdEntrenador()%></td>
            <td class="success"><%=eq.getIdJugador()%></td>
            <td class="success"><%=eq.getPuntaje()%></td>
            
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
        </div>
    </div>
        
        <div class="row">
            <div class="color1 col-xs-12 col-sm-6  col-md-3">
                <center><font face="Arial black" size="5" col >Misi&oacute;n</font></center>
                <font size="3">
                <center><img src="../Imagenes/wowo.png" width="75" height="100"></center>
                <p>
                    Proveer a nuestros clientes la informacion actualizada del deporte con alta calidad
                    que les permitan disfrutar al maximo los mejores momentos de su equipo
                </p>
                </font>
            </div>
            <div class="color2 col-xs-12 col-sm-6 col-md-3">
                <center><font face="Arial black" size="5" col >Visi&oacute;n</font></center>
                <center><img src="../Imagenes/wowo.png" width="75" height="67"></center>
                <p>
                    
                    Ser una de los mas solicitados al momento de hablar de deporte
                    y estar en el 1° de los liga top,presentar los resultados 
                    detalladamente y estar a la disponiblidad del client 
                    al momento que desean
                </p>
            </div>
            <div class="color1 col-xs-12 col-sm-6 col-md-3">
                <center><font face="Arial black" size="5" col > Valores</font></center>
                <center><img src="../Imagenes/wowo.png" width="75" height="87"></center>
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
                <center><img src="../Imagenes/wowo.png" width="75" height="75"></center>
                <font size="3">
                <ul>
                    <li> Presentarle lo ultimo en la informacion de futbol</li>
                    <br>
                    <li> Mostrarle al segundo exacto los resultados de cada partido</li>
                </ul>
                </font>
            </div>
        </div>
    
<script scr="http://code.jquey.com/jquery-latest.js"></script>
</body>
</html>

