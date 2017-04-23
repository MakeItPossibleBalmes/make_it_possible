/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.controller;

import com.makeit.model.POJO.Usuario;
import com.makeit.model.dao.DAOTema;
import java.io.IOException;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author hartbold <ardevolp at gmail dot com>
 */
public class Tema extends HttpServlet {

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

        String view = "/META-INF/views/temasRecientes.jsp";
        String create = request.getParameter("create");
        if (create != null) {
            //doPost(request, response);
            view = "/META-INF/views/addTema.jsp";
        }

        TreeSet<com.makeit.model.POJO.Tema> recientes = DAOTema.getRecientes();
        request.setAttribute("recientes", recientes);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    protected void createTema(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String cuerpo = request.getParameter("cuerpo");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        com.makeit.model.POJO.Tema tema = new com.makeit.model.POJO.Tema(titulo, cuerpo, usuario);
        String msg = "Error al insertar el tema";
        try {
            DAOTema.insertTema(tema);
            msg = "Nuevo tema creado";
        } catch (Exception e) {
            System.out.println(msg + " " + e.getMessage());
        }

        request.setAttribute("msg",msg);
        response.sendRedirect(request.getContextPath()+"/tema");

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
        createTema(request, response);
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
