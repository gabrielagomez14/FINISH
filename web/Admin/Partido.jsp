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
    CrudPartido cpar = new CrudPartido();

%>
<body><div class="well"><center>
            <div class="container"><br>
                <form action="operacionesPartido" name="frmPartido" method="post" class="form-horizontal">
                    <table>
                        <thead>
                            <tr >
                                <td>
                                    <label class="control-label col-xs-3" >Codigo de Partido</label>
                                </td>
                                <td>
                                    <div class="col-xs-9">
                                        <%                            CrudPartido obj = new CrudPartido();
                                            Object n = obj.contar(obj);
                                        %>
                                        <input type="text" class="form-control" name="id" value="<%=n%>" placeholder="Ingrese su codigo de Arbitro" required>
                                    </div>
                                </td>
                                <td>
                                    <label class="control-label col-xs-3" >Nombre de Partido</label>
                                </td>
                                <td>
                                    <div class="col-xs-15">
                                        <input type="text" class="form-control" name="nombre" value="" placeholder="Ingrese su nombre" required>
                                    </div>
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <label for="sel1" class="control-label col-xs-3">Tipo de Partido</label>
                                </td>
                                <td>
                                    <div class="col-xs-15"> 
                                        <select class="form-control" id="sel1" name="tPartido">
                                            <option value="">Seleccione</option>
                                            <option value="Futbol Sala">Futbol Sala</option>
                                            <option value="Futbol 11">Futbol 11</option>
                                            <option value="Partido Amistosos">Partido Amistosos</option>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <label for="sel1" class="control-label col-xs-2">Cantida de Goles</label>
                                </td>
                                <td>
                                    <div class="col-xs-15">
                                        <input type="number" class="form-control" name="cGoles" value="" 
                                               placeholder="Ingrese su nombre" required min="0">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <label for="sel1" class="control-label col-xs-2">Fecha Partido</label>
                                    <div class="col-xs-6"> 
                                        <div class="col-lg">
                                            <input type="date" class="form-control" name="fecha" value="" 
                                                   placeholder="Ingrese su nombre" required min="0">
                                        </div>
                                    </div>
                                </td>
                            </tr><tr>
                                <td hidden="true">
                                    <label class="control-label col-xs-3" >Codigo de Equipo</label>
                                </td>
                                <td hidden="true">
                                    <div class="form-group">

                                        <div class="col-xs-15">
                                            <%
                                                CrudPartido obj1 = new CrudPartido();
                                                Object m = obj1.contar(obj1);
                                            %>
                                            <input type="text" class="form-control" name="cEq" value="<%=m%>" placeholder="Ingrese su codigo de Arbitro" required>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <label for="sel1" class="control-label col-xs-2">Equipo Visitante</label>
                                </td>
                                <td>
                                    <div class="col-xs-15" > 
                                        <select class="form-control" id="sel1" name="eqVisitante">
                                            <%
                                                List<Equipo> leq = cpar.Visitante();
                                                for (Equipo par : leq) {
                                            %>
                                            <option value="<%=par.getNombre()%>"><%=par.getNombre()%></option>
                                            <%
                                                }%>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <label for="sel1" class="control-label col-xs-2">Equipo Local</label>
                                </td>
                                <td>
                                    <div class="col-xs-15">
                                        <select class="form-control" id="sel1" name="eqLocal">
                                            <%
                                                List<Equipo> leql = cpar.Local();
                                                for (Equipo par : leql) {
                                            %>
                                            <option value="<%=par.getNombre()%>"><%=par.getNombre()%></option>
                                            <%
                                    }%>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="sel1" class="control-label col-xs-2">Marcador Eq Local</label>
                                </td>
                                <td>
                                    <div class="col-xs-15" > 
                                        <select class="form-control" id="sel1" name="mEqLo">
                                            <%
                                                List<Equipo> lml = cpar.mLocal();
                                                for (Equipo par : lml) {
                                            %>
                                            <option value="<%=par.getCantGoles()%>"><%=par.getCantGoles()%></option>
                                            <%
                                    }%>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <label for="sel1" class="control-label col-xs-2">Marcador Equipo Visitante</label>
                                </td>
                                <td>
                                    <div class="col-xs-15"> 
                                        <select class="form-control" id="sel1" name="mEqVisi">
                                            <%
                                                List<Equipo> lmv = cpar.mVisitante();
                                                for (Equipo par : lmv) {
                                            %>
                                            <option value="<%=par.getCantGoles()%>"><%=par.getCantGoles()%></option>
                                            <%
                                    }%>
                                        </select> 
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="sel1" class="control-label col-xs-2">Jornada</label>
                                </td>
                                <td colspan="3">
                                    <div class="col-xs-11" > 
                                        <select class="form-control" id="sel1" name="jornada">
                                            <%
                                                List<Jornada> ljor = cpar.viewJ();
                                                for (Jornada jo : ljor) {
                                            %>
                                            <option value="<%=jo.getIdJornada() %>"><%=jo.getNombre() %></option>
                                            <%}%>
                                        </select>   
                                    </div> 
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="sel1" class="control-label col-xs-2">Arbitro</label>
                                </td>
                                <td>
                                    <div class="col-xs-15">
                                        <select class="form-control" id="sel1" name="arbitro">
                                            <%
                                                List<Arbitro> lar = cpar.viewarbi();
                                                for (Arbitro ar : lar) {
                                            %>
                                            <option value="<%=ar.getIdArbitro() %>"><%=ar.getNombre() %></option>
                                            <%}%>
                                        </select>   
                                    </div> 
                                </td>
                                <td>
                                    <label for="sel1" class="control-label col-xs-2">Codigo de Detalle</label>
                                </td>
                                <td>
                                    <div class="col-xs-15">
                                        <select class="form-control" id="sel1" name="detalle">
                                            <%
                                                List<DetallePartido> lde = cpar.viewDet();
                                                for (DetallePartido dp : lde) {
                                            %>
                                            <option value="<%=dp.getIdDetalle()%>"><%=dp.getIdDetalle()%></option>
                                            <%}%>
                                        </select>  
                                    </div> 
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    </center>
    </div><hr>
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
            </table></center><hr>
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
            <th class="danger">seleccionar</th>
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
            <td class="success"><a href="javascript:cargar(<%= parti.getIdPartido()%>,
                                   '<%= parti.getNombre()%>',
                                   '<%= parti.getTipoPartido()%>',
                                   '<%= parti.getNumGoles()%>',
                                   '<%= parti.getFecha()%>',
                                   '<%= parti.getIdEquipo()%>',
                                   '<%=parti.getEqVisitante()%>',
                                   '<%=parti.getEqLocal()%>',
                                   '<%=parti.getMarcadorVisi()%>',
                                   '<%=parti.getMarcadorLocal()%>',
                                   '<%=parti.getIdjornada()%>',
                                   '<%=parti.getIdArb()%>',
                                   '<%=parti.getIdDetalle()%>')">Seleccionar</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table></center>


</body>
</html>

