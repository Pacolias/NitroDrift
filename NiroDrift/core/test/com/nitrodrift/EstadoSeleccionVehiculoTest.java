/*
package com.nitrodrift;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstadoSeleccionVehiculoTest {

    private EstadoSeleccionVehiculo estadoSeleccionVehiculo;

    @BeforeEach
    public void setUp() {
        estadoSeleccionVehiculo = new EstadoSeleccionVehiculo();
    }

    @Test
    public void testMoverSeleccionIzquierda() {
        estadoSeleccionVehiculo.moverSeleccionIzquierda();
        assertEquals(7, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());

        estadoSeleccionVehiculo.moverSeleccionIzquierda();
        assertEquals(6, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());
    }

    @Test
    public void testMoverSeleccionDerecha() {
        estadoSeleccionVehiculo.moverSeleccionDerecha();
        assertEquals(5, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());

        estadoSeleccionVehiculo.moverSeleccionDerecha();
        assertEquals(6, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());
    }

    @Test
    public void testMoverSeleccionArriba() {
        estadoSeleccionVehiculo.moverSeleccionArriba();
        assertEquals(0, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());

        estadoSeleccionVehiculo.moverSeleccionArriba();
        assertEquals(4, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());
    }

    @Test
    public void testMoverSeleccionAbajo() {
        estadoSeleccionVehiculo.moverSeleccionAbajo();
        assertEquals(0, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());

        estadoSeleccionVehiculo.moverSeleccionAbajo();
        assertEquals(4, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());
    }

    @Test
    public void testSeleccionarYConfirmarVehiculo() {
        estadoSeleccionVehiculo.moverSeleccionIzquierda();
        estadoSeleccionVehiculo.moverSeleccionAbajo();
        assertEquals(3, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());

        estadoSeleccionVehiculo.moverSeleccionDerecha();
        assertEquals(0, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());

        estadoSeleccionVehiculo.moverSeleccionArriba();
        assertEquals(4, estadoSeleccionVehiculo.getVehiculoSeleccionadoIndex());
    }
}*/
