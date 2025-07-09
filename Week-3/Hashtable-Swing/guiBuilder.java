package org.example;

import javax.swing.*;
import java.awt.*;

public class guiBuilder {

    public static void createAndShowGui(XHashtable ht) {
        JFrame frame = new JFrame("Hashtable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

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
                ht.add(key);
                drawerPanel.repaint();
                keyTextField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            String key = AppShell.getKeyFromUser(keyTextField, frame);
            if (key == null) return;

            ht.delete(key);
            drawerPanel.repaint();
            keyTextField.setText("");
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
