<%-- 
    Document   : Incidencias
    Created on : Oct 18, 2017, 11:43:54 AM
    Author     :  Ale Gomez
--%>

<%@page import="org.modelo.*"%>
<%@page import="java.util.*"%>
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
        <link rel="shortcut icon" href="../Imagenes/2.jpg"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/tables.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Mantenimiento de Incidencias</title>
        <script Language='JavaScript'>
            function cargar(id, tipo, fecha, minuto, tiempo, cant, idPar, idjuga)
            {
                document.frmInci.id.value = id;
                document.frmInci.tipo.value = tipo;
                document.frmInci.fecha.value = fecha;
                document.frmInci.min.value = minuto;
                document.frmInci.tiempo.value = tiempo;
                document.frmInci.cant.value = cant;
                document.frmInci.partido.value = idPar;
                document.frmInci.jugador.value = idjuga;


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
    CrudIncidencias cin = new CrudIncidencias();

%>
<body ><center><div class="well well-lg">
        <div class="container"><br>
            <form action="operacionesIncidencias" name="frmInci" method="post" class="form-horizontal">

                <div class="form-group">
                    <label class="control-label col-xs-3" ><font face="arial-black" size="4">Codigo de  Incidencia:</font></label>
                    <div class="col-xs-7">
                        <%                            CrudIncidencias obj = new CrudIncidencias();
                            Object n = obj.contarI(obj);
                        %>
                        <input type="text" class="form-control" name="id" value="<%=n%>" placeholder="Ingrese Id Incidencia" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Tipo:</font></label>
                    <div class="col-xs-6"> 
                        <select class="form-control" id="sel1" name="tipo">
                            <option value="">Seleccione</option>
                            <option value="Caidas">Caidas</option>
                            <option value="Golpes en la Cabeza">Golpes en la Cabeza</option>
                            <option value="Golpes en la Cabeza">Sobrecarga muscular</option>Otra lesión ósea
                            <option value="Golpes en la Cabeza">Contractura muscular</option>
                            <option value="Golpes en la Cabeza">Otra lesión ósea</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" ><font face="arial-black" size="4">Fecha:</font></label>
                    <div class="col-xs-7">
                        <input type="date" class="form-control" name="fecha" value="" placeholder="Ingrese Nombre de Jugador" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" ><font face="arial-black" size="4">Minuto:</font></label>
                    <div class="col-xs-7">
                        <input type="number" class="form-control" name="min" value="" placeholder="Ingrese Minuto" min="0" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Tiempo:</font></label>
                    <div class="col-xs-6"> 
                        <select class="form-control" id="sel1" name="tiempo">
                            <option value="">Seleccione</option>
                            <option value="Primer Tiempo">Primer Tiempo</option>
                            <option value="Segundo Tiempo">Segundo Tiempo</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" ><font face="arial-black" size="4">Cantidad de Incidencias:</font></label>
                    <div class="col-xs-3">
                        <input type="number" class="form-control" name="cant" value="" placeholder="Ingrese Minuto" min="0" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Nombre de Partido</font></label>
                    <div class="col-xs-6"> 
                        <select class="form-control" id="sel1" name="partido">
                            <%
                                List<Partido> leq = cin.viewPar();
                                for (Partido eq : leq) {
                            %>
                            <option value="<%=eq.getIdEquipo()%>"><%=eq.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Nombre de Jugador</font></label>
                    <div class="col-xs-6"> 
                        <select class="form-control" id="sel1" name="jugador">
                            <%
                                List<Jugador> lju = cin.viewJuga();
                                for (Jugador ju : lju) {
                            %>
                            <option value="<%=ju.getIdJugador()%>"><%=ju.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>   
        </div></div>
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
</div>          
<hr>
<center>
    <table  border="1" class="table table-striped table-bordered table-hover table-condensed">

        <tr>
            <th class="danger">Codigo de Incidencias</th>
            <th class="danger">Tipo de Incidencias</th>
            <th class="danger">Fecha de Incidencias</th>
            <th class="danger">Minuto de Incidencias</th>
            <th class="danger">Tiempo de Incidencias</th>
            <th class="danger">Cantidad de Incidencias</th>
            <th class="danger">Nombre del Partido</th>
            <th class="danger">Nombre del Jugador</th>
            <th class="danger">Seleccionar</th>
        </tr>

        <%
            List<Incidencias> lst2 = cin.view();
            for (Incidencias ince : lst2) {
        %>
        <tr>
            <td class="success"><%= ince.getIdInci()%></td>
            <td class="success"><%=ince.getTipo()%></td>
            <td class="success"><%= ince.getFecha()%></td>
            <td class="success"><%= ince.getMinuto()%></td>
            <td class="success"><%= ince.getTiempo()%></td>
            <td class="success"><%= ince.getCantidad()%></td>
            <td class="success"><%= ince.getIdPartido()%></td>
            <td class="success"><%= ince.getIdJugador()%></td>
            <td><a href="javascript:cargar(<%= ince.getIdInci()%>,
                   '<%=ince.getTipo()%>',
                   '<%= ince.getFecha()%>',
                   '<%= ince.getMinuto()%>',
                   '<%= ince.getTiempo()%>',
                   '<%= ince.getCantidad()%>',
                   '<%= ince.getIdPartido()%>',
                   '<%= ince.getIdJugador()%>')">Seleccionar</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table></center>



</body>
</html>


