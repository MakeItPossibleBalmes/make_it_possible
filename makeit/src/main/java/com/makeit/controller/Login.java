/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.controller;

import com.makeit.exceptions.InvalidEmail;
import com.makeit.exceptions.InvalidName;
import com.makeit.exceptions.PasswordException;
import com.makeit.model.POJO.Usuario;
import com.makeit.model.dao.DAOUsuario;
import com.makeit.model.util.Crypt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hartbold <ardevolp at gmail dot com>
 */
public class Login extends HttpServlet {

    /**
     * Controlará la acción de Login. 
     * Recoge el email y la contraseña y establece el usuario que encuentre por las mismas credenciales en una variable de sesión.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void procesarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = "";
        boolean valido = false;
        try {
            email = request.getParameter("email");
            String psw = request.getParameter("password");
            if (Comprobacio.isValidEmailAddress(email) && Comprobacio.isValidPassword(psw, psw)) {
                Usuario usuario = DAOUsuario.getUsuario(email);
                if (usuario.getPassword().equals(Crypt.encripta(psw))) {
                    request.getSession().setAttribute("usuario", usuario);
                    response.sendRedirect(request.getContextPath() + "/");
                    valido = true;
                }else{
                    request.setAttribute("error", "datos contraseña incorrecta");
                    //doGet(request, response);
                }
            }
        } catch (InvalidEmail e) {
            request.setAttribute("error", "email invalido"+e.getMessage());
        } catch (PasswordException e) {
            request.setAttribute("error", "contraseña invalida"+e.getMessage());
        } catch (Exception e) {
            request.setAttribute("error", "error extraño, contacte con el admin"+e.getMessage());
        } finally {
            request.setAttribute("email", email);
            if(!valido){
            	doGet(request, response);
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
    	
    	String action = request.getParameter("a");
    	if(action != null){
    		request.getSession().removeAttribute("usuario");
    		response.sendRedirect(request.getContextPath()+"/login");
    	}else {
    		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(request, response);
    	}
    	
    	
        
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
        procesarLogin(request, response);
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
