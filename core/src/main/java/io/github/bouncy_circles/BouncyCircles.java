package io.github.bouncy_circles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BouncyCircles extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(150, 200, 10, 2, 2);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ball.update();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        shape.end();
    }
}
