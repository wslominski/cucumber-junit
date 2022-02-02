package edu.citadel.slominski;

import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.*;


public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    // construct an empty Deque
    public Deque() {
    }

    // is the Deque empty?
    public boolean empty() {
        return size == 0;
    }

    // return the number of items on the Deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFront(Item item) {
        if (empty()) {
            first = new Node<>();
            first.item = item;
            last = first;
        } else {
            Node<Item> oldFirst = first;
            first = new Node<Item>();
            first.item = item;
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        size++;
    }

    // add the item to the end
    public void addBack(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.item = item;
        if (last != null) {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        if (first == null) first = last;
        size++;
    }

    // remove and return the item from the front
    public Item removeFront() {
        if (empty()) throw new java.util.NoSuchElementException();
        Item deleted = first.item;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }
        size--;
        return deleted;
    }

    // remove second element
    public Item removeSecond(){
        if (!(size > 1)) throw new java.util.NoSuchElementException();
        Item second = first.next.item;
        if (size == 2){
            first.next.item = null;
            last.item = first.item;
            last.prev.item = null;
        } else {
            first.next.item = first.next.next.item;
            first.next.prev.item = first.item;
        }
        size--;
        return second;
    }

    // remove and return the item from the end
    public Item removeBack() {
        if (empty()) {
            System.out.println("no element in that position");
            throw new java.util.NoSuchElementException();
        }
        Item deleted = last.item;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }
        size--;
        return deleted;
    }

    public Item peekLast(){
        if (empty()) throw new java.util.NoSuchElementException();
        return last.item;
    }

    public Item peekFirst(){
        if (empty()) throw new java.util.NoSuchElementException();
        return first.item;
    }

    public void toEmptyDeque(){
        while(size != 0){
            removeFront();
        }
    }


    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new FancyIterator<>(first);
    }



    // helper static classes to follow.

    // this is a node.
    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;
    }

    // this is an iterator class for Items in this linked list.
    private static class FancyIterator<Item> implements Iterator<Item> {
        private Node<Item> nextNode;

        public FancyIterator(Node<Item> startNode) {
            nextNode = startNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Node<Item> save = nextNode;
            nextNode = nextNode.next;
            return save.item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> d = new Deque<String>();
        d.addFront("one");
        d.addBack("two");
        d.addFront("zero");
        System.out.println(d.peekLast());
        for (String s : d)
            System.out.println(s);
        d.removeFront();
        for (String s : d)
            System.out.println(s);
        d.removeBack();
        for (String s : d)
            System.out.println(s);
        d.removeFront();
        System.out.println(d.empty());
    }
}
