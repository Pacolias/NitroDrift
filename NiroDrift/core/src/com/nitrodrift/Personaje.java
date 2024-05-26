package com.nitrodrift;
import com.badlogic.gdx.graphics.*;

public class Personaje {
    private static int ID;
    private String nombre;
    private Texture imagen;

    /**
     * Constructor de la clase
     * @param ID Número entero que servirá de identificador
     * @param nombre String que será cómo se llama el personaje
     * @param imagen Textura de la clase Texture que será la imagen del personaje
     */
    public Personaje(int ID, String nombre, Texture imagen) {
        this.ID = ID;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    /**
     * Constructor auxiliar de la clase
     * @param ID Número entero que será el identificador del personaje
     * @param nombre String que recogerá cómo se llama el personaje
     * @param direccionImagen String que recogerá la ruta de la imagen con la que
     *                        generar la textura para dicha imagen del personaje
     */
    public Personaje(int ID, String nombre, String direccionImagen){
        this.ID = ID;
        this.nombre = nombre;
        this.imagen = new Texture(direccionImagen);
    }

    /**
     * Getter del atributo ID
     * @return Número entero que indica el identificador correspondiente al personaje
     */
    public int getID() {
        return ID;
    }

    /**
     * Getter del atributo nombre
     * @return String que indica el nombre del personaje
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del atributo nombre
     * @param nombre String que indica el nombre del personaje
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del atributo imagen
     * @return Objeto de clase Texture correspondiente a la imagen asignada al personaje
     */
    public Texture getImagen() {
        return imagen;
    }
    /**
     * Setter del atributo imagen
     * @param imagen Objeto de clase Texture que corresponde a la imagen que se le asignará al personaje
     */
    public void setImagen(Texture imagen) {
        this.imagen = imagen;
    }
}