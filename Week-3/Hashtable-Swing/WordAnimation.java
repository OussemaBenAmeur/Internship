package org.example;

import java.awt.*;

public class WordAnimation {
    String key;
    int x, y;
    int xTarget, yTarget;
    boolean isMoving;

    public WordAnimation(String key, int xStart, int yStart, int xTarget, int yTarget) {
        this.key = key;
        this.x = xStart;
        this.y = yStart;
        this.xTarget = xTarget;
        this.yTarget = yTarget;
        this.isMoving = true;
    }

    public void moveStep() {
        if (!isMoving) return;
        if (x < xTarget) x += 10;
        if (x > xTarget) x -= 10;
        if (y < yTarget) y += 10;
        if (y > yTarget) y -= 10;

        if (Math.abs(x - xTarget) < 3 && Math.abs(y - yTarget) < 3) {
            x = xTarget;
            y = yTarget;
            isMoving = false;
        }
    }

    public void draw(Graphics2D g2d) {
        if (!isMoving) return;

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString(key, x, y);
    }
}
