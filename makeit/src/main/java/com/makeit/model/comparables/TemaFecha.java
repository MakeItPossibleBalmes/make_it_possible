/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.comparables;

import com.makeit.model.POJO.Tema;
import java.util.Comparator;

/**
 * Clase comparable que se implementará en un treeset para que los temas salgan
 * ordenados por fecha.
 *
 * @author hartbold <ardevolp at gmail dot com>
 */
public class TemaFecha implements Comparator {

    @Override
    public int compare(Object x, Object y) {
        Tema t1 = (Tema) x;
        Tema t2 = (Tema) y;

        int cont = t1.getFecha_creacion().compareTo(t2.getFecha_creacion());
        //Si son iguales, que ordene por nombre.
        if (cont == 0) {
            cont = t1.getTitulo().compareTo(t2.getTitulo());
        }
        return -cont;
    }
}
