package com.ejemplo;
import com.badlogic.gdx.graphics.Texture;

public class Vehiculo {
    private String nombre;
    private Texture imagenVehiculo;
    private EstadisticasVehiculo estadisticas;

    public Vehiculo(String nombre, Texture imagen,EstadisticasVehiculo estadisticas) {
        this.nombre = nombre;
        this.estadisticas = estadisticas;
        this.imagenVehiculo = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadisticasVehiculo getEstadisticas() {
        return estadisticas;
    }
    
    public Texture getImagenVehiculo() {
    	return imagenVehiculo;
    }

}
