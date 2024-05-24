package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;

public class EstadoSeleccionVehiculo implements Estado {
    private Texture[] seleccionVehiculo;
    private Texture fondo;
    private int vehiculoSeleccionadoIndex;
    private NitroDrift game;

    public EstadoSeleccionVehiculo(NitroDrift game) {
        this.game = game;
        
        fondo = game.carrera.getPersonaje().getImagen();
        
        seleccionVehiculo = new Texture[8];
        seleccionVehiculo[0] = new Texture(Gdx.files.internal("codebreaker.jpeg"));
        seleccionVehiculo[1] = new Texture(Gdx.files.internal("sailorswrath.jpeg"));
        seleccionVehiculo[2] = new Texture(Gdx.files.internal("albusvalor.jpeg"));
        seleccionVehiculo[3] = new Texture(Gdx.files.internal("atranox.jpeg"));
        seleccionVehiculo[4] = new Texture(Gdx.files.internal("capobanana.jpeg"));
        seleccionVehiculo[5] = new Texture(Gdx.files.internal("libertybeast.jpeg"));
        seleccionVehiculo[6] = new Texture(Gdx.files.internal("diavolorosso.jpeg"));
        seleccionVehiculo[7] = new Texture(Gdx.files.internal("nightcrawler.jpeg"));
        vehiculoSeleccionadoIndex = 4;
    }

    @Override
    public void update(float delta) {
        // Manejo de la entrada del jugador para cambiar la selección de vehículo
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (vehiculoSeleccionadoIndex == 0 || vehiculoSeleccionadoIndex == 4) {
                vehiculoSeleccionadoIndex += 3;
            } else {
                vehiculoSeleccionadoIndex--;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (vehiculoSeleccionadoIndex == 3 || vehiculoSeleccionadoIndex == 7) {
                vehiculoSeleccionadoIndex -= 3;
            } else {
                vehiculoSeleccionadoIndex++;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (vehiculoSeleccionadoIndex >= 4) {
                vehiculoSeleccionadoIndex -= 4;
            } else {
                vehiculoSeleccionadoIndex += 4;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (vehiculoSeleccionadoIndex < 4) {
                vehiculoSeleccionadoIndex += 4;
            } else {
                vehiculoSeleccionadoIndex -= 4;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            // El jugador ha confirmado su selección, cambiar el estado a la carrera
            EstadisticasVehiculo e = new EstadisticasVehiculo(10, 2, 30);
            Jugador v = new Jugador(vehiculoSeleccionadoIndex, "Nombre", "Historia", 150000, seleccionVehiculo[vehiculoSeleccionadoIndex],0, 0, 0.015f, e);
            game.carrera.setVehiculoDelJugador(v);
            game.estadoActual = new EstadoSeleccionCircuito(game);
        }
    }

    @Override
    public void dibujarEstado(NitroDrift game) {
        // Redibujado de la pantalla
        game.camara.update();
        game.gestorDeGraficos.setProjectionMatrix(game.camara.combined);
        game.gestorDeGraficos.begin();

        // Dibujar el fondo de la pantalla de selección de vehículo
        Gdx.gl.glClearColor(0, 0, 0, 1); // Color negro
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Limpiar el buffer de color

        // Dibujar el fondo
        game.gestorDeGraficos.setColor(Color.WHITE); // Asegurarse de que el color sea blanco para el fondo
        game.gestorDeGraficos.draw(fondo, 0, 0, game.camara.viewportWidth, game.camara.viewportHeight);
 
        // Calcular las posiciones de los cuadros de selección de vehículo
        float cuadroWidth = 150;
        float cuadroHeight = 150;
        float padding = 20;
        float startX = (game.camara.viewportWidth - (cuadroWidth * 4 + padding * 3)) / 2; // Centrar horizontalmente
        float startY = (game.camara.viewportHeight - (cuadroHeight * 2 + padding)) / 2; // Centrar verticalmente

        // Dibujar los cuadros de selección de vehículo
        for (int i = 0; i < seleccionVehiculo.length; i++) {
            int fila = i / 4; // Calcular la fila actual
            int columna = i % 4; // Calcular la columna actual

            // Calcular las coordenadas x e y del cuadro actual
            float posX = startX + (cuadroWidth + padding) * columna;
            float posY = startY + (cuadroHeight + padding) * fila;

            // Determinar el color a aplicar al vehículo
            if (i != vehiculoSeleccionadoIndex) {
                game.gestorDeGraficos.setColor(0.5f, 0.5f, 0.5f, 1); // Oscurecer los vehículos no seleccionados
            } else {
                game.gestorDeGraficos.setColor(Color.WHITE); // Restaurar el color original para el vehículo seleccionado
            }

            game.gestorDeGraficos.draw(seleccionVehiculo[i], posX, posY, cuadroWidth, cuadroHeight);
        }

        game.gestorDeGraficos.end();
    }
}