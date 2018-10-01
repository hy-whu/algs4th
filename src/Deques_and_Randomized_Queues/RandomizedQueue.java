package Deques_and_Randomized_Queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static int N = 1;
    private static int count = 0;
    private Item[] queue;



    public RandomizedQueue() {
        queue = (Item[]) new Object[N];


    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return count;
    }

    public void enqueue(Item item) {
        if(item == null) throw new java.lang.NullPointerException();

        queue[count++] = item;
        if (count == queue.length) {
            queue = resize(queue,N*2);

        }

    }


    public Item dequeue() {
        if(isEmpty()) throw new java.util.NoSuchElementException();
        int index = StdRandom.uniform(count);
        Item item = queue[index];

        if (count == N-1) queue[count--] = null;
        else queue[index] = queue[count--];

        if (count == N/4) {
            queue = resize(queue,N/2);
        }

        return item;
    }

    public Item sample() {

        if(isEmpty()) throw new java.util.NoSuchElementException();
        int index = StdRandom.uniform(count);
        Item item = queue[index];
        return item;

    }

    public Iterator<Item> iterator() {
        return new queueIterator();
    }


    private Item[] resize (Item[] q,int length){
        Item[] newQueue = (Item[]) new Object[length];
        for (int i = 0;i<count;i++) {
            newQueue[i] = q[i];
        }
        return newQueue;
    }

    private class queueIterator implements Iterator<Item> {
        private Item[] item = (Item[]) new Object[count];
        private int index;

        public queueIterator() {

            for (int i = 0;i<count;i++) {
                item[i] = queue[i];
            }


        }
        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            StdRandom.shuffle(item);
            Item item1 = item[index++];
            return item1;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }



    public static void main(String[] args){
        //unit testing (optional)
    }
}
