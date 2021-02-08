package pl.com.konrad.myarraylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList implements List {
    private Node head;


    public MyArrayList() {
        this.head = null;
    }


    //+
    @Override
    public int size() {
        return getSize(head);
    }

    private static int getSize(Node node) {
        Node current = node;
        int sum = 0;
        if (current == null) {
            throw new NullPointerException("List is empty.");
        } else {
            while (current != null) {
                sum++;
                current = current.next;
            }
        }
        return sum;
    }

    //+
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    //+
    @Override
    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        } else {
            return isContains(o, head);
        }
    }

    private static boolean isContains(Object o, Node head) {
        Node current = head;
        while (current != null && !current.data.equals(o)) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    //+
    @Override
    public boolean add(Object o) {
        return addNew(o,head);
    }
    private boolean addNew(Object o, Node head) {
        Node current = head;
        Node newNode = new Node(o);
        if (current == null) {
            this.head = newNode;
        }
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return true;
    }

    //+
    @Override
    public boolean remove(Object o) {


        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {

    }

    @Override
    public void sort(Comparator c) {

    }

    //+
    @Override
    public void clear() {

    }

    //+
    @Override
    public Object get(int index) {
        return null;
    }

    //+
    @Override
    public Object set(int index, Object element) {
        return null;
    }

    //+
    @Override
    public void add(int index, Object element) {

    }

    //+
    @Override
    public Object remove(int index) {
        return null;
    }

    //+
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    //+
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    //+
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    //+
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    //+
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    // nie wiem czy mi się settery przydadzą, czy węzeł jest DTOsem czy nie.
    class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
