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
            email = request.getParameter("email");//recogemos email
            String psw = request.getParameter("password");//recogemos password
            
            //validacion de email y psw
            if (Comprobacio.isValidEmailAddress(email) && Comprobacio.isValidPassword(psw, psw)) {
                
                Usuario usuario = DAOUsuario.getUsuario(email);//buscamos usuario con el email
                
                //si el psw del usuario coincide con la que ha introducido, se
                //creará una sesion para el usuario. y luego se le redirecciona a index
                if (usuario.getPassword().equals(Crypt.encripta(psw))) {
                    request.getSession().setAttribute("usuario", usuario);
                    response.sendRedirect(request.getContextPath() + "/");
                    valido = true;
                }else{//si los datos introducidos no coinciden con registros de bd 
                    //se le mostrara un mensaje de error en la pagina de login
                    //request.setAttribute("error", "datos contraseña incorrecta");
                	request.setAttribute("error", "Los datos no son correctos");
                	System.out.println("Contraseña incorrecta");
                    //doGet(request, response);
                }
            }
        } catch (InvalidEmail e) {//recogida de excepcion de email
        	System.out.println("Email inválido");
            //request.setAttribute("error", "email invalido"+e.getMessage());
        } catch (PasswordException e) {//recogida de excepcion de psw
        	System.out.println("Contraseña inválida");
            //request.setAttribute("error", "contraseña invalida"+e.getMessage());
        } catch (Exception e) {//excepcion general
            request.setAttribute("error", "Los datos no son correctos");
        } finally {
        	//finalmente al saltar algun error a la hora de login, devolvemos
                //al usuario a la pagina de login junto a su email
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
    	
        //para desloguear al usuario hacemos una peticion get y aquí en este
        //metodo quitamos la sesion del usuario. A continuacion le devolvemos a la pagina de login
    	String action = request.getParameter("a");
    	if(action != null){
    		request.getSession().removeAttribute("usuario");
    		response.sendRedirect(request.getContextPath()+"/login");
    	}else {//si la accion es cualquier otra, devolvemos al usuario a la pagina de login
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
        procesarLogin(request, response);//login de usuario
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
