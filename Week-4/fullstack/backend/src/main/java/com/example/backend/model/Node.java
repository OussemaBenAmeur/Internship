package com.example.backend.model;

public class Node {
    private String key;
    private String value;
    private Node next;

    public Node() {}

    public Node(String key, String value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
}
