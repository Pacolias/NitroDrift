package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;

public class EstadoCarrera  implements  Estado{
    tipoEstado tipo;
    Carrera carrera;

    private Texture fondo;//TODO CAMBIAR

    private Pista pista;
    protected static Array<Coche> coches;
    private Jugador jugador;
    private OrthographicCamera camera;

    public EstadoCarrera() {
        tipo = tipoEstado.CARRERA;
        fondo = new Texture("carretera.png");
        pista = new Pista();
        coches = new Array<>();
        jugador = new Jugador();

        // Añadir el jugador a la lista de coches
        coches.add(jugador);

        // Añadir algunos coches controlados por IA
        for (int i = 0; i < 5; i++) {
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

        // Dibujar el jugador
        //TODO jugador.render(game.gestorDeGraficos);

        // Actualizar y dibujar cada coche
        for (Coche coche : coches) {
            coche.update(Gdx.graphics.getDeltaTime());
            coche.render(game.gestorDeGraficos);
        }

        game.gestorDeGraficos.end();
    }

    public void update(float delta) {
        // Actualizar todos los coches

        jugador.update(delta);

        for (Coche coche : coches) {
            coche.update(delta);
        }

        // Llama al método para evitar colisiones entre los coches de la IA
        evitarColisionesCoches();

        // Actualizar la cámara para seguir al jugador
        //camera.position.set(jugador.getX(), jugador.getY(), 0);
        //camera.update();

        // Lógica adicional de la carrera (e.g., detección de final de carrera)
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

    private void evitarColisionesCoches() {
        for (Coche coche : coches) {
            coche.evitarColisiones(coches);
        }
    }

}
