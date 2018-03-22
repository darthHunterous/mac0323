//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node top, bottom;
    private int size;

    private class Node {
        Item item;
        Node previous;
        Node next;
    }

    public Deque() {
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        return false;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Trying to add a null element");
        Node aux = new Node();
        aux.item = item;
        aux.next = null;
        if (size == 0) {
            aux.previous = null;
            this.bottom = aux;
        }
        else {
            this.top.next = aux;
            aux.previous = top;
        }
        this.top = aux;
        size++;
    }

    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Trying to add a null element");
        Node aux = new Node();
        aux.item = item;
        aux.previous = null;
        if (size == 0) {
            this.top = aux;
            this.bottom = aux;
            aux.next = null;
        }
        else {
            aux.next = this.bottom;
            this.bottom.previous = aux;
            this.bottom = aux;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Empty deque");
        Item item = this.top.item;
        if (size == 1) {
            this.top = null;
            this.bottom = null;
        }
        else {
            this.top = this.top.previous;
            this.top.next = null;
        }
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Empty deque");
        Item item = this.bottom.item;
        if (size == 1) {
            this.top = null;
            this.bottom = null;
        }
        else {
            this.bottom = this.bottom.next;
            this.bottom.previous = null;
        }
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = top;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.previous;
            return item;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deck = new Deque<Integer>();
        StdOut.println(deck.isEmpty());

        while (deck.size() < 10) {
            int number = StdIn.readInt();
            if (number % 2 == 0)
                deck.addFirst(number);
            else
                deck.addLast(number);
        }

        for (int n : deck)
            StdOut.print(n + " ");
        StdOut.println();
        StdOut.println("Top is " + deck.removeFirst());
        StdOut.println("Bottom is " + deck.removeLast());
    }
}
