/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.classes.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author razomiah
 */
public class DAOCategoria {

    /**
     * Funcion per inserir Categories a la base de dades.
     *
     * @param categoria
     * @return devuelve un true si se ha introducido correctamente, false en el
     * caso contrario
     */
    public boolean insertCategoria(Categoria categoria) throws SQLException {
        boolean recordOk = true;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO categoria(nombre) VALUES(?)";
            stmt = conexio().prepareStatement(sql);
            stmt.setString(1, categoria.getNombre());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            recordOk = false;
            throw e;
        }
        return recordOk;
    }

    /**
     * Funcion para obtener todas las categorias registradas en la bd
     *
     * @return devuelve una lista de Categoria
     */
    public ArrayList<Categoria> getAllCategorias() throws SQLException {
        ArrayList<Categoria> resultat = new ArrayList();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM categoria";
            stmt = conexio().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultat.add(new Categoria(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }
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
