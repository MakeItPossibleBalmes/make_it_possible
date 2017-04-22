package com.makeit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.makeit.model.dao.DAOCategoria;

/**
 * @author hartbold <ardevolp at gmail dot com>
 * Servlet implementation class Categoria
 */
@WebServlet("/Categoria")
public class Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categoria() {
        super();
    }
    
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
    	
    	int id = Integer.parseInt(request.getParameter("q")) ;
    	
    	//Hay conflictos con el nombre del servlet.
    	//Ref futura: Cambiar el nombre de los servlets a <ClaseServlet> 
    	com.makeit.model.POJO.Categoria categoria = DAOCategoria.getCategoria(id);
    	
    	request.setAttribute("categoria", categoria);
    	//TODO: Quizá se puede recoger temas desde la JSP
    	request.setAttribute("temas", categoria.getTemas());
    	
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/categoria.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
