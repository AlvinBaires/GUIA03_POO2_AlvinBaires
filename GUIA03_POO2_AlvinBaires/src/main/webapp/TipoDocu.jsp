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
    <script src="assets/js/validacionJquery.js"></script>
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
          <form  name="TipoDocuForm" action="TipoDocuServ" class="form-horizontal style-form" method="POST">
              <!--<section class="wrapper">
                 
                                   
                  <div class="row mt">
                      <div class="col-lg-12">
                          <div class="form-panel">
                              <div id="recargarForm">
                                  <h4 class="mb" id="Estado"><i class="fa fa-angle-right"></i> Datos:    ${mensAler}</h4>

                                  <input type="hidden" id="id" name="id" value="${id}"/>

                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Nombre Procesador</label>
                                      <div class="col-sm-10">
                                          <input id="nombre" name="nombre" value="${nombre}"  type="text" class="form-control round-form">
                                      </div>
                                  </div>

                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Descripcion</label>
                                      <div class="col-sm-10">
                                          <input id="descripcion" name="descripcion" value="${descripcion}"  type="text" class="form-control round-form">

                                      </div>
                                  </div>

                              </div>
                              <div class="col s12 center-align">
                                  <input type="button" class="waves-effect waves-light btn" id="boton"  name="cursBton" value="Guardar"/>
                                  <input type="button" class="waves-effect waves-light btn" id="boton"  name="cursBton" value="Modificar"/>
                                  <input type="button" class="waves-effect waves-light btn" id="boton"  name="cursBton" value="Eliminar" onclick="return confirm('¿Estas seguro que deseas eliminar este registro?');"/>
                              </div>    
                          </div>
                      </div>     	
                  </div>
                  
              </section>-->
          </form>
      
                                          
          <form  name="TipoDocuForm" action="TipoDocuServ" class="form-horizontal style-form" method="POST">
              <jsp:useBean id="beanTipoDocuCtrl" class="com.sv.udb.controlador.TipoDocuCtrl" scope="page"/>
              <section class="wrapper">
                   <h3><i class="fa fa-angle-right"></i> Tipo Documento</h3>
                  <div class="row">

                      <div class="col-md-12">
                          <div class="content-panel">
                              <h4><i class="fa fa-angle-right"></i>Registros</h4>
                              <hr>
                              <div id = "tblDatos">
                                  <section class="col-md-12">
                                      <% request.setAttribute("displayBod", new TipoDocuCtrl().consTodo());%>
                                      <display:table id="tablBod" name="displayBod" class="table" pagesize="4">
                                          <display:column property="CODI_TIPO_DOCU" title="Codigo" sortable="true"/>  
                                          <display:column property="NOMB_TIPO_DOCU" title="Nombre" sortable="true"/>  
                                          <display:column property="FECH_ALTA" title="Fecha Alta" sortable="true"/>  
                                          <display:column property="FECH_BAJA" title="Fecha Baja" sortable="true"/>
                                          <display:column title="Selecione" sortable="true">
                                              <input type="radio" name="idRadi" value="${tablBod.CODI_TIPO_DOCU}"/>
                                          </display:column>
                                      </display:table> 
                                  </section>
                              </div>                                  
                                      <input type="button" class="waves-effect waves-light btn"   name="cursBton" value="Consultar"/>
                              </div>
                          </div>
                      </div><!-- /col-md-12 -->
                  </div><!-- row -->
              </section><! --/wrapper -->
          </form>
      </section><!-- /MAIN CONTENT -->

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
                            //alert("Si entra al evento");
                            var cursBton = $(this).val();
                            var form = $(this).closest("form");
                            if(cursBton == "Consultar"){
                            $.ajax( {
                                type: "POST",
                                url: form.attr('action'),
                                data: form.serialize() + "&cursBton=" + cursBton,
                                success: function(response) {
                                    //alert("Si entra al evento");
                                   $("#tblDatos").html($(response).find("#tblDatos").html());
                                   $("#id").val($(response).find("#id").val());
                                   $("#nombre").val($(response).find("#nombre").val());
                                   $("#descripcion").val($(response).find("#descripcion").val());                                }
                              });
                            }
                            else if (cursBton == "Guardar"|| cursBton =="Modificar" ||cursBton =="Eliminar" )
                            {
                                $.ajax( {
                                type: "POST",
                                url: form.attr('action'),
                                data: form.serialize() + "&cursBton=" + cursBton,
                                success: function(response) {
                                    //alert("Si entra al evento");
                                    $("#Estado").html($(response).find("#Estado").html());
                                    $("#tblDatos").html($(response).find("#tblDatos").html());
                                }
                              });
                            }
                        });
                    });
</script>

  </body>
</html>

