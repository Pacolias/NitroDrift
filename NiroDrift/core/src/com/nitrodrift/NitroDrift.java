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
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.math.Vector2;

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

	private World world;

	@Override
	public void create() {
		// Inicialización de Box2D
		Box2D.init();
		world = new World(new Vector2(0, 0), true);

		// Carga de imágenes
		fondoBarco = new Texture(Gdx.files.internal("fondoBarco.png"));
		fondoInicio = new Texture("fondoInicio.png");
		imgObstaculo = new Texture(Gdx.files.internal("tronco.png"));
		imgBarco = new Texture(Gdx.files.internal("barco.png"));
		imgBarcoRev = new Texture(Gdx.files.internal("barcoRev.png"));

		// Carga de sonidos
		sonidoGolpe = Gdx.audio.newSound(Gdx.files.internal("golpe.mp3"));
		musicaDeFondo = Gdx.audio.newMusic(Gdx.files.internal("bucle.mp3"));

		// Reproducción de la música de fondo
		musicaDeFondo.setLooping(true);
		musicaDeFondo.play();

		// Inicialización de los elementos gráficos
		camara = new OrthographicCamera();
		camara.setToOrtho(false, 1024, 900);
		gestorDeGraficos = new SpriteBatch();

		inicializarGraficos();

		estadoActual = new EstadoInicio();
	}

	protected void inicializarGraficos() {
		// Rectángulo para determinar el tamaño,
		// la posición inicial y la dirección del barco
		barco = new Rectangle();
		barco.x = 0;
		barco.y = 450;
		barco.width = 237;
		barco.height = 38; // 110;
		dirBarco = "der";

		// Lista de rectángulos para almacenar los obstáculos
		obstaculos = new Array<Rectangle>();
	}

	private void generarObstaculo() {
		Rectangle obstaculo = new Rectangle();
		obstaculo.width = 47;
		obstaculo.height = 64;

		do { // Nos aseguramos de que el obstáculo no aparece sobre el barco
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

		// Redibujar la pantalla
		camara.update();
		gestorDeGraficos.setProjectionMatrix(camara.combined);
		gestorDeGraficos.begin();
		estadoActual.dibujarEstado(this);
		gestorDeGraficos.end();

		// Actualizar el mundo de Box2D
		world.step(1/60f, 6, 2);
	}

	@Override
	public void dispose() {
		world.dispose();
		imgObstaculo.dispose();
		imgBarco.dispose();
		sonidoGolpe.dispose();
		musicaDeFondo.dispose();
		gestorDeGraficos.dispose();
	}
}
