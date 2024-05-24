package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class EstadoInicio implements  Estado{
    private Texture nitroLogo;

    public EstadoInicio(){
        nitroLogo = new Texture("NitroDriftFondoMorado.jpg");
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void dibujarEstado(NitroDrift game) {
        // Redibujado de la pantalla
        game.camara.update();
        game.gestorDeGraficos.setProjectionMatrix(game.camara.combined);
        game.gestorDeGraficos.begin();

        // Limpiar la pantalla dibujando un color de fondo
        Gdx.gl.glClearColor(0, (float)0.75, 1,0); // Color negro

        game.gestorDeGraficos.draw(nitroLogo, 0,0);

        // Manejo del clic para cambiar al estado de selección de personaje
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.estadoActual = new EstadoSeleccionPersonaje(game);
        }
        
        game.gestorDeGraficos.end();
    }
}
