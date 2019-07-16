package com.kripesh.dsandalgorithm.stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a stack using a array list
 * @author kripesh
 */
public class ArrayListStack {

    List<Integer> stackList;

    ArrayListStack(){
        stackList = new ArrayList<>();
    }

    void push(int value) {
        stackList.add(value);
    }

    int pop() {
        if(!isEmpty()) {
            int popValue = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);
            return  popValue;
        }else{
            System.out.println("Stack is empty");
            return -1;
        }
    }

    int peek() {
            return stackList.get(stackList.size() - 1);
    }

    boolean isEmpty() {
        return stackList.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        ArrayListStack myStack = new ArrayListStack();
        // Populate the stack
        myStack.push(5);
        myStack.push(8);
        myStack.push(2);
        myStack.push(9);

        System.out.println("*********************Stack ArrayList Implementation*********************");
        System.out.println(myStack.isEmpty()); // will print false
        System.out.println(myStack.peek()); // will print 9
        System.out.println(myStack.pop()); // will print 9
        System.out.println(myStack.peek()); // will print 2
        System.out.println(myStack.pop()); // will print 2
    }
}
