package org.academiadecodigo.bootcamp.containers;

import javax.xml.crypto.Data;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */

    public Object get(int index) {

        Node iterator = head;
        int count = -1;

        if (head == null) {
            return false;
        }

        for (int i = count; i < index; i++) {

                if (iterator.getNext() == null) {
                    return null;
                }
                    iterator = iterator.getNext();
                }

        return iterator.getData();
            }



    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {

        Node iterator = head;
        int count = -1;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            count++;
            if(data.equals(iterator.getData())) {

                return count;
            }
        }
        return -1;
    }




    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    @SuppressWarnings("LoopStatementThatDoesntLoop")
    public boolean remove(Object data) {

        Node iterator = head;

        if(indexOf(data) == -1) {
            return false;
        }

        while (!iterator.getNext().getData().equals(data)) {

            iterator = iterator.getNext();
        }

            if(iterator.getNext().getData().equals(data)) {
                iterator.setNext(iterator.getNext().getNext());


        } else {

                iterator.setNext(null);

            }
            length--;
            return true;

        }


    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


        }
    }


