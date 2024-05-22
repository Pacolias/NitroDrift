package com.nitrodrift;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class NitroDrift extends ApplicationAdapter {
	protected static final long TNANO = 1000000000;
	protected Music musicaDeFondo;
	protected SpriteBatch gestorDeGraficos;
	protected OrthographicCamera camara;
	protected Carrera carrera;
	protected Estado estadoActual;

	@Override
	public void create() {
		// Inicializaci�n de elementos del juego
		// S�lo se ejecuta una vez al arrancar la aplicaci�n
		musicaDeFondo = Gdx.audio.newMusic(Gdx.files.internal("menu_principal.mp3"));

		// Reproducci�n de la m�sica de fondo
		musicaDeFondo.setLooping(true);
		musicaDeFondo.play();

		// Inicializaci�n de los elementos gr�ficos
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
		// Eliminaci�n de recursos en memoria
		// Si no se invoca expl�citamente, s�lo se ejecuta al cerrar el juego
		musicaDeFondo.dispose();
		gestorDeGraficos.dispose();
	}
}