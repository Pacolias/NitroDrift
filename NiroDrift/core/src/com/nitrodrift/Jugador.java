package com.nitrodrift;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Jugador extends Coche {

    public Jugador(World world) {
        super(world,"jugador.png", 400, 300, 0.1f); // Asegúrate de tener la textura del jugador
    }

    @Override
    public void update(float delta) {
        // Actualizar la posición del jugador basado en la entrada del usuario
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            position.x -= 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            position.x += 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            position.y += 200 * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            position.y -= 200 * delta;
        }
    }
}
