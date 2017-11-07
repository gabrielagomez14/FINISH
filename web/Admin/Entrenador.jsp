<%-- 
    Document   : Entrenador
    Created on : Oct 18, 2017, 10:07:30 AM
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
        <title>Mantenimiento de Entrenador</title>
        <script Language='JavaScript'>
            function cargar(id,nom,ape,g,e,tel,correo,ide)
            {
                document.frmEntrenador.id.value=id;
                document.frmEntrenador.nombre.value=nom;
                document.frmEntrenador.apellido.value=ape;
                document.frmEntrenador.genero.value=g;
                document.frmEntrenador.edad.value=e;
                document.frmEntrenador.telefono.value=tel;
                document.frmEntrenador.correo.value=correo;
                document.frmEntrenador.equipo.value=ide;
            }
        </script>
        <%
        if (request.getAttribute("valor")!=null) {%>
        <script>
               alert('<%= request.getAttribute("valor") %>');      
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
    
        CrudEntrenador cen=new CrudEntrenador();

    %>
    <body><div class="well well-lg">
        <div class="container"><br>
            <form action="operacionesEntrenador" name="frmEntrenador" method="post" class="form-horizontal">
            
              <div class="form-group">
                  <label class="control-label col-xs-3" ><font face="arial-black" size="4">Codigo Entrenador:</font></label>
                    <div class="col-xs-7">
                        <% 
                            CrudEquipo obj= new CrudEquipo();
                            Object n= obj.contarEq(obj);
                        %>
                    <input type="text" class="form-control" name="id" value="<%= n%>" placeholder="Ingrese Id de Entrenador" required>
                    </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-xs-3" ><font face="arial-black" size="4">Nombre de Entrenador:</font></label>
                    <div class="col-xs-7">
                    <input type="text" class="form-control" name="nombre" value="" placeholder="Ingrese Nombre de Entrenador" required>
                    </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-xs-3" ><font face="arial-black" size="4">Apellido de Entrenador:</font></label>
                    <div class="col-xs-7">
                    <input type="text" class="form-control" name="apellido" value="" placeholder="Ingrese Apellido de Entrenador" required>
                    </div>
                </div>
                 <div class="form-group">
                            <label class="control-label col-xs-3"><font face="arial-black" size="4">Genero</font></label>
                    <div class="col-xs-2">
                        <div class="radio">
                            <label for="genero">
                             <input type="radio" name="genero" value="Femenino"  checked="true" ><font face="arial-black" size="4">Femenino</font>
                            </label>
                        </div>
                        <div class="radio">
                             <label for="genero">
                             <input type="radio" name="genero" value="masculino" id="radio2"><font face="arial-black" size="4">Masculino</font>
                             </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Edad:</font></label>
                  <div class="col-xs-2"><font face="arial-black" size="4">
                      <input type="number" class="form-control" name="edad" value="" placeholder="Edad" max="50" min="18" required>
                    </font>
                  </div>
                </div>
                <div class="form-group">
                <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Telefono:</font></label>
                 <div class="col-xs-7">
                    <input type="text" class="form-control" name="telefono" value="" placeholder="Ingrese Numero de Telefono" required>
                    </div>
                </div>
                <div class="form-group">
                <label for="sel1" class="control-label col-xs-3"><font face="arial-black" size="4">Correo:</font></label>
                 <div class="col-xs-7">
                    <input type="text" class="form-control" name="correo" value="" placeholder="Ingrese Correo Electronico" required>
                    </div>
                </div>
               <div class="form-group">
                <label for="sel1" class="control-label col-xs-3">Nombre de Equipo</label>
                  <div class="col-xs-6"> 
                      <select class="form-control" id="sel1" name="equipo">
                          <%
                              List<Equipo>lEq=cen.vieweq();
                              for(Equipo eq:lEq)
                              {
                          %>
                      <option value="<%=eq.getIdEq()%>"><%=eq.getNombre() %></option>
                      <%}%>
                  </select>
                    </div>
                </div>
        </div></div><hr>
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
                      <th class="danger">ID Entrenador</th>
                      <th class="danger">Nombre</th>
                      <th class="danger">Apellido</th>
                      <th class="danger">Genero</th>
                      <th class="danger">Edad</th>
                      <th class="danger">Telefono</th>
                      <th class="danger">Correo</th>
                      <th class="danger">NombreEquipo</th>
                      <th class="danger" >Seleccionar</th>
                  </tr>
                  
                  <%
                 List<Entrenador> lst2=cen.view();
                  for(Entrenador ve:lst2){
                  %>
                  <tr>
                      <td class="success"><%= ve.getIdEntre()%></td>
                      <td class="success"><%= ve.getNombre()%></td>
                      <td class="success"><%= ve.getApellido() %></td>
                      <td class="success"><%= ve.getGenero()%></td>
                      <td class="success"><%= ve.getEdad()%></td>
                      <td class="success"><%= ve.getTelefono()%></td>
                      <td class="success"><%=ve.getCorreo()%></td>
                      <td class="success" ><%=ve.getIdEqu()%></td>
                      <td><a href="javascript:cargar(<%=ve.getIdEntre()%>,
                             '<%=ve.getNombre()%>',
                             '<%=ve.getApellido()%>',
                             '<%=ve.getGenero()%>',
                             '<%=ve.getEdad()%>',
                             '<%=ve.getTelefono()%>',
                             '<%=ve.getCorreo()%>',
                             '<%=ve.getIdEqu()%>')">Seleccionar</a></td>
                      </tr>
                   <%
                  }
                  %>
              </tbody>
        </table>
    </center>
                 
              
             
    </body>
</html>
