/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controlador;

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
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fam Gomez
 */
public class ReporteTorneo extends HttpServlet {

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
                res=st.executeQuery("select * from torneo");
                
                if(con!=null){
                    try {
                
                        Document documento=new Document();
                        PdfWriter.getInstance(documento, out);
                        documento.open();
                        
                        
                        
                        Paragraph par1=new Paragraph();
                        Font fontitulo=new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
                        par1.add(new Phrase("REPORTE DE Torneo",fontitulo));
                        par1.setAlignment(Element.ALIGN_LEFT);
                        par1.setAlignment(Element.ALIGN_TOP);
                        par1.add(new Phrase(Chunk.NEWLINE));
                        par1.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par1);

                        Paragraph par2=new Paragraph();
                        Font fontdescript=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK);
                        par2.add(new Phrase("Infome total de todos los Torneos, registrados para los partidos"
                                + "con sus respectivos detalles de cada torneos",fontdescript));
                        par2.setAlignment(Element.ALIGN_JUSTIFIED);
                        par2.add(new Phrase(Chunk.NEWLINE));
                        par2.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par2);

                        PdfPTable tabla= new PdfPTable(8);
                        PdfPCell celda1=new PdfPCell(new Paragraph("nomtorneo",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.ORANGE)));
                        PdfPCell celda2=new PdfPCell(new Paragraph("ubicacion",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.ORANGE)));
                        PdfPCell celda3=new PdfPCell(new Paragraph("campeon",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.ORANGE)));
                        PdfPCell celda4=new PdfPCell(new Paragraph("goleador",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.ORANGE)));
                        PdfPCell celda5=new PdfPCell(new Paragraph("seglugar",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.ORANGE)));
                        PdfPCell celda6=new PdfPCell(new Paragraph("terlugar",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.ORANGE)));
                        PdfPCell celda7=new PdfPCell(new Paragraph("cuarlugar",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.ORANGE)));
                        PdfPCell celda8=new PdfPCell(new Paragraph("descenso",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.ORANGE)));
                        tabla.addCell(celda1);
                        tabla.addCell(celda2);
                        tabla.addCell(celda3);
                        tabla.addCell(celda4);
                        tabla.addCell(celda5);
                        tabla.addCell(celda6);
                        tabla.addCell(celda7);
                        tabla.addCell(celda8);
                        while(res.next())
                        {
                            tabla.addCell(res.getString(1));
                            tabla.addCell(res.getString(2));
                            tabla.addCell(res.getString(3));
                            tabla.addCell(res.getString(4));
                            tabla.addCell(res.getString(5));
                            tabla.addCell(res.getString(6));
                            tabla.addCell(res.getString(7));
                            tabla.addCell(res.getString(8));
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
