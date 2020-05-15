package ru.gb.jtwo.alesson.online;

import java.awt.*;

public class Background extends Sprite {
    Color color;
    public float timeSinceLastUpdate;

    public Background(int width, int height){
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        timeSinceLastUpdate = 0;

        color = new Color(red, green, blue);
        halfWidth = width;
        halfHeight = height;
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillRect((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {

        timeSinceLastUpdate += deltaTime;
        if (timeSinceLastUpdate > 2) {
            timeSinceLastUpdate = 0;
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            color = new Color(red, green, blue);
        }
    }
}
