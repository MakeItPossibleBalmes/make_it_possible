package com.makeit.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.makeit.model.POJO.Tema;
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
    private com.makeit.model.POJO.Categoria buscaCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String catId = request.getParameter("q");
    	com.makeit.model.POJO.Categoria categoria = null;
    	if(catId != null){
    		int id = Integer.parseInt(catId) ;
    		//Hay conflictos con el nombre del servlet.
        	//Ref futura: Cambiar el nombre de los servlets a <ClaseServlet> 
        	categoria = DAOCategoria.getCategoria(id);
        	
        	request.setAttribute("categoria", categoria);
        	//TODO: Quizá se puede recoger temas desde la JSP
        	Set<Tema> temas = categoria.getTemas();
        	if(temas.size() == 0){
        		temas = new TreeSet<Tema>();
        	}
        	request.setAttribute("temas", temas);   	
            
    	} 
    	
    	return categoria;
    }
    
    private void addCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/categoria.jsp";
		com.makeit.model.POJO.Categoria categoria = buscaCategoria(request,response);
		//No se ha encontrado nada así que cargamos el formulario.
		if(categoria == null){
			view = "/WEB-INF/views/addCategoria.jsp";
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(view);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addCategoria(request, response);
	}

}
