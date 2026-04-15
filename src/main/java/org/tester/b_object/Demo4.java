package org.tester.b_object;

/**
 * @created : 17/03/2026,22:21,mar.
 **/
public class Demo4 {
    public static void main(String[] args) {
        Demo[] d=new Demo[3];
        Demo d1 = new Demo("ahmaq",12,"ughul", 1.25f);
        Demo d2 = new Demo("gul",11,"qiz",1.3f);
        Demo d3 = new Demo("luffy",17,"ughul",1.50f);
        d[0]=d1;
        d[1]=d2;
        d[2]=d3;

        for (Demo dd : d) {
            System.out.println(dd);
        }

    }
}
