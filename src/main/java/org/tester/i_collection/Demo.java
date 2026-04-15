package org.tester.i_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @created : 26/03/2026,21:22,jeu.
 **/
public class Demo {
    public static void main(String[] args) {
        int[] ints = new int[6];
        int[] ints1 = {3, 4, 5};
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));


        System.out.println("\"*****************************************************\" = " + "*****************************************************");
        List<String> list = new ArrayList<>();
        list.add("aka");
        list.add("uka");
        list.add(2,"15");
        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

            for (String s : list) {
            System.out.println(s);
        }

    }
}
