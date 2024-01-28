package org.example;

public class Node {

    private int info;
    private Node prev;

    private Node next;

    public Node(int info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
