package org.tester.stremapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @created : 14/04/2026,17:44,mar.
 **/
public class StreamApiDemo1 {
    public static void main(String[] args) {
        // 1. On crée la liste de départ
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        // 2. On utilise le Stream pour transformer les données
        List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());

        // Affichage du résultat
        System.out.println(square); // Affiche [4, 9, 16, 25]
        System.out.println("-------------------------------------------");
        List<Integer> list = Arrays.asList(100, 200, 85, 41, 97, 125, 635);
      /*  for (Integer i : list) {
            if (i%2==0){
                System.out.print(i + " ");
            }
        }*/
        list.stream().filter(t->t%2==0).forEach(System.out::println);
        List<Integer> collect = list.stream().filter(t -> t % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);


    }
}
