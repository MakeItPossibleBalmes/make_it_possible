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
 * Servlet controlador de tema
 * @author hartbold <ardevolp at gmail dot com>
 */
public class Tema extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * 
     * Mostrará el form de inserción o bien la lista de temas dependiendo de si le llega el parámetro "a" (action) en la petición
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
        String err = (String) request.getAttribute("err");
        
        if (create != null || err != null) {
        	
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

    /**
     * Crea un tema recogiendo los parámetros que llegan desde el formulario por POST
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createTema(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String cuerpo = request.getParameter("cuerpo");
        String[] categorias = request.getParameterValues("categorias");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        com.makeit.model.POJO.Tema tema = new com.makeit.model.POJO.Tema(titulo, cuerpo, usuario);
        try {
            
        	int id = DAOTema.insertTema(tema);
            
            /*for(int i =0; i< categorias.length; i++){
            	insert en la tabla relacional
            }*/
        	
            response.sendRedirect(request.getContextPath()+"/tema");
        } catch (Exception e) {
        	request.setAttribute("err", "Error insertando el tema.");
            doGet(request,response);
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
     * Llamará al método de crear un tema.
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
