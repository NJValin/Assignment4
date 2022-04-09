// Author: Neil Valin, Vishal Bhat
// Student number: 300236063, 300247928
// Course: ITI 1121 A00
// Assignment 4
// Question 2
import java.util.NoSuchElementException;

/**
 * A Linked List implementation with added iterator methods,
 * the extra <code>iterator()</code> methods allow for more control over the list's iterator
 *
 * @author Neil Valin (nvali069@uottawa.ca)
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 *
 */
public class LinkedList<E> implements List<E> {

    private static class Node<T> {

        private T value;
        private Node<T> prev;
        private Node<T> next;

        private Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = new Node<E>(null, null, null); // dummy node!
        head.prev = head.next = head;
        size = 0;
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> current = head;

        public boolean hasNext() {
            return (current.next != head);
        }

        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            current = current.next;

            return current.value;
        }
        /**
         * A utility method that returns the index(from 0 to size of the list) of the element immediately after the current element.
         * @author Neil Valin
         * @return int - This method returns the index of the next element in the Linked list.
         */
        public int nextIndex() {
            if (head.next == head) {
                throw new NullPointerException();
            }
            int counter = 0;
            Node<E> temp  = head;
            while (temp != current) {
                temp = temp.next;
                counter++;
            }
            return counter;
        }
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    /**
     * An access method for other files to access the private class LinkedListIterator.
     * This pseudo constructor allows a user to start from a chosen element in the list
     * rather than the dummy node.
     *
     * @param index
     * @return Iterator<E> - A new Iterator that points to the node with the index given by the parameter
     */
    public Iterator<E> iterator(int index) {
        Iterator<E> x = new LinkedListIterator();
        while (x.nextIndex()!=index) {
            if (x.hasNext()==false){
                throw new IndexOutOfBoundsException();
            }
            x.next();
        }
        return x;
    }
    /**
     * An access method that allows a the user to create a deep copy of a previously established
     * iterator.
     * @param other
     * @return Iterator<E> - A new Iterator that points to the same index as other's current instance variable.
     */
    public Iterator<E> iterator(Iterator<E> other) {
        Iterator<E> x = iterator(other.nextIndex());
        return x;

    }

    public int size() {
        return size;
    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> p = head.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.value;
    }

    public void addFirst(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> second = head.next;

        head.next = new Node<E>(elem, head, second);
        second.prev = head.next;

        size++;
    }

    public void add(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> before = head.prev, after = head;

        before.next = new Node<E>(elem, before, after);
        after.prev = before.next;

        size++;
    }

}
