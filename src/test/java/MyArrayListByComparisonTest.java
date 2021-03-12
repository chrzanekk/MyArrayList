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
        arrayList.add(arrayList.size(),testObject);

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
        arrayList.add(indexToTest,testObject);
        arrayList.remove(indexToTest);

        assertEquals(10, myArrayList.size());
        assertEquals(10, arrayList.size());
    }

    @Test
    public void testRemoveMethodByIndexAndIndexIsInTheEndOfArray() {
        Object testObject = new Object();
        myArrayList.add(myArrayList.size(), testObject);
        arrayList.add(arrayList.size(),testObject);

        Object removedObjectFromMyArray = myArrayList.remove(myArrayList.indexOf(testObject));
        Object removedObjectFromArray = arrayList.remove(arrayList.indexOf(testObject));

        assertEquals(testObject,removedObjectFromMyArray);
        assertEquals(testObject,removedObjectFromArray);
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
        Object setObjectToMyArray = myArrayList.set(2,testObject);
        Object setObjectToArray = arrayList.set(2,testObject);

        assertEquals(replacedObjectFromMyArray, setObjectToMyArray);
        assertEquals(replacedObjectFromArray, setObjectToArray);
    }

    @Test
    public void testSetMethodWhereReplacedObjectIsInTheEndOfArray() {
        Object testObject = new Object();
        Object replacedObjectFromMyArray = myArrayList.get(myArrayList.size()-1);
        Object replacedObjectFromArray = arrayList.get(arrayList.size()-1);
        Object setObjectInMyArray = myArrayList.set(myArrayList.size()-1,testObject);
        Object setObjectInArray = arrayList.set(arrayList.size()-1,testObject);

        assertEquals(replacedObjectFromMyArray, setObjectInMyArray);
        assertEquals(replacedObjectFromArray, setObjectInArray);
    }

    @Test
    public void testIndexOfMethod(){
        Object testObject = new Object();
        myArrayList.add(testObject);
        arrayList.add(testObject);

        assertEquals(10,myArrayList.indexOf(testObject));
        assertEquals(10,arrayList.indexOf(testObject));
    }

    @Test
    public void testIndexOfMethodWhenObjectIsNull(){
        assertEquals(-1,myArrayList.indexOf(null));
        assertEquals(-1,arrayList.indexOf(null));
    }

}
