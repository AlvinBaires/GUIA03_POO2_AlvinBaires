<%-- 
    Document   : ReporteVisitas
    Created on : 08-05-2016, 09:31:15 PM
    Author     : Alvin
--%>

<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%
    Connection cn = new Conexion().getConn(); 
    File reportFile = new File(application.getRealPath("Reportes/Reporte2.jasper"));
    System.out.println(reportFile.getPath());
    Map parameters = new HashMap();
    parameters.put("CodiPers",request.getParameter("cmbPers"));
    byte[] bytes=JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,cn);
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream outputStream = response.getOutputStream();
    outputStream.write(bytes,0,bytes.length);
    outputStream.flush();
    outputStream.close();
%>