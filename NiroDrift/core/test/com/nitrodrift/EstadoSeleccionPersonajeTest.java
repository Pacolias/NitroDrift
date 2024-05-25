/*
package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EstadoSeleccionPersonajeTest {

    private NitroDrift game;
    private EstadoSeleccionPersonaje estadoSeleccionPersonaje;

    @BeforeEach
    void setUp() {
        game = mock(NitroDrift.class, RETURNS_DEEP_STUBS);
        estadoSeleccionPersonaje = new EstadoSeleccionPersonaje(game);
    }

    @Test
    void testInicializacionTexturas() {
        for (Texture texture : estadoSeleccionPersonaje.getSeleccionPersonaje()) {
            assertNotNull(texture);
        }
    }

    @Test
    void testSeleccionInicialPersonaje() {
        assertEquals(4, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }

    @Test
    void testSeleccionPersonajeTeclaIzquierda() {
        Gdx.input = mock(Input.class);
        when(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)).thenReturn(true);

        estadoSeleccionPersonaje.update(0);
        assertEquals(3, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.update(0);
        assertEquals(2, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }

    @Test
    void testSeleccionPersonajeTeclaDerecha() {
        Gdx.input = mock(Input.class);
        when(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)).thenReturn(true);

        estadoSeleccionPersonaje.update(0);
        assertEquals(5, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.update(0);
        assertEquals(6, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }

    @Test
    void testSeleccionPersonajeTeclaArriba() {
        Gdx.input = mock(Input.class);
        when(Gdx.input.isKeyJustPressed(Input.Keys.UP)).thenReturn(true);

        estadoSeleccionPersonaje.update(0);
        assertEquals(0, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.update(0);
        assertEquals(4, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }

    @Test
    void testSeleccionPersonajeTeclaAbajo() {
        Gdx.input = mock(Input.class);
        when(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)).thenReturn(true);

        estadoSeleccionPersonaje.update(0);
        assertEquals(4, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.update(0);
        assertEquals(4, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }
}*/
