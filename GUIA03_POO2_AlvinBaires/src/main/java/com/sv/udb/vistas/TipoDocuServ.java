/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.TipoDocuCtrl;
import com.sv.udb.modelo.TipoDocu;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orlando Vasquez
 */
@WebServlet(name = "ProcesadorServ", urlPatterns = {"/ProcesadorServ"})
public class TipoDocuServ extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("cursBton");
            if(CRUD.equals("Guardar"))
            {
//                TipoDocu Insti = new TipoDocu();
//                Insti.setNombre(request.getParameter("nombre"));
//                Insti.setDescripcion(request.getParameter("descripcion"));
//                mens = new TipoDocuCtrl().guar(Insti) ? "Datos guardados" : "Datos no guardados";
            }
            else if(CRUD.equals("Modificar"))
            {
//                TipoDocu Insti = new TipoDocu();
//                Insti.setId(Integer.parseInt(request.getParameter("id")));
//                Insti.setNombre(request.getParameter("nombre"));
//                Insti.setDescripcion(request.getParameter("descripcion"));
//                if(Insti != null)
//                {
//                    mens = new TipoDocuCtrl().modi(Insti) ? "Datos modificados" : "Datos no modificados";
//                }
            }
            else if(CRUD.equals("Eliminar"))
            {
//                TipoDocu objeInsti = new TipoDocu();
//                objeInsti.setId(Integer.parseInt(request.getParameter("id")));
//                mens = new TipoDocuCtrl().elim(objeInsti) ? "Datos eliminados" : "Datos no eliminados";
            }
            else if(CRUD.equals("Consultar"))
            {
//                int id = Integer.parseInt(request.getParameter("idRadi") == null ? "0" : request.getParameter("idRadi"));
//                TipoDocu objeInsti = new TipoDocuCtrl().cons(id);
//                if(objeInsti != null)
//                {
//                    request.setAttribute("id", id);
//                    request.setAttribute("nombre", objeInsti.getNombre());
//                    request.setAttribute("descripcion", objeInsti.getDescripcion()); 
//                } 
            }
            request.setAttribute("mensAler", mens);
            request.getRequestDispatcher("/TipoDocu.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/TipoDocu.jsp");
        }
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
