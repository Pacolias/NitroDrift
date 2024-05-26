package com.nitrodrift;

import com.badlogic.gdx.Gdx;

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

    /**
     * Getter del atributo velocidad
     * @return Número flotante que indica la velocidad que lleva el vehículo
     */
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

    /**
     * Getter del atributo velocidadLimite
     * @return Número flotante que indica la velocidad límite del vehículo
     */
    public float getVelocidadLimite() {
        return velocidadLimite;
    }

    /**
     * Setter del atributo velocidadLimite
     * @param velocidadLimite Número flotante que indica la velocidad máxima que podrá alcanzar el vehículo
     */
    public void setVelocidadLimite(float velocidadLimite) {
        this.velocidadLimite = velocidadLimite;
    }

    /**
     * Getter del atributo aceleracion
     * @return Número flotante que indica la aceleración que tiene el vehículo
     */
    public float getAcelaracion() {
        return acelaracion;
    }

    /**
     * Setter del atributo aceleracion
     * @param acelaracion Número flotante que indica la aceleración que tendrá el vehículo
     */
    public void setAcelaracion(float acelaracion) {
        this.acelaracion = acelaracion;
    }

    /**
     * Getter del atributo totalChoquesSoportados
     * @return Número entero que indica la cantidad de choques que puede soportar el Vehiculo
     */
    public int getTotalChoquesSoportados() {
        return totalChoquesSoportados;
    }

    /**
     * Setter del atributo totalChoquesSoportados
     * @param totalChoquesSoportados Número entero que indica cuántos choques soportará el vehículo
     */
    public void setTotalChoquesSoportados(int totalChoquesSoportados) {
        this.totalChoquesSoportados = totalChoquesSoportados;
    }

    /**
     * Getter del atributo choquesActuales 
     * @return Número entero que indica la cantidad de choques que ha recibido el coche
     */
    public int getChoquesActuales() {
        return choquesActuales;
    }

    /**
     * Setter del atributo choquesActuales
     * @param choquesActuales Número entero que indica la cantidad de choques que ha recibido el coche
     */
    public void setChoquesActuales(int choquesActuales) {
        this.choquesActuales = choquesActuales;
    }

    /**
     * Método que incrementa la cantidad de choques recibidos por el coche en uno.
     */
    public void incrementarChoques(){
        choquesActuales++;
    }

}
