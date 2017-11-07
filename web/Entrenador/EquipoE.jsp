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
        <link rel="shortcut icon" href="../Imagenes/2.jpg"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/tables.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                <li><a href="Arbitro.jsp">Arbitros</a></li>
                <li><a href="#">Ingresa tus Equipos</a></li>                
                <li><a href="Jornada.jsp">Jornada</a></li>
                <li><a href="Torneo.jsp">Torneo</a></li>
                <li><a href="jugador.jsp">Jugador</a></li>
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
<body><center><div class="well well-lg">
        <div class="container"><br>
            <form action="eOperacionesEquipo" name="frmEquipo" method="post" class="form-horizontal">
                <table >
                    <tr>
                        <td>
                            <label class="control-label col-xs-3" ><font face="arial-black" size="4">Codigo de Equipo:</font></label>
                        </td>
                        <td>
                            <div class="col-xs-7">
                                <%                            
                                    CrudEquipo obj = new CrudEquipo();
                                    Object n = obj.contarEq(obj);
                                %>
                                <input type="text" class="form-control" name="id" value="<%=n%>" placeholder="Ingrese Id de Equipo" required>
                            </div>
                        </td>
                        <td>
                            <label class="control-label col-xs-3" ><font face="arial-black" size="4">Nombre de Equipo:</font></label>
                        </td>
                        <td>
                            <div class="col-xs-15">
                                <input type="text" class="form-control" name="nombre" value="" placeholder="Ingrese Nombre de Equipo" required>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Numero de Jugadores</font></label>
                        </td>
                        <td>
                            <div class="col-xs-7"><font face="arial-black" size="4">
                                <input type="number" class="form-control" name="numJug" value="" placeholder="Ingresar Numero de Jugadores" max="11" min="9" required>
                                </font>
                            </div>
                        </td>
                        <td>
                            <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Numero de Amonestados</font></label>
                        </td>
                        <td>
                            <div class="col-xs-15"><font face="arial-black" size="4">
                                <input type="number" class="form-control" name="numAmon" value="" placeholder="Ingresar Numero de Amonestados" max="11" min="0" required>
                                </font>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Correo:</font></label>
                        </td>
                        <td>
                            <div class="col-xs-15">
                                <input type="text" class="form-control" name="correo" value="" placeholder="Ingrese Correo Electronico" required>
                            </div>
                        </td>
                        <td>
                            <label class="control-label col-xs-3" ><font face="arial-black" size="4">Dirección:</font></label>
                        </td>
                        <td>
                            <div class="col-xs-15">
                                <input type="text" class="form-control" name="direccion" value="" placeholder="Ingrese Direccion de Equipo" required>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="sel1" class="control-label col-xs-3">Tipo Equipo</label>
                        </td>
                        <td>
                            <div class="col-xs-15"> 
                                <select class="form-control" id="sel1" name="tipoEq">
                                    <option value="">Seleccione</option>
                                    <option value="Visitante">Visitante</option>
                                    <option value="Local">Local</option>
                                </select>
                            </div> 
                        </td>
                        <td>
                            <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Telefono:</font></label>
                        </td>
                        <td>
                            <div class="col-xs-15">
                                <input type="text" class="form-control" name="telefono" value="" placeholder="Ingresar numero de telefono" required>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Cantidad de Goles</font></label>
                        </td>
                        <td>
                            <div class="col-xs-15"><font face="arial-black" size="4">
                                <input type="number" class="form-control" name="cantg" value="" placeholder="Ingresar cantidad de Goles"  required>
                                </font>
                            </div>
                        </td>
                        <td>
                            <label for="sel1" class="control-label col-xs-3">Entrenador de Equipo</label>
                        </td>
                        <td >
                            <div class="col-xs-15" > 
                                <select class="form-control" id="sel1" name="entrenador" >
                                    <%
                                        List<Entrenador> lEnI = ceq.viewEn();
                                        for (Entrenador en : lEnI) {
                                    %>
                                    <option  value="<%=en.getIdEntre()%>"><%=en.getNombre()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="sel1" class="control-label col-xs-3">capitan de Equipo</label>
                        </td>
                        <td>
                            <div class="col-xs-15">
                                            <select class="form-control" id="sel1" name="Jugador">
                                    <%
                                        List<Jugador> lJu = ceq.viewJuga();
                                        for (Jugador jugador : lJu) {
                                    %>
                                    <option value="<%=jugador.getIdJugador()%>"><%=jugador.getNombre()%></option>
                                    <%}%>
                                </select>
                                        </div>
                        </td>
                        <td>
                            <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Puntos:</font></label>
                        </td>
                        <td>
                            <div class="col-xs-9"><font face="arial-black" size="4">
                                <input type="number" class="form-control" name="puntaje" value="" placeholder=" Puntaje" max="100" min="1" required>
                                </font>
                            </div>
                        </td>
                    </tr>

                </table>

        </div>
    </div>  
    <hr>
    <center><table>
            <thead>
                <tr>
                    <th>
                        <button class="btn btn-lg btn-primary" type="submit" name="insertar" value="insertar">Insertar</button> 
                    </th></form>
                    </th>
                    <td>
                        <form name="reporte" action="reporte1">&nbsp;
                            <button class="btn btn-lg btn-toolbar" type="submit" value="Generar Reporte" name="btn">Generar Reporte</button>
                        </form> 
                    </td>
                </tr>
            </thead>
        </table></center>  
</form>
<hr>
<center>
    <table  border="1" class="table table-striped table-bordered table-hover table-condensed">

        <tr>
            <th class="danger">Codigo Equipo</th>
            <th class="danger">Nombre</th>
            <th class="danger">Numero Jugadores</th>
            <th class="danger">Numero Amonestados</th>
            <th class="danger">Email</th>
            <th class="danger">Direccion</th>
            <th class="danger">Tipo Equipo</th>
            <th class="danger">Telefono</th>
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
            <td class="success"><%= eq.getIdEq()%></td>
            <td class="success"><%= eq.getNombre()%></td>
            <td class="success"><%= eq.getNumJugadores()%></td>
            <td class="success"><%= eq.getNumAmonestado()%></td>
            <td class="success"><%= eq.getEmail()%></td>
            <td class="success"><%= eq.getDireccion()%></td>
            <td class="success"><%=eq.getTipoEq()%></td>
            <td class="success"><%=eq.getTelefono()%></td>
            <td class="success"><%=eq.getCantGoles()%></td>
            <td class="success"><%=eq.getIdEntrenador()%></td>
            <td class="success"><%=eq.getIdJugador()%></td>
            <td class="success"><%=eq.getPuntaje()%></td>

        </tr>
        <%
            }
        %>
        </tbody>
    </table></center>
<script scr="http://code.jquey.com/jquery-latest.js"></script>
</body>
</html>

