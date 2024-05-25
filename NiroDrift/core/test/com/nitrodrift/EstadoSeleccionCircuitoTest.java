/*
package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglFiles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EstadoSeleccionCircuitoTest {

    private NitroDrift game;
    private EstadoSeleccionCircuito estadoSeleccionCircuito;

    @BeforeEach
    void setUp() {
        // Configurar Gdx.files para que funcione con JUnit
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        Gdx.files = new LwjglFiles();

        // Crear instancias de NitroDrift y EstadoSeleccionCircuito
        game = new NitroDrift();
        Personaje personaje = new Personaje(0, "TestPersonaje", new Texture("fondoseleccion2.jpeg"));
        game.carrera.setPersonaje(personaje);

        estadoSeleccionCircuito = new EstadoSeleccionCircuito(game);
    }

    @Test
    void testInicializacionTexturas() {
        Texture[] texturas = estadoSeleccionCircuito.getSeleccionCircuito();
        assertEquals(2, texturas.length);
        for (Texture texture : texturas) {
            assertNotNull(texture);
        }
    }

    @Test
    void testSeleccionInicialCircuito() {
        assertEquals(0, estadoSeleccionCircuito.getCircuitoSeleccionadoIndex());
    }

    @Test
    void testSeleccionCircuitoTeclaIzquierda() {
        Gdx.input = new InputStub(Input.Keys.LEFT);

        estadoSeleccionCircuito.update(0);
        assertEquals(0, estadoSeleccionCircuito.getCircuitoSeleccionadoIndex());

        estadoSeleccionCircuito.setCircuitoSeleccionadoIndex(1);
        estadoSeleccionCircuito.update(0);
        assertEquals(0, estadoSeleccionCircuito.getCircuitoSeleccionadoIndex());
    }

    @Test
    void testSeleccionCircuitoTeclaDerecha() {
        Gdx.input = new InputStub(Input.Keys.RIGHT);

        estadoSeleccionCircuito.update(0);
        assertEquals(1, estadoSeleccionCircuito.getCircuitoSeleccionadoIndex());

        estadoSeleccionCircuito.update(0);
        assertEquals(1, estadoSeleccionCircuito.getCircuitoSeleccionadoIndex());
    }

    @Test
    void testTransicionEstadoCarrera() {
        Gdx.input = new InputStub(Input.Keys.ENTER);

        estadoSeleccionCircuito.update(0);
        assertNotNull(game.getEstadoActual());
        assertEquals(EstadoCarrera.class, game.getEstadoActual().getClass());
    }

    @Test
    void testSeleccionCircuitoActualizado() {
        Gdx.input = new InputStub(Input.Keys.ENTER);

        estadoSeleccionCircuito.update(0);
        assertNotNull(game.carrera.getCircuito());
        assertEquals("NombreCircuito", game.carrera.getCircuito().getNombre());
    }

    // Clase auxiliar para simular la entrada del usuario
    private static class InputStub extends InputAdapter {
        private final int key;

        public InputStub(int key) {
            this.key = key;
        }

        @Override
        public boolean isKeyJustPressed(int keycode) {
            return keycode == key;
        }
    }
}
*/
