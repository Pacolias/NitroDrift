package com.nitrodrift;

import com.badlogic.gdx.graphics.Texture;

/**
 * Aquí creo que habría que crear también los límites del circuito según sea la imagen.
 * Apostaría por crear una clase privada bordes del circuito y que el circuito en su
 * construcción llame a algo tipo generar bordes o así
 */
public class Circuito {
    private static int ID; //identificador del circuito
    private String nombre; //nombre del circuito
    private String descripcion; //descripción del circuito, una breve oración descriptiva
    private float longitud; //la longitud de una vuelta del circuito
    private Texture imagen; //imagen en vista cenital del circuito.

    /**
     * Constructor de la clase circuito. Inicialmente se inicializa con un
     * @param id
     * @param nombre
     * @param longitud
     * @param imagen
     */
    public Circuito (int id, String nombre, float longitud, Texture imagen){
        this.ID = id;
        this.nombre = nombre;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    //Getters and setters menos de ID, que será inmutable
    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public Texture getImagen() {
        return imagen;
    }

    public void setImagen(Texture imagen) {
        this.imagen = imagen;
    }


}


