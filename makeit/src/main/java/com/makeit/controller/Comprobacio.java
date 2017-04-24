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
 *
 * @author razomiah
 */
public class Comprobacio {
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
	public static boolean isValidName(String name) throws InvalidName{
		String regx = "^[\\p{L} .'-]+$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(name);
		if(matcher.matches() && name.length()>=2){
			return true;
		}else{
			throw new InvalidName();
		}
		
	}
	public static boolean isValidPassword(String password,String password_confirmation) throws PasswordException{
		boolean correcte=false;
		if(password.equals(password_confirmation) && password.length()>=8 &&password_confirmation.length()>=8){
			correcte=true;
		}else{
			throw new PasswordException();
		}
		return correcte;
	}

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
