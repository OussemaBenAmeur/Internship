package org.example;

import javax.swing.*;
import java.awt.*;

public class JPanelSubClass extends JPanel {
    private final XHashtable ht;

    public JPanelSubClass(XHashtable ht) {
        this.ht = ht;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        int bucketX = 20;
        int bucketY = 20;
        final int bucketWidth = 30;
        final int bucketHeight = 30;
        final int nodeWidth = 60;
        final int nodeHeight = 25;
        final int spacing = 20;

        for (int i = 0; i < ht.getSize(); i++) {

            g.setColor(Color.BLACK);//loun l brush
            g.drawRect(bucketX, bucketY, bucketWidth, bucketHeight);//mourabba3
            g.drawString(String.valueOf(i), bucketX + 12, bucketY + 20);
            // el sahm

            int nodeX = bucketX + bucketWidth + spacing ;//x node
            int nodeY = bucketY + 2; // y node

            Node current = ht.table[i].head;
            while (current != null) {
                g.setColor(Color.BLACK);
                g.drawLine(nodeX - spacing, bucketY + (bucketHeight / 2), nodeX, bucketY + (bucketHeight / 2));//ARROW

                g.setColor(Color.BLACK);
                FontMetrics fm = g.getFontMetrics();
                int stringWidth = fm.stringWidth(current.key) ;

                g.drawRect(nodeX, nodeY, nodeWidth + stringWidth ,nodeHeight);
                g.setColor(Color.BLACK);
                g.drawString(current.key, nodeX +30 , nodeY + 17);
                nodeX += nodeWidth + spacing +stringWidth;
                current = current.next;
            }
            bucketY += bucketHeight + spacing;
        }
    }

}