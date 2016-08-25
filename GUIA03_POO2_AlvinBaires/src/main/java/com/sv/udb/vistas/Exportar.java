/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.recursos.Conexion;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Alvin
 */
@WebServlet(name = "Exportar", urlPatterns = {"/Exportar"})
public class Exportar extends HttpServlet {

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
            if(request.getParameter("Exportar").equals("PDF"))
            {
                imprimirPDF(response, request);
            }
            else if(request.getParameter("Exportar").equals("HTML"))
            {
                imprimirHTML(response, request);
            }
            else if(request.getParameter("Exportar").equals("EXCEL"))
            {
                imprimirExcel(response, request);
            }
    }
    
    private void imprimirExcel(HttpServletResponse response, HttpServletRequest request)
    {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ReporteExcel.xlsx");          
            try {
                ServletOutputStream out = response.getOutputStream();
                Connection cn = new Conexion().getConn();
                JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(getServletContext().getRealPath("Reportes/Reporte1.jasper")));

                Map parametros = new HashMap();
                parametros.put("CodigoUnidad",request.getParameter("cmbUnidOrga"));
                
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, cn);

                JRExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                exporter.exportReport();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void imprimirHTML(HttpServletResponse response, HttpServletRequest request)
    {
        response.setContentType("text/html;charset=UTF-8");        
            try {
                ServletOutputStream out = response.getOutputStream();
                Connection cn = new Conexion().getConn();
                JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(getServletContext().getRealPath("Reportes/Reporte1.jasper")));

                Map parametros = new HashMap();
                parametros.put("CodigoUnidad",request.getParameter("cmbUnidOrga"));
                //parametros.put("ot_entidad_id", request.getSession().getAttribute("ot_entidad_id"));
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, cn);

                JRExporter exporter = new JRHtmlExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                exporter.exportReport();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void imprimirPDF(HttpServletResponse response, HttpServletRequest request)
    {
        response.setContentType("application/pdf");    
        response.setHeader("Content-Disposition", "attachment; filename=ReportePDF.pdf");        
            try {
                ServletOutputStream out = response.getOutputStream();
                Connection cn = new Conexion().getConn();
                JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(getServletContext().getRealPath("Reportes/Reporte1.jasper")));

                Map parametros = new HashMap();
                parametros.put("CodigoUnidad",request.getParameter("cmbUnidOrga"));
                //parametros.put("ot_entidad_id", request.getSession().getAttribute("ot_entidad_id"));
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, cn);

                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                exporter.exportReport();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
