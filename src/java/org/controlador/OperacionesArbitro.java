
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelo.Arbitro;
import org.modelo.CrudArbitro;

/**
 * Nombre de la clase:OperacionesArbitro
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesArbitro extends HttpServlet {

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
        Arbitro ar = new Arbitro();
        CrudArbitro car=new CrudArbitro();
        String val=null;
        try 
        {
            ar.setIdArbitro(Integer.parseInt(request.getParameter("id")));
            ar.setNombre(request.getParameter("nombre"));
            ar.setApellido(request.getParameter("apellido"));
            ar.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
            ar.setCategoria(request.getParameter("categoria"));
            ar.setRolArbi(request.getParameter("rol"));
            ar.setIdEquipo(Integer.parseInt(request.getParameter("equipo")));
            
            if (request.getParameter("insertar")!=null) 
            {
                car.add(ar);
                val="Datos Insertados Correctamente";
            }else if (request.getParameter("modificar")!=null) 
            {
                car.update(ar);
                val="Datos Modificado Correctamente";
            }else if (request.getParameter("eliminar")!=null) 
            {
                car.delete(ar);
                val="Datos Eliminado Correctamente";
            }
            request.setAttribute("valor", val);
            request.getRequestDispatcher("Arbitro.jsp").forward(request, response);
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
