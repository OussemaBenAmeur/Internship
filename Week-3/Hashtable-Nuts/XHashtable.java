package org.example;

import net.thevpc.nuts.NOut;

public class XHashtable {
    private int SIZE;
    LinkedList[] table;

    public XHashtable(int size) {
        if (size > 0) {
            SIZE = size;
        } else {
            NOut.println("Invalid size. Using default size 10.");
            SIZE = 10;
        }

        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList();
        }
    }
    public int getSize() {
        return SIZE;
    }

    private int hash(String key) {
        int hashValue = 0;
        for (char c : key.toCharArray()) {
            hashValue += c;
        }
        return hashValue % SIZE;
    }

    public void add(String key) {
        if (find(key)){
            NOut.println("Duplicate key.");
        }
        else {
            int index = hash(key);
            table[index].add(key);
            NOut.println("Key added: " + key);

        }

    }
    public boolean delete(String key) {

        int index = hash(key);
        return table[index].delete(key);
    }
    public boolean find(String key) {


        int index = hash(key);

        if (table[index].findN(key)) {
            NOut.println("Key " + key + " found at position in bucket : "
                    + index + " and at position in list " + table[index].findPosition(key));
            return true;
        } else {
            NOut.println("Key " + key + " not found.");
            return false;
        }
    }

    }




