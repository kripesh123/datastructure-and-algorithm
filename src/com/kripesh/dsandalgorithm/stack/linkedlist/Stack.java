package com.kripesh.dsandalgorithm.stack.linkedlist;

import java.util.EmptyStackException;

/**
 * Implementation of a stack using a linked list
 * @author kripesh
 */
public class Stack {

    private Node top;
    private int length;

    public Stack() {
        length = 0;
        top = null;
    }

    public void push(int data) {
        Node temp = new Node(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        int result = top.getData();
        top = top.getNext();
        length--;
        return result;
    }

    public int peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        return top.getData();
    }

    // Returns true if this stack is empty and false otherwise.
    public boolean isEmpty() {
        return (length == 0);
    }

    // Returns the number of elements in the stack.
    public int size() {
        return length;
    }

    // Returns a string representation of this stack.
    public String toString() {
        String result = "";
        Node current = top;
        while (current != null) {
            result = result + current.toString() + "\n";
            current = current.getNext();
        }

        return result;
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.toString();

        System.out.println("Size of stack is: " + stack.size());

        stack.pop();
        stack.pop();

        System.out.println("Top element of stack is: " + stack.peek());

    }

}