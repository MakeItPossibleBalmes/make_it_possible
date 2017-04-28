/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.controller;

import com.makeit.model.POJO.Categoria;
import com.makeit.model.POJO.Usuario;
import com.makeit.model.dao.DAOCategoria;
import com.makeit.model.dao.DAOTema;

import java.util.List;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        String view = "/WEB-INF/views/temasRecientes.jsp";
        String create = request.getParameter("a");
        if (create != null) {
        	
        	List<Categoria> categorias= DAOCategoria.getAllCategorias();
        	
        	request.setAttribute("categorias", categorias);
            //doPost(request, response);
            view = "/WEB-INF/views/addTema.jsp";
        } else {
        	TreeSet<com.makeit.model.POJO.Tema> recientes = DAOTema.getRecientes();
            request.setAttribute("recientes", recientes);
        }        

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    protected void createTema(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String cuerpo = request.getParameter("cuerpo");
        String[] categorias = request.getParameterValues("categorias");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        com.makeit.model.POJO.Tema tema = new com.makeit.model.POJO.Tema(titulo, cuerpo, usuario);
        String msg = "Error al insertar el tema";
        try {
            DAOTema.insertTema(tema);
            
            /*com.makeit.model.POJO.Tema t = DAOTema.getLastInserted();
            for(int i =0; i< categorias.length; i++){
            	
            }*/
            
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
