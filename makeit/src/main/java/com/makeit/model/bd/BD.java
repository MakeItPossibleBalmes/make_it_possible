/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author razomiah
 */
public class BD {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javaweb";
    private static final String ID_DB = "root";
    private static final String PW_DB = "";
    private static Connection CONNECTION = null;
    
    public static Connection getConnexio() throws SQLException {
        if (CONNECTION == null) {
            new BD(DATABASE_URL, ID_DB, PW_DB);
        }
        return CONNECTION;
    }
    public BD(){
        
    }
    private BD(String url, String id, String pw) throws SQLException {
        connectarBBDD(url, id, pw);
    }

    private void connectarBBDD(String url, String id, String pw) throws SQLException {
        CONNECTION = DriverManager.getConnection(url, id, pw);
    }

    public static void tancarConnexio() {
        if (CONNECTION != null) {
            try {
                CONNECTION.close();
            } catch (Exception ignore) {
            }
        }
    }

}
