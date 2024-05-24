package com.nitrodrift;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class Carrera {
    private Circuito circuito;
    private Vehiculo vehiculoDelJugador;
    private Jugador jugador;
    private Personaje personaje;
    private OrthographicCamera camera;

    public Carrera(){

    }
    public Carrera(Personaje p, Vehiculo c, Circuito cir) {
        this.circuito = cir;
        vehiculoDelJugador = c;
        jugador = new Jugador();
        this.personaje = p;

    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public Vehiculo getVehiculoDelJugador() {
        return vehiculoDelJugador;
    }

    public void setVehiculoDelJugador(Vehiculo vehiculoDelJugador) {
        this.vehiculoDelJugador = vehiculoDelJugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
}