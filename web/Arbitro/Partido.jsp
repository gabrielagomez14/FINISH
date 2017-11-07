<%-- 
    Document   : Partido
    Created on : Oct 20, 2017, 2:13:18 PM
    Author     :  Ale Gomez
--%>

<%@page import="java.util.List"%>
<%@page import="org.modelo.*"%>
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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/tables.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Mantenimiento de Partido</title>
        <script Language='JavaScript'>
            function cargar(id, nom, parti, goles, fecha, cEqui, eqVisi,eqlocal, mLoca,mVisi ,j ,arbi, detalle)
            {
                document.frmPartido.id.value = id;
                document.frmPartido.nombre.value = nom;
                document.frmPartido.tPartido.value = parti;
                document.frmPartido.cGoles.value = goles;
                document.frmPartido.fecha.value = fecha;
                document.frmPartido.cEq.value = cEqui;
                document.frmPartido.eqVisitante.value = eqVisi;
                document.frmPartido.mEqVisi.value = mVisi;
                document.frmPartido.eqLocal.value = eqlocal;
                document.frmPartido.mEqLo.value = mLoca;
                document.frmPartido.jornada.value = j;
                document.frmPartido.arbitro.value = arbi;
                document.frmPartido.detalle.value = detalle;
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
    <header>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <font color="white" size="5" face="Arial black">Liga Sivar</font>
                    </a>
                </div>
                <ul class="nav navbar-nav">
                <li><a href="Equipo.jsp"> Equipo</a></li>
                <li><a href="ArbitroA.jsp"> Arbitro</a></li>
                <li><a href="Incidencias.jsp">Inicidencias</a></li>
                <li><a href="Jornada.jsp">Jornada</a></li>
                <li><a href="#">Partidos</a></li>
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
    CrudPartido cpar = new CrudPartido();

%>
<body><div class="well">
        <center>
            <div class="container">
    <table  border="1" class="table table-striped table-bordered table-hover table-condensed">

        <tr>
            <th class="danger">Codigo de Partido</th>
            <th class="danger">Nombre de Partido</th>
            <th class="danger">Tipo</th>
            <th class="danger">N° Goles</th>
            <th class="danger">Fecha</th>
            <th class="danger" hidden="true">id Equipo</th>
            <th class="danger">Eq.Visitante</th>
            <th class="danger">Eq.Local</th>
            <th class="danger">Marc.Visitante</th>
            <th class="danger">Marc.Local</th>
            <th class="danger">Jornada</th>
            <th class="danger">Arbitro</th>
            <th class="danger">Detalle</th>
        </tr>
        <%
            List<Partido> lst2 = cpar.view();
            for (Partido parti : lst2) {
        %>
        <tr>
            <td class="success"><%= parti.getIdPartido()%></td>
            <td class="success"><%= parti.getNombre()%></td>
            <td class="success"><%= parti.getTipoPartido()%></td>
            <td class="success"><%= parti.getNumGoles()%></td>
            <td class="success"><%= parti.getFecha()%></td>
            <td class="success" hidden=""><%= parti.getIdEquipo()%></td>
            <td class="success"><%=parti.getEqVisitante()%></td>
            <td class="success"><%=parti.getEqLocal()%></td>
            <td class="success"><%=parti.getMarcadorVisi()%></td>
            <td class="success"><%=parti.getMarcadorLocal()%></td>
            <td class="success"><%=parti.getIdjornada()%></td>
            <td class="success"><%=parti.getIdArb()%></td>
            <td class="success"><%=parti.getIdDetalle()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table></center>
        </div>
        

</body>
</html>

