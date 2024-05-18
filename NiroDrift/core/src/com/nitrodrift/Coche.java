package com.nitrodrift;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Coche {
    protected Texture texture;
    protected Body body;
    protected float scale;

    public Coche(World world, String texturePath, float startX, float startY, float scale) {
        texture = new Texture(texturePath);
        this.scale = scale;

        // Crear el cuerpo en Box2D
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(startX, startY);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(texture.getWidth() * scale / 2, texture.getHeight() * scale / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.3f;
        fixtureDef.restitution = 0.5f;

        body.createFixture(fixtureDef);
        shape.dispose();
    }

    public abstract void update(float delta);

    public void render(SpriteBatch batch) {
        batch.draw(texture, body.getPosition().x - (texture.getWidth() * scale / 2), body.getPosition().y - (texture.getHeight() * scale / 2), texture.getWidth() * scale, texture.getHeight() * scale);
    }

    public void dispose() {
        texture.dispose();
    }
}
