package org.example;

import net.thevpc.nuts.NOut;
import net.thevpc.nuts.Nuts;
import net.thevpc.nuts.util.NMsg;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        HashMap<String,String> cha3che3i= new HashMap<>();
        cha3che3i.put("RED","##:11:%s##");
        cha3che3i.put("BLUE","##:1:%s##");
        cha3che3i.put("GREEN","##:5:%s##");
        cha3che3i.put("YELLOW","##:10:%s##");
        cha3che3i.put("PURPLE","##:8:%s##");
        cha3che3i.put("TURQUOISE","##:2:%s##");

        Nuts.require();
        //entrée lel size
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hash table size: ");
        int size;
        try {
            size = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Using default size 10.");
            size = 10;
        }

        XHashtable ht = new XHashtable(size);//creation de hashtable
        Drawer drawer = new Drawer(ht);//creation lel drawer mtaa l hashtable

        scanner.nextLine();

        boolean running = true;

        while (running) {



            System.out.print(">>>");

            String input = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            if (!tokenizer.hasMoreTokens()) {
                System.out.println("Empty command.");
                continue;
            }
            String command = tokenizer.nextToken().toLowerCase();
            String key = tokenizer.hasMoreTokens() ? tokenizer.nextToken("").trim() : "";

            switch (command) {
                case "help":

                        NOut.print(NMsg.ofC(cha3che3i.get("RED") ,"=== HASHTABLE HELP ===\n"));
                        System.out.print("Available commands  : \n");
                        NOut.print(NMsg.ofC(cha3che3i.get("BLUE"),"add(key) \n"));
                        NOut.print(NMsg.ofC( cha3che3i.get("GREEN"),"delete(key)\n"));
                        NOut.print(NMsg.ofC(cha3che3i.get("PURPLE"),"find(key)\n"));
                        NOut.print(NMsg.ofC(cha3che3i.get("TURQUOISE"),"findpositioninbucket(key)\n"));
                        NOut.print(NMsg.ofC(cha3che3i.get("YELLOW"),"findpositioninlist(key)\n"));
                        NOut.print(NMsg.ofC(cha3che3i.get("RED"),"exit \n"));
                        break;

                case "add":
                    if (!key.isEmpty()) {
                        ht.add(key);
                        drawer.draw();
                    } else {
                        System.out.println("No key provided.");
                    }
                    break;
                case "delete":
                    if (!key.isEmpty()) {
                        ht.delete(key);
                        drawer.draw();
                    } else {
                        System.out.println("No key provided.");
                    }
                    break;
                case "find":
                    if (!key.isEmpty()) {
                        ht.find(key);
                    } else {
                        System.out.println("No key provided.");
                    }
                    break;
                case "findpositioninbucket":
                    if (!key.isEmpty()) {
                        ht.findPositionInBucket(key);
                    } else {
                        System.out.println("No key provided.");
                    }
                    break;
                case "findpositioninlist":
                    if (!key.isEmpty()) {
                        ht.findPositionInList(key);
                    } else {
                        System.out.println("No key provided.");
                    }
                    break;
                case "exit":
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }
}
