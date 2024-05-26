package com.nitrodrift;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class Carrera {
    private Circuito circuito; // Circuito que se va a jugar
    private Vehiculo vehiculoDelJugador; // Vehículo seleccionado por el jugador
    private Jugador jugador; // Jugador
    private Personaje personaje; // Personaje seleccionado por el jugador
    private OrthographicCamera camera;

    public Carrera(){

    }
    
    /**
     * Constructor de la clase carrera. Inicialmente se inicializa con los siguientes parámetros:
     * @param p
     * @param c
     * @param cir
     */

    public Carrera(Personaje p, Vehiculo c, Circuito cir) {
        this.circuito = cir;
        vehiculoDelJugador = c;
        jugador = new Jugador();
        this.personaje = p;

    }
    /**
     * Getter del atributo circuito
     * @return Objeto de clase Circuito que indica el circuito que se va a jugar
     */
    public Circuito getCircuito() {
        return circuito;
    }

    /**
     * Setter del atributo circuito
     * @param circuito Objeto de clase Circuito que indica qué circuito se va a jugar
     */
    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    /**
     * Getter del atributo vehiculoDelJugador
     * @return Objeto de clase Vehiculo que indica el vehiculo seleccionado por el jugador
     */
    public Vehiculo getVehiculoDelJugador() {
        return vehiculoDelJugador;
    }

    /**
     * Setter del atributo vehiculoDelJugador
     * @param vehiculoDelJugador Objeto de clase Vehiculo que indica qué vehículo ha seleccionado el jugador
     */
    public void setVehiculoDelJugador(Vehiculo vehiculoDelJugador) {
        this.vehiculoDelJugador = vehiculoDelJugador;
    }

    /**
     * Getter del atributo jugador
     * @return Objeto de clase Jugador que indica el jugador que va a jugar la partida
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * Setter del atributo jugador
     * @param jugador Objeto de clase Jugador que indica qué jugador va a jugar la partida
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Getter del atributo personaje
     * @return Objeto de clase Personaje que indica el jugador seleccionado por el jugador
     */
    public Personaje getPersonaje() {
        return personaje;
    }

    /**
     * Setter del atributo personaje
     * @param personaje Objeto de clase Personaje que indica qué personaje ha seleccionado el jugador
     */
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    /**
     * Getter del atributo camera
     * @return Objeto de clase OrthographicCamera 
     */
    public OrthographicCamera getCamera() {
        return camera;
    }

    /**
     * Setter del atributo camera
     * @param camera Objeto de clase OrthographicCamera
     */
    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
}