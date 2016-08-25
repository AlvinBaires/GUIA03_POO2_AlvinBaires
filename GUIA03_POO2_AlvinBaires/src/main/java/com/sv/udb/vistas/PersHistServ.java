/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.*;
import com.sv.udb.modelo.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet(name = "PersHistServ", urlPatterns = {"/PersHistServ"})

public class PersHistServ extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("accion");
            System.out.println("boton " +CRUD);
            request.setAttribute("bloquear", "");
            if(CRUD.equals("Guardar"))
            {
                if(request.getParameter("cmbTipoPers").trim().equals("")||request.getParameter("cmbUbicGeog").trim().equals("") ||request.getParameter("nombrePersona").trim().equals("") || request.getParameter("nombrePersona").trim().equals("apellidoPersona"))
                {
                    mens="Campos vacíos";
                }
                else
                {
                    InputStream inputStream = null;
                    Part filePart;
                    try
                    {
                        filePart = request.getPart("fotoPersona");
                    }
                    catch(Exception err)
                    {
                        filePart=null;
                        System.out.println("SIN FOTO");
                    }
                    if (filePart != null) {
                        // prints out some information for debugging
                        if(filePart.getContentType().equals("image/jpg")||filePart.getContentType().equals("image/gif")||filePart.getContentType().equals("image/jpeg")||filePart.getContentType().equals("image/png"))
                        {
                            inputStream = filePart.getInputStream();      
                            try
                            {
                                Pers objePers = new Pers();
                                objePers.setNomb_pers(request.getParameter("nombrePersona"));
                                objePers.setApel_pers(request.getParameter("apellidoPersona"));
                                objePers.setCodi_tipo_pers(new TipoPers(Integer.parseInt(request.getParameter("cmbTipoPers")),null,null,null,null));
                                objePers.setCodi_ubic_geog(new UbicGeog(Integer.parseInt(request.getParameter("cmbUbicGeog")),null,0,null,null,null));
                                objePers.setEsta(1);
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                Date fecha = formatter.parse(request.getParameter("fechaNacimiento"));
                                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                String convertido = formato.format(fecha)+" 00:00:001";
                                
                                objePers.setFech_naci_pers(convertido);
                                objePers.setGene_pers(request.getParameter("cmbGeneroPersona"));
                                objePers.setDui_pers(request.getParameter("duiPersona"));
                                objePers.setNit_pers(request.getParameter("nitPersona"));
                                objePers.setTipo_sang_pers(request.getParameter("tipoSangre"));
                                mens = new PersCtrl().guardar(objePers,inputStream)? "Datos Guardados" : "Datos no guardados";
                                
                                PersHist objePersHist = new PersHist();
                                objePersHist.setCodi_pers(objePers);
                                objePersHist.setNomb_pers(request.getParameter("nombrePersona"));
                                objePersHist.setApel_pers(request.getParameter("apellidoPersona"));
                                objePersHist.setCodi_tipo_pers(new TipoPers(Integer.parseInt(request.getParameter("cmbTipoPers")),null,null,null,null));
                                objePersHist.setCodi_ubic_geog(new UbicGeog(Integer.parseInt(request.getParameter("cmbUbicGeog")),null,0,null,null,null));
                                objePersHist.setEsta(1);
                                mens = new PersHistCtrl().guardar(objePersHist,inputStream)? "Datos Guardados" : "Datos no guardados";
                                
                            }
                            catch(Exception err)
                            {
                                mens="Fecha mala!";
                            }
                        }
                        else
                        {
                            mens="Formato de imagen incorrecto debe seleccionar una imgen";
                        }                        
                    }
                }                
            }
            else if(CRUD.equals("Modificar"))
            {
                if(request.getParameter("cmbTipoPers").trim().equals("")||request.getParameter("cmbUbicGeog").trim().equals("") ||request.getParameter("nombrePersona").trim().equals("") || request.getParameter("nombrePersona").trim().equals("apellidoPersona"))
                {
                    mens="Campos vacíos";
                }
                else
                {
                    InputStream inputStream = null;
                    Part filePart;
                    try
                    {
                        filePart = request.getPart("fotoPersona");
                    }
                    catch(Exception err)
                    {
                        filePart=null;
                        System.out.println("SIN FOTO");
                    }
                    if (filePart != null ) {
                        // prints out some information for debugging
                        if(filePart.getContentType().equals("image/jpg")||filePart.getContentType().equals("image/gif")||filePart.getContentType().equals("image/jpeg")||filePart.getContentType().equals("image/png"))
                        {
                            inputStream = filePart.getInputStream();      
                            try
                            {
                                Pers objePers = new Pers();
                                objePers.setCodi_pers(Integer.parseInt(request.getParameter("codigoPersona")));
                                objePers.setNomb_pers(request.getParameter("nombrePersona"));
                                objePers.setApel_pers(request.getParameter("apellidoPersona"));
                                objePers.setCodi_tipo_pers(new TipoPers(Integer.parseInt(request.getParameter("cmbTipoPers")),null,null,null,null));
                                objePers.setCodi_ubic_geog(new UbicGeog(Integer.parseInt(request.getParameter("cmbUbicGeog")),null,0,null,null,null));
                                objePers.setEsta(1);
                                        
                                PersHist objePersHist = new PersHist();
                                objePersHist.setCodi_pers(objePers);
                                objePersHist.setCodi_pres_hist(Integer.parseInt(request.getParameter("codigoHistorial")));
                                objePersHist.setNomb_pers(request.getParameter("nombrePersona"));
                                objePersHist.setApel_pers(request.getParameter("apellidoPersona"));
                                objePersHist.setCodi_tipo_pers(new TipoPers(Integer.parseInt(request.getParameter("cmbTipoPers")),null,null,null,null));
                                objePersHist.setCodi_ubic_geog(new UbicGeog(Integer.parseInt(request.getParameter("cmbUbicGeog")),null,0,null,null,null));
                                objePersHist.setEsta(1);
                                mens = new PersHistCtrl().Modificar(objePersHist,inputStream)? "Datos Guardados" : "Datos no guardados";
                                
                            }
                            catch(Exception err)
                            {
                                mens="Hubo algún error :(";
                            }
                        }
                        else
                        {
                            mens="Formato de imagen incorrecto debe seleccionar una ";
                        }                        
                    }
                    else
                    {
                        mens="Lastimosamente debe actualizar la foto c:";                        
                    }
                }
            }
            else if(CRUD.equals("Consultar"))
            {
                int codigo = Integer.parseInt(request.getParameter("idRadi") == null ? "0" : request.getParameter("idRadi"));
                PersHist objeto = new PersHistCtrl().consRegistro(codigo);
                if(objeto != null)
                {
                    request.setAttribute("codigoHistorial", objeto.getCodi_pres_hist());
                    request.setAttribute("codigoPersona", objeto.getCodi_pers().getCodi_pers());
                    request.setAttribute("nombrePersona", objeto.getNomb_pers());
                    request.setAttribute("apellidoPersona", objeto.getApel_pers());
                    request.setAttribute("cmbTipoPers", objeto.getCodi_tipo_pers().getCodi_tipo_pers());
                    request.setAttribute("cmbUbicGeog", objeto.getCodi_ubic_geog().getCODI_UBIC_GEOG());
                    request.setAttribute("generoPesona", objeto.getCodi_pers().getGene_pers());
                    request.setAttribute("fechaNacimiento", objeto.getCodi_pers().getFech_naci_pers());
                    request.setAttribute("duiPersona", objeto.getCodi_pers().getDui_pers());
                    request.setAttribute("nitPersona", objeto.getCodi_pers().getNit_pers());
                    request.setAttribute("tipoSangre", objeto.getCodi_pers().getTipo_sang_pers());
                } 
                request.setAttribute("bloquear", "readonly");
            }
            else if(CRUD.equals("Limpiar"))
            {
                request.setAttribute("codigoHistorial", "");
                request.setAttribute("codigoPersona", "");
                request.setAttribute("nombrePersona", "");
                request.setAttribute("apellidoPersona", "");
                request.setAttribute("cmbTipoPers", "");
                request.setAttribute("cmbUbicGeog", "");
                request.setAttribute("generoPesona", "");
                request.setAttribute("fechaNacimiento", "");
                request.setAttribute("duiPersona", "");
                request.setAttribute("nitPersona", "");
                request.setAttribute("tipoSangre", "");
            }
            request.setAttribute("mensAler", mens);            
            request.getRequestDispatcher("/Personas.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/Personas.jsp");
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
