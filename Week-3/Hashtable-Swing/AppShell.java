package org.example;

import javax.swing.*;

public class AppShell {

    public static boolean canConvertToInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int callSize() {
        while (true) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Enter hashtable size:",
                    "Hashtable Size",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                System.exit(0);
            }

            if (!canConvertToInt(input)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Input is not numeric",
                        "INVALID INPUT",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }

            int size = Integer.parseInt(input);
            if (size <= 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Input must be strictly positive",
                        "INVALID INPUT",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }

            return size;
        }
    }

    public static String getKeyFromUser(JTextField keyField, JFrame frame) {
        String key = keyField.getText().trim();
        if (key.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Invalid input",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return key;
    }

    public static void showMessage(JFrame frame, String message, String title, int type) {
        JOptionPane.showMessageDialog(frame, message, title, type);
    }
}
