<%-- 
    Document   : login
    Created on : Oct 31, 2017, 5:17:29 PM
    Author     : fam Gomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  
  <link href='dist.png' rel='shortcut icon' type='image/png'>
  <title>Iniciar Session</title>
  <link rel="stylesheet" href="css/bootstrap.css">
  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/bootstrapValidator.min.js"></script>
  <script src="js/noty.js"></script>
  <script src="js/app.js"></script>
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body backgroung="Imagenes/f3"><br><br><br><br>



  <div class="container" >
    <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <center>
                  <h4 class="modal-title" id="myModalLabel">
                      <font size="5" face="Cooper Black">Iniciar Session</font>
                  </h4>
              </center>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-6">
                      <div class="well">
                          <form role="form" name="login" action="acceso" method="POST">
                            <div class="form-group">
                              <label for="username">Nombre de usuario</label>
                              <input type="text" class="form-control" id="username" name="userName" placeholder="Nombre de usuario" required
                                     >
                            </div>
                            <div class="form-group">
                              <label for="password">Contrase&ntilde;a</label>
                              <input type="password" class="form-control" id="password" name="clave" placeholder="Contrase&ntilde;a" required>
                              <span class=""></span>
                            </div>
                            <button type="submit" class="btn btn-success btn-block"   name="btnAcceder">Acceder</button>
                          </form>                 
                    </div>
                  </div><br>
                  <img src="Imagenes/pelota.gif"  width="290" height="185">
              </div>
          </div>
      </div>
    </div>
  </div>
          <%
        HttpSession sesion = request.getSession();
        int nivel=0;
        if (request.getAttribute("nivel")!=null) 
        {
            nivel= (Integer)(request.getAttribute("nivel"));
            if (nivel==1) 
            {
                sesion.setAttribute("userName",request.getAttribute("userName"));
                sesion.setAttribute("nivel", nivel);
                response.sendRedirect("Admin/jugador.jsp");
            }else if (nivel==2) 
            {
                sesion.setAttribute("username",request.getAttribute("username"));
                sesion.setAttribute("nivel", nivel);
                response.sendRedirect("Entrenador/EquipoE.jsp");
            }else if (nivel==3) 
            {
                sesion.setAttribute("username",request.getAttribute("username"));
                sesion.setAttribute("nivel", nivel);
                response.sendRedirect("Arbitro/ArbitroA.jsp");   
            }
        }//para ver si biene un atribueto
        if (request.getParameter("cerrar")!=null) 
        {
            session.invalidate();
            
        }
    %>
</body>
</html>