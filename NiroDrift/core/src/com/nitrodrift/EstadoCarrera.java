package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;

public class EstadoCarrera  implements  Estado{
    private tipoEstado tipo;
    private NitroDrift game;


    public EstadoCarrera(NitroDrift game) {
        tipo = tipoEstado.CARRERA;
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
        game.gestorDeGraficos.draw(game.carrera.getCircuito().getImagen(), 0, 0, newWidth, newHeight);
        Texture coche = new Texture("jugador.png");
        //game.gestorDeGraficos.draw(coche, 0, 0, coche.getWidth()*game.carrera.getVehiculoDelJugador().getScale(), coche.getHeight()*game.carrera.getVehiculoDelJugador().getScale());


        // Actualizar y dibujar cada coche
       /* for (Coche coche : coches) {
            coche.update(Gdx.graphics.getDeltaTime());
            coche.render(game.gestorDeGraficos);
        }*/
        game.carrera.getVehiculoDelJugador().update(Gdx.graphics.getDeltaTime());
        game.carrera.getVehiculoDelJugador().render(game.gestorDeGraficos);

        //if (!countdownFinished) {
            // Dibuja la cuenta regresiva en la pantalla
            //game.gestorDeGraficos.begin();
            //font.draw(game.gestorDeGraficos, "Cuenta atrás: " + (int) countdownTimer, 100, 100);
            //game.gestorDeGraficos.end();
       // }

        game.gestorDeGraficos.end();

    }

    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
            game.estadoActual = new EstadoInicio();
        }

    }





}
