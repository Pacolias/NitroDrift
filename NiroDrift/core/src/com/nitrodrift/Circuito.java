package com.nitrodrift;

import com.badlogic.gdx.graphics.Texture;


public class Circuito {
    private static int ID; // Identificador del circuito
    private String nombre; // Nombre del circuito
    private String descripcion; // Descripción del circuito, una breve oración descriptiva
    private float longitud; // La longitud de una vuelta del circuito
    private Texture imagen; // Imagen en vista cenital del circuito.

    /**
     * Constructor de la clase circuito. Inicialmente se inicializa con los siguientes parámetros:
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

    /**
     * Getter del atributo id
     * @return Entero con el id del circuito
     */
    public int getID() {
        return ID;
    }

    /**
     * Getter del atributo nombre
     * @return String con atributo nombre, que contiene el nombre del circuito
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para el atributo nombre
     * @param nombre String que indicará el nuevo nombre del circuito
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para el atributo descripción
     * @return String con el atributo descripción.
     * En dicho String se incluirá una breve descripción de cómo es dicho circuito
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter para el atributo descripción
     * @param descripcion String en el que irá la nueva descripción del circuito
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter para el atributo longitud del circuito
     * @return Entero con la longitud del circuito
     */
    public float getLongitud() {
        return longitud;
    }

    /**
     * Setter para el atributo longitud del circuito
     * @param longitud Entero con la nueva longitud del circuito
     */
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    /**
     * Getter para la imagen del circuito
     * @return Instancia de la clase Texture en la cual irá la imagen del circuito.
     * Dicha imagen será una vista cenital en la que se aprecia la forma del circuito
     */
    public Texture getImagen() {
        return imagen;
    }

    /**
     * Setter para el atributo imagen
     * @param imagen Instancia de la clase Texture que será la nueva imagen del circuito
     * Deberá ser una imagen en perspectiva cenital en la que se aprecie la nueva forma del circuito.
     */
    public void setImagen(Texture imagen) {
        this.imagen = imagen;
    }
}