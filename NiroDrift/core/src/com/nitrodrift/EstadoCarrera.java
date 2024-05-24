package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

public class EstadoCarrera  implements  Estado{
    private NitroDrift game;

    public EstadoCarrera(NitroDrift game) {
        this.game = game;
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
        game.gestorDeGraficos.setColor(Color.WHITE); // Asegurarse de que el color sea blanco para el fondo
        game.gestorDeGraficos.draw(game.carrera.getCircuito().getImagen(), 0, 0, newWidth, newHeight);

        game.carrera.getVehiculoDelJugador().update(Gdx.graphics.getDeltaTime());
        game.carrera.getVehiculoDelJugador().render(game.gestorDeGraficos);

        game.gestorDeGraficos.end();
    }

    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
            game.estadoActual = new EstadoInicio();
        }
    }
}
