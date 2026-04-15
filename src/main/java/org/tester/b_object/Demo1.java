package org.tester.b_object;

import java.util.ArrayList;

/**
 * @created : 17/03/2026,18:00,mar.
 **/
public class Demo1 {
    public static void main(String[] args) {
        Demo uta = new Demo();
        uta.setName("charlotte");
        System.out.println(uta.getSex());
        System.out.println(uta.getName());
        Demo wait = new Demo();
        wait.setAge(11);
        wait.setSex("garçon");
        System.out.println(uta);
        ArrayList<Demo> demos = new ArrayList<>();
        demos.add(wait);


        for (Demo demo : demos) {
            System.out.println(demo);
        }


    }
}
