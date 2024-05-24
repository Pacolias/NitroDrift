package com.nitrodrift;
import com.badlogic.gdx.graphics.*;

public class Personaje {
    private static int ID;
    private String nombre;
    private Texture imagen;

    /**
     * Constructor de la clase
     * @param ID un integer que servirá de identificador
     * @param nombre un String que será cómo se llama el personaje
     * @param imagen una textura de la clase Texture que será la imagen del personaje
     */
    public Personaje(int ID, String nombre, Texture imagen) {
        this.ID = ID;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    /**
     * Constructor auxiliar de la clase
     * @param ID int que será el identificador del personaje
     * @param nombre String que recogerá cómo se llama el personaje
     * @param direccionImagen String que recogerá la ruta de la imagen con la que
     *                        generar la textura para dicha imagen del personaje
     */
    public Personaje(int ID, String nombre, String direccionImagen){
        this.ID = ID;
        this.nombre = nombre;
        this.imagen = new Texture(direccionImagen);
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Texture getImagen() {
        return imagen;
    }

    public void setImagen(Texture imagen) {
        this.imagen = imagen;
    }
}