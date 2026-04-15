package org.tester.b_object;

/**
 * @created : 17/03/2026,22:05,mar.
 **/
public class Demo2 {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.setSex("ughul");
        d.setAge(11);
        d.setName("ahmaq");
        Demo d2 = new Demo();
        Demo d3 = new Demo();
        d3.setSex("qiz");
        d3.setName("gul");
        Demo[] dem = new Demo[3];
        dem[0]=d;
        dem[1]=d3;
        dem[2]=d2;
        for (Demo i : dem) {
            System.out.println(i);
        }

    }
}
