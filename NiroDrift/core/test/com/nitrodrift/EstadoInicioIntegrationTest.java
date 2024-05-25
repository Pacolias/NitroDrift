/*
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class EstadoInicioIntegrationTest {

    private EstadoInicio estadoInicio;
    private NitroDrift gameMock;
    private Input inputMock;

    @Before
    public void setUp() {
        // Crear mocks
        gameMock = mock(NitroDrift.class);
        gameMock.camara = mock(OrthographicCamera.class);
        gameMock.gestorDeGraficos = mock(SpriteBatch.class);
        inputMock = mock(Input.class);

        // Reemplazar la instancia de Input de Gdx con el mock
        Gdx.input = inputMock;
        Gdx.gl = mock(GL20.class);

        // Inicializar el estado de inicio
        estadoInicio = new EstadoInicio();
    }

    @Test
    public void testEscKeyExitsGame() {
        // Simular que la tecla ESCAPE está presionada
        when(inputMock.isKeyJustPressed(Input.Keys.ESCAPE)).thenReturn(true);

        // Llamar al método dibujarEstado
        estadoInicio.dibujarEstado(gameMock);

        // Verificar que Gdx.app.exit() ha sido llamado
        verify(Gdx.app).exit();
    }

    @Test
    public void testSpaceKeyChangesState() {
        // Simular que la tecla SPACE está presionada
        when(inputMock.isKeyJustPressed(Input.Keys.SPACE)).thenReturn(true);

        // Llamar al método dibujarEstado
        estadoInicio.dibujarEstado(gameMock);

        // Verificar que el estado del juego ha cambiado a EstadoSeleccionPersonaje
        assertTrue(gameMock.estadoActual instanceof EstadoSeleccionPersonaje);
    }
}
*/
