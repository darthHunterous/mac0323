import edu.princeton.cs.algs4.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] randomQueue;
    private int size;

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        this.randomQueue = (Item[]) new Object[1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Trying to add a null element");
        if (size == this.randomQueue.length) {
            Item[] aux = (Item[]) new Object[2*size];
            for (int i = 0; i < size; i++)
                aux[i] = this.randomQueue[i];
            randomQueue = aux;
        }
        randomQueue[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Empty queue");
        int random = StdRandom.uniform(this.size);
        Item item = this.randomQueue[random];
        this.randomQueue[random] = this.randomQueue[size-1];
        size--;
        if (this.size == this.randomQueue.length/4 && this.size >= 1) {
            Item[] aux = (Item[]) new Object[randomQueue.length/2];
            for (int i = 0; i < size; i++)
                aux[i] = randomQueue[i];
            randomQueue = aux;
        }
        return item;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("Empty queue");
        int random = StdRandom.uniform(this.size);
        Item item = this.randomQueue[random];
        return item;
    }

    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private Item[] aux;
        private int auxSize;

        @SuppressWarnings("unchecked")
        public RandomIterator() {
            aux = (Item[]) new Object[size];
            for (int i = 0; i < size; i++)
                aux[i] = randomQueue[i];
            auxSize = size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return auxSize > 0;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int random = StdRandom.uniform(auxSize);
            Item item = aux[random];
            aux[random] = aux[auxSize-1];
            auxSize--;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        StdOut.println(queue.isEmpty());

        while (queue.size() < 10) {
            int number = StdIn.readInt();
            queue.enqueue(number);
        }
        StdOut.println(queue.size());

        for (int n : queue)
            StdOut.print(n + " ");
        StdOut.println();

        StdOut.println("sample " + queue.sample());

        for (int i = 0; i < 10; i++)
            StdOut.println(queue.dequeue() + " ");
    }
}
