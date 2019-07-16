package com.kripesh.dsandalgorithm.linkedlist;

/**
 * Linked list implementation
 * @author kripesh
 */
public class LinkedList {

    Node head;
    private int length;

    public LinkedList(){
        length = 0;
    }

    /**
     * Insert a node at the beginning of the List
     */
    public synchronized void insertAtBegin(Node node) {
        node.setNext(head);
        head = node;
        length++;
    }

    /**
     * Insert a node at the end of the list
     */
    public synchronized void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node p,q;
            for (p=head; (q = p.getNext()) != null; p=q){}
            p.setNext(node);
        }
        length++;
    }

    /**
     * Add a new value to the list at a given position. All the values at that position to the end move over.
     * @param data
     * @param position
     */
    public synchronized void insertAt(int data, int position) {
        // fix the position to start
        if (position < 0)
            position = 0;

        // fix the position to end
        if (position > length )
            position = length;

        // if the list is empty.
        if (head == null) {
            head = new Node(data);
        }
        // if adding at the front of the list
        else if (position == 0) {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
        // else find the position and add
        else {
            Node temp = head;
            for(int i = 1; i < position; i += 1) {
                temp = temp.getNext();
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.setNext(newNode);
        }
        length += 1;
    }

    /**
     * @return and remove the node at the head of the list
     */
    public synchronized Node removeFromBegin() {
        Node node = head;
        if (node != null)
            head = node.getNext();
            node.setNext(null);
        length -= 1;
        return node;
    }

    /**
     *
     * @return the first node in the list
     */
    public synchronized Node getHead() {
        return head;
    }

    /**
     *
     * @return the last node in the list
     */
    public synchronized Node getLast() {
        if(head == null)
            return null;

        if(head.getNext() == null)
            return head;

        Node p = head.getNext();
        while (p.getNext() != null){
            p = p.getNext();
        }
        return p;
    }

    /**
     * @return and remove the node at the end of the list
     */
    public synchronized Node removeFromEnd() {
        if(head == null) {
            return null;
        }

        Node p = head, q = null, next = head.getNext();
        if (next == null ) {
            head = null;
            length -= 1;
            return p;
        }

         while ((next = p.getNext()) != null) {
             q = p;
             p = next;
         }

         q.setNext(null);
         length -= 1;
         return p;
    }

    /**
     * Remove a node matching the specified node from the list.
     * @param node
     */
    public synchronized void removeMatched(Node node) {
        if(head == null ) {
            return;
        }
        if(node.equals(head)) {
            head = head.getNext();
            length -= 1;
            return;
        }

        Node p = head, q = null;
        while ((q = p.getNext()) != null) {
            if(node.equals(q)) {
                p.setNext(q.getNext());
                length -= 1;
                return;
            }
            p = q;
        }
    }

    /**
     * Remove the value at a given position. If the position is negative '-1', remove the value at position 0 or else at the last position
     * @param position
     */
    public void removeAt(int position) {

        if (position < 0 )
            position = 0;

        if (position >= length)
            position = length-1;

        if (head == null)
            return;

        if (position == 0) {
            head = head.getNext();
        } else {
           Node temp = head;
           for (int i = 1; i < position; i+=1) {
               temp = temp.getNext();
           }
           temp.setNext(temp.getNext().getNext());
        }
        length -= 1;
    }

    /**
     * Return a string representation of this collection
     */
    public String toString() {
        String result = "[";
        if (head == null) {
            return result + "]";
        }
        result = result + head.getData();
        Node temp = head.getNext();
        while (temp != null) {
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    /** Return the current length of the list. */
    public int length() {
        return length;
    }

    /**
     * Find the position of the first value that is equal to a given value.
     */
    public int getPosition(int data) {
        // go looking for the data
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.getData() == data) {
                // return the position if found
                return pos;
            }
            pos += 1;
            temp = temp.getNext();
        }
        // else return -1
        return Integer.MIN_VALUE;
    }

    /** Size of the list. */
    public boolean isEmpty() {
        return length == 0;
    }

    /** Remove everything from the list. */
    public void clearList() {
        head = null;
        length = 0;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAt(10, 1);
        linkedList.insertAt(20, 2);
        linkedList.insertAt(30, 3);
        linkedList.insertAt(40, 4);
        // insert node at beginning of the linkedlist
        Node firstNode = new Node();
        firstNode.setData(0);
        linkedList.insertAtBegin(firstNode);
        // insert node at end of the linkedlist
        Node lastNode = new Node();
        lastNode.setData(50);
        linkedList.insertAtEnd(lastNode);

        System.out.println(" Head of the linked list : " + linkedList.getHead());
        System.out.println(" Last of the linked list : " + linkedList.getLast());
        System.out.println(" Postion of the node data 10 : " + linkedList.getPosition(10));

        // remove node by position
        linkedList.removeAt(1);

        // remove node from begin
        linkedList.removeFromBegin();

        // Remove node from end
        linkedList.removeFromEnd();

        System.out.println(" Head of the linked list : " + linkedList.getHead());
        System.out.println(" Last of the linked list : " + linkedList.getLast());
    }

}
