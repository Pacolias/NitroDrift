package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;

/**
 * Clase que implementa el estado del juego en el que el jugador debe elegir el personaje con el que jugar la carrera
 */
public class EstadoSeleccionPersonaje implements Estado {
    private Texture[] seleccionPersonaje;
    private Texture fondo;
    private int personajeSeleccionadoIndex;
    private NitroDrift game;

    public EstadoSeleccionPersonaje(NitroDrift game) {
        this.game = game;

        fondo = new Texture(Gdx.files.internal("fondoseleccion2.jpeg"));

        seleccionPersonaje = new Texture[8];
        seleccionPersonaje[0] = new Texture(Gdx.files.internal("personaje5.jpg"));
        seleccionPersonaje[1] = new Texture(Gdx.files.internal("personaje6.jpeg"));
        seleccionPersonaje[2] = new Texture(Gdx.files.internal("personaje7.jpeg"));
        seleccionPersonaje[3] = new Texture(Gdx.files.internal("personaje8.jpeg"));
        seleccionPersonaje[4] = new Texture(Gdx.files.internal("personaje1.jpeg"));
        seleccionPersonaje[5] = new Texture(Gdx.files.internal("personaje2.jpeg"));
        seleccionPersonaje[6] = new Texture(Gdx.files.internal("personaje3.jpeg"));
        seleccionPersonaje[7] = new Texture(Gdx.files.internal("personaje4.jpeg"));
        personajeSeleccionadoIndex = 4;
    }

    @Override
    public void update(float delta) {
        // Manejo de la entrada del jugador para cambiar la selección de personaje
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (personajeSeleccionadoIndex == 0 || personajeSeleccionadoIndex == 4) {
                personajeSeleccionadoIndex += 3;
            } else {
                personajeSeleccionadoIndex--;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (personajeSeleccionadoIndex == 3 || personajeSeleccionadoIndex == 7) {
                personajeSeleccionadoIndex -= 3;
            } else {
                personajeSeleccionadoIndex++;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (personajeSeleccionadoIndex >= 4) {
                personajeSeleccionadoIndex -= 4;
            } else {
                personajeSeleccionadoIndex += 4;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (personajeSeleccionadoIndex < 4) {
                personajeSeleccionadoIndex += 4;
            } else {
                personajeSeleccionadoIndex -= 4;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            // El jugador ha confirmado su selección, cambiar el estado a la selección de vehículos
            Personaje p = new Personaje(personajeSeleccionadoIndex,"nombrePersonaje", seleccionPersonaje[personajeSeleccionadoIndex] );
            game.carrera.setPersonaje(p);
            game.estadoActual = new EstadoSeleccionVehiculo(game);
        }
    }

    @Override
    public void dibujarEstado(NitroDrift game) {
        // Redibujado de la pantalla
        game.camara.update();
        game.gestorDeGraficos.setProjectionMatrix(game.camara.combined);
        game.gestorDeGraficos.begin();

        // Dibujar el fondo de la pantalla de selección de personaje
        Gdx.gl.glClearColor(0, 0, 0, 1); // Color negro
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Limpiar el buffer de color

        // Dibujar el fondo
        game.gestorDeGraficos.setColor(Color.WHITE); // Asegurarse de que el color sea blanco para el fondo
        game.gestorDeGraficos.draw(fondo, 0, 0, game.camara.viewportWidth, game.camara.viewportHeight);

        // Calcular las posiciones de los cuadros de selección de personaje
        float cuadroWidth = 150;
        float cuadroHeight = 150;
        float padding = 20;
        float startX = (game.camara.viewportWidth - (cuadroWidth * 4 + padding * 3)) / 2; // Centrar horizontalmente
        float startY = (game.camara.viewportHeight - (cuadroHeight * 2 + padding)) / 2; // Centrar verticalmente

        // Dibujar los cuadros de selección de personaje
        for (int i = 0; i < seleccionPersonaje.length; i++) {
            int fila = i / 4; // Calcular la fila actual
            int columna = i % 4; // Calcular la columna actual

            // Calcular las coordenadas x e y del cuadro actual
            float posX = startX + (cuadroWidth + padding) * columna;
            float posY = startY + (cuadroHeight + padding) * fila;

            // Determinar el color a aplicar al personaje
            if (i != personajeSeleccionadoIndex) {
                game.gestorDeGraficos.setColor(0.5f, 0.5f, 0.5f, 1); // Oscurecer los personajes no seleccionados
            } else {
                game.gestorDeGraficos.setColor(Color.WHITE); // Restaurar el color original para el personaje seleccionado
            }

            game.gestorDeGraficos.draw(seleccionPersonaje[i], posX, posY, cuadroWidth, cuadroHeight);
        }

        game.gestorDeGraficos.end();
    }
}