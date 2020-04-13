import less06.ArrayMethods;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class ArrayMethodsTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1, 2, 1, 1, 4},  false },
                {new int[] {1, 1, 1, 1}, false},
                {new int[] {4, 4, 1},  true},
                {new int[] {4, 1, 1, 1, 4, 1, 1, 1, 1}, true},
                {new int[] {4, 4},false,},
                {new int[] {}, false}
        });
    }

    private ArrayMethods arrayMethods;
    private final int[] arr;
    private final boolean bool;


    public ArrayMethodsTest(int[] arr, boolean bool) {
        this.arr = arr;
        this.bool = bool;
    }

    @Before
    public void init(){
        arrayMethods = new ArrayMethods();
    }

    @Test
    public void testArrayOf4and1 (){
        Assert.assertEquals(bool, arrayMethods.arrayOf4and1(arr));
    }



    @After
    public void shutdown(){
        arrayMethods = null;
    }

}
