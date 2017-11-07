<%-- 
    Document   : detalle
    Created on : Oct 22, 2017, 3:26:17 PM
    Author     :  Ale Gomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.modelo.*"%>
<%@page import="java.util.*"%>
<%@page  session="true" %>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Detalle</title>
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
            function cargar(id, juga, jugado, p, e, a, penal, llegada, gole, cor)
            {
                document.frmDetalle.id.value = id;
                document.frmDetalle.cJuga.value = juga;
                document.frmDetalle.Jugador.value = jugado;
                document.frmDetalle.posesion.value = p;
                document.frmDetalle.expulsados.value = e;
                document.frmDetalle.amonestados.value = a;
                document.frmDetalle.penaltis.value = penal;
                document.frmDetalle.llegada.value = llegada;
                document.frmDetalle.goleador.value = gole;
                document.frmDetalle.corner.value = cor;
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
                   <li><a href="jugador.jsp">Gestionar Jugador</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Gestionar Partidos
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="Partido.jsp">Partido</a></li>
                            <li><a href="Equipo.jsp">Equipo</a></li>
                            <li><a href="#">Detalle de Partido</a></li>
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
</head>
<%
    CrudDetalle cdt = new CrudDetalle();
%>
<body>
    <div class="well ">
        <div class="container">
            <form action="operacionesDetalles" method="get" name="frmDetalle" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-xs-3" >Codigo Detalle:</label>
                    <div class="col-xs-6">
                        <%
                            CrudDetalle obj = new CrudDetalle();
                            Object n = obj.contarDeta(obj);
                        %>
                        <input type="text" class="form-control" name="id" value="<%=n%>" placeholder="Ingrese codigo  Detalle" required>
                    </div>
                </div>
                    <div class="form-group" hidden="" >
                    <label for="sel1" class="control-label col-xs-3">codigo de Jugador</label>
                    <div class="col-xs-6">
                        <%
                            CrudDetalle obj1 = new CrudDetalle();
                            Object m = obj1.contarDeta(obj);
                        %>
                        <input type="text" class="form-control" name="cJuga" value="<%=m%>" placeholder="Ingrese codigo  Detalle" required>
                    </div>
                </div>
                <div class="form-group input-group" >
                    <label for="sel1" class="control-label col-xs-2">Mejor jugador</label>
                    <div class="col-xs-4" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select class="form-control" id="sel1" name="Jugador">
                            <%
                                List<Jugador> lj1 = cdt.viewJuga();
                                for (Jugador ju : lj1) {
                            %>
                            <option value="<%=ju.getIdJugador()%>"><%=ju.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>

                    <label for="sel1" class="control-label col-xs-2">Posecion de Balon</label>
                    <div class="col-xs-4"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select class="form-control" id="sel1" name="posesion">
                            <%
                                List<Jugador> lj2 = cdt.viewJuga();
                                for (Jugador ju : lj2) {
                            %>
                            <option value="<%=ju.getIdJugador()%>"><%=ju.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
                <div class="form-group" >
                    <label for="sel1" class="control-label col-xs-3">Goleador</label>
                    <div class="col-xs-6"> 
                        <select class="form-control" id="sel1" name="goleador">
                            <%
                                List<Jugador> lj3 = cdt.viewJuga();
                                for (Jugador ju : lj3) {
                            %>
                            <option value="<%=ju.getIdJugador()%>"><%=ju.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>

                <div class="form-group input-group" >
                    <label for="sel1" class="control-label col-xs-2">Numero de expulsados</label>
                    <div class="col-xs-4"> 
                        <input type="number" class="form-control" name="expulsados" value="" 
                               placeholder="Ingrese Numero  Expulsados" required min="0">
                    </div>
                    <label for="sel1" class="control-label col-xs-2">Numero de Amonestado</label>
                    <div class="col-xs-4"> 
                        <input type="number" class="form-control" name="amonestados" value=""
                               placeholder="Ingrese Numero  Amonestados" required min="0">
                    </div>
                </div>
                <div class="form-group input-group" >
                    <label for="sel1" class="control-label col-xs-2">Numero de Penaltis</label>
                    <div class="col-xs-4"> 
                        <input type="number" class="form-control" name="penaltis" value="" 
                               placeholder="Ingrese Numero Penaltis" required min="0">
                        &nbsp;&nbsp;&nbsp;</div>
                    <label for="sel1" class="control-label col-xs-2">Numero de LLega a Meta</label>
                    <div class="col-xs-4"> 
                        <input type="number" class="form-control" name="llegada" value="" 
                               placeholder="Ingrese de LLegadas a Meta" required min="0">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-xs-3" >Cant. de Corner</label>
                    <div class="col-xs-6">
                        <input type="number" class="form-control" name="corner" value=""
                               placeholder="Corner" required min="0"> 
                    </div>
                </div>
        </div>

    </div>
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
            <th class="danger">Codigo Detalle</th>
            <th class="danger" >Codigo Jugador</th>
            <th class="danger">Mejor Jugador</th>
            <th class="danger">Pesesion de Balon</th>
            <th class="danger">Goleador</th>
            <th class="danger">N° Expulsados</th>
            <th class="danger">N° de Amonestados</th>
            <th class="danger">Cant. Penaltis</th>
            <th class="danger">Llegadas a Metas</th>
            <th class="danger">Cant. Corner</th>
            <th class="danger">Seleccionar</th>
        </tr>
        <%
            List<DetallePartido> ldp = cdt.view();
            for (DetallePartido dp : ldp) {
        %>
        <tr>
            <th class=""><%=dp.getIdDetalle()%></th>
            <th ><%=dp.getIdJugador()%></th>
            <th><%=dp.getMejorJuga()%></th>
            <th><%=dp.getPosesionBalon()%></th>
            <th><%=dp.getGoleador()%></th>
            <th><%=dp.getNumExpul()%></th>
            <th><%=dp.getNumAmo()%></th>
            <th><%=dp.getCatPenal()%></th>
            <th><%=dp.getLlegaMeta()%></th>
            <th><%=dp.getCorner()%></th>
            <td><a href="javascript:cargar(<%=dp.getIdDetalle()%>,
                   '<%=dp.getIdJugador()%>',
                   '<%=dp.getMejorJuga()%>',
                   '<%=dp.getPosesionBalon()%>',
                   '<%=dp.getGoleador()%>',
                   '<%=dp.getNumExpul()%>',
                   '<%=dp.getNumAmo()%>',
                   '<%=dp.getCatPenal()%>',
                   '<%=dp.getLlegaMeta()%>',
                   '<%=dp.getCorner()%>')">Seleccionar</a></td>
        </tr>
        </tr>
        <%}%>
        </tbody>
    </table>
</body>
</html>
