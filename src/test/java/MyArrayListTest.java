import org.junit.BeforeClass;
import org.junit.Test;
import pl.com.konrad.myarraylist.MyArrayList;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    public static MyArrayList myArrayList;

    @BeforeClass
    public static void initMyArrayList() {
        int initialArraySize = 10;
        myArrayList = new MyArrayList();
        for (int i = 0; i < initialArraySize; i++) {
            myArrayList.add(new Object());
        }

    }

    @Test
    public void testSizeMethod() {
        int size = 11;

        int result = myArrayList.size();

        assertEquals(size, result);
    }

    @Test
    public void testAddMethod() {
        int size = 11;
        myArrayList.add(new Object());
        int result = myArrayList.size();

        assertEquals(size, result);
    }

    @Test
    public void testRemoveMethodByObject() {
        myArrayList.remove(myArrayList.get(0));
        Object result = myArrayList.get(myArrayList.size()-1);

        assertEquals(null, result);
    }

    @Test
    public void testRemoveMethodByIndex() {
        myArrayList.remove(0);
        Object result = myArrayList.get(myArrayList.size()-1);

        assertEquals(null, result);
    }

    @Test
    public void testContainsMethod() {

        boolean result = myArrayList.contains(myArrayList.get(0));

        assertEquals(true,result);
    }

    @Test
    public void testIsEmptyMethod() {
        boolean result = myArrayList.isEmpty();

        assertEquals(false, result);
    }

    //todo dopytac jak ogarnac test geta i seta (jak sprawdzic czy get zwraca dobry obiekt oraz czy set
    // zmienia/podmienia obiekt ).
//    @Test
//    public void testGetMethod() {
//        Object result = myArrayList.get(0);
//
//        assertEquals(myArrayList., result);
//    }






}
