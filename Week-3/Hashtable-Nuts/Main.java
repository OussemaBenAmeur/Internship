package org.example;

import net.thevpc.nuts.NOut;
import net.thevpc.nuts.Nuts;
import net.thevpc.nuts.util.NMsg;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) {
        Nuts.require();
        int size =AppShell.callSize();
        XHashtable ht = new XHashtable(size);//creation de hashtable
        Drawer drawer = new Drawer(ht);//creation lel drawer mtaa l hashtable
        AppShell shell = new AppShell(ht,drawer);

        AppShell.callSystem(ht,drawer);

    }
}
