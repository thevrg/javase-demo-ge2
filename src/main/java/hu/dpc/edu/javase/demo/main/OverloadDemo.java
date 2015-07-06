package hu.dpc.edu.javase.demo.main;

import java.util.Date;

/**
 *
 * @author IQJB
 */
public class OverloadDemo {
    
    public static void hello(int a, int b) {
        System.out.println("int a, int b");
    }
    
    public static void hello(int a, int... b) {
        System.out.println("int a, int... b");
    }
    
    public static int hello(String s, Date d) {
        System.out.println("String s, Date d");
        return 1;
    }
    
    public static void hello(Date d, String s) {
        System.out.println("Date d, String s");
    }
     
    public static void main(String[] args) {
        int szam = hello((String)null, null);
        hello( 1, 2);
        hello( 1, new int[] {2, 3});
        hello( 1, 2, 3);
    }
}
