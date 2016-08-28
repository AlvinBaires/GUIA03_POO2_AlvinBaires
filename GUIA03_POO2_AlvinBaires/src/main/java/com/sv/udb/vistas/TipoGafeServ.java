/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.*;
import com.sv.udb.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alvin
 * @version 1.0 27 de Agosto de 2016
 */
@WebServlet(name = "TipoGafeServ", urlPatterns = {"/TipoGafeServ"})
public class TipoGafeServ extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("accionBtn");
            if(CRUD.equals("Guardar"))
            {
                TipoGafe obje = new TipoGafe();
                obje.setNombTipoGafe(request.getParameter("nomb"));
                obje.setFechAlta(new Date());
                obje.setEsta(1);
                mens = new TipoGafeCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
            }
            else if(CRUD.equals("Eliminar"))
            {
                
                 Long Codigo = Long.parseLong(request.getParameter("codiRadi") == null ? 
                            "0" : request.getParameter("codiRadi"));
                mens = new TipoGafeCtrl().elim(Codigo) ? "Datos Eliminados" : "Datos no eliminados"; 
            }
            else if(CRUD.equals("Consultar"))
            {
                Long Codigo = Long.parseLong(request.getParameter("codiRadi") == null ? 
                            "0" : request.getParameter("codiRadi"));
                    TipoGafe objeto = new TipoGafeCtrl().get(Codigo);
                    if(objeto != null)
                    {
                        //System.out.println(objeLuga.getCodiLugaAcce() +" "+objeLuga.getNombLugaAcce());
                        request.setAttribute("codi", objeto.getCodiTipoGafe());
                        request.setAttribute("nomb", objeto.getNombTipoGafe());
                     }
            }
            else if(CRUD.equals("Modificar"))
            {
                 TipoGafe obje = new TipoGafe();
                obje.setNombTipoGafe(request.getParameter("nomb"));
                obje.setEsta(1);
                obje.setCodiTipoGafe(Long.parseLong(request.getParameter("codi")));
                mens = new TipoGafeCtrl().modi(obje) ? "Datos modificados" : "Datos no modificados";
            }
            request.getRequestDispatcher("/TipoGafe.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/TipoGafe.jsp");
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
