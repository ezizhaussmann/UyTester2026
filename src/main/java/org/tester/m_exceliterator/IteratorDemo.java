package org.tester.m_exceliterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @created : 31/03/2026,23:15,mar.
 **/
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> obj = Arrays.asList("lemon", "pomme", "peche");
        Iterator<String> iterator = obj.iterator();
//        System.out.println(iterator.next());
//        for (String s : obj) {
//            boolean b = iterator.hasNext();
//            System.out.println(s);
//
//        }
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
