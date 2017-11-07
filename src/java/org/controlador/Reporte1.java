
package org.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.conexion.Conexion;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fam Gomez
 */
public class Reporte1 extends HttpServlet
{
    Conexion con = new Conexion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        response.setContentType("application/pdf");
        OutputStream out= response.getOutputStream();
        String nombre=request.getParameter("txtn");
        try{
            
            try {
                Connection con=null;
                Statement st=null;
                ResultSet res;
                
                Class.forName("org.postgresql.Driver");
                con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/MultiSoccer?user=postgres&password=Admin");
                st=(Statement) con.createStatement();
                res=st.executeQuery("select * from arbitro");
                
                if(con!=null){
                    try {
                
                        Document documento=new Document();
                        PdfWriter.getInstance(documento, out);
                        documento.open();
                        
                        
                        
                        Paragraph par1=new Paragraph();
                        Font fontitulo=new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
                        par1.add(new Phrase("REPORTE DE ARBITROS",fontitulo));
                        par1.setAlignment(Element.ALIGN_LEFT);
                        par1.setAlignment(Element.ALIGN_TOP);
                        par1.add(new Phrase(Chunk.NEWLINE));
                        par1.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par1);
                        
                        
                        Image imagenes= Image.getInstance("C:\\Users\\fam Gomez\\Desktop\\Proyecto\\Futboll\\web\\Imagenes\\2.jpg");
                        imagenes.setAlignment(Element.ALIGN_RIGHT);
                        imagenes.scaleToFit(100, 100);
                        documento.add(imagenes);

                        Paragraph par2=new Paragraph();
                        Font fontdescript=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK);
                        par2.add(new Phrase("Infome total de todos los arbitro, registrados para los partidos"
                                + "con sus respectivos detalles de cada arbitro",fontdescript));
                        par2.setAlignment(Element.ALIGN_JUSTIFIED);
                        par2.add(new Phrase(Chunk.NEWLINE));
                        par2.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par2);

                        PdfPTable tabla= new PdfPTable(7);
                        PdfPCell celda1=new PdfPCell(new Paragraph("idarbitro",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                        PdfPCell celda2=new PdfPCell(new Paragraph("nombre",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                        PdfPCell celda3=new PdfPCell(new Paragraph("apellido",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                        PdfPCell celda4=new PdfPCell(new Paragraph("sueldo",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                        PdfPCell celda5=new PdfPCell(new Paragraph("categoria",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                        PdfPCell celda6=new PdfPCell(new Paragraph("rol",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                        PdfPCell celda7=new PdfPCell(new Paragraph("idequipo",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                        tabla.addCell(celda1);
                        tabla.addCell(celda2);
                        tabla.addCell(celda3);
                        tabla.addCell(celda4);
                        tabla.addCell(celda5);
                        tabla.addCell(celda6);
                        tabla.addCell(celda7);
                        while(res.next())
                        {
                            tabla.addCell(res.getString(1));
                            tabla.addCell(res.getString(2));
                            tabla.addCell(res.getString(3));
                            tabla.addCell(res.getString(4));
                            tabla.addCell(res.getString(5));
                            tabla.addCell(res.getString(6));
                            tabla.addCell(res.getString(7));
                        }
                        documento.add(tabla);

                        documento.close();
                    } catch (Exception ex) {
                        ex.getMessage();
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        finally
        {
            out.close(); 
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

