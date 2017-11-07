
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelo.CrudEquipo;
import org.modelo.Equipo;

/**
 * Nombre de la clase:OperacionesEquipo
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesEquipo extends HttpServlet {

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
        
        Equipo eq= new Equipo();
        CrudEquipo ce= new CrudEquipo();
        String val=null;
        try 
        {
            eq.setIdEq(Integer.parseInt(request.getParameter("id")));
            eq.setNombre(request.getParameter("nombre"));
            eq.setNumJugadores(Integer.parseInt(request.getParameter("numJug")));
            eq.setNumAmonestado(Integer.parseInt(request.getParameter("numAmon")));
            eq.setEmail(request.getParameter("correo"));
            eq.setDireccion(request.getParameter("direccion"));
            eq.setTipoEq(request.getParameter("tipoEq"));
            eq.setTelefono(request.getParameter("telefono"));
            eq.setCantGoles(Integer.parseInt(request.getParameter("cantg")));
            eq.setIdEntrenador(Integer.parseInt(request.getParameter("entrenador")));
            eq.setIdJugador(Integer.parseInt(request.getParameter("Jugador")));
            eq.setPuntaje(Integer.parseInt(request.getParameter("puntaje")));
            if (request.getParameter("insertar")!=null) 
            {
                ce.add(eq);
                val="Datos Insertados Correctamente";
            }else if (request.getParameter("modificar")!=null) 
            {
                ce.udpate(eq);
                val="Datos Modificados Correctamente";
            }else if (request.getParameter("eliminar")!=null) 
            {
                ce.delete(eq);
                val="Datos Eliminados Correctamente";
            }
           request.setAttribute("valor", val);
           request.getRequestDispatcher("Equipo.jsp").forward(request, response);
           
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
