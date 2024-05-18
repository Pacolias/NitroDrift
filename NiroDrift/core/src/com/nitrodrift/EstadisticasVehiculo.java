package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import java.util.Random;

public class EstadisticasVehiculo {

    private float ultimoLimiteVelocidad;
    private float velocidad;
    private float velocidadLimite;
    private float acelaracion;
    private int totalChoquesSoportados;

    private int choquesActuales;

    /**
     * Constructor de las estadísticas de un vehículo
     * @param vL número flotante que indica la velocidad límite del vehículo
     * @param a  número flotante que indica la aceleración que tiene el vehículo
     * @param tcs int que representa la cantidad de choques que puede soportar un vehículo antes de romperse
     */
    public EstadisticasVehiculo(float vL, float a, int tcs){
        this.velocidadLimite = vL;
        this.velocidad = 0;
        this.acelaracion = a;
        this.totalChoquesSoportados = tcs;
        this.choquesActuales = 0;
        this.ultimoLimiteVelocidad = -1;
    }

    //Getters and setters
    public float getVelocidad() {
        return velocidad;
    }

    /**
     * Método que actualiza la velocidad que lleva el vehículo.
     * Simula que la nueva velocidad mediante dv = a*dt hasta alcanzar que se alcance la velocidad limite
     * En caso de alcanzar la velocidad límite esta se mantiene constante hasta que no frene
     * entre la velocidad anterior
     */
    public void setVelocidad() {
        float newVelocidad = velocidad+acelaracion*Gdx.graphics.getDeltaTime();
        if(velocidadLimite>= newVelocidad){
            this.velocidad = newVelocidad;
        } else {
            this.velocidad = velocidadLimite;
        }

    }

    public float getVelocidadLimite() {
        return velocidadLimite;
    }

    public void setVelocidadLimite(float velocidadLimite) {
        this.velocidadLimite = velocidadLimite;
    }

    public float getAcelaracion() {
        return acelaracion;
    }

    public void setAcelaracion(float acelaracion) {
        this.acelaracion = acelaracion;
    }

    public int getTotalChoquesSoportados() {
        return totalChoquesSoportados;
    }

    public void setTotalChoquesSoportados(int totalChoquesSoportados) {
        this.totalChoquesSoportados = totalChoquesSoportados;
    }

    public int getChoquesActuales() {
        return choquesActuales;
    }

    public void setChoquesActuales(int choquesActuales) {
        this.choquesActuales = choquesActuales;
    }

    public void incrementarChoques(){
        choquesActuales++;
    }

}
