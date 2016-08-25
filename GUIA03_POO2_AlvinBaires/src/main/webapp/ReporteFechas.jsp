<%-- 
    Document   : ReporteVisitas
    Created on : 08-05-2016, 09:31:15 PM
    Author     : Alvin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%
    Date fecha;
    try
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicial = formatter.parse(request.getParameter("fechaInicial"));
        Date fechaFinal = formatter.parse(request.getParameter("fechaFinal"));
        if(fechaInicial.after(fechaFinal)            )
        {
            %>
            La fecha Inicial no puede ser mayor a la Final
            <%
        }
        else
        {
            Connection cn = new Conexion().getConn(); 
            File reportFile = new File(application.getRealPath("Reportes/Reporte3.jasper"));
            System.out.println(reportFile.getPath());
            Map parameters = new HashMap();
            parameters.put("FechaInicial",(request.getParameter("fechaInicial")+" 00:00:01"));
            parameters.put("FechaFinal",(request.getParameter("fechaFinal")+" 11:59:59"));
            byte[] bytes=JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,cn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
        }
    }
    catch(Exception err)
    {
       %>
            Fechas no Válidas
            <%
    }
%>