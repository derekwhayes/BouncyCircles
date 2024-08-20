package io.github.bouncy_circles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {

    }

    public void draw(ShapeRenderer shape) {
        shape.rect(Gdx.input.getX(), y, x, y);
    }
}
