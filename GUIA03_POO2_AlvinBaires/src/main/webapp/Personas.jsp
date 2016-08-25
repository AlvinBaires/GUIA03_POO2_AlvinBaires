
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sv.udb.controlador.*"%>
<%@page import="com.sv.udb.modelo.*"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <link rel="icon" href="assets/img/ui-sam.jpg"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Personas</title>

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
      <form  name="PersonasForm" action="PersHistServ" class="form-horizontal style-form" enctype="multipart/form-data" method="POST">
      <section id="main-content">          
              <input type="hidden" name="accion" id="txtAccion"/>
              <section class="wrapper">
                  <h3><i class="fa fa-angle-right"></i> Personas</h3>

                  <!-- BASIC FORM ELELEMNTS -->
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                                  <h4 class="mb" id="mensaje">${mensAler}</h4>

                                  <input type="hidden" name="codigoPersona" value="${codigoPersona}"/>
                                  <input type="hidden" name="codigoHistorial" value="${codigoHistorial}"/>

                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Nombres</label>
                                      <div class="col-sm-10">
                                          <input id="nombrePersona" name="nombrePersona" value="${nombrePersona}"  type="text" class="form-control">
                                      </div>
                                  </div>
                                      
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Apellidos</label>
                                      <div class="col-sm-10">
                                          <input id="apellidoPersona" name="apellidoPersona" value="${apellidoPersona}"  type="text" class="form-control ">
                                      </div>
                                  </div>
                                      
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Foto</label>
                                      <div class="col-sm-10">
                                          <input type="file" name="fotoPersona" class="form-control "/>
                                      </div>
                                  </div>

                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Tipo Persona</label>
                                      <div class="col-sm-10">
                                          <select class="form-control" id="cmbTipoPers" name="cmbTipoPers">
                                              <jsp:useBean id="beanTipoPers" class="com.sv.udb.controlador.TipoPersCtrl" scope="page"/>
                                              <c:forEach items="${beanTipoPers.consTodo()}" var="fila">
                                                  <c:choose>
                                                      <c:when test="${fila.codi_tipo_pers eq cmbTipoPers}">
                                                          <option data-rule-required="true" name="codigoTipoPers" value="${fila.codi_tipo_pers}" selected="">${fila.nomb_tipo_pers}</option>
                                                      </c:when>
                                                      <c:otherwise>
                                                          <option data-rule-required="true" name="codigoTipoPers" value="${fila.codi_tipo_pers}">${fila.nomb_tipo_pers}</option>
                                                      </c:otherwise>
                                                  </c:choose>
                                              </c:forEach>
                                          </select>
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Ubicacion Geografica</label>
                                      <div class="col-sm-10">
                                          <select class="form-control" id="cmbUbicGeog" name="cmbUbicGeog">
                                              <jsp:useBean id="beanUbicGeog" class="com.sv.udb.controlador.UbicGeogCtrl" scope="page"/>
                                              <c:forEach items="${beanUbicGeog.consTodo()}" var="fila">
                                                  <c:choose>
                                                      <c:when test="${fila.CODI_UBIC_GEOG eq cmbUbicGeog}">
                                                          <option data-rule-required="true" name="codigoTipoPers" value="${fila.CODI_UBIC_GEOG}" selected="">${fila.NOMB_UBIC_GEOG}</option>
                                                      </c:when>
                                                      <c:otherwise>
                                                          <option data-rule-required="true" name="codigoTipoPers" value="${fila.CODI_UBIC_GEOG}">${fila.NOMB_UBIC_GEOG}</option>
                                                      </c:otherwise>
                                                  </c:choose>
                                              </c:forEach>
                                          </select>
                                      </div>
                                  </div>
                                              
                                 <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Género</label>
                                      <div class="col-sm-10">
                                          <select class="form-control" id="cmbUbicGeog" name="cmbGeneroPersona" ${bloquear}>      
                                              
                                              <c:choose>                                                  
                                                      <c:when test="${generoPesona eq 'F'}">
                                                          <option  data-rule-required="true"selected name="generoPersona" value="F" selected="">Femenino</option>
                                                          <option data-rule-required="true" name="generoPersona" value="M">Masculino</option>
                                                      </c:when>
                                                      <c:otherwise>
                                                          <option data-rule-required="true" name="generoPersona" value="F" selected="">Femenino</option>
                                                          <option data-rule-required="true"  selected name="generoPersona" value="M">Masculino</option>
                                                      </c:otherwise>
                                              </c:choose>
                                          </select>
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Fecha Nadimiento (dd/mm/aaaa)</label>
                                      <div class="col-sm-10">
                                          <input ${bloquear} id="fechaNacimiento" name="fechaNacimiento" value="${fechaNacimiento}"  type="date" class="form-control ">
                                      </div>
                                  </div>
                                      
                                 <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">DUI</label>
                                      <div class="col-sm-10">
                                          <input ${bloquear} id="duiPersona" name="duiPersona" value="${duiPersona}"  type="text" class="form-control ">
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">NIT</label>
                                      <div class="col-sm-10">
                                          <input ${bloquear} id="nitPersona" name="nitPersona" value="${nitPersona}"  type="text" class="form-control">
                                      </div>
                                  </div>
                                      
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Tipo Sangre</label>
                                      <div class="col-sm-10">
                                          <input ${bloquear} id="tipoSangre" name="tipoSangre" value="${tipoSangre}"  type="text" class="form-control">
                                      </div>
                                  </div>
                                      
                              <div class="col s12 center-align">
                                  <input type="button" class="waves-effect waves-light btn" id="boton"  name="cursBton" value="Guardar"/>
                                  <input type="button" class="waves-effect waves-light btn" id="boton"  name="cursBton" value="Modificar"/>
                                  <input type="button" class="waves-effect waves-light btn" id="boton"  name="cursBton" value="Limpiar" />
                              </div>    
                          </div>
                      </div><!-- col-lg-12-->      	
                  </div><!-- /row -->
              </section>
          <jsp:useBean id="beanPersHist" class="com.sv.udb.controlador.PersHistCtrl" scope="page"/>
              <section class="wrapper">
                  <div class="row">

                      <div class="col-lg-12">
                          <div class="content-panel">
                              <h4><i class="fa fa-angle-right"></i>Listado de Personas</h4>
                              <hr>
                              <div id = "tblDatos">
                                  <section class="col-md-12">
                                      <% request.setAttribute("displayBod", new PersHistCtrl().consTodo());%>
                                      <display:table id="tablBod" name="displayBod" class="table" pagesize="4">
                                          <display:column property="nomb_pers" title="Nombre" sortable="true"/>  
                                          <display:column property="apel_pers" title="Apellido" sortable="true"/>  
                                          <display:column property="codi_tipo_pers.nomb_tipo_pers" title="Tipo" sortable="true"/>  
                                          <display:column property="codi_ubic_geog.NOMB_UBIC_GEOG" title="Ubicación" sortable="true"/>
                                          <display:column title="Selecione" sortable="true">
                                              <input type="radio" name="idRadi" value="${tablBod.codi_pers.codi_pers}"/>
                                          </display:column>
                                      </display:table> 
                                  </section>
                              </div>                                  
                                      <input type="button" class="waves-effect waves-light btn"   name="cursBton" value="Consultar"/>
                              </div>
                          </div>
                      </div>
              </section><! --/wrapper -->
          
      </section><!-- /MAIN CONTENT -->
      </form>
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
	
  <script>
    $(document).ready(function() {
                        $("input[name='cursBton']").click(function(event) {
                            document.getElementById("txtAccion").value=$(this).val();
                            $(this).closest("form").submit();
                            
                        });
                    });
</script>

  </body>
</html>
