package com.nitrodrift;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Jugador extends Coche {

    public Jugador() {
        super("jugador.png", 400, 300, 0.1f); // Asegúrate de tener la textura del jugador
    }

    @Override
    public void update(float delta) {
        // Actualizar la posición del jugador basado en la entrada del usuario
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            position.x -= 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            position.x += 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            position.y += 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            position.y -= 200 * delta;
        }

        // Lógica para mantener el coche dentro de los límites de la pantalla
        if (position.x < 170) position.x = 170; // No permitir que el coche se salga por el lado izquierdo
        if (position.x > Gdx.graphics.getWidth() - texture.getWidth() * scale - 110) {
            position.x = Gdx.graphics.getWidth() - texture.getWidth() * scale - 110; // No permitir que el coche se salga por el lado derecho
        }
        if (position.y < 0) position.y = 0; // No permitir que el coche se salga por la parte inferior
        if (position.y > Gdx.graphics.getHeight() - texture.getHeight() * scale) {
            position.y = Gdx.graphics.getHeight() - texture.getHeight() * scale; // No permitir que el coche se salga por la parte superior
        }
    }

    public boolean isAccelerating() {
        // Aquí puedes agregar la lógica para determinar si el jugador está acelerando
        // Por ejemplo, puedes verificar si se están presionando las teclas de aceleración (arriba) o cualquier otra condición que indique aceleración
        return Gdx.input.isKeyPressed(Keys.UP);
    }

    public float getAccelerationSpeed() {
        // Aquí puedes implementar la lógica para determinar la velocidad de aceleración del jugador
        // Por ejemplo, puedes retornar una velocidad constante o calcularla dinámicamente en función de las condiciones del juego
        return 200; // Ejemplo de una velocidad constante de aceleración
    }
}
