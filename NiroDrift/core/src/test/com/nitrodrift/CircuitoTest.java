/*package com.nitrodrift;

import com.badlogic.gdx.graphics.Texture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CircuitoTest {
    Circuito c;
    Texture t;

    @BeforeEach
    public void setUp(){
        t = new Texture("circuito1.jpg");
        c = new Circuito(1, "El Jarama", 0, t);
    }

    @AfterEach
    public void cleanUp(){
        t = null;
        c = null;
    }
    @Test
    void setLongitudTest() {
        c.setLongitud(1239);
        assertEquals(1239, c.getLongitud());
    }

    @Test
    void getImagen() {
        assertEquals(c.getImagen(), t);
    }
} */