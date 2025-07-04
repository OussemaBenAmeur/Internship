
package org.example;

import net.thevpc.nuts.NOut;

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(String key) {
        Node newNode = new Node(key);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    public boolean delete(String key) {
        Node current = head;

        while (current != null) {
            if (current.key.equals(key)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                NOut.println("Key deleted: " + key);
                return true;
            }
            current = current.next;
        }
        NOut.println("Key not found: " + key);
        return false;
    }

    public boolean findN(String key) {
        Node current = head;
        while (current != null) {
            if (current.key.equals(key)) {

                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int findPosition(String key) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.key.equals(key)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }
}
