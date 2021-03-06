package pl.com.konrad.myarraylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList implements List {
    private final static int INITIAL_SIZE = 10;
    private Object[] myArray = new Object[INITIAL_SIZE];

    //++
    @Override
    public int size() {
        return myArray.length;
    }

    //++
    @Override
    public boolean isEmpty() {
        return isArrayEmpty();
    }

    private boolean isArrayEmpty() {
        for (Object o : myArray) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    //++
    @Override
    public boolean contains(Object element) {
        return isObjectExists(element);
    }

    private boolean isObjectExists(Object element) {
        for (Object value : myArray) {
            if (value.equals(element)) {
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
    public boolean add(Object element) {
        return addToArray(element);
    }

    private boolean addToArray(Object element) {
        if (size() == INITIAL_SIZE) {
            myArray = Arrays.copyOf(myArray, INITIAL_SIZE + 1);
            myArray[INITIAL_SIZE + 1] = element;
        } else {
            int lastIndex = lastIndexOf(null);
            myArray[lastIndex] = element;
        }
        return true;
    }

    //++
    @Override
    public boolean remove(Object element) {
        return removeObject(element);
    }

    private boolean removeObject(Object element) {
        if (contains(element)) {
            int index = indexOf(element);
            for (int i = index; i < myArray.length; i++) {
                myArray[i] = replaceElement(i + 1, get(i + 1));
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
//        for (int i = 0; i < array.length; i++) {
//            array[i] = null;
//        }
        myArray = new Object[INITIAL_SIZE];
    }

    //++
    @Override
    public Object get(int index) {
        return getObjectByIndex(index);
    }

    private Object getObjectByIndex(int index) {
        if (checkIsIndexCorrect(index)) {
            for (int i = 0; i < myArray.length; i++) {
                if (i == index) {
                    return myArray[i];
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

    private Object replaceElement(int index, Object element) {
        if (checkIsIndexCorrect(index)) {
            myArray[index] = element;
        }
        return new IndexOutOfBoundsException("Index out of bound.");
    }

    //++
    @Override
    public void add(int index, Object element) {
        addElementByIndex(index,element);
    }

    private void addElementByIndex(int index, Object element) {
        if (checkIsIndexCorrect(index)) {
            if (size() == INITIAL_SIZE) {
                myArray = Arrays.copyOf(myArray, INITIAL_SIZE + 1);
            }
            int lastIndex = lastIndexOf(null);
            for (int i = index; i < lastIndex; i++) {
                myArray[i + 1] = myArray[i];
            }
            myArray[index] = add(element);
//            if (lastIndex - index >= 0) System.arraycopy(array, index, array, index + 1, lastIndex - index);
//            array[index] = add(element);
        } else {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
    }

    //++
    @Override
    public Object remove(int index) {
        return removeObjectByIndex(index);
    }

    //todo to jeszcze przemyslec jesli index jest w zakresie ale nie zwraca obiektu tylko nulla
    private Object removeObjectByIndex(int index) {
        if (checkIsIndexCorrect(index)) {
            Object elementToReturn = get(index);
            int iterations = size();
            if (size() < INITIAL_SIZE) {
                iterations = lastIndexOf(null);
            }
            for (int i = index; i < iterations; i++) {
                myArray[i] = myArray[i + 1];
            }
            return elementToReturn;
        } else {
            return new IndexOutOfBoundsException("Index out of bound");
        }
    }

    //++
    @Override
    public int indexOf(Object element) {
        return indexOfObject(element);
    }

    private int indexOfObject(Object element) {
        if (element == null) {
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < myArray.length; i++) {
                if (element.equals(myArray[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //++
    @Override
    public int lastIndexOf(Object element) {
        return lastIndexOfArray(element, myArray.length);
    }

    private int lastIndexOfArray(Object element, int size) {
        if (element == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (myArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (element.equals(myArray[i])) {
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

    private List getSubList(int fromIndex, int toIndex) {
        List newSubList = new ArrayList();
        if(checkIsRangeIndexIsCorrect(fromIndex,toIndex)) {
            for (int i = fromIndex; i<= toIndex; i++) {
                newSubList.add(myArray[i]);
            }
            return newSubList;
        }
        else {
            throw new IllegalArgumentException("Wrong input");
        }
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
        if ((index < 0 || index > myArray.length) && myArray.length > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkIsRangeIndexIsCorrect(int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            return false;
        } else if (toIndex > myArray.length) {
            return false;
        } else return fromIndex <= toIndex;
    }
}

