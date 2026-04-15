package org.tester.g_handling;

/**
 * @created : 25/03/2026,16:01,mer.
 **/
public class Demo1 {
    public static void main(String[] args) {
      try {

        int i=12/0;
      } catch (Exception e) {
//          e.printStackTrace();
          System.out.println(e);
          System.out.println(e.getMessage());

      }
        System.out.println("mangmas codlaringni toxtat");


    }
}
