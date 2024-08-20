package io.github.bouncy_circles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x < size || x > Gdx.graphics.getWidth() - size) {
            xSpeed = -xSpeed;
        }
        if (y < size || y > Gdx.graphics.getHeight() - size) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)) ySpeed = -ySpeed;
    }

    public void checkCollision(Block block) {
        if(collidesWith(block)) {
            ySpeed = -ySpeed;
            block.destroyed = true;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        int paddleStart = Gdx.input.getX();
        int paddleEnd = Gdx.input.getX() + paddle.x;
        int paddleTop = paddle.y * 2;
        int paddleBottom = paddle.y;

        int ballStart = x - size;
        int ballEnd = x + size;
        int ballTop = y + size;
        int ballBottom = y - size;

        return (ballEnd >= paddleStart && ballStart <= paddleEnd) && (ballBottom <= paddleTop && ballTop >= paddleBottom);
    }

    private boolean collidesWith(Block block) {
        int blockStart = block.x;
        int blockEnd = block.x + block.width;
        int blockTop = block.y + block.height;
        int blockBottom = block.y;

        int ballStart = x - size;
        int ballEnd = x + size;
        int ballTop = y + size;
        int ballBottom = y - size;

        return (ballEnd >= blockStart && ballStart <= blockEnd) && (ballBottom <= blockTop && ballTop >= blockBottom);
    }
}
