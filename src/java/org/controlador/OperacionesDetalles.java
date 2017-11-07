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
import org.modelo.CrudDetalle;
import org.modelo.DetallePartido;

/**
 *Nombre de la clase:OperacionesDetalle
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesDetalles extends HttpServlet {

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
        DetallePartido dp= new DetallePartido();
        CrudDetalle cd= new CrudDetalle();
        String val=null;
        try 
        {
            dp.setIdDetalle(Integer.parseInt(request.getParameter("id")));
            dp.setIdJugador(Integer.parseInt(request.getParameter("cJuga")));
            dp.setMejorJuga(request.getParameter("Jugador"));
            dp.setPosesionBalon(request.getParameter("posesion"));
            dp.setGoleador(request.getParameter("goleador"));
            dp.setNumExpul(Integer.parseInt(request.getParameter("expulsados")));
            dp.setNumAmo(Integer.parseInt(request.getParameter("amonestados")));
            dp.setCatPenal(Integer.parseInt(request.getParameter("penaltis")));
            dp.setLlegaMeta(Integer.parseInt(request.getParameter("llegada")));
            
            dp.setCorner(Integer.parseInt(request.getParameter("corner")));
            if (request.getParameter("insertar")!=null) 
            {
                cd.add(dp);
                val="Datos Insertados Correctamente";
            }else if (request.getParameter("modificar")!=null) 
            {
                cd.update(dp);
                val="Datos Modificados Correctamente";
            }else if (request.getParameter("eliminar")!=null) 
            {
                cd.delete(dp);
                val="Datos Eliminado Correctamente";
            }
            request.setAttribute("valor",val);
            request.getRequestDispatcher("Detalle.jsp").forward(request, response);
        } catch (Exception e) {
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
