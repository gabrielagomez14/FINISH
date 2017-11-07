
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelo.CrudEntrenador;
import org.modelo.Entrenador;

/**
 *Nombre de la clase:OperacionesEntrenador
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesEntrenador extends HttpServlet {

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
        Entrenador en= new Entrenador();
        CrudEntrenador ce= new CrudEntrenador();
        //RequestDispatcher rd= null;
        String val=null;
        try 
        {
            en.setIdEntre(Integer.parseInt(request.getParameter("id")));
            en.setNombre(request.getParameter("nombre"));
            en.setApellido(request.getParameter("apellido"));
            en.setGenero(request.getParameter("genero"));
            en.setEdad(Integer.parseInt(request.getParameter("edad")));
            en.setTelefono(request.getParameter("telefono"));
            en.setCorreo(request.getParameter("correo"));
            en.setIdEqu(Integer.parseInt(request.getParameter("equipo")));
            if (request.getParameter("insertar")!=null)
            {
                ce.add(en);
                val="Datos Insertados Correctamente";
                
            }else if (request.getParameter("modificar")!=null)
            {   
                ce.update(en);
                val="Datos Modificados Correctamente";
                
            }else if (request.getParameter("eliminar")!=null) {
                ce.delete(en);
                val="Datos Eliminados Correctamente";
            }
            request.setAttribute("valor", val);
            //rd=request.getRequestDispatcher("Admin/Entrenador.jsp");
            request.getRequestDispatcher("Entrenador.jsp").forward(request, response);
        } catch (Exception e) 
        {
            out.print(val);
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
