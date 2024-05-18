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
	protected Texture imgObstaculo, imgBarco, imgBarcoRev, fondoBarco, fondoInicio;
	protected Sound sonidoGolpe;
	protected Music musicaDeFondo;
	protected SpriteBatch gestorDeGraficos;
	protected OrthographicCamera camara;
	protected Rectangle barco;
	protected Array<Rectangle> obstaculos;
	protected long tiempoUltimoObstaculo;
	protected String dirBarco;


	protected Estado estadoActual;

	@Override
	public void create() {
		// Inicializaci�n de elementos del juego
		// S�lo se ejecuta una vez al arrancar la aplicaci�n

		// Carga de im�genes
		fondoBarco = new Texture(Gdx.files.internal("fondoBarco.png"));
		fondoInicio = new Texture("fondoInicio.png");
		imgObstaculo = new Texture(Gdx.files.internal("tronco.png"));
		imgBarco = new Texture(Gdx.files.internal("barco.png"));
		imgBarcoRev = new Texture(Gdx.files.internal("barcoRev.png"));

		// Carga de sonidos
		sonidoGolpe = Gdx.audio.newSound(Gdx.files.internal("golpe.mp3"));
		musicaDeFondo = Gdx.audio.newMusic(Gdx.files.internal("menu_principal.mp3"));

		// Reproducci�n de la m�sica de fondo
		musicaDeFondo.setLooping(true);
		musicaDeFondo.play();

		// Inicializaci�n de los elementos gr�ficos
		camara = new OrthographicCamera();
		camara.setToOrtho(false, 1024, 900);
		gestorDeGraficos = new SpriteBatch();

		inicializarGraficos();

		estadoActual = new EstadoInicio();
	}

	protected void inicializarGraficos() {
		// Rect�ngulo para determinar el tama�o,
		// la posici�n inicial y la direcci�n del barco
		barco = new Rectangle();
		barco.x = 0;
		barco.y = 450;
		barco.width = 237;
		barco.height = 38; // 110;
		dirBarco = "der";

		// Lista de rect�ngulos para almacenar los obst�culos
		obstaculos = new Array<Rectangle>();
	}

	private void generarObstaculo() {
		Rectangle obstaculo = new Rectangle();
		obstaculo.width = 47;
		obstaculo.height = 64;

		do { // Nos aseguramos de que el obst�culo no aparece sobre el barco
			obstaculo.x = MathUtils.random(0, 1024 - 47);
			obstaculo.y = MathUtils.random(370, 450);
		} while (obstaculo.overlaps(barco));

		obstaculos.add(obstaculo);
		tiempoUltimoObstaculo = TimeUtils.nanoTime() / TNANO;
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
		imgObstaculo.dispose();
		imgBarco.dispose();
		sonidoGolpe.dispose();
		musicaDeFondo.dispose();
		gestorDeGraficos.dispose();
	}
}