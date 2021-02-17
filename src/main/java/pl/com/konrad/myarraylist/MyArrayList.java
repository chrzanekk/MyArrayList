package pl.com.konrad.myarraylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList implements List {
//    zmienic na stala
    private final int initialSize = 10;
    private Object[] array = new Object[initialSize];

    //++
    @Override
    public int size() {
        return array.length;
    }

    //++
    @Override
    public boolean isEmpty() {
        return isArrayEmpty();
    }

    private boolean isArrayEmpty() {
        for (Object o : array) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    //++
    @Override
    public boolean contains(Object o) {
        return isObjectExists(o);
    }

    private boolean isObjectExists(Object o) {
        for (Object value : array) {
            if (value.equals(o)) {
                return true;
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
        return new Object[0];
    }

    //++
    @Override
    public boolean add(Object o) {
        return addToArray(o);
    }

    private boolean addToArray(Object o) {
        if (size() == initialSize) {
            array = Arrays.copyOf(array, initialSize + 1);
            array[initialSize + 1] = o;
        } else {
            int lastIndex = lastIndexOf(null);
            array[lastIndex] = o;
        }
        return true;
    }

    //++
    @Override
    public boolean remove(Object o) {
        return removeObject(o);
    }

    private boolean removeObject(Object o) {
        if (contains(o)) {
            int index = indexOf(o);
            for (int i = index; i < array.length; i++) {
                array[i] = replaceElement(i + 1, get(i + 1));
            }
            int lastIndex = lastIndexOf(null);
            removeObject(lastIndex);
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

    //++
    @Override
    public void clear() {
        clearArray();
    }

    private void clearArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    //++
    @Override
    public Object get(int index) {
        return getObjectByIndex(index);
    }

    private Object getObjectByIndex(int index) {
        if (checkIsIndexCorrect(index)) {
            for (int i = 0; i < array.length; i++) {
                if (i == index) {
                    return array[i];
                }
            }
        }
        return null;
    }

    //++
    @Override
    public Object set(int index, Object element) {
        return replaceElement(index, element);
    }

    private Object replaceElement(int index, Object o) {
        if (checkIsIndexCorrect(index)) {
            array[index] = o;
        }
        return new IndexOutOfBoundsException("Index out of bound.");
    }

    //++
    @Override
    public void add(int index, Object element) {

    }

    //++
    @Override
    public Object remove(int index) {
        return null;
    }

    //++
    @Override
    public int indexOf(Object o) {
        return indexOfObject(o);
    }

    private int indexOfObject(Object o) {
        if (o == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //++
    @Override
    public int lastIndexOf(Object o) {
        return lastIndexOfArray(o, array.length);
    }

    private int lastIndexOfArray(Object o, int size) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    //++
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

    //++
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    //++
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private boolean checkIsIndexCorrect(int index) {
        if ((index < 0 || index > array.length) && array.length > 0) {
            return false;
        } else {
            return true;
        }
    }
}

