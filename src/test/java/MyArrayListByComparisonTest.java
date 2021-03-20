import org.junit.Before;
import org.junit.Test;
import pl.com.konrad.myarraylist.MyArrayList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class MyArrayListByComparisonTest {
    public List myArrayList = new MyArrayList();
    public List arrayList = new ArrayList();

    @Before
    public void initMyArrayList() {
        int initialArraySize = 10;
        myArrayList = new MyArrayList();
        arrayList = new ArrayList();
        for (int i = 0; i < initialArraySize; i++) {
            myArrayList.add(new Object());
            arrayList.add(new Object());
        }
    }

    @Test
    public void testSize() {
        assertEquals(10, myArrayList.size());
        assertEquals(arrayList.size(), myArrayList.size());
    }

    @Test
    public void testAddMethodByObject() {
        Object testObject = new Object();
        myArrayList.add(testObject);
        arrayList.add(testObject);

        assertEquals(11, myArrayList.size());
        assertEquals(11, arrayList.size());
    }

    @Test
    public void testAddMethodByIndexAndIndexIsInTheMiddleOfArray() {
        myArrayList.add(1, new Object());
        arrayList.add(1, new Object());

        assertEquals(11, myArrayList.size());
        assertEquals(11, arrayList.size());
    }

    @Test
    public void testAddMethodByIndexAndIndexIsInTheEndOfArray() {
        Object testObject = new Object();
        myArrayList.add(myArrayList.size(), testObject);
        arrayList.add(arrayList.size(), testObject);

        assertEquals(11, myArrayList.size());
        assertEquals(10, myArrayList.indexOf(testObject));

        assertEquals(11, arrayList.size());
        assertEquals(10, arrayList.indexOf(testObject));
    }

    @Test
    public void testRemoveMethodByObject() {
        Object testObject = new Object();
        myArrayList.add(testObject);
        myArrayList.remove(testObject);
        arrayList.add(testObject);
        arrayList.remove(testObject);

        assertEquals(10, myArrayList.size());
        assertEquals(10, arrayList.size());
    }

    @Test
    public void testRemoveMethodByIndexAndIndexIsInTheMiddleOfArray() {
        Object testObject = new Object();
        int indexToTest = 2;
        myArrayList.add(indexToTest, testObject);
        myArrayList.remove(indexToTest);
        arrayList.add(indexToTest, testObject);
        arrayList.remove(indexToTest);

        assertEquals(10, myArrayList.size());
        assertEquals(10, arrayList.size());
    }

    @Test
    public void testRemoveMethodByIndexAndIndexIsInTheEndOfArray() {
        Object testObject = new Object();
        myArrayList.add(myArrayList.size(), testObject);
        arrayList.add(arrayList.size(), testObject);

        Object removedObjectFromMyArray = myArrayList.remove(myArrayList.indexOf(testObject));
        Object removedObjectFromArray = arrayList.remove(arrayList.indexOf(testObject));

        assertEquals(testObject, removedObjectFromMyArray);
        assertEquals(testObject, removedObjectFromArray);
        assertEquals(10, myArrayList.size());
        assertEquals(10, arrayList.size());
    }

    @Test
    public void testContainsMethod() {
        Object testObject = new Object();
        myArrayList.add(testObject);
        arrayList.add(testObject);

        boolean resultForMyArray = myArrayList.contains(testObject);
        boolean resultForArray = myArrayList.contains(testObject);

        assertTrue(resultForMyArray);
        assertTrue(resultForArray);
    }

    @Test
    public void testContainsMethodWhereObjectIsNotInArray() {
        Object testObject = new Object();

        boolean resultForMyArray = myArrayList.contains(testObject);
        boolean resultForArray = arrayList.contains(testObject);
        assertFalse(resultForMyArray);
        assertFalse(resultForArray);
    }

    @Test
    public void testIsEmptyMethod() {
        assertFalse(myArrayList.isEmpty());
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testGetMethod() {
        Object testObject = new Object();

        myArrayList.add(testObject);
        arrayList.add(testObject);
        int indexOfTestObject = myArrayList.indexOf(testObject);
        Object objectToGetFromMyArray = myArrayList.get(indexOfTestObject);
        Object objectToGetFromArray = myArrayList.get(indexOfTestObject);

        assertEquals(11, myArrayList.size());
        assertEquals(11, arrayList.size());
        assertEquals(testObject, objectToGetFromMyArray);
        assertEquals(testObject, objectToGetFromArray);
    }

    @Test
    public void testClearMethod() {
        myArrayList.clear();
        arrayList.clear();

        assertEquals(0, myArrayList.size());
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testSetMethodWhereReplacedObjectIsInMiddleOfArray() {
        Object testObject = new Object();
        Object replacedObjectFromMyArray = myArrayList.get(2);
        Object replacedObjectFromArray = arrayList.get(2);
        Object setObjectToMyArray = myArrayList.set(2, testObject);
        Object setObjectToArray = arrayList.set(2, testObject);

        assertEquals(replacedObjectFromMyArray, setObjectToMyArray);
        assertEquals(replacedObjectFromArray, setObjectToArray);
    }

    @Test
    public void testSetMethodWhereReplacedObjectIsInTheEndOfArray() {
        Object testObject = new Object();
        Object replacedObjectFromMyArray = myArrayList.get(myArrayList.size() - 1);
        Object replacedObjectFromArray = arrayList.get(arrayList.size() - 1);
        Object setObjectInMyArray = myArrayList.set(myArrayList.size() - 1, testObject);
        Object setObjectInArray = arrayList.set(arrayList.size() - 1, testObject);

        assertEquals(replacedObjectFromMyArray, setObjectInMyArray);
        assertEquals(replacedObjectFromArray, setObjectInArray);
    }

    @Test
    public void testIndexOfMethod() {
        Object testObject = new Object();
        myArrayList.add(testObject);
        arrayList.add(testObject);

        assertEquals(10, myArrayList.indexOf(testObject));
        assertEquals(10, arrayList.indexOf(testObject));
    }


    @Test
    public void testIndexOfMethodWhenObjectIsNull() {
        assertEquals(-1, myArrayList.indexOf(null));
        assertEquals(-1, arrayList.indexOf(null));
    }

    @Test
    public void testSublistMethod() {
        List myNewSublist = myArrayList.subList(2, 6);
        List newSublist = arrayList.subList(2, 6);

        assertEquals(4, myNewSublist.size());
        assertEquals(4, newSublist.size());
        assertEquals(myArrayList.get(2), myNewSublist.get(0));
        assertEquals(arrayList.get(2), newSublist.get(0));
    }

    @Test
    public void testAddAllMethod(){
        MyArrayList myArrayToAdd = new MyArrayList();
        List arrayToAdd = new ArrayList();
        Object testObject1 = new Object();
        Object testObject2 = new Object();
        Object testObject3 = new Object();
        myArrayToAdd.add(testObject1);
        myArrayToAdd.add(testObject2);
        myArrayToAdd.add(testObject3);
        arrayToAdd.add(testObject1);
        arrayToAdd.add(testObject2);
        arrayToAdd.add(testObject3);

        boolean myArrayResult = myArrayList.addAll(myArrayToAdd);
        boolean arrayResult = arrayList.addAll(arrayToAdd);

        assertEquals(13, myArrayList.size());
        assertTrue(myArrayList.contains(testObject3));
        assertEquals(13, arrayList.size());
        assertTrue(arrayList.contains(testObject3));
        assertTrue(myArrayResult);
        assertTrue(arrayResult);
    }

    @Test
    public void testAddAllMethodByIndex(){
        MyArrayList myArrayToAdd = new MyArrayList();
        List arrayToAdd = new ArrayList();
        Object testObject1 = new Object();
        Object testObject2 = new Object();
        Object testObject3 = new Object();
        myArrayToAdd.add(testObject1);
        myArrayToAdd.add(testObject2);
        myArrayToAdd.add(testObject3);
        arrayToAdd.add(testObject1);
        arrayToAdd.add(testObject2);
        arrayToAdd.add(testObject3);

       boolean myArrayResult = myArrayList.addAll(5,myArrayToAdd);
       boolean arrayResult = arrayList.addAll(5,arrayToAdd);

        assertEquals(13, myArrayList.size());
        assertTrue(myArrayList.contains(testObject3));
        assertEquals(7,myArrayList.indexOf(testObject3));
        assertEquals(13, arrayList.size());
        assertTrue(arrayList.contains(testObject3));
        assertEquals(7,arrayList.indexOf(testObject3));
        assertTrue(myArrayResult);
        assertTrue(arrayResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllMethodByIndexWhereIndexIsOutOfBound(){
        MyArrayList myArrayToAdd = new MyArrayList();
        List arrayToAdd = new ArrayList();
        Object testObject1 = new Object();
        Object testObject2 = new Object();
        Object testObject3 = new Object();
        myArrayToAdd.add(testObject1);
        myArrayToAdd.add(testObject2);
        myArrayToAdd.add(testObject3);
        arrayToAdd.add(testObject1);
        arrayToAdd.add(testObject2);
        arrayToAdd.add(testObject3);

        boolean myArrayResult = myArrayList.addAll(11,myArrayToAdd);
        boolean arrayResult = arrayList.addAll(11,arrayToAdd);

        assertFalse(myArrayResult);
        assertFalse(arrayResult);
    }

    @Test
    public void testRemoveAllMethod(){
        MyArrayList myArrayToRemove = new MyArrayList();
        List arrayListToRemove = new ArrayList();
        Object myTestObject1 = myArrayList.get(2);
        Object myTestObject2 = myArrayList.get(4);
        Object myTestObject3 = myArrayList.get(6);
        myArrayToRemove.add(myTestObject1);
        myArrayToRemove.add(myTestObject2);
        myArrayToRemove.add(myTestObject3);
        Object testObject1 = arrayList.get(2);
        Object testObject2 = arrayList.get(4);
        Object testObject3 = arrayList.get(6);
        arrayListToRemove.add(testObject1);
        arrayListToRemove.add(testObject2);
        arrayListToRemove.add(testObject3);

        boolean myArrayResult = myArrayList.removeAll(myArrayToRemove);
        boolean arrayResult = arrayList.removeAll(arrayListToRemove);

        assertEquals(7, myArrayList.size());
        assertFalse(myArrayList.contains(myTestObject3));
        assertEquals(7, arrayList.size());
        assertFalse(arrayList.contains(testObject3));
        assertTrue(myArrayResult);
        assertTrue(arrayResult);
    }


    @Test
    public void testRemoveAllMethodWhitOneObjectNotContain(){
        MyArrayList myArrayToRemove = new MyArrayList();
        List arrayListToRemove = new ArrayList();
        Object myTestObject1 = myArrayList.get(2);
        Object myTestObject2 = myArrayList.get(4);
        Object myTestObject3 = myArrayList.get(6);
        Object myTestObject4 = new Object();
        myArrayToRemove.add(myTestObject1);
        myArrayToRemove.add(myTestObject2);
        myArrayToRemove.add(myTestObject3);
        myArrayToRemove.add(myTestObject4);
        Object testObject1 = arrayList.get(2);
        Object testObject2 = arrayList.get(4);
        Object testObject3 = arrayList.get(6);
        Object testObject4 = new Object();
        arrayListToRemove.add(testObject1);
        arrayListToRemove.add(testObject2);
        arrayListToRemove.add(testObject3);
        arrayListToRemove.add(testObject4);

        boolean myArrayResult = myArrayList.removeAll(myArrayToRemove);
        boolean arrayResult = arrayList.removeAll(arrayListToRemove);

        assertEquals(7, myArrayList.size());
        assertFalse(myArrayList.contains(myTestObject3));
        assertEquals(7, arrayList.size());
        assertFalse(arrayList.contains(testObject3));
        assertTrue(myArrayResult);
        assertTrue(arrayResult);
    }

}
