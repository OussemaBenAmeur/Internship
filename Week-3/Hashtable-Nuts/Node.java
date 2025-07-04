package org.example ;
class Node {
    String key;
    Node prev;
    Node next;

    Node(String key) {
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}