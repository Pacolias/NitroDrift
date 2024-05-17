package com.ejemplo;
import com.badlogic.gdx.graphics.Texture;

public class Personaje {
	private String nombre;
	private Texture imagenPersonaje;
	private String descripcion;
	

	public Personaje(String nombre, Texture imagen, String desc) {
        this.nombre = nombre;
        this.imagenPersonaje = imagen;
        this.descripcion = desc;
    }

    public String getNombre() {
    	return nombre;
	}
    
    public Texture getImagenPersonaje() {
    	return imagenPersonaje;
    }
    
    public String descripcion() {
    	return descripcion;
    }

}
