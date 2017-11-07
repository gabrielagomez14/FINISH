<%-- 
    Document   : Arbitro
    Created on : Oct 14, 2017, 2:17:59 PM
    Author     : Ale Gomez
--%>

<%@page import="org.modelo.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  session="true" %>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Arbitro</title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="../Imagenes/2.jpg"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/tables.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script Language='JavaScript'>
            function cargar(id, nom, ape, sue, cate, rol, eq)
            {
                document.frmArb.id.value = id;
                document.frmArb.nombre.value = nom;
                document.frmArb.apellido.value = ape;
                document.frmArb.sueldo.value = sue;
                document.frmArb.categoria.value = cate;
                document.frmArb.rol.value = rol;
                document.frmArb.equipo.value = eq;
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
                   <li><a href="#">Arbitro</a></li>
                    <li><a href="EquipoE.jsp">Agrega tu Equipo</a></li>
                    <li><a href="Jornada.jsp">Jornada</a></li>
                    <li><a href="Torneo.jsp">Torneo</a></li>
                    <li><a href="jugador.jsp">Jugadores</a></li>
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
    CrudArbitro car = new CrudArbitro();

%>
<body >
    <div class="well well-lg">
    <div class="container">
        <table  border="1" class="table table-striped table-bordered table-hover table-condensed">

        <tr>
            <th class="danger">Codigo</th>
            <th class="danger">Nombre</th>
            <th class="danger">Apellido</th>
            <th class="danger">Sueldo</th>
            <th class="danger">Categoria</th>
            <th class="danger">Rol de Arbitro</th>
            <th class="danger">Nombre de Equipo</th>
            <th class="danger">Seleccionar</th>
        </tr>
        <%
            List<Arbitro> lst2 = car.view();
            for (Arbitro ve : lst2) {
        %>
        <tr>
            <td class="success"><%= ve.getIdArbitro()%></td>
            <td class="success"><%= ve.getNombre()%></td>
            <td class="success"><%= ve.getApellido()%></td>
            <td class="success"><%= ve.getSueldo()%></td>
            <td class="success"><%= ve.getCategoria()%></td>
            <td class="success"><%= ve.getRolArbi()%></td>
            <td class="success"><%=ve.getIdEquipo()%></td>
            <td class="success"><a href="javascript:cargar(<%=ve.getIdArbitro()%>,
                                   '<%=ve.getNombre()%>',
                                   '<%=ve.getApellido()%>',
                                   '<%=ve.getSueldo()%>',
                                   '<%=ve.getCategoria()%>',
                                   '<%=ve.getRolArbi()%>',
                                   '<%=ve.getIdEquipo()%>')">Seleccionar</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table></center>
                </div>      
            </div>     

<hr>
<center>
    


</body>
</html>
