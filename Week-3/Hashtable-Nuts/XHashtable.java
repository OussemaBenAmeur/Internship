package org.example;
class XHashtable {
    private int SIZE;
    LinkedList[] table;

    public XHashtable(int size) {
        if (size > 0) {
            SIZE = size;
        } else {
            System.out.println("Invalid size. Using default size 10.");
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
        int index = hash(key);
        table[index].add(key);
    }

    public boolean delete(String key) {
        int index = hash(key);
        return table[index].delete(key);
    }


    public boolean find(String key) {
        int index = hash(key);
        return table[index].find(key);
    }

    public int findPositionInBucket(String key) {
        int index = hash(key);
        System.out.println("Bucket index: " + index);
        return index;
    }

    public int findPositionInList(String key) {
        int index = hash(key);
        return table[index].findPosition(key);
    }
}