/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstadoSeleccionPersonajeTest {

    private EstadoSeleccionPersonaje estadoSeleccionPersonaje;

    @BeforeEach
    public void setUp() {
        estadoSeleccionPersonaje = new EstadoSeleccionPersonaje();
    }

    @Test
    public void testMoverSeleccionIzquierda() {
        estadoSeleccionPersonaje.moverSeleccionIzquierda();
        assertEquals(7, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.moverSeleccionIzquierda();
        assertEquals(6, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }

 @Test
    public void testMoverSeleccionDerecha() {
        estadoSeleccionPersonaje.moverSeleccionDerecha();
        assertEquals(5, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.moverSeleccionDerecha();
        assertEquals(6, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }

    @Test
    public void testMoverSeleccionArriba() {
        estadoSeleccionPersonaje.moverSeleccionArriba();
        assertEquals(0, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.moverSeleccionArriba();
        assertEquals(4, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }

    @Test
    public void testMoverSeleccionAbajo() {
        estadoSeleccionPersonaje.moverSeleccionAbajo();
        assertEquals(0, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.moverSeleccionAbajo();
        assertEquals(4, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
    }

@Test
    public void testSeleccionarYConfirmarPersonaje() {
        estadoSeleccionPersonaje.moverSeleccionIzquierda();
        estadoSeleccionPersonaje.moverSeleccionAbajo();
        assertEquals(3, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.moverSeleccionDerecha();
        assertEquals(0, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());

        estadoSeleccionPersonaje.moverSeleccionArriba();
        assertEquals(4, estadoSeleccionPersonaje.getPersonajeSeleccionadoIndex());
}

}*/
