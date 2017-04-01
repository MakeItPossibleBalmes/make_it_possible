/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.classes.Tema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author razomiah
 */
public class DAOTema {

    /**
     * Funcio per inserir Temes a la base de dades.
     *
     * @param tema Parametro de tipo Tema
     * @return devuelve un true si se ha introducido correctamente, false en el
     * caso contrario
     */
    public boolean insertTema(Tema tema) throws SQLException {
        boolean recordOk = true;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO tema(titulo,cuerpo,id_usuario) VALUES(?,?,?)";
            stmt = conexio().prepareStatement(sql);
            stmt.setString(1, tema.getTitulo());
            stmt.setString(2, tema.getCuerpo());
            stmt.setInt(3, tema.getId_usuario());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            recordOk = false;
            throw e;
        }
        return recordOk;
    }
        /**
     * Funcio per fer update Temes a la base de dades.
     *
     * @param tema Parametro de tipo Tema
     * @return devuelve un true si se ha introducido correctamente, false en el
     * caso contrario
     */
    public boolean updateTema(Tema tema) throws SQLException {
        boolean recordOk = true;
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE tema SET titulo=?,cuerpo=? WHERE id =?";
            stmt = conexio().prepareStatement(sql);
            stmt.setString(1, tema.getTitulo());
            stmt.setString(2, tema.getCuerpo());
            stmt.setInt(3, tema.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            recordOk = false;
            throw e;
        }
        return recordOk;
    }
    

    /**
     * Funcion para obtener todos los temas registradas en la bd
     *
     * @return devuelve una lista de Tema
     */
    public ArrayList<Tema> getAllTemas() throws SQLException {
        ArrayList<Tema> resultat = new ArrayList();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM tema ORDER BY fecha_creacion LIMIT 25";
            stmt = conexio().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultat.add(new Tema(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("cuerpo"),
                        new Date(rs.getTimestamp("fecha_creacion").getTime()),
                        rs.getInt("id_usuario")
                ));
            }
            stmt.close();
        } catch (SQLException e) {
            resultat = null;
            throw e;
        }
        return resultat;
    }

    /**
     * Funcion para obtener todos los temas registradas en la bd de un usuario
     *
     * @return devuelve una lista de Tema
     */
    public ArrayList<Tema> getAllTemas(int id_usuario) throws SQLException {
        ArrayList<Tema> resultat = new ArrayList();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM tema WHERE id_usuario=?";
            stmt = conexio().prepareStatement(sql);
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultat.add(new Tema(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("cuerpo"),
                        new Date(rs.getTimestamp("fecha_creacion").getTime()),
                        rs.getInt("id_usuario")
                ));
            }
            stmt.close();
        } catch (SQLException e) {
            resultat = null;
            throw e;
        }
        return resultat;
    }

    /**
     * Funcion para obtener la conexion a la bd
     *
     * @return
     * @throws SQLException
     */
    private Connection conexio() throws SQLException {
        return BD.getConnexio();
    }
}
