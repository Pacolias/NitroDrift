/*package com.nitrodrift;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;

public class Carrera {
    //private Pista pista;
    private Array<Coche> coches;
    private Jugador jugador;
    private OrthographicCamera camera;

    public Carrera() {
        //pista = new Pista();
        coches = new Array<>();
        jugador = new Jugador();

        // Añadir el jugador a la lista de coches
        coches.add(jugador);

        // Añadir algunos coches controlados por IA
        for (int i = 0; i < 5; i++) {
            coches.add(new IA());
        }

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);  // Ajustar según tu resolución deseada
    }

    public void update(float delta) {
        // Actualizar todos los coches
        for (Coche coche : coches) {
            coche.update(delta);
        }

        // Actualizar la cámara para seguir al jugador
        //camera.position.set(jugador.getX(), jugador.getY(), 0);
        //camera.update();

        // Lógica adicional de la carrera (e.g., detección de final de carrera)
    }

    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        pista.render(batch);

        for (Coche coche : coches) {
            coche.render(batch);
        }

        batch.end();
    }
}
*/
