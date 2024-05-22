package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class EstadoInicio implements  Estado{
    private tipoEstado tipo;
    private Texture nitroLogo;

    public EstadoInicio(){
        tipo = tipoEstado.INICIO;
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
        //Gdx.gl.glClearColor(0, (float)0.75, 1,0); // Color negro

        // Dibujar el logo de NitroDrift escalado
        //float logoWidth = 800; // Ancho deseado del logo
        //float logoHeight = 800; // Alto deseado del logo
        //float logoX = (game.camara.viewportWidth - logoWidth) / 2; // Centrar el logo horizontalmente
        //float logoY = (game.camara.viewportHeight - logoHeight) / 2; // Centrar el logo verticalmente
        game.gestorDeGraficos.draw(nitroLogo, 0,0);


        game.gestorDeGraficos.end();

        // Manejo del clic para cambiar al estado de selección de personaje
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.estadoActual = new EstadoSeleccionPersonaje(game);
        }

    }
}
