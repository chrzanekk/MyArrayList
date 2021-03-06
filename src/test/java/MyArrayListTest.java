import org.junit.BeforeClass;
import pl.com.konrad.myarraylist.MyArrayList;

public class MyArrayListTest {
    private static Object[] myArray;

    @BeforeClass
    public static void initMyArrayList() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        myArray = new MyArrayList[11];
        for (int i = 0; i < myArray.length; i++) {

        }

    }


}
