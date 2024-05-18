package com.nitrodrift;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class IA extends Coche {
    private boolean movingForward;

    public IA(World world) {
        super(world, "coche_ia.png", MathUtils.random(100, 700), MathUtils.random(100, 500), 0.3f);
        movingForward = MathUtils.randomBoolean();
    }

    @Override
    public void update(float delta) {
        // Lógica de actualización de IA utilizando el cuerpo de Box2D
        if (movingForward) {
            body.setLinearVelocity(0, -150 * delta);
        } else {
            body.setLinearVelocity(0, 150 * delta);
        }

        if (MathUtils.randomBoolean(0.005f)) {
            movingForward = !movingForward;
        }

        if (MathUtils.randomBoolean(0.01f)) {
            body.setLinearVelocity(MathUtils.random(-50, 50), body.getLinearVelocity().y);
        }
    }
}
