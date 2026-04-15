package org.tester.c_metod.method;

import java.lang.reflect.Array;

/**
 * @created : 18/03/2026,16:40,mer.
 **/
public class MaxValue {
    public static void main(String[] args) {
         int[] a1={200,96,198,493,221,6541};
        int[] a3={2001,96,198,493,221,6541};
        int[] a4={2005,296,198,493,221,6541};
        int[] a5={2007,936,198,493,221,6541};
        int[] a6={1200,964,198,493,221,6541};
        MaxValue maxValue = new MaxValue();
        maxValue.maxvalue(a1);
    }



    public int maxvalue(int[] arr){
        int maxV=0;
        for (int i = 0; i <arr.length ; i++) {
            if (maxV<arr[i]){
                maxV=arr[i];
            }
            
        }
        System.out.println(maxV);
        return maxV;

    }
}
