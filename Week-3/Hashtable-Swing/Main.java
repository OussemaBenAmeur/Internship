package org.example;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
    int size = AppShell.callSize();
    XHashtable ht= new XHashtable(size);
    guiBuilder.createAndShowGui(ht);
        }
    }

