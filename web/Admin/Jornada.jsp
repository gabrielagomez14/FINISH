<%-- 
    Document   : Jornada
    Created on : Oct 20, 2017, 2:14:06 PM
    Author     :  Ale Gomez
--%>

<%@page import="java.util.*"%>
<%@page import="org.modelo.*"%>
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
        <%-- mensaje de confirmacion--%>
        <script src="/path/to/jquery.js" type="text/javascript"></script>
        <script src="/path/to/jquery.ui.draggable.js" type="text/javascript"></script>
        <script src="/path/to/jquery.alerts.js" type="text/javascript"></script>
        <link href="/path/to/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Mantenimiento de Jornada</title>
        <script Language='JavaScript'>
            function cargar(id, eq, n, c, v,e,d,a,en,di,pu)
            {
                document.frmJornada.id.value = id;
                document.frmJornada.nEq.value = eq;
                document.frmJornada.nom.value = n;
                document.frmJornada.cant.value = c;
                document.frmJornada.victoria.value = v;
                document.frmJornada.empate.value = e;
                document.frmJornada.derrotas.value = d;
                document.frmJornada.afavor.value = a;
                document.frmJornada.encontra.value = en;
                document.frmJornada.diferencia.value = di;
                document.frmJornada.puntos.value = pu;

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
    CrudJornada cen = new CrudJornada();

%>
<body >
    <div class="well ">
        <div class="container"><br>
            <form action="operacionesJornada" name="frmJornada" method="post" class="form-horizontal">
                <center>
                <table >
                    <thead>
                        <tr>
                            <td>
                                <label for="username" class="control-label col-xs-3">Nombre de usuario</label>
                            </td>
                            <td>
                                <div class="col-xs-9">
                                        <%                            
                                            CrudJornada obj = new CrudJornada();
                                            Object n = obj.ContarJor(obj);
                                        %>
                                        <input type="text" class="form-control" name="id" value="<%=n%>" placeholder="Ingrese su codigo de Arbitro" required>
                                    </div>
                            </td>
                            <td>
                                <label for="equipo" class="control-label col-xs-3">Nombre de Equipo</label>
                            </td>
                            <td>
                                <div class="col-xs-15">
                                        <select class="form-control" id="sel1" name="nEq">
                                            <%
                                                List<Equipo> leq = cen.viewEq();
                                                for (Equipo par : leq) {
                                            %>
                                            <option value="<%=par.getIdEq()%>"><%=par.getNombre()%></option>
                                            <%
                                                }%>
                                        </select>
                                </div>
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label for="equipo" class="control-label col-xs-3">Nombre de Jornada</label></td>
                            <td>
                                <select class="form-control" id="sel1" name="nom">
                                    <option value="Seleccione">Seleccione</option>
                                    <option value="Jornada A">Jornada A</option>
                                    <option value="Jornada B">Jornada B</option>
                                    <option value="Jornada C">Jornada C</option>
                                    <option value="Jornada D">Jornada D</option>
                                    <option value="Jornada E">Jornada E</option>
                                </select>
                            </td>
                            <td><label for="equipo" class="control-label col-xs-3">Cantidad de partidos</label></td>
                            <td>
                                <input type="number" class="form-control" name="cant" value="" 
                                       placeholder="Ingrese su codigo de Arbitro" required min="0">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="equipo" class="control-label col-xs-3">Victorias</label></td>
                            <td>
                                <input type="number" class="form-control" name="victoria" value="" 
                                       placeholder="Ingrese su codigo de Arbitro" required min="0">
                            </td>
                            <td>
                                <label for="equipo" class="control-label col-xs-3">Cant Empate</label>
                            </td>
                            <td>
                                <input type="number" class="form-control" name="empate" value="" 
                                       placeholder="Ingrese su codigo de Arbitro" required min="0">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="equipo" class="control-label col-xs-3">Derrotas</label>
                            </td>
                            <td>
                                <input type="number" class="form-control" name="derrotas" value="" 
                                       placeholder="Ingrese su codigo de Arbitro" required min="0">
                            </td>
                            <td>
                                <label for="equipo" class="control-label col-xs-3">A Favor</label>
                            </td>
                            <td>
                                <input type="number" class="form-control" name="afavor" value="" 
                                       placeholder="Ingrese su codigo de Arbitro" required min="0">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="equipo" class="control-label col-xs-3">En Contra</label>
                            </td>
                            <td>
                                <input type="number" class="form-control" name="encontra" value="" 
                                       placeholder="Ingrese su codigo de Arbitro" required min="0">
                            </td>
                            <td>
                                <label for="equipo" class="control-label col-xs-3">Diferencia</label>
                            </td>
                            <td>
                                <input type="number" class="form-control" name="diferencia" value="" 
                                       placeholder="Ingrese su codigo de Arbitro" required min="0">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="equipo" class="control-label col-xs-3">Puntos</label>
                            </td>
                            <td colspan="3">
                                <div class="col-xs-9">
                                <input type="number" class="form-control" name="puntos" value="" 
                                       placeholder="Ingrese su codigo de Arbitro" required min="0">
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>

                                        </div></center><hr>
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
            <th class="danger">Codigo de Jornada</th>
            <th class="danger">Equipo</th>
            <th class="danger">Nombre</th>
            <th class="danger">victorias</th>
            <th class="danger">Cantidad de Partidos</th>
            <th class="danger">Empate</th>
            <th class="danger">Derrotas</th>
            <th class="danger">A Favor</th>
            <th class="danger">Enconta</th>
            <th class="danger">Diferencia</th>
            <th class="danger">Puntos</th>
            <th class="danger" >Seleccionar</th>
        </tr>

        <%
            List<Jornada> lst2 = cen.view();
            for (Jornada jor : lst2) {
        %>
        <tr>
                    <td><%=jor.getIdJornada() %></td>
                    <td><%=jor.getIdEquipo() %></td>
                    <td><%=jor.getNombre() %></td>
                    <td><%=jor.getCantPar() %></td>
                    <td><%=jor.getVictorias() %></td>
                    <td><%=jor.getEmpate() %></td>
                    <td><%=jor.getDerrota() %></td>
                    <td><%=jor.getaFavor() %></td>
                    <td><%=jor.getEncontra()%></td>
                    <td><%=jor.getDiferencia()%></td>
                    <td><%=jor.getPuntos()%></td>
                    <td>
                        <a href="javascript:cargar(<%= jor.getIdJornada()%>,
                                   '<%= jor.getIdEquipo()%>',
                                   '<%= jor.getNombre()%>',
                                   '<%= jor.getCantPar()%>',
                                   '<%= jor.getVictorias()%>',
                                   '<%= jor.getEmpate()%>',
                                   '<%=jor.getDerrota()%>',
                                   '<%=jor.getaFavor()%>',
                                   '<%=jor.getEncontra()%>',
                                   '<%=jor.getDiferencia()%>',
                                   '<%=jor.getPuntos()%>'
                                   )">Seleccionar</a>
                    </td>
        </tr>

        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</center>



</body>
</html>
