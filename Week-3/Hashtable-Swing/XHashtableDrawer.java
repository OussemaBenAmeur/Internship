package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class XHashtableDrawer extends JPanel implements ActionListener {

    private final XHashtable ht;

    private ArrayList<WordAnimation> animators = new ArrayList<>();
    private Timer timer;
    private ArrayList<WordFadeOut> fadeOuts = new ArrayList<>();

    public XHashtableDrawer(XHashtable ht) {
        this.ht = ht;

        timer = new Timer(20, this);
        timer.start();
    }
    //***********
    public void addFadeOut(String key, int x, int y) {
        fadeOuts.add(new WordFadeOut(key, x, y));
    }
    //***********

    public void addAnimatedWord(String key, int xStart, int yStart, int xTarget, int yTarget) {
        animators.add(new WordAnimation(key, xStart, yStart, xTarget, yTarget));
    }
    //***********

    public int[] getBucketCoordinates(int index) {
        int bucketX = 20;
        int bucketY = 20 + index * (30 + 20);
        return new int[]{bucketX + 60, bucketY + 20};
    }
    //***********
    public int[] getNodeCoordinates(int bucketIndex, String key) {
        int bucketX = 20;
        int bucketY = 20 + bucketIndex * (30 + 20);

        int bucketWidth = 30;
        int spacing = 20;
        int nodeWidth = 60;

        int nodeX = bucketX + bucketWidth + spacing;
        int nodeY = bucketY + 2;

        Node current = ht.table[bucketIndex].head;
        while (current != null) {
            if (current.key.equals(key)) {
                return new int[]{nodeX + 30, nodeY + 17};
            }

            FontMetrics fm = getFontMetrics(new Font("Arial", Font.BOLD, 16));
            int stringWidth = fm.stringWidth(current.key);
            nodeX += nodeWidth + spacing + stringWidth;
            current = current.next;
        }


        return new int[]{nodeX, nodeY};
    }
    //***********

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        int bucketX = 20;
        int bucketY = 20;
        final int bucketWidth = 30;
        final int bucketHeight = 30;
        final int nodeWidth = 60;
        final int nodeHeight = 25;
        final int spacing = 20;


        for (int i = 0; i < ht.getSize(); i++) {
            int lineX = bucketX + bucketWidth / 2;
            int lineStartY = bucketY + bucketHeight;
            int lineEndY = lineStartY + 20;

            g2d.setColor(Color.BLACK);
            if (i != ht.getSize() - 1) {
                g2d.drawLine(lineX, lineStartY, lineX, lineEndY);
            }

            g2d.drawRect(bucketX, bucketY, bucketWidth, bucketHeight);
            g2d.drawString(String.valueOf(i), bucketX + 12, bucketY + 20);

            int nodeX = bucketX + bucketWidth + spacing;
            int nodeY = bucketY + 2;

            Node current = ht.table[i].head;
            while (current != null) {
                g2d.drawLine(nodeX - spacing, bucketY + (bucketHeight / 2), nodeX, bucketY + (bucketHeight / 2));

                FontMetrics fm = g2d.getFontMetrics();
                int stringWidth = fm.stringWidth(current.key);

                g2d.drawRect(nodeX, nodeY, nodeWidth + stringWidth, nodeHeight);

                g2d.drawString(current.key, nodeX + 30, nodeY + 17);


                nodeX += nodeWidth + spacing + stringWidth;

                if (current.next == null) {
                    int endX = nodeX;
                    int centerY = bucketY + (bucketHeight / 2);
                    g2d.drawLine(endX - spacing, centerY, endX, centerY);
                    g2d.drawLine(endX, centerY - 5, endX, centerY + 5);
                }

                current = current.next;
            }

            bucketY += bucketHeight + spacing;
        }

        for (WordAnimation wa : animators) {
            wa.draw(g2d);
        }
        //for (WordAnimation wa : animators) {wa.draw(g2d);}
            for (WordFadeOut fade : fadeOuts) {
                fade.draw(g2d);
            }


        }
    //***********
    @Override
    public void actionPerformed(ActionEvent e) {
        Iterator<WordAnimation> iterator = animators.iterator();
        while (iterator.hasNext()) {
            WordAnimation wa = iterator.next();
            wa.moveStep();
            if (!wa.isMoving) {
                iterator.remove();
            }
        }
        repaint();
        Iterator<WordFadeOut> fadeIt = fadeOuts.iterator();
        while (fadeIt.hasNext()) {
            WordFadeOut fade = fadeIt.next();
            fade.fadeStep();
            if (fade.isDone()) fadeIt.remove();
        }

    }
}
