package pl.com.konrad.myarraylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList implements List {
    private final static int INITIAL_SIZE = 0;
    private Object[] myArray = new Object[INITIAL_SIZE];

    public MyArrayList() {
    }

    //++ tested
    @Override
    public int size() {
        return myArray.length;
    }

    //++ tested
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

    //++ tested
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

    //++ tested
    @Override
    public boolean add(Object element) {
        return addToArray(element);
    }

    private boolean addToArray(Object element) {
        if (checkIsArrayFull()) {
            myArray = Arrays.copyOf(myArray, myArray.length + 1);
//            variable lastIndex only for test method lastIndexOf() - do poprawy
            int lastIndex = lastIndexOf(null);
            myArray[lastIndex] = element;
        } else {
            int lastIndex = lastIndexOf(null);
            myArray[lastIndex] = element;
        }
        return true;
    }

    //++ tested
    @Override
    public boolean remove(Object element) {
        return removeObject(element);
    }

    //todo zmiana rozmiaru listy po usunieciu obiektu - czy trzeba
    private boolean removeObject(Object element) {
        if (contains(element)) {
            int index = indexOf(element);
            if (index < myArray.length - 1) {
                for (int i = index; i < myArray.length - 1; i++) {
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = null;
                }
            } else {
                myArray[index] = null;
            }
            myArray = Arrays.copyOf(myArray, myArray.length - 1);
            return true;
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

    //++ testes
    @Override
    public void clear() {
        clearArray();
    }

    private void clearArray() {
        myArray = new Object[INITIAL_SIZE];
    }

    //++ tested
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
        return new IndexOutOfBoundsException("Index out of bound.");
    }

    //++ tested
    @Override
    public Object set(int index, Object element) {
        return replaceElement(index, element);
    }

    private Object replaceElement(int index, Object element) {
        if (checkIsIndexCorrect(index)) {
            Object objectToReturn = myArray[index];
            myArray[index] = element;
            return  objectToReturn;
        }
        return new IndexOutOfBoundsException("Index out of bound.");
    }

    //++ tested
    @Override
    public void add(int index, Object element) {
        addElementByIndex(index, element);
    }

    private void addElementByIndex(int index, Object element) {
        if (checkIsIndexCorrect(index)) {
            if (checkIsArrayFull()) {
                myArray = Arrays.copyOf(myArray, myArray.length + 1);
            }
            for (int i = index; i < myArray.length - 1; i++) {
                myArray[i + 1] = myArray[i];
            }
            myArray[index] = element;
        } else {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
    }

    //++ tested
    @Override
    public Object remove(int index) {
        return removeObjectByIndex(index);
    }

    private Object removeObjectByIndex(int index) {
        if (checkIsIndexCorrect(index)) {
            Object elementToReturn = get(index);
            if (index < myArray.length - 1) {
                for (int i = index; i < myArray.length - 1; i++) {
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = null;
                }
            }
            myArray = Arrays.copyOf(myArray, myArray.length - 1);
            return elementToReturn;
        } else {
            return new IndexOutOfBoundsException("Index out of bound");
        }
    }

    //++ tested
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
        }
        else {
            for (int i = 0; i < myArray.length; i++) {
                if (element.equals(myArray[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //++ tested
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
        return getSubList(fromIndex,toIndex);
    }

    private List getSubList(int fromIndex, int toIndex) {
        List newSubList = new MyArrayList();
        if (checkIsRangeIndexIsCorrect(fromIndex, toIndex)) {
            for(int i = fromIndex; i < toIndex; i++) {
                newSubList.add(get(i));
            }


            return newSubList;
        } else {
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

    private boolean checkIsArrayFull() {
        if ((get(myArray.length - 1)) != null) {
            return true;
        }
        return false;
    }
}

