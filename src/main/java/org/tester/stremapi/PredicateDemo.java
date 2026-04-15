package org.tester.stremapi;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @created : 14/04/2026,17:11,mar.
 **/
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate=a->(a>200);
        System.out.println(predicate.test(100));
        System.out.println(predicate.test(50));
        System.out.println(predicate.test(500));

        System.out.println("*********************************************");

        Function<Integer,Long> f=s-> (long) (s*2);
        System.out.println(f.apply(100));
        Function<String,Integer> f1=s -> (s.length());
        System.out.println(f1.apply("test automation"));
        Consumer<String> stringConsumer=d-> System.out.println(d+" is fun ");
        stringConsumer.accept("Java");
    }
}
