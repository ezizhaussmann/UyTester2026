package org.tester.g_handling;

/**
 * @created : 25/03/2026,17:49,mer.
 **/
public class ExeptionFinally {
    public static void valideDateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input can not be null");
        } else {
            System.out.println("input = " + input);
        }
    }
    public static void main(String[] args) {
        valideDateInput(null);

    }
}
