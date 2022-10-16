/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.river_raid.enemigos;

import com.river_raid.global.CargarImagen;

/**
 *
 * @author JHOAN CARRERO Y PAOLA PEREZ
 */

/**
 * Clase barco que es un enemigo en el juego para el jugador
 **/
public class Barco extends Enemigos {
    /**
     * Constructor parametrico de la clase barco, inicializa las variables y le da
     * una imagen
     * 
     * @param x         posicion en x del enemigo
     * @param y         posicion en y del enemigo
     * @param direccion derecha o izquierda
     **/

    public Barco(int x, int y, boolean direccion) {
        super(x, y, direccion);

        if (direccion)
            imagen = CargarImagen.loadImage("enemigos/Barco Derecha.jpg");
        else
            imagen = CargarImagen.loadImage("enemigos/Barco Izquierda.jpg");
    }

    @Override
    public void moverx(int velocidad, int BORDE_IZQUIERDO, int BORDE_DERECHO) {

        if (direccion) {
            if (posx + velocidad >= BORDE_DERECHO - imagen.getWidth(null)) {
                direccion = false;
                imagen = CargarImagen.loadImage("enemigos/Barco Izquierda.jpg");
            } else
                posx += velocidad;
        } else {
            if (posx - velocidad <= BORDE_IZQUIERDO) {
                direccion = true;
                imagen = CargarImagen.loadImage("enemigos/Barco Derecha.jpg");
            } else
                posx -= velocidad;
        }

    }

    @Override
    public void explosion() {
        if (!vivo)
            imagen = CargarImagen.loadImage("enemigos/Explosion Barco.jpg");
    }

}
