package com.makeit.controller;

import com.makeit.exceptions.InvalidEmail;
import com.makeit.exceptions.InvalidName;
import com.makeit.exceptions.PasswordException;
import com.makeit.model.POJO.Usuario;
import com.makeit.model.dao.DAOUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registro
 *
 * @author hartbold <ardevolp at gmail dot com>
 */
// @WebServlet("/registro")
public class Registro extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        // TODO Auto-generated constructor stub
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
    protected void peticionRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> datos = new ArrayList<String>();
        datos.add(request.getParameter("email"));
        datos.add(request.getParameter("password"));
        datos.add(request.getParameter("password-confirmation"));
        datos.add(request.getParameter("nombre"));
        datos.add(request.getParameter("primer_apellido"));
        datos.add(request.getParameter("ciudad"));
        datos.add(request.getParameter("pais"));
        try {
            Comprobacio.comprobarDatosForumlario(datos);
            Usuario usuario = new Usuario(datos.get(0), datos.get(1), datos.get(3), datos.get(4), datos.get(5), datos.get(6));
            DAOUsuario.insertUsuario(usuario);
            request.getSession().setAttribute("usuario", usuario);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        peticionRegistro(request, response);
    }

}
