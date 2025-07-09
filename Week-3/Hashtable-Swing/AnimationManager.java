package org.example;


import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class AnimationManager {
    private final List<AnimatedWord> animatedWords = new ArrayList<>();
    private final JPanel panel; // the component to repaint

    public AnimationManager(JPanel panel) {
        this.panel = panel;

        // Timer: 60 FPS
        Timer timer = new Timer(16, e -> {
            updateAnimations();
            panel.repaint();
        });
        timer.start();
    }

    public void animateInsert(String key, int targetX, int targetY) {
        animatedWords.add(new AnimatedWord(key, targetX, targetY));
    }

    public void animateDelete(String key, int nodeX, int nodeY) {
        AnimatedWord aw = new AnimatedWord(key, nodeX, nodeY);
        aw.inserting = false;
        animatedWords.add(aw);
    }

    private void updateAnimations() {
        Iterator<AnimatedWord> iterator = animatedWords.iterator();
        while (iterator.hasNext()) {
            AnimatedWord aw = iterator.next();
            if (aw.inserting) {
                aw.currentX += (aw.targetNodeX - aw.currentX) * 0.2f;
                if (Math.abs(aw.currentX - aw.targetNodeX) < 1) {
                    aw.currentX = aw.targetNodeX;
                }
            } else {
                aw.scale += 0.1f;
                aw.opacity -= 0.05f;
                if (aw.opacity <= 0) {
                    iterator.remove();
                }
            }
        }
    }

    public void draw(Graphics2D g2d) {
        for (AnimatedWord aw : animatedWords) {
            Graphics2D g2 = (Graphics2D) g2d.create();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, aw.opacity));
            g2.translate(aw.currentX, aw.currentY);
            g2.scale(aw.scale, aw.scale);
            g2.setColor(Color.RED);
            g2.drawString(aw.text, 0, 0);
            g2.dispose();
        }
    }
}
