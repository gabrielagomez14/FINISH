
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelo.CrudPartido;
import org.modelo.Partido;

/**
 * Nombre de la clase:OperacionesPartidos
 * Fecha:17/10/2017
 * Version:1.0
 * Copyrigth:ITCA-FEPADE
 * @author Ale Gomez
 */
public class OperacionesPartido extends HttpServlet {

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
        
        Partido par= new Partido();
        CrudPartido cp= new CrudPartido();
        String val=null;
        try 
        {
            par.setIdPartido(Integer.parseInt(request.getParameter("id")));
            par.setNombre(request.getParameter("nombre"));
            par.setTipoPartido(request.getParameter("tPartido"));
            par.setNumGoles(Integer.parseInt(request.getParameter("cGoles")));
            par.setFecha(request.getParameter("fecha"));
            par.setIdEquipo(Integer.parseInt(request.getParameter("cEq")));
            par.setEqVisitante(request.getParameter("eqVisitante"));
            par.setEqLocal(request.getParameter("eqLocal"));
            par.setMarcadorLocal(Integer.parseInt(request.getParameter("mEqVisi")));
            par.setMarcadorVisi(Integer.parseInt(request.getParameter("mEqLo")));
            par.setIdjornada(Integer.parseInt(request.getParameter("jornada")));
            par.setIdArb(Integer.parseInt(request.getParameter("arbitro")));
            par.setIdDetalle(Integer.parseInt(request.getParameter("detalle")));
            if (request.getParameter("insertar")!=null) 
            {
                cp.add(par);
                val="Datos Ingresados Correctamente";
            }else if (request.getParameter("modificar")!=null) 
            {
                cp.update(par);
                val="Datos Modificar Correctamente";
            }else if (request.getParameter("eleiminar")!=null) 
            {
               cp.delete(par);
               val="Datos Eliminar Correctamente";
            }
            request.setAttribute("valor", val);
            request.getRequestDispatcher("Partido.jsp").forward(request, response);
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
