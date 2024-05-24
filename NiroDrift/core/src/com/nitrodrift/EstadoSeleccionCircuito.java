package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class EstadoSeleccionCircuito implements Estado{
    private Texture[] seleccionCircuito;
    private Texture fondo;
    private int circuitoSeleccionadoIndex;
    private NitroDrift game;

    public EstadoSeleccionCircuito(NitroDrift game){
        this.game = game;
        
        fondo = game.carrera.getPersonaje().getImagen();

        seleccionCircuito = new Texture[2];
        seleccionCircuito[0] = new Texture(Gdx.files.internal("circuito1.jpg"));
        seleccionCircuito[1] = new Texture(Gdx.files.internal("circuito2.jpg"));
        circuitoSeleccionadoIndex = 0;
    }

    @Override
    public void update(float delta) {
        // Manejo de la entrada del jugador para cambiar la selección de circuito
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            if(circuitoSeleccionadoIndex > 0) {
                circuitoSeleccionadoIndex--;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (circuitoSeleccionadoIndex < seleccionCircuito.length - 1) {
                circuitoSeleccionadoIndex++;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            Circuito c = new Circuito(circuitoSeleccionadoIndex, "NombreCircuito", 1000, seleccionCircuito[circuitoSeleccionadoIndex]);
            game.carrera.setCircuito(c);
            game.estadoActual = new EstadoCarrera(game);
        }
    }

    @Override
    public void dibujarEstado(NitroDrift game) {
        // Redibujado de la pantalla
        game.camara.update();
        game.gestorDeGraficos.setProjectionMatrix(game.camara.combined);
        game.gestorDeGraficos.begin();

        // Dibujar el fondo de la pantalla de selección de circuito
        Gdx.gl.glClearColor(0, 0, 0, 1); // Color negro

        // Dibujar el fondo
        game.gestorDeGraficos.setColor(Color.WHITE); // Asegurarse de que el color sea blanco para el fondo
        game.gestorDeGraficos.draw(fondo, 0, 0, game.camara.viewportWidth, game.camara.viewportHeight);

        // Calcular las posiciones de los cuadros de selección de circuito
        float cuadroWidth = 200;
        float cuadroHeight = 200;
        float padding = 20;
        float startX = (game.camara.viewportWidth - (cuadroWidth * 2 + padding)) / 2; // Centrar horizontalmente
        float posY = (game.camara.viewportHeight - cuadroHeight) / 2; // Centrar verticalmente
        
        // Dibujar los cuadros de selección de circuito
        for (int i = 0; i < seleccionCircuito.length; i++) {
            // Calcular la coordenada x del cuadro actual
            float posX = startX + (cuadroWidth + padding) * i;

            // Determinar el color a aplicar al circuito
            if(i != circuitoSeleccionadoIndex) {
                game.gestorDeGraficos.setColor(0.5f, 0.5f, 0.5f, 1); // Oscurece los circuitos no seleccionados
            } else {
                game.gestorDeGraficos.setColor(Color.WHITE);
            }
            game.gestorDeGraficos.draw(seleccionCircuito[i], posX, posY,cuadroWidth, cuadroHeight);
        }
        
        game.gestorDeGraficos.end();
    }
}