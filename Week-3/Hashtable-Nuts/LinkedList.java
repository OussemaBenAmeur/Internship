
package org.example;
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
        System.out.println("Key added: " + key);
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
                System.out.println("Key deleted: " + key);
                return true;
            }
            current = current.next;
        }
        System.out.println("Key not found: " + key);
        return false;
    }

    public boolean find(String key) {
        Node current = head;

        while (current != null) {
            if (current.key.equals(key)) {
                System.out.println("Key found: " + key);
                return true;
            }
            current = current.next;
        }
        System.out.println("Key not found: " + key);
        return false;
    }

    public int findPosition(String key) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.key.equals(key)) {
                System.out.println("Key '" + key + "' found at position: " + index);
                return index;
            }
            current = current.next;
            index++;
        }
        System.out.println("Key '" + key + "' not found in list.");
        return -1;
    }
}
