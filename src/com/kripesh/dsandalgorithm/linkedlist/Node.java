package com.kripesh.dsandalgorithm.linkedlist;

/**
 * Declaration for a linked list.
 * @author kripesh
 */
public class Node {

    public Node next;
    public int data;

    // Construct empty node
    public Node() {
        next = null;
        data = Integer.MIN_VALUE;
    }

    // Construct a node storing the specified data
    public Node(int data) {
        next = null;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String toString() {
        return Integer.toString(data);
    }
}
