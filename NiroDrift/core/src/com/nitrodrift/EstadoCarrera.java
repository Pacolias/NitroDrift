package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;

public class EstadoCarrera  implements  Estado{
    private tipoEstado tipo;
    private Texture fondo;//TODO CAMBIAR

    private float countdownTimer = 6; // Tiempo en segundos para la cuenta regresiva
    private boolean countdownFinished = false;
    private BitmapFont font; // Necesitas una instancia de BitmapFont para dibujar texto

    //private Pista pista;
    protected static Array<Coche> coches;
    private Jugador jugador;
    private OrthographicCamera camera;

    public EstadoCarrera() {
        font = new BitmapFont(); // Inicializa la fuente para dibujar texto


        tipo = tipoEstado.CARRERA;
        fondo = new Texture("carretera.png");
        //pista = new Pista();
        coches = new Array<>();
        jugador = new Jugador();

        // Añadir el jugador a la lista de coches
        coches.add(jugador);

        // Añadir algunos coches controlados por IA
        for (int i = 0; i < 3; i++) {
            coches.add(new IA());
        }

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);  // Ajustar según tu resolución deseada
    }

    @Override
    public void dibujarEstado(NitroDrift game) {

        // Redibujado de la pantalla
        game.camara.update();
        game.gestorDeGraficos.setProjectionMatrix(game.camara.combined);
        game.gestorDeGraficos.begin();

        // Dibujar el fondo de la pantalla
        Gdx.gl.glClearColor(0, 0, 0, 1); // Color negro

        // Definir el tamaño deseado para el fondo (circuito)
        float newWidth = 1080; // Nuevo ancho en píxeles
        float newHeight = 1000; // Nuevo alto en píxeles

        // Dibujar la textura redimensionada
        game.gestorDeGraficos.draw(fondo, 0, 0, newWidth, newHeight);

        // Actualizar y dibujar cada coche
        for (Coche coche : coches) {
            coche.update(Gdx.graphics.getDeltaTime());
            coche.render(game.gestorDeGraficos);
        }

        if (!countdownFinished) {
            // Dibuja la cuenta regresiva en la pantalla
            //game.gestorDeGraficos.begin();
            font.draw(game.gestorDeGraficos, "Cuenta atrás: " + (int) countdownTimer, 100, 100);
            //game.gestorDeGraficos.end();
        }

        game.gestorDeGraficos.end();

    }

    public void update(float delta) {

        if (!countdownFinished) {
            countdownTimer -= delta; // Actualiza el temporizador de la cuenta regresiva
            if (countdownTimer <= 0) {
                countdownFinished = true; // Marca la cuenta regresiva como finalizada
                // Inicia la carrera
                // ...
            }

        } else {
            // Actualizar todos los coches

            jugador.update(delta);

            for (Coche coche : coches) {
                coche.update(delta);
            }

            // Mover el escenario junto con el jugador si está acelerando
            if (jugador.isAccelerating()) {
                moveScenario(-jugador.getAccelerationSpeed() * delta);
            }

            // Llama al método para evitar colisiones entre los coches de la IA
            //evitarColisionesCoches();

            // Actualizar la cámara para seguir al jugador
            //camera.position.set(jugador.getX(), jugador.getY(), 0);
            //camera.update();
        }
    }

    private void moveScenario(float distance) {
        for (Coche coche : coches) {
            coche.getPosition().y += distance;
        }
    }

    /*
    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        estadoCarrera.update(delta);
        estadoCarrera.dibujarEstado(this);
    }*/
    /*
    @Override
    public void dispose() {
        fondo.dispose();
        for (Coche coche : coches) {
            coche.dispose();
        }
    }*/

    public void render(NitroDrift game) {
        // Redibujado de la pantalla
        game.camara.update();
        game.gestorDeGraficos.setProjectionMatrix(game.camara.combined);
        game.gestorDeGraficos.begin();

        // Dibujar el fondo de la pantalla
        Gdx.gl.glClearColor(0, 0, 0, 1); // Color negro

        // Definir el tamaño deseado para el fondo (circuito)
        float newWidth = 1080; // Nuevo ancho en píxeles
        float newHeight = 1000; // Nuevo alto en píxeles

        // Dibujar la textura redimensionada
        game.gestorDeGraficos.draw(fondo, 0, 0, newWidth, newHeight);

        // Dibujar el jugador
        //TODO jugador.render(game.gestorDeGraficos);

        // Actualizar y dibujar cada coche
        for (Coche coche : coches) {
            coche.render(game.gestorDeGraficos);
        }

        game.gestorDeGraficos.end();
    }

    /*private void evitarColisionesCoches() {
        for (Coche coche : coches) {
            coche.evitarColisiones(coches);
        }
    }*/

}
