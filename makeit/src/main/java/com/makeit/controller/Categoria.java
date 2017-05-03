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
     *  Busca temas relacionados a una categoria en la db indicando la id de categoria
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void buscaTemasCategoria(HttpServletRequest request, int id)
            throws ServletException, IOException {
    	
        //se especifica la ruta del paquete para no confundir la clase Categoria de POJO con la del controller Categoria
    	com.makeit.model.POJO.Categoria categoria = DAOCategoria.getCategoria(id);//buscamos la categoria con su id
        request.setAttribute("categoria", categoria);//guardaos el objeto categoria en el request para su envío posterior 
        Set<Tema> temas = categoria.getTemas();//recibimos los temas relacionamos
    	if(temas.size() == 0){
    		temas = new TreeSet<Tema>();
    	}
    	request.setAttribute("temas", temas);//se guarda en el objeto request     
    	
    }
    
    /**
     * Añade una nueva categoría a la base de datos.
     * @param request
     * @param response
     * @param nombre Nombre de la categoria
     * @throws ServletException
     * @throws IOException
     */
    private void addCategoria(HttpServletRequest request, HttpServletResponse response, String nombre)
            throws ServletException, IOException {
    	
    	int resultado = DAOCategoria.insertCategoria(new com.makeit.model.POJO.Categoria(nombre)); //false;//
    	
    	if(resultado <= 0){//en el caso de que el resultado sea 0 o menor, quiere 
            //decir que ha habido un error al intentar insertar la categoria en la bd
    		request.setAttribute("error", true);
    	}
    	
    	response.sendRedirect(request.getContextPath()+"/categoria");//redireccion a url /categoria
    	/*RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(view);
        dispatcher.forward(request, response);*/
    }
    
    /**
     * Elimina una categoria de la base de datos dada la ID
     * @param request
     * @param response
     * @param id
     * @throws ServletException
     * @throws IOException
     */
    private void deleteCategoria(HttpServletRequest request,HttpServletResponse response, int id)
            throws ServletException, IOException {
    	
    	if(! DAOCategoria.deleteCategoria(id)){//en el caso de que devuelva un false 
            //al intentar eliminar la categoria, querra decir que ha habido un error al intentar eleiminarlo
    		request.setAttribute("errorDelete", true);
    	}
    	
    	response.sendRedirect(request.getContextPath()+"/categoria");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
            //recogemos los parametros de query(busqueda) y delete
		String busqueda = request.getParameter("q");
		String delete = request.getParameter("delete");		
		
		if(busqueda != null){//en el caso de que no sea null entrara aqui 
			int id = Integer.parseInt(busqueda) ;
			buscaTemasCategoria(request,id);//busca los temas por la categoria indicada
		}
		
		else if(delete != null){//en el caso de que no sea null entrara aqui
			int id = Integer.parseInt(delete);
			deleteCategoria(request,response, id);//elimina la categoria indicada
		}
		
		else {//en el caso de que los dos parametros 'q' y 'delete' sean null, entramos aqui
			List<com.makeit.model.POJO.Categoria> categorias = DAOCategoria.getAllCategorias();//recogemos todas las categorias
                        //y se envian a la vista
			request.setAttribute("categorias", categorias);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addCategoria.jsp");
	        dispatcher.forward(request, response);
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");//se recoge el nombre de la nueva categoria
		addCategoria(request, response,nombre);//insertando la nueva categoria
	}

}
