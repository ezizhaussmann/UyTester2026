package testng_tests;

import org.testng.annotations.Test;

/**
 * @created : 23/04/2026,17:16,jeu.
 **/
public class ArrayTest {
    @Test
    public void testArray(){
        int[] array = {1,2,3};
        assert array.length == 3;
    }
    @Test
    public void testArray2(){
        int[][] array = {{1,2,3},{2,4,6}};
        assert array.length == 2;
        System.out.println(array[0].length);
        System.out.println(array[1][1]);
    }
}
