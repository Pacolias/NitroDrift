package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

/**
 * Clase que implementa el comportamiento del jugador durante la carrera. Es la que maneja el funcionamiento del coche durante la carrera
 */
public class Jugador extends Vehiculo {
    Texture izquierda;
    Texture derecha;
    Texture abajo;
    Texture arriba;

    public Jugador(int id, String nom, String desc, int p, Texture texture, float startX, float startY, float scale, EstadisticasVehiculo e) {
        super(id, nom, desc, p, texture, startX, startY, scale, e); // Asegúrate de tener la textura del jugador
        izquierda = new Texture("jugadorIzquierda.png");
        derecha = new Texture("jugadorDerecha.png");
        arriba = new Texture("jugador.png");
        abajo = new Texture("jugadorAbajo.png");
    }

    public Jugador(){

    }

    @Override
    public void update(float delta) {
        // Actualizar la posición del jugador basado en la entrada del usuario
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            super.imagen = izquierda;
            position.x -= 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            super.imagen = derecha;
            position.x += 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            super.imagen = arriba;
            position.y += 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            super.imagen = abajo;
            position.y -= 200 * delta;
        }

        // Lógica para mantener el coche dentro de los límites de la pantalla
        if (position.x < 0) position.x = 0; // No permitir que el coche se salga por el lado izquierdo
        if (position.x > Gdx.graphics.getWidth() - imagen.getWidth() * scale) {
            position.x = Gdx.graphics.getWidth() - imagen.getWidth() * scale ; // No permitir que el coche se salga por el lado derecho
        }
        if (position.y < 0) position.y = 0; // No permitir que el coche se salga por la parte inferior
        if (position.y > Gdx.graphics.getHeight() - imagen.getHeight() * scale) {
            position.y = Gdx.graphics.getHeight() - imagen.getHeight() * scale; // No permitir que el coche se salga por la parte superior
        }
    }

    public boolean isAccelerating() {
        return Gdx.input.isKeyPressed(Keys.UP);
    }

    public float getAccelerationSpeed() {
        return 200; // Velocidad constante de aceleración
    }
}
