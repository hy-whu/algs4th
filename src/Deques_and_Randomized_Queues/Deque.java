package Deques_and_Randomized_Queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{
    private int N;
    private Node first;
    private Node last;

    private class Node {
        Item item = null;
        Node pre = null;
        Node later = null;
    }

    public Deque() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return (first == null) && (last == null);
    }

    public int size() {
        return  N;
    }

    public void addFirst(Item item) {
        if (item == null) throw new java.lang.IllegalArgumentException();
            Node originList = first;
            first.item = item;
            first.pre = null;
            if (isEmpty()) {
                last = first;
                first.later= null;
            }
            else {
                first.later = originList;
                originList.pre = first;

            }

        N++;
    }

    public void addLast(Item item) {
        if ( item == null)  throw new java.lang.IllegalArgumentException();
        Node originList  = last;
        last.item = item;
        if (isEmpty()) {

            first = last;
            last.pre = null;
        }
        else {
            last.pre = originList;
            originList.later = last;
        }
        N++;
    }

    public Item removeFirst() {
        if(first == null) throw new java.util.NoSuchElementException();
        Node node = first;
        first = first.later;

        if (isEmpty()) first = last = null;
        else first.pre = null;          //remember set both pre and later pointer

        N--;
        return node.item;
    }

    public Item removeLast() {

        if (isEmpty()) throw new java.util.NoSuchElementException();
        Node node = last;
        last = last.pre;

        if (isEmpty()) first = null;
        else last.later = null;

        N--;
        return  node.item;
    }






    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
//        return new Iterator<Item>() {
//            public Node current = first;
//            @Override
//            public boolean hasNext() {
//
//                return current != null;
//            }
//
//            // remove comes from Iterator so cannot return a Item type
//            public void remove() {
//                throw new java.lang.UnsupportedOperationException();
//            }
//
//            @Override
//            public Item next() {
//
//                if (!hasNext()) throw new NoSuchElementException();
//
//                Node node = current;
//                current = current.pre;
//                return node.item;
//            }
//        };
    }



    public static void main(String[] args){
       // unit testing (optional)
    }

    private class DequeIterator implements Iterator<Item> {

        public Node current = first;

        @Override
            public boolean hasNext() {

                return current != null;
            }

            // remove comes from Iterator so cannot return a Item type
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override
            public Item next() {

                if (!hasNext()) throw new NoSuchElementException();

                Node node = current;
                current = current.pre;
                return node.item;
            }
    }
}
