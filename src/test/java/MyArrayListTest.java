import org.junit.Before;
import org.junit.Test;
import pl.com.konrad.myarraylist.MyArrayList;

import java.util.List;

import static org.junit.Assert.*;

public class MyArrayListTest {
    public static List myArrayList;

    @Before
    public void initMyArrayList() {
        int initialArraySize = 10;
        myArrayList = new MyArrayList();
        for (int i = 0; i < initialArraySize; i++) {
            myArrayList.add(new Object());
        }
    }

    @Test
    public void testSizeMethod() {
        int size = 10;

        int result = myArrayList.size();

        assertEquals(size, result);
    }

    @Test
    public void testAddMethodByObject() {
        Object testObject = new Object();
        int size = 11;
        myArrayList.add(testObject);
        int result = myArrayList.size();

        assertEquals(size, result);
    }

    @Test
    public void testAddMethodByIndexAndIndexIsInTheMiddleOfArray() {
        myArrayList.add(1, new Object());

        assertEquals(11, myArrayList.size());
    }

    @Test
    public void testAddMethodByIndexAndIndexIsInTheEndOfArray() {
        Object testObject = new Object();
        myArrayList.add(myArrayList.size(), testObject);

        assertEquals(11, myArrayList.size());
        assertEquals(10, myArrayList.indexOf(testObject));
    }

    @Test
    public void testRemoveMethodByObject() {
        Object testObject = new Object();
        myArrayList.add(testObject);
        myArrayList.remove(testObject);
        assertEquals(10, myArrayList.size());
    }

    @Test
    public void testRemoveMethodByIndexAndIndexIsInTheMiddleOfArray() {
        Object testObject = new Object();
        myArrayList.add(2, testObject);
        myArrayList.remove(2);

        assertEquals(10, myArrayList.size());
    }
    @Test
    public void testRemoveMethodByIndexAndIndexIsInTheEndOfArray() {
        Object testObject = new Object();
        myArrayList.add(myArrayList.size(), testObject);
        Object removedObject = myArrayList.remove(myArrayList.indexOf(testObject));

        assertEquals(testObject,removedObject);
        assertEquals(10, myArrayList.size());
    }


    @Test
    public void testContainsMethod() {
        Object testObject = new Object();
        myArrayList.add(testObject);
        boolean result = myArrayList.contains(testObject);
        assertTrue(result);
    }

    @Test
    public void testIsEmptyMethod() {
        boolean result = myArrayList.isEmpty();

        assertFalse(result);
    }

    @Test
    public void testGetMethod() {
        int size = 11;
        Object testObject = new Object();

        myArrayList.add(testObject);
        int indexOfTestObject = myArrayList.indexOf(testObject);
        Object objectToGet = myArrayList.get(indexOfTestObject);
        int result = myArrayList.size();

        assertEquals(size, result);
        assertEquals(testObject, objectToGet);
    }

    @Test
    public void testClearMethod() {
        myArrayList.clear();

        assertEquals(0, myArrayList.size());
    }

    @Test
    public void testSetMethodWhereReplacedObjectIsInMiddleOfArray() {
        Object testObject = new Object();
        Object replacedObject = myArrayList.get(2);
        Object setObject = myArrayList.set(2,testObject);

        assertEquals(replacedObject, setObject);
    }
    @Test
    public void testSetMethodWhereReplacedObjectIsInTheEndOfArray() {
        Object testObject = new Object();
        Object replacedObject = myArrayList.get(myArrayList.size()-1);
        Object setObject = myArrayList.set(myArrayList.size()-1,testObject);

        assertEquals(replacedObject, setObject);
    }

    @Test
    public void testIndexOfMethod(){
        Object testObject = new Object();
        myArrayList.add(testObject);

        assertEquals(10,myArrayList.indexOf(testObject));
    }

    @Test
    public void testIndexOfMethodWhenObjectIsNull(){

        assertEquals(-1,myArrayList.indexOf(null));
    }




}
