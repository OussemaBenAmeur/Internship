package org.example;
import net.thevpc.nuts.NIn;
import net.thevpc.nuts.NOut;
import net.thevpc.nuts.Nuts;
import net.thevpc.nuts.text.NTextStyle;
import net.thevpc.nuts.util.NLiteral;
import net.thevpc.nuts.util.NMsg;

import java.awt.*;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class AppShell {
    int size;
    XHashtable ht ;
    Drawer drawer ;

    public AppShell(XHashtable ht,Drawer drawer){
        this.ht=ht;
        this.drawer=drawer;

    }
    public static int callSize() {
        while (true) {
            try {
                NOut.print("Enter hash table size (positive integer): ");
                String input = NIn.readLiteral().toString();

                if (input.length() > 9) {
                    NOut.println("Number too large. Try something smaller ");
                    continue;
                }
                int size = Integer.parseInt(input);
                if (size <= 0) {
                    NOut.println("Size must be positive.");
                    continue;
                }

                if (size > 1000000000) {
                    NOut.print(NMsg.ofC("%s", NMsg.ofStyled("Warning: Size " , NTextStyle.parse("red").get())));
                    String str = String.valueOf(size);
                    NOut.print(size);
                    NOut.print(NMsg.ofC("%d", NMsg.ofStyled(str , NTextStyle.parse("red").get())));
                    NOut.print(NMsg.ofC("%s", NMsg.ofStyled(" might cause memory issues." , NTextStyle.parse("red").get())));
                    NOut.print(NMsg.ofC("%s", NMsg.ofStyled(" mContinue anyway? (yes/no):" , NTextStyle.parse("red").get())));

                    if (!NIn.readLiteral().toString().equalsIgnoreCase("yes")) {
                        continue;
                    }
                }
                return size;
            } catch (NumberFormatException e) {

                NOut.println(NMsg.ofC("%s", NMsg.ofStyled("Invalid number. Try again.", NTextStyle.parse("red").get())));
            }
        }
    }
public static void callSystem(XHashtable ht,Drawer drawer){
    boolean running = true;
    while (running) {
        NOut.print(">>>");

        String input = NIn.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input);

        if (!tokenizer.hasMoreTokens()) {
            NOut.println("Empty command.");
            continue;
        }
        String command = tokenizer.nextToken().toLowerCase();
        String key = tokenizer.hasMoreTokens() ? tokenizer.nextToken().trim() : "";

        switch (command) {
            case "help":
                NOut.println(NMsg.ofC("%s", NMsg.ofStyled("HASHTABLE COMMAND REFERENCE", NTextStyle.parse("blue").get())));
                NOut.println("--------------------------------------------------");

                NOut.println(NMsg.ofC("%s", NMsg.ofStyled("add <key>", NTextStyle.parse("cyan").get())));
                NOut.println("  Adds the specified key to the hashtable");
                NOut.println("  • Returns success message or duplicate key warning");

                NOut.println(NMsg.ofC("%s", NMsg.ofStyled("delete <key>", NTextStyle.parse("green").get())));
                NOut.println("  Removes the specified key from the hashtable");
                NOut.println("  • Returns confirmation or 'key not found' message");

                NOut.println(NMsg.ofC("%s", NMsg.ofStyled("find <key>", NTextStyle.parse("purple").get())));
                NOut.println("  Locates the specified key in the hashtable");
                NOut.println("  • Returns bucket position and list index if found");

                NOut.println(NMsg.ofC("%s", NMsg.ofStyled("exit", NTextStyle.parse("red").get())));
                NOut.println("  Terminates the application");
                NOut.println("--------------------------------------------------");
                NOut.println(NMsg.ofC("%s", NMsg.ofStyled("💡 Pro Tip: Keys are case-sensitive!", NTextStyle.parse("gold").get())));
                break;

            case "add":
                if (!key.isEmpty()) {
                    ht.add(key);
                    drawer.draw();
                } else {
                    NOut.println(NMsg.ofC("%s",NMsg.ofStyled("Invalid input", NTextStyle.parse("red").get())));
                }
                break;
            case "delete":
                if (!key.isEmpty()) {
                    ht.delete(key);
                    drawer.draw();
                } else {
                    NOut.println(NMsg.ofC("%s",NMsg.ofStyled("Invalid input", NTextStyle.parse("red").get())));
                }
                break;
            case "find":
                if (!key.isEmpty()) {
                    ht.find(key);
                } else {
                    NOut.println(NMsg.ofC("%s",NMsg.ofStyled("Invalid input", NTextStyle.parse("red").get())));
                }
                break;

            case "exit":
                running = false;

                break;
            default:
                NOut.println(NMsg.ofC("%s",NMsg.ofStyled("Invalid input", NTextStyle.parse("red").get())));
        }
    }









}}