package org.example;

import javax.swing.*;
import java.awt.*;

public class GuiBuilder {

    public static void createAndShowGui(XHashtable ht) {
        JFrame frame = new JFrame("Hashtable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        XHashtableDrawer drawerPanel = new XHashtableDrawer(ht);
        frame.add(drawerPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JTextField keyTextField = new JTextField(10);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton findButton = new JButton("Find");
        JButton exitButton = new JButton("Exit");

        controlPanel.add(new JLabel("Key:"));
        controlPanel.add(keyTextField);
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        controlPanel.add(findButton);
        controlPanel.add(exitButton);
        frame.add(controlPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String key = AppShell.getKeyFromUser(keyTextField, frame);
            if (key == null) return;

            if (ht.findN(key)) {
                AppShell.showMessage(frame, "Duplicate key",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                int bucketIndex = ht.getBucketIndex(key);
                int[] target = drawerPanel.getBucketCoordinates(bucketIndex);
                drawerPanel.addAnimatedWord(key, 100, 50, target[0], target[1]);

                ht.add(key);
                keyTextField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            String key = AppShell.getKeyFromUser(keyTextField, frame);
            if (key == null) return;

            if (ht.findN(key)) {
                int bucketIndex = ht.getBucketIndex(key);
                int[] pos = drawerPanel.getNodeCoordinates(bucketIndex, key);
                drawerPanel.addFadeOut(key, pos[0], pos[1]);
                ht.delete(key);
                keyTextField.setText("");
            } else {
                AppShell.showMessage(frame, "Key not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        findButton.addActionListener(e -> {
            String key = AppShell.getKeyFromUser(keyTextField, frame);
            if (key == null) return;

            if (!ht.findN(key)) {
                AppShell.showMessage(frame,
                        "The key '" + key + "' does not exist",
                        "Key not found", JOptionPane.ERROR_MESSAGE);
            } else {
                AppShell.showMessage(frame,
                        "Your key '" + key + "' has been found in bucket number " + ht.getBucketIndex(key)
                                + " and list element number " + ht.getListPosition(key),
                        "Key Found", JOptionPane.INFORMATION_MESSAGE);
                keyTextField.setText("");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
