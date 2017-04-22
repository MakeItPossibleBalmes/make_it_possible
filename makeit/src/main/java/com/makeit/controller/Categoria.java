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
    private void buscaTemasCategoria(HttpServletRequest request, int id)
            throws ServletException, IOException {
    	
    	com.makeit.model.POJO.Categoria categoria = DAOCategoria.getCategoria(id);
        request.setAttribute("categoria", categoria);
        Set<Tema> temas = categoria.getTemas();
    	if(temas.size() == 0){
    		temas = new TreeSet<Tema>();
    	}
    	request.setAttribute("temas", temas);     
    	
    }
    
    private void addCategoria(HttpServletRequest request, HttpServletResponse response, String nombre)
            throws ServletException, IOException {
    	
    	boolean resultado = false;//DAOCategoria.insertCategoria(new com.makeit.model.POJO.Categoria(nombre)); 
    	
    	if(!resultado){
    		request.setAttribute("error", true);
    	}
    	
    	response.sendRedirect(request.getContextPath()+"/categoria");
    	/*RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(view);
        dispatcher.forward(request, response);*/
    }
    
    private void deleteCategoria(HttpServletRequest request,HttpServletResponse response, int id)
            throws ServletException, IOException {
    	
    	if(! DAOCategoria.deleteCategoria(id)){
    		request.setAttribute("errorDelete", true);
    	}
    	
    	response.sendRedirect(request.getContextPath()+"/categoria");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("q");
		String delete = request.getParameter("delete");		
		
		if(busqueda != null){
			int id = Integer.parseInt(busqueda) ;
			buscaTemasCategoria(request,id);
		}
		
		else if(delete != null){
			int id = Integer.parseInt(delete);
			deleteCategoria(request,response, id);
		}
		
		else {
			List<com.makeit.model.POJO.Categoria> categorias = DAOCategoria.getAllCategorias();
			request.setAttribute("categorias", categorias);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addCategoria.jsp");
	        dispatcher.forward(request, response);
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		addCategoria(request, response,nombre);
	}

}
