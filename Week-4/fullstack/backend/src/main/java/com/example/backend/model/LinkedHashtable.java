package com.example.backend.model;

import java.util.ArrayList;
import java.util.List;

public class LinkedHashtable {

    private int size;
    private Node[] table;

    public LinkedHashtable(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    public int getSize() {
        return size;
    }

    public Node[] getTable() {
        return table;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void put(String key, String value) {
        int index = hash(key);
        Node head = table[index];

        Node current = head;
        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setValue(value);
                return;
            }
            current = current.getNext();
        }

        Node newNode = new Node(key, value, head);
        table[index] = newNode;
    }

    public void delete(String key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (prev == null) {
                    table[index] = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public List<List<Node>> getTableAsList() {
        List<List<Node>> result = new ArrayList<>();
        for (Node bucket : table) {
            List<Node> bucketList = new ArrayList<>();
            Node current = bucket;
            while (current != null) {
                bucketList.add(new Node(current.getKey(), current.getValue(), null)); // break linkage for safety
                current = current.getNext();
            }
            result.add(bucketList);
        }
        return result;
    }
}
