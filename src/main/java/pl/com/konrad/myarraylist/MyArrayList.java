package pl.com.konrad.myarraylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList implements List {
    private int listSize = 0;
    private Object[] list = new Object[listSize];


//+
    @Override
    public int size() {
        return (int) Arrays.stream(list).count();
    }
//+
    @Override
    public boolean isEmpty() {
        return Arrays.stream(list).count() == 0;
    }
//+
    @Override
    public boolean contains(Object o) {
        if (listSize!=0) {
            for (Object object : list) {
                if (o.equals(object)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(list,list.length);
    }
//+
    @Override
    public boolean add(Object o) {
        list = new Object[listSize+1];
        list[list.length-1] = o;
        return true;
    }
//+
    @Override
    public boolean remove(Object o) {
        if (listSize!=0) {
            for (Object object : list) {
                if (o.equals(object)) {
                    
                    return true;
                }
            }
        }
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
}
