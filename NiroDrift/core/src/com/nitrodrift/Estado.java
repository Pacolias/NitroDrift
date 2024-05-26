package com.nitrodrift;

/**
 * Interfaz que permitirá implementar los distintos tipos de estados que tendrá el juego
 */
public interface Estado {

    public void update(float delta);
    
    public void dibujarEstado(NitroDrift game);
};