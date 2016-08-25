<%@page import="com.sv.udb.controlador.TipoDocuCtrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sv.udb.controlador.TipoDocuCtrl"%>
<%@page import="com.sv.udb.modelo.TipoDocu"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <link rel="icon" href="assets/img/ui-sam.jpg"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>POO 2</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/icono/style.css" rel="stylesheet" />    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <jsp:include page="INCLUDES/HEADER.jsp" flush="true"/>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <jsp:include page="INCLUDES/ASIDE.jsp" flush="true"/>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      
      <section id="main-content">
          
          <section class="wrapper">                       
          <form action="ReporteVisitas.jsp" target="_blank" class="form-horizontal style-form" method="POST">
                               
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                              <h4><i class="fa fa-angle-right"></i>Reporte 1 Guia 1</h4>
                              Ver visitas de una unidad                              
                              <div class="form-group">
                                  <label class="col-sm-2 col-sm-2 control-label">Unidad Organizativa:</label>
                                  <div class="col-sm-10">
                                      <select class="form-control" id="cmbUnidOrga" name="cmbUnidOrga">
                                      <jsp:useBean id="beanCtrl" class="com.sv.udb.controlador.UnidOrgaCtrl" scope="page"/>
                                          <c:forEach items="${beanCtrl.consTodo()}" var="fila">
                                                  <option data-rule-required="true" name="CODI_UNID_ORGA" value="${fila.CODI_UNID_ORGA}">${fila.NOMB_UNID}</option>                                      
                                          </c:forEach>
                                      </select>
                                  </div>
                              </div>
                              <input type="submit" class="waves-effect waves-light btn"  value="Generar Reporte"/>
                          </div>     
                      </div><!-- /col-md-12 -->
                  </div><!-- row -->              
          </form>
          
          <form action="ReportePersonas.jsp" target="_blank" class="form-horizontal style-form" method="POST">
                               
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                              <h4><i class="fa fa-angle-right"></i>Reporte 2 Guia 1</h4>
                              Ver lugar, fecha y hora de acceso y salida de una persona, así como la unidad organizativa que ha visitado.                            
                              <div class="form-group">
                                  <label class="col-sm-2 col-sm-2 control-label">Persona:</label>
                                  <div class="col-sm-10">
                                      <select class="form-control" id="cmbPers" name="cmbPers">
                                      <jsp:useBean id="beanPersCtrl" class="com.sv.udb.controlador.PersCtrl" scope="page"/>
                                          <c:forEach items="${beanPersCtrl.consTodo()}" var="fila">
                                                  <option data-rule-required="true" name="CODI_UNID_ORGA" value="${fila.codi_pers}">${(fila.nomb_pers.concat(" ")).concat(fila.apel_pers)}</option>                                      
                                          </c:forEach>
                                      </select>
                                  </div>
                              </div>
                              <input type="submit" class="waves-effect waves-light btn"  value="Generar Reporte"/>
                          </div>     
                      </div><!-- /col-md-12 -->
                  </div><!-- row -->
              
          </form>
                                          
          <form action="ReporteFechas.jsp" target="_blank" class="form-horizontal style-form" method="POST">
                               
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                              <h4><i class="fa fa-angle-right"></i>Reporte 3 Guia 1</h4>
                              Ver las visitas de cada unidad organizativa han realizado en un rango de fechas                             
                              <div class="form-group">
                                  <label class="col-sm-2 col-sm-2 control-label">Fecha Inicial: (dd/mm/aaaa)</label>
                                  <div class="col-sm-10">
                                      <input type="date" name="fechaInicial" class="form-control"/>
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label class="col-sm-2 col-sm-2 control-label">Fecha Inicial: (dd/mm/aaaa)</label>
                                  <div class="col-sm-10">
                                      <input type="date" name="fechaFinal" class="form-control"/>
                                  </div>
                              </div>
                              
                              <input type="submit" class="waves-effect waves-light btn"  value="Generar Reporte"/>
                          </div>     
                      </div><!-- /col-md-12 -->
                  </div><!-- row -->              
          </form>
                                          
          <form action="ReporteiText" target="_blank" class="form-horizontal style-form" method="POST">
                               
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                              <h4><i class="fa fa-angle-right"></i>Reporte con iText Guia 1</h4>
                              Ver listado de usuarios</br>
                              <input type="submit" class="waves-effect waves-light btn"  value="Generar Reporte"/>
                          </div>     
                      </div><!-- /col-md-12 -->
                  </div><!-- row -->              
          </form>
          
          <form action="Exportar" target="_blank" class="form-horizontal style-form" method="POST">
                               
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                              <h4><i class="fa fa-angle-right"></i>Exportar reporte 1 Guia 1</h4>
                              Ver visitas de una unidad                              
                              <div class="form-group">
                                  <label class="col-sm-2 col-sm-2 control-label">Unidad Organizativa:</label>
                                  <div class="col-sm-10">
                                      <select class="form-control" id="cmbUnidOrga" name="cmbUnidOrga">
                                          <c:forEach items="${beanCtrl.consTodo()}" var="fila">
                                                  <option data-rule-required="true" name="CODI_UNID_ORGA" value="${fila.CODI_UNID_ORGA}">${fila.NOMB_UNID}</option>                                      
                                          </c:forEach>
                                      </select>
                                  </div>
                              </div>
                              <input type="submit" class="waves-effect waves-light btn" name="Exportar" value="EXCEL"/>
                              <input type="submit" class="waves-effect waves-light btn" name="Exportar" value="PDF"/>
                              <input type="submit" class="waves-effect waves-light btn" name="Exportar" value="HTML"/>
                          </div>     
                      </div><!-- /col-md-12 -->
                  </div><!-- row -->              
          </form>
                                          
          <form action="FichaPersona.jsp" target="_blank" class="form-horizontal style-form" method="POST">
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                              <h4><i class="fa fa-angle-right"></i>Ficha Persona Guia 2</h4>
                              Ver visitas de una unidad                              
                              <div class="form-group">
                                  <label class="col-sm-2 col-sm-2 control-label">Persona: </label>
                                  <div class="col-sm-10">
                                      <select class="form-control" id="cmbUnidOrga" name="cmbPersona">
                                      <jsp:useBean id="beanPersHist" class="com.sv.udb.controlador.PersHistCtrl" scope="page"/>
                                          <c:forEach items="${beanPersHist.consTodo()}" var="fila">
                                                  <option data-rule-required="true"  value="${fila.codi_pers.codi_pers}">${fila.nomb_pers}</option>                                      
                                          </c:forEach>
                                      </select>
                                  </div>
                              </div>
                              <input type="submit" class="waves-effect waves-light btn"  value="Generar Reporte"/>
                          </div>     
                      </div><!-- /col-md-12 -->
                  </div><!-- row -->              
          </form>
                                          
          <form action="VerHistorial.jsp" target="_blank" class="form-horizontal style-form" method="POST">
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                              <h4><i class="fa fa-angle-right"></i>Historial Persona Guia 2</h4>
                              Ver visitas de una unidad                              
                              <div class="form-group">
                                  <label class="col-sm-2 col-sm-2 control-label">Persona: </label>
                                  <div class="col-sm-10">
                                      <select class="form-control" id="cmbUnidOrga" name="cmbPersona">
                                        <c:forEach items="${beanPersHist.consTodo()}" var="fila">
                                                  <option data-rule-required="true"  value="${fila.codi_pers.codi_pers}">${fila.nomb_pers}</option>                                      
                                          </c:forEach>
                                      </select>
                                  </div>
                              </div>
                              <input type="submit" class="waves-effect waves-light btn"  value="Generar Reporte"/>
                          </div>     
                      </div><!-- /col-md-12 -->
                  </div><!-- row -->              
          </form>
                                          
          </section>
                                          
      </section>

      <!--main content end-->
      <!--footer start-->
      <jsp:include page="INCLUDES/FOOTER.jsp" flush="true" />
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="assets/js/bootstrap-switch.js"></script>
	
	<!--custom tagsinput-->
	<script src="assets/js/jquery.tagsinput.js"></script>
	
	<!--custom checkbox & radio-->
	<script type="text/javascript" src="assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


  </body>
</html>

