import less06.ArrayMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayMethodsTesting {
    private static int[][] arr = {
            {1, 2, 3, 4, 5, 6},
            {1, 1, 1, 1, 1, 1, 1},
            {4, 2, 2, 3},
            {2, 3, 4},
            {}
    };

    ArrayMethods arrayMethods;

    @Before
    public void init(){
        arrayMethods = new ArrayMethods();
    }

    @Test
    public void testArrayAfter4_0(){
        Assert.assertArrayEquals(new int[] {5, 6}, arrayMethods.arrayAfter4(arr[0]));
    }
    @Test(expected = RuntimeException.class)
    public void testArrayAfter4_1(){
        Assert.assertArrayEquals(null, arrayMethods.arrayAfter4(arr[1]));
    }
    @Test
    public void testArrayAfter4_2(){
        Assert.assertArrayEquals(new int[] {2 ,2, 3}, arrayMethods.arrayAfter4(arr[2]));
    }
    @Test
    public void testArrayAfter4_3(){
        Assert.assertArrayEquals(new int[] {}, arrayMethods.arrayAfter4(arr[3]));
    }
    @Test(expected = RuntimeException.class)
    public void testArrayAfter4_4(){
        Assert.assertArrayEquals(null, arrayMethods.arrayAfter4(arr[4]));
    }



    @After
    public void shutdown(){
        arrayMethods = null;
    }
}
