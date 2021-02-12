package pl.com.konrad.myarraylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyOneDirectionDynamicList implements List {
    private Node head;


    public MyOneDirectionDynamicList() {
        this.head = null;
    }


    //+
    @Override
    public int size() {
        return getSize(head);
    }

    private int getSize(Node head) {
        Node current = head;
        int sum = 0;
        if (isEmpty()) {
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

    private boolean isContains(Object o, Node head) {
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
        return addNode(o, head);
    }

    private boolean addNode(Object o, Node head) {
        Node current = head;
        Node newNode = new Node(o);
        if (current == null) {
            this.head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return true;
    }

    //+
    @Override
    public boolean remove(Object o) {
        return removeNode(o,head);
    }

    private boolean removeNode(Object o, Node head) {
        Node current = head;
        Node previous = null;
        int index = 0;
        if (current == null) {
            throw new NullPointerException("List is empty.");
        } else {
            while (current.next != null && index++ < indexOf(o))
                previous = current;
            current = current.next;
        }
        if (indexOf(o) > index) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
        if (previous == null && current.next != null) {
            this.head = current.next;
        } else if (previous != null && current.next == null) {
            previous.next = null;
        } else {
            previous.next = current.next;
        }
        return true;
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
        return indexOfNode(o);
    }

    private int indexOfNode(Object o) {
        Node current = head;
        int index = 0;
        if (isEmpty()) {
            throw new NullPointerException("List is empty.");
        } else {
            while (current != null && !current.equals(o)) {
                index++;
                current = current.next;
            }
        }
        return index;
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
        return addToArray(a,head);
    }
    private Object[] addToArray(Object[] a, Node head) {
        Node current = head;
        while (current != null) {
            a[indexOf(current)] = current.data;
            current = current.next;
        }
        return a;
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
