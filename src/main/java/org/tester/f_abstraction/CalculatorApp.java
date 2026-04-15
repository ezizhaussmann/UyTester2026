package org.tester.f_abstraction;



import static java.lang.Math.*;

/**
 * @created : 25/03/2026,14:08,mer.
 **/
public class CalculatorApp implements SimpleCalculator,AdvanceCalculator{
    @Override
    public long addition(int a, int b) {
        long sum=a+b;
        System.out.println("resultat d'addition= " + sum);
        return sum;
    }

    @Override
    public double sub(double d, double c) {
        double subtraction=d-c;
        System.out.println("resultat de subtraction = " + subtraction);
        return subtraction;
    }

    @Override
    public long multipilication(int a, int b) {
        long mult=a*b;
        System.out.println("resultat de multipilication = " + mult);
        return mult;
    }

    @Override
    public double divition(int e, int f) {
//        double div=e/f;
        if (f!=0) {
            System.out.println("resultat de division  = " + (double)e/f);
            return e/f;
        }else{
            System.out.println("\"diviseur peut pas 0\" = " + "diviseur peut pas 0");
        }
        return 0;
    }

    @Override
    public double powerval(int base, int b) {
        double p=pow(base,b);
        System.out.println("power = " + p);
        return p;
    }

    @Override
    public double sqrtvalue(int a) {
        double s=sqrt(a);
        System.out.println("sqrt is = " + s);
        return s;
    }

    @Override
    public double absolute(int a) {
        double s=abs(a);
        System.out.println("abs is = " + s);
        return s;
    }

    @Override
    public double minimum(int a, int b) {
        double m=min(a,b);
        System.out.println("min is = " + m);
        return m;
    }
}
