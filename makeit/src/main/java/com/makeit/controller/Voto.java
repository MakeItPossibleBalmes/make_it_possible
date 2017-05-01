/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.controller;

import com.makeit.model.POJO.Usuario;
import com.makeit.model.POJO.Tema;
import com.makeit.model.POJO.VotoTemaUsuario;
import com.makeit.model.dao.DAOTema;
import com.makeit.model.dao.DAOUsuario;
import com.makeit.model.dao.DAOVoto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author razomiah
 */
public class Voto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Realizará la acción de voto.
     * 
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String up = request.getParameter("up");
        String down = request.getParameter("down");
        
        //Controlamos que el usuario esté logeado y se esté realizando una acción.
        if(usuario == null && (up != null || down != null) ){
        	request.getSession().setAttribute("msg", "Necesitas estar registrado para poder votar.");
        } else {
        	try{
            	if(up != null){
                	Tema tema = DAOTema.getTema(Integer.parseInt(up));
                	DAOVoto.insertVoto(usuario, tema);
                } else {
                	Tema tema = DAOTema.getTema(Integer.parseInt(down));
                	DAOVoto.cancelarVoto(usuario, tema);
                }
            	request.getSession().setAttribute("msg", null);
            } catch(Exception e){
            	System.out.println("Error:"+e);
            	request.getSession().setAttribute("msg", "No se pudo votar este tema.");
            }  
        }    
        
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
        processRequest(request, response);
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
