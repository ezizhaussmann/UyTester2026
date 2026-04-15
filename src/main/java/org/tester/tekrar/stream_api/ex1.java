package org.tester.tekrar.stream_api;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @created : 14/04/2026,19:33,mar.
 **/
public class ex1 {
    public static void main(String[] args) {
        List<String> nakama = Arrays.asList("Luffy", "Zoro", "Nami", "Usoppe", "Sanji", "Choppa", "Robin", "Franky", "Brook", "Jinbe");
        List<String> dis = nakama.stream().distinct().collect(Collectors.toList());
        System.out.println(dis);
        Collection<String> collect = nakama.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(collect);

        List<String> debut = nakama.stream().limit(5).collect(Collectors.toList());
        System.out.println(debut);
    }
}
