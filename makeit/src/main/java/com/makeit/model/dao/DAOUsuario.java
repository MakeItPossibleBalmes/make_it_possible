/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author razomiah
 */
public class DAOUsuario {

    /**
     * Funcio per inserir Usuaris a la base de dades.
     *
     * @param usuario Parametro de tipo Usuario
     * @return devuelve un true si se ha introducido correctamente, false en el
     * caso contrario
     */
    public boolean insertUsuario(Usuario usuario) throws SQLException {
        boolean recordOk = true;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO usuario(dni,password,nombre,primer_apellido,"
                    + "segundo_apellido,codigo_postal,ciudad,pais,is_admin)"
                    + " VALUES(?,?,?,?,?,?,?,?,?)";
            stmt = conexio().prepareStatement(sql);
            stmt.setString(1, usuario.getDni());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getNombre());
            stmt.setString(4, usuario.getPrimer_apellido());
            stmt.setString(5, usuario.getSegundo_apellido());
            stmt.setInt(6, usuario.getCodigo_postal());
            stmt.setString(7, usuario.getCiudad());
            stmt.setString(8, usuario.getPais());
            stmt.setBoolean(9, usuario.is_admin());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            recordOk = false;
            throw e;
        }
        return recordOk;
    }

    /**
     * Funcio per fer update d'Usuaris a la base de dades.
     *
     * @param usuario Parametro de tipo Usuario
     * @return devuelve un true si se ha introducido correctamente, false en el
     * caso contrario
     */
    public boolean updateUsuario(Usuario usuario) throws SQLException {
        boolean recordOk = true;
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE usuario SET password=?,nombre=?,primer_apellido=?,"
                    + "segundo_apellido=?,codigo_postal=?,ciudad=?,pais=?"
                    + "WHERE id=?";
            stmt = conexio().prepareStatement(sql);
            stmt.setString(1, usuario.getPassword());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getPrimer_apellido());
            stmt.setString(4, usuario.getSegundo_apellido());
            stmt.setInt(5, usuario.getCodigo_postal());
            stmt.setString(6, usuario.getCiudad());
            stmt.setString(7, usuario.getPais());
            stmt.setInt(8, usuario.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            recordOk = false;
            throw e;
        }
        return recordOk;
    }

    /**
     * Funcion para obtener un usuario registrado en la bd
     *
     * @param String dni
     * @return devuelve un Usuario
     */
    public Usuario getUsuario(String dni) throws SQLException {
        Usuario usuario;
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM usuario WHERE dni=?";
            stmt = conexio().prepareStatement(sql);
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            usuario = new Usuario(rs.getInt("id"), rs.getString("dni"), rs.getString("password"),
                    rs.getString("nombre"), rs.getString("primer_apellido"), rs.getString("segundo_apellido"),
                    rs.getInt("codigo_postal"), rs.getString("ciudad"), rs.getString("pais"), rs.getBoolean("is_admin"));
            stmt.close();
        } catch (SQLException e) {
            usuario = null;
            throw e;
        }
        return usuario;
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
