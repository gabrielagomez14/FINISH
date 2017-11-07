
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelo.CrudUsuario;
import org.modelo.Usuarios;

/**
 * Nombre de la clase:OperacionesUsuarios
 * Fecha:17/10/2017
 * Version:1.0
 * Copyrigth:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Usuarios us= new Usuarios();
        CrudUsuario cu= new CrudUsuario();
        RequestDispatcher rd=null;
        String val=null;
        try 
        {
            us.setId(Integer.parseInt(request.getParameter("id")));
            us.setNombre(request.getParameter("nombre"));
            us.setApellido(request.getParameter("apellido"));
            us.setUsername(request.getParameter("usuario"));
            us.setClave(request.getParameter("clave"));
            us.setNivel(Integer.parseInt(request.getParameter("rol")));
            if (request.getParameter("insertar")!=null) 
            {
                cu.add(us);
                val="Datos Insertados Correctamente";
            }else if (request.getParameter("modificar")!=null) 
            {
                cu.update(us);
                val="Datos Modificados Correctamente";
            }else if (request.getParameter("eliminar")!=null)
            {
                cu.delete(us);
                val="Datos Eliminados Correctamente";
            }
            request.setAttribute("valor", val);
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (Exception e) 
        {
            out.print(e.toString());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
