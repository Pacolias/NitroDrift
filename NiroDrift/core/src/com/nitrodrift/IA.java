package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class IA extends Coche {

    private boolean movingForward; // Variable para almacenar la dirección del movimiento

    public IA() {
        super("coche_ia.png", MathUtils.random(100, 700), MathUtils.random(100, 500), 0.3f); // Asegúrate de tener la textura de la IA
        movingForward = MathUtils.randomBoolean(); // Inicializar aleatoriamente la dirección del movimiento
    }

    @Override
    public void update(float delta) {
        // Lógica para mover el coche hacia adelante o hacia atrás
        if (movingForward) {
            position.y -= 150 * delta; // Mover hacia adelante
        } else {
            position.y += 150 * delta; // Mover hacia atrás
        }

        // Lógica para cambiar de dirección aleatoriamente
        if (MathUtils.randomBoolean(0.005f)) {
            movingForward = !movingForward; // Cambiar la dirección
        }

        // Lógica para cambiar de carril aleatoriamente
        if (MathUtils.randomBoolean(0.01f)) {
            position.x += MathUtils.random(-50, 50);
        }

        // Asegurarse de que el coche IA se mantenga en la pantalla
        if (position.x < 0) position.x = 0;
        if (position.x > 800 - texture.getWidth() * scale) position.x = 800 - texture.getWidth() * scale;
        if (position.y < 0) position.y = 600 - texture.getHeight() * scale; // Vuelve a la parte superior de la pantalla

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

}