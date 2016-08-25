package com.sv.udb.vistas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Element;
import com.sv.udb.controlador.UsuaCtrl;
import com.sv.udb.modelo.Usua;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReporteiText", urlPatterns = {"/ReporteiText"})
public class ReporteiText extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try {
            try
            {
                Document document = new Document();
                PdfWriter.getInstance(document,out);
                document.open();
                
                Paragraph paragraph = new Paragraph(new Phrase(1,"Listado de Usuarios"  ,FontFactory.getFont(FontFactory.TIMES_BOLD, 20)));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.add(new Paragraph(" "));
                
                PdfPTable tblCont = new PdfPTable(3);
                tblCont.setWidthPercentage(100);
                PdfPCell celda = new PdfPCell(new Paragraph("Usuario"));
                celda.setBackgroundColor(WebColors.getRGBColor("#E0F8F7"));                    
                tblCont.addCell(celda);
                celda = new PdfPCell(new Paragraph("Persona"));
                celda.setBackgroundColor(WebColors.getRGBColor("#E0F8F7"));
                tblCont.addCell(celda);
                celda = new PdfPCell(new Paragraph("Fecha de Alta"));
                celda.setBackgroundColor(WebColors.getRGBColor("#E0F8F7"));
                tblCont.addCell(celda);
                document.add(tblCont);

                for(Usua temp : new UsuaCtrl().consTodo()){
                    tblCont = new PdfPTable(3);
                    tblCont.setWidthPercentage(100);
                    tblCont.addCell(temp.getAcce_usua());
                    tblCont.addCell(temp.getCodi_pers().getNomb_pers()+" "+temp.getCodi_pers().getApel_pers());
                    tblCont.addCell(temp.getFech_alta());
                    document.add(tblCont);            
                }
                
                document.close();
                
            }
            catch(Exception err)
            {
                err.getMessage();
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
