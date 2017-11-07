/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelo.CrudTorneo;
import org.modelo.Torneo;

/**
 ** Nombre de la clase:OperacionesTorneos
 * Fecha:17/10/2017
 * Version:1.0
 * Copyrigth:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesTorneos extends HttpServlet {

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
        Torneo tor = new Torneo();
        CrudTorneo ct= new CrudTorneo();
        String val=null;
        try 
        {
           tor.setIdTorneo(Integer.parseInt(request.getParameter("id")));
           tor.setNombre(request.getParameter("nombre"));
           tor.setUbicacion(request.getParameter("ubicacion"));
           tor.setCatEq(Integer.parseInt(request.getParameter("goles")));
           tor.setCampeon(request.getParameter("campeon"));
           tor.setGoleador(request.getParameter("goleador"));
           tor.setSegLugar(request.getParameter("segundo"));
           tor.setTerLugar(request.getParameter("tercer"));
           tor.setCuarLugar(request.getParameter("cuartos"));
           tor.setFechaIni((request.getParameter("fechaI")));
           tor.setFechaF(request.getParameter("fechaF"));
           tor.setDescenso(request.getParameter("descenso"));
           tor.setIdEq(Integer.parseInt(request.getParameter("idEq")));
           tor.setIdJugador(Integer.parseInt(request.getParameter("jugador")));
           tor.setIdJornada(Integer.parseInt(request.getParameter("jornada")));
            if (request.getParameter("insertar")!=null)
            {
                ct.add(tor);
                val="Datos Insertados Correctamente";
            }else if (request.getParameter("modificar")!=null)
            {
                ct.update(tor);
                val="Datos Modificados Correctamente";
            }else if (request.getParameter("eliminar")!=null) 
            {
                ct.delete(tor);
                val="Datos Eliminados Correctamente";
            }
            request.setAttribute("valor", val);
            request.getRequestDispatcher("Torneo.jsp").forward(request, response);
            
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
