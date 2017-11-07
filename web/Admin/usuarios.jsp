<%-- 
    Document   : usuarios
    Created on : Oct 28, 2017, 2:50:30 PM
    Author     :  Ale Gomez
--%>

<%@page import="org.modelo.Usuarios"%>
<%@page import="java.util.List"%>
<%@page import="org.modelo.CrudUsuario"%>
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
        if (!nivel.equals("1")) 
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
    <script Language='JavaScript'>
            function cargar(id, n, a, u, c, r)
            {
                document.frmUser.id.value = id;
                document.frmUser.nombre.value = n;
                document.frmUser.apellido.value = a;
                document.frmUser.usuario.value = u;
                document.frmUser.clave.value = c;
                document.frmUser.rol.value = r;
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
</header>
<script src="js/jquery-latest.js"></script> 
<script src="../bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<%
    CrudUsuario cu = new CrudUsuario();
%>
<body>
    <div class="well">
        <div class="container"><br>
            <form action="operacionesUsuarios" name="frmUser" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-xs-3" >Codigo de Partido</label>
                    <div class="col-xs-7">
                        <%
                            CrudUsuario obj = new CrudUsuario();
                            Object n = obj.Contar(obj);
                        %>
                        <input type="text" class="form-control"  name="id" value="<%=n%>" placeholder="Ingrese su codigo de Arbitro" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" >Nombre de Usuario</label>
                    <div class="col-xs-7">
                        <input type="text" class="form-control" name="nombre" value="" placeholder="Ingrese su nombre" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" >Apellido de Usuario</label>
                    <div class="col-xs-7">
                        <input type="text" class="form-control" name="apellido" value="" placeholder="Ingrese su nombre" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" >Usuario</label>
                    <div class="col-xs-7">
                        <input type="text" class="form-control" name="usuario" value="" placeholder="Ingrese su nombre" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" >Clave</label>
                    <div class="col-xs-7">
                        <input type="password" class="form-control" name="clave" value="" placeholder="Ingrese su nombre" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" >Rol de Usuario</label>
                    <div class="col-xs-7">
                        <select class="form-control" id="sel1" name="rol">
                            <option value="">Seleccione</option>
                            <option value="1">Administrador</option>
                            <option value="2">Entrenador</option>
                            <option value="3">Arbitro</option>
                        </select>
                    </div>
                </div>
        </div> 

    </div>
    <hr>
    <center><table>
                    <thead>
                        <tr>
                            <th>
                                <button class="btn btn-lg btn-primary" type="submit" name="insertar" value="insertar">Insertar</button> 
                            </th>
                            <th>
                                <button class="btn btn-lg btn-success" type="submit" name="modificar" value="modificar" onclick="return confirm('Esta Seguro que Desea Modificar?');">Modificar</button>
                            </th>
                            <th>
                                <button class="btn btn-lg btn-danger" type="submit" name="eliminar" value="eliminar" onclick="return confirm('Esta Seguro que Desea Eliminar');">Eliminar</button>
                            </th>
                            <th>
                                <button class="btn btn-lg btn-info" type="reset" value="Limpiar">Limpiar</button></form>
                            </th>
                            <td>
                                <form name="reporte" action="reporte1">&nbsp;
                                    <button class="btn btn-lg btn-toolbar" type="submit" value="Generar Reporte" name="btn">Generar Reporte</button>
                                </form> 
                            </td>
                        </tr>
                    </thead>
                </table></center>     
<hr>
<table  border="1" class="table table-striped table-bordered table-hover table-condensed">

    <tr>
        <th class="danger">Codigo de Usuario</th>
        <th class="danger">Nombre de Usuario</th>
        <th class="danger">Apellido de Usuario</th>
        <th class="danger">UserName</th>
        <th class="danger">Clave</th>
        <th class="danger">Rol de Usuario</th>
        <th class="danger">seleccionar</th>
    </tr>
    <%
        List<Usuarios> lus = cu.view();
        for (Usuarios us : lus) {
    %>
    <tr>
        <td class="success"><%= us.getId()%></td>
        <td class="success"><%= us.getNombre()%></td>
        <td class="success"><%= us.getApellido()%></td>
        <td class="success"><%= us.getUsername()%></td>
        <td class="success"><%= us.getClave()%></td>
        <td class="success"><%= us.getNivel()%></td>
        <td class="success"><a href="javascript:cargar(<%= us.getId()%>,
                               '<%= us.getNombre()%>',
                               '<%= us.getApellido()%>',
                               '<%= us.getUsername()%>',
                               '<%= us.getClave()%>',
                               '<%= us.getNivel()%>')">Seleccionar</a></td>
    </tr>
    <%
        }
    %>
</tbody>
</table></center>
</body>
</html>
