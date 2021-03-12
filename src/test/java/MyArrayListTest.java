import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.com.konrad.myarraylist.MyArrayList;

import static org.junit.Assert.*;

public class MyArrayListTest {
    public static MyArrayList myArrayList;

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
        int size = 11;
        myArrayList.add(new Object());
        int result = myArrayList.size();

        assertEquals(size, result);
    }

    @Test
    public void testAddMethodByIndex() {
        int size = 11;
        myArrayList.add(1, new Object());
        int result = myArrayList.size();

        assertEquals(size, result);
    }

    @Test
    public void testRemoveMethodByObject() {
        int size = 9;
        myArrayList.remove(myArrayList.get(0));
        int result = myArrayList.size();

        assertEquals(size, result);
    }

    @Test
    public void testRemoveMethodByIndex() {
        int size = 9;
        myArrayList.remove(0);
        int result = myArrayList.size();

        assertEquals(size, result);
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

    //todo dopytac jak ogarnac test geta i seta (jak sprawdzic czy get zwraca dobry obiekt oraz czy set
    // zmienia/podmienia obiekt ).
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


}
