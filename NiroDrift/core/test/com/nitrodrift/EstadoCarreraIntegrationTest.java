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

public class EstadoCarreraIntegrationTest {

    private EstadoCarrera estadoCarrera;
    private NitroDrift gameMock;
    private Input inputMock;
    private Carrera carreraMock;
    private Vehiculo vehiculoMock;
    private Texture circuitoMock;
    private SpriteBatch spriteBatchMock;

    @Before
    public void setUp() {
        // Crear mocks
        gameMock = mock(NitroDrift.class);
        inputMock = mock(Input.class);
        carreraMock = mock(Carrera.class);
        vehiculoMock = mock(Vehiculo.class);
        circuitoMock = mock(Texture.class);
        spriteBatchMock = mock(SpriteBatch.class);

        // Reemplazar la instancia de Input de Gdx con el mock
        Gdx.input = inputMock;
        Gdx.gl = mock(GL20.class);

        // Configurar la cámara y gestor de gráficos del juego mock
        gameMock.camara = mock(OrthographicCamera.class);
        gameMock.gestorDeGraficos = spriteBatchMock;
        gameMock.carrera = carreraMock;

        // Configurar el circuito y vehículo del mock de carrera
        when(carreraMock.getCircuito()).thenReturn(new Circuito(circuitoMock));
        when(carreraMock.getVehiculoDelJugador()).thenReturn(vehiculoMock);

        // Inicializar el estado de carrera
        estadoCarrera = new EstadoCarrera(gameMock);
    }

    @Test
    public void testCKeyChangesState() {
        // Simular que la tecla C está presionada
        when(inputMock.isKeyJustPressed(Input.Keys.C)).thenReturn(true);

        // Llamar al método update
        estadoCarrera.update(1.0f);

        // Verificar que el estado del juego ha cambiado a EstadoInicio
        assertTrue(gameMock.estadoActual instanceof EstadoInicio);
    }

    @Test
    public void testDrawsCircuitAndVehicle() {
        // Simular el dibujo del estado de carrera
        estadoCarrera.dibujarEstado(gameMock);

        // Verificar que el método begin ha sido llamado
        verify(spriteBatchMock).begin();

        // Verificar que la textura del circuito ha sido dibujada
        verify(spriteBatchMock).draw(eq(circuitoMock), eq(0f), eq(0f), eq(1080f), eq(1000f));

        // Verificar que el método update del vehículo ha sido llamado
        verify(vehiculoMock).update(anyFloat());

        // Verificar que el método render del vehículo ha sido llamado
        verify(vehiculoMock).render(eq(spriteBatchMock));

        // Verificar que el método end ha sido llamado
        verify(spriteBatchMock).end();
    }
}
*/
