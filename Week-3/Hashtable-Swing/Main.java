package org.example;

public class Main {
    public static void main(String[] args) {
        int size = AppShell.callSize();
        XHashtable ht = new XHashtable(size);
        GuiBuilder.createAndShowGui(ht);
    }
}
