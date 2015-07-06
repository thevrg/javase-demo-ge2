package hu.dpc.edu.javase.demo.main;

/**
 *
 * @author IQJB
 */
public class WrapperDemo {
    public static void main(String[] args) {
        
        Integer i1 = Integer.valueOf("12");
        Integer i2 = Integer.parseInt("12");
        
        System.out.println("i1 == i2 : " + (i1.intValue() == i2));
        
        Object o = true;
        System.out.println("o.getClass() " + o.getClass().getName());
 
        if (i1 < i2 || i1 == i2 || i1 > i2) {
            System.out.println("mindig igaz?");
        }
        
        double d1 = Double.NaN;
        double d2 = 0;
        
        if (d1 < d2 || d1 == d2 || d1 > d2) {
            System.out.println("mindig igaz (double) ?");
        }
        
        System.out.println(Double.isNaN(d1));
        
        
    }
}
