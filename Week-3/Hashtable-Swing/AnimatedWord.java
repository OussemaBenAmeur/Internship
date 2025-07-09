package org.example;

public class AnimatedWord {
    String text;
    int targetNodeX, targetNodeY;
    float currentX, currentY;
    float scale = 1.0f;
    boolean inserting = true;
    float opacity = 1.0f;

    public AnimatedWord(String text, int targetX, int targetY) {
        this.text = text;
        this.targetNodeX = targetX;
        this.targetNodeY = targetY;
        this.currentX = targetX - 50; // Start left for slide-in
        this.currentY = targetY;
    }
}
