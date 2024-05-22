package com.nitrodrift;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

    public Vehiculo(){

    }

    public abstract void update(float delta);

    public void render(SpriteBatch batch) {
        batch.draw(imagen, position.x, position.y, imagen.getWidth() * scale, imagen.getHeight() * scale);
    }

    public void dispose() {
        imagen.dispose();
    }

    // Método para obtener la posición del coche
    public Vector2 getPosition() {
        return position;
    }



    /*public void evitarColisiones(Array<Coche> coches) {
        for (Coche otroCoche : coches) {
            if (otroCoche != this) {
                Rectangle thisRect = new Rectangle(this.position.x, this.position.y, this.texture.getWidth() * this.scale, this.texture.getHeight() * this.scale);
                Rectangle otroRect = new Rectangle(otroCoche.position.x, otroCoche.position.y, otroCoche.texture.getWidth() * otroCoche.scale, otroCoche.texture.getHeight() * otroCoche.scale);

                if (thisRect.overlaps(otroRect)) {
                    // Calcular la dirección del empuje
                    float deltaX = otroCoche.position.x - this.position.x;
                    float deltaY = otroCoche.position.y - this.position.y;

                    // Aplicar el empuje ajustando las posiciones
                    this.position.x -= deltaX * 0.1f;
                    this.position.y -= deltaY * 0.1f;
                    otroCoche.position.x += deltaX * 0.1f;
                    otroCoche.position.y += deltaY * 0.1f;
                }
            }
        }
    }*/

}