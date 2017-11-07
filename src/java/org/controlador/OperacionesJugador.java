
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelo.CrudJugador;
import org.modelo.Jugador;

/**
 * Nombre de la clase:OperacionesJugador
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesJugador extends HttpServlet {

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
        Jugador ju= new Jugador();
        CrudJugador cj= new CrudJugador();
        String val=null;
        try 
        {
          ju.setIdJugador(Integer.parseInt(request.getParameter("id")));
          ju.setNombre(request.getParameter("nombre"));
          ju.setDui(request.getParameter("dui"));
          ju.setPosicion(request.getParameter("posicion"));
          ju.setPais(request.getParameter("pais"));
          ju.setTelefono(request.getParameter("telefono"));
          ju.setEmail(request.getParameter("correo"));
          
            if (request.getParameter("insertar")!=null) 
            {
                cj.add(ju);
                val="Datos Insertados correctamente";
            }else if (request.getParameter("modificar")!=null) 
            {
                cj.update(ju);
                val="Datos Modificados correctamente";
            }else if (request.getParameter("eliminar")!=null) 
            {
                cj.delete(ju);
                val="Datos Eliminados Correctamente";
            }
            request.setAttribute("valor", val);
            request.getRequestDispatcher("jugador.jsp").forward(request, response);
            
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
