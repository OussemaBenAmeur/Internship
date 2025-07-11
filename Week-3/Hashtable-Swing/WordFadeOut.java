package org.example;

import java.awt.*;

public class WordFadeOut {
    String key;
    int x, y;
    float alpha;

    public WordFadeOut(String key, int x, int y) {
        this.key = key;
        this.x = x;
        this.y = y;
        this.alpha = 1.0f;
    }

    public void fadeStep() {
        alpha -= 0.02f;
        if (alpha < 0) alpha = 0;
    }

    public boolean isDone() {
        return alpha <= 0.0f;
    }

    public void draw(Graphics2D g2d) {
        Composite original = g2d.getComposite();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString(key, x, y);
        g2d.setComposite(original);
    }
}
