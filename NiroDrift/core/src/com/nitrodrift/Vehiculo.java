package com.nitrodrift;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Vehiculo {
    private int ID;
    private String nombre;
    private String descripcion;
    private int precio;
    private EstadisticasVehiculo estadisticas;
    protected Texture imagen;
    protected Vector2 position;
    protected float scale;

    /**
     * Constructor de la clase
     * @param id Número entero que corresponde al identificador asignado al vehículo
     * @param nom String correspondiente al nombre del vehículo
     * @param desc String que contiene la descripción del vehículo
     * @param p Número entero que indica el precio del vehículo
     * @param texture Imagen correspondiente al vehículo
     * @param startX Coordenada X de la posición inicial del vehículo
     * @param startY Coordenada Y de la posición inicial del vehículo
     * @param scale Escala determinada para la imagen del vehículo
     * @param e Estadísticas correspondientes al vehículo
     */
    public Vehiculo(int id, String nom, String desc, int p, Texture texture, float startX, float startY, float scale, EstadisticasVehiculo e) {
        Texture tex = new Texture("jugador.png");
        this.imagen = tex;
        this.position = new Vector2(startX, startY);
        this.scale = scale;
        this.ID = id;
        this.descripcion = desc;
        this.nombre = nom;
        this.precio = p;
        this.estadisticas = e;
    }
    /**
     * Constructor auxiliar de la clase
     */
    public Vehiculo(){

    }

    public abstract void update(float delta);
    
    public void render(SpriteBatch batch) {
        batch.draw(imagen, position.x, position.y, imagen.getWidth() * scale, imagen.getHeight() * scale);
    }

    public void dispose() {
        imagen.dispose();
    }

    public Vector2 getPosition() {
        return position;
    }
}