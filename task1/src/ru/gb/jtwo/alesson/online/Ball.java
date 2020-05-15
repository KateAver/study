package ru.gb.jtwo.alesson.online;

import java.awt.*;

public class Ball extends Sprite {

    Color color;
    private float velocityX = (float) (100f + (Math.random() * 200f));
    private float velocityY = (float) (100f + (Math.random() * 200f));

    public Ball() {

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        color = new Color(red, green, blue);

        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += velocityX * deltaTime;
        y += velocityY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            velocityX = -velocityX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            velocityX = -velocityX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            velocityY = -velocityY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            velocityY = -velocityY;
        }

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }
}
