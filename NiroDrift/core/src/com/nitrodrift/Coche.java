package com.nitrodrift;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public abstract class Coche {
    protected Texture texture;
    protected Vector2 position;
    protected Vector2 velocity;

    protected float scale;

    public Coche(String texturePath, float startX, float startY, float scale) {
        texture = new Texture(texturePath);
        position = new Vector2(startX, startY);
        velocity = new Vector2(0, 0);
        this.scale = scale;
    }

    public abstract void update(float delta);

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, texture.getWidth() * scale, texture.getHeight() * scale);
    }

    public void dispose() {
        texture.dispose();
    }

    public void evitarColisiones(Array<Coche> coches) {
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
    }

}