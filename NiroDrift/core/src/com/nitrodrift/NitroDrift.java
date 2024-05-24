package com.nitrodrift;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NitroDrift extends ApplicationAdapter {
	protected static final long TNANO = 1000000000;
	protected Music musicaDeFondo;
	protected SpriteBatch gestorDeGraficos;
	protected OrthographicCamera camara;
	protected Carrera carrera;
	protected Estado estadoActual;
	protected Estado estadoPersonaje;
	protected Estado estadoCircuito;
	protected Estado estadoVehiculo;

	@Override
	public void create() {
		// Inicializacion de elementos del juego
		// Solo se ejecuta una vez al arrancar la aplicacion
		musicaDeFondo = Gdx.audio.newMusic(Gdx.files.internal("menu_principal.mp3"));

		// Reproduccion de la musica de fondo
		musicaDeFondo.setLooping(true);
		musicaDeFondo.play();

		// Inicializacion de los elementos graficos
		camara = new OrthographicCamera();
		camara.setToOrtho(false, 1024, 900);
		gestorDeGraficos = new SpriteBatch();
		
		estadoActual = new EstadoInicio();
		carrera = new Carrera();
	}

	@Override
	public void render() {
		float delta = Gdx.graphics.getDeltaTime();
		estadoActual.update(delta);
		estadoActual.dibujarEstado(this);
	}

	@Override
	public void dispose() {
		// Eliminacion de recursos en memoria
		musicaDeFondo.dispose();
		gestorDeGraficos.dispose();
	}
}