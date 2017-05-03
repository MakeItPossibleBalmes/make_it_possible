/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.controller;

import com.makeit.exceptions.InvalidEmail;
import com.makeit.exceptions.InvalidName;
import com.makeit.exceptions.PasswordException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Clase de validaciones
 * @author razomiah
 */
public class Comprobacio {
    /**
     * Comprueba que los datos del formulario de registro sean correctos.
     * @param datos datos del formulario
     * @return True en el caso de que sean correctos, False en el caso contrario
     * @throws InvalidEmail
     * @throws PasswordException
     * @throws InvalidName 
     */
    	public static boolean comprobarDatosForumlario(ArrayList<String> datos) throws InvalidEmail, PasswordException, InvalidName{
		boolean correcto = true;
			isValidEmailAddress(datos.get(0));
			isValidPassword(datos.get(1),datos.get(2));
			isValidName(datos.get(3));
			isValidName(datos.get(4));
			isValidName(datos.get(5));
			isValidName(datos.get(6));
		return correcto;
	}
        /**
         * Validacion de nombre
         * @param name
         * @return
         * @throws InvalidName 
         */
	public static boolean isValidName(String name) throws InvalidName{
		/*String regx = "^[a-zA-Z \\-]+$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(name);
		if(matcher.matches() && name.length()>=2){
			return true;
		}else{
			throw new InvalidName();
		}*/
		
		//Pablo - 27/04
		//Que pongan lo que quieran en el nombre, controlar acentos y todos es un coñazo xd
		return true;
		
	}
        /**
         * Valida el password. Comprueba que los dos pw sean iguales y mayor o igual que 8(caracteres) minimos
         * @param password  la contraseña
         * @param password_confirmation la contraseña de consfirm
         * @return True en el caso de correcto, False en el caso contrario
         * @throws PasswordException 
         */
	public static boolean isValidPassword(String password,String password_confirmation) throws PasswordException{
		boolean correcte=false;
		if(password.equals(password_confirmation) && password.length()>=8 &&password_confirmation.length()>=8){
			correcte=true;
		}else{
			throw new PasswordException();
		}
		return correcte;
	}
        
        
        /**
         * Valida un email.
         * @param email String el email a validar
         * @return True en el caso de que sea correcto, False en el caso contrario
         * @throws InvalidEmail 
         */
	public static  boolean isValidEmailAddress(String email) throws InvalidEmail {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches()){
			return true;
		}else{
			throw new InvalidEmail();
		}
	}
    
}
