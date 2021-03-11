import org.junit.Before;
import org.junit.Test;
import pl.com.konrad.myarraylist.MyArrayList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


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


}
