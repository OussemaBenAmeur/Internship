package org.example;

public class XHashtable {
    private int SIZE;
    LinkedList[] table;

    public XHashtable(int size) {
        if (size > 0) {
            SIZE = size;
        } else {
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

    public int hash(String key) {
        int hashValue = 0;
        for (char c : key.toCharArray()) {
            hashValue += c;
        }
        return hashValue % SIZE;
    }
    public void deleteNodeRef(Node node, int bucketIndex) {
        if (table[bucketIndex].head == node) {
            table[bucketIndex].head = node.next;
            return;
        }
        Node prev = table[bucketIndex].head;
        while (prev != null && prev.next != null) {
            if (prev.next == node) {
                prev.next = node.next;
                break;
            }
            prev = prev.next;
        }
    }

    public boolean add(String key) {
        if (findN(key)) {
            return false;
        } else {
            int index = hash(key);
            table[index].add(key);
            return true;
        }
    }

    public boolean delete(String key) {
        int index = hash(key);
        return table[index].delete(key);
    }

    public boolean findN(String key) {
        int index = hash(key);
        return table[index].findN(key);
    }

    public int getBucketIndex(String key) {
        return hash(key);
    }

    public int getListPosition(String key) {
        int index = hash(key);
        return table[index].findPosition(key);
    }
}