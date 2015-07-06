package hu.dpc.edu.javase.demo.main;

import hu.dpc.edu.javase.demo.*;
import static hu.dpc.edu.javase.demo.Season.AUTUMN;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.PI;

/**
 *
 * @author IQJB
 */
public class MathDemo {

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(cos(PI));
        hu.dpc.edu.javase.demo.Season s = AUTUMN;
        int a = Integer.MIN_VALUE;
        int absA = Math.abs(Integer.MIN_VALUE);
        System.out.println("a == absA : " + (a == absA));
        long end = System.nanoTime();

        System.out.println("time: " + (end - start));

    }
}
