package com.nitrodrift;

import com.badlogic.gdx.graphics.Texture;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CircuitoTest {

    @Test
    void setLongitudTest() {
        Texture t = new Texture("circuito1.jpg");
        Circuito c = new Circuito(1, "El Jarama", 0, t);
        c.setLongitud(1239);
        assertEquals(1239, c.getLongitud());
    }

    @Test
    void getImagenTest() {
        Texture t = new Texture("circuito1.jpg");
        Circuito c = new Circuito(1, "El Jarama", 0, t);
        assertEquals(t, c.getImagen());
    }
}
