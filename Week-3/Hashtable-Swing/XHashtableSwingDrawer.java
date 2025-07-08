package org.example;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class XHashtableSwingDrawer extends JFrame {
    XHashtable ht;
public XHashtableSwingDrawer(XHashtable ht) {
    this.ht = ht;
}
    public static void createAndShowGui(XHashtable ht) {
        JFrame frame = new JFrame(" Hashtable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);


        JPanelSubClass drawerPanel = new JPanelSubClass(ht);

        frame.add(drawerPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JTextField keyTextField = new JTextField(10);
        //
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton findButton = new JButton("Find");
        controlPanel.add(new JLabel("Key:"));
        //
        controlPanel.add(keyTextField);
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        controlPanel.add(findButton);
        frame.add(controlPanel, BorderLayout.SOUTH);


        addButton.addActionListener(e -> {
            String key = keyTextField.getText();
            if (!key.isEmpty()) {
                ht.add(key);
                drawerPanel.repaint();
                keyTextField.setText("");
            }
        });
        deleteButton.addActionListener(e -> {
            String key = keyTextField.getText();
            if (!key.isEmpty()) {
                ht.delete(key);
                drawerPanel.repaint();
                keyTextField.setText("");
            }
        });

        findButton.addActionListener(e -> {
            String key = keyTextField.getText();
            if (!key.isEmpty()) {
                ht.findN(key);
                drawerPanel.repaint();
                keyTextField.setText("");
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}