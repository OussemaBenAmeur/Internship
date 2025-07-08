package org.example;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog(null,
                "Enter hashtable size :", "Hashtable Size",
                JOptionPane.QUESTION_MESSAGE);

        if (input != null && !input.isEmpty()) {
            int size = Integer.parseInt(input);
            XHashtable ht = new XHashtable(size);
            XHashtableSwingDrawer.createAndShowGui(ht);
        }
    }

}