package com.nitrodrift;

public interface Estado {

    void update(float delta);

    public enum tipoEstado{
        INICIO, SELECCIONAR_PERSONAJE, SELECCIONAR_VEHICULO, SELECCIONAR_CIRCUITO, CARRERA
    };


    public void dibujarEstado(NitroDrift game);

};
