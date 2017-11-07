
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelo.CrudIncidencias;
import org.modelo.Incidencias;

/**
 *Nombre de la clase:OperacionesIncidencias
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesIncidencias extends HttpServlet {

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
        
        Incidencias in= new Incidencias();
        CrudIncidencias ci= new CrudIncidencias();
        RequestDispatcher rd=null;
        String val=null;
        
        try 
        {
            in.setIdInci(Integer.parseInt(request.getParameter("id")));
            in.setTipo(request.getParameter("tipo"));
            in.setFecha(request.getParameter("fecha"));
            in.setMinuto(request.getParameter("min"));
            in.setTiempo(request.getParameter("tiempo"));
            in.setCantidad(Integer.parseInt(request.getParameter("cant")));
            in.setIdPartido(Integer.parseInt(request.getParameter("partido")));
            in.setIdJugador(Integer.parseInt(request.getParameter("jugador")));
            if (request.getParameter("insertar")!=null)
            {
              ci.add(in);
              val="Datos Insertados Correctamente";
            }else if (request.getParameter("modificar")!=null) 
            {
                ci.update(in);
                val="Datos Modificados Correctamente";
            }else if (request.getParameter("eliminar")!=null) 
            {
                ci.delete(in);
                val="Datos Eliminados Correctamente";
            }
            request.setAttribute("valor", val);
            request.getRequestDispatcher("Incidencias.jsp").forward(request, response);
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
