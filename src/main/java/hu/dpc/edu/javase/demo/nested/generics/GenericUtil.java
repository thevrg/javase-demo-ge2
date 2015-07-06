package hu.dpc.edu.javase.demo.nested.generics;

/**
 *
 * @author IQJB
 */
public class GenericUtil {

    public static <T> T cast(Object o) {
        try {
            System.out.println("hello, casting...");
            return (T) o;
        } finally {
            System.out.println("after casting...");
        }
    }

//    public static Integer cast(Object o) {
//        return (Integer) o;
//    }
//    public static Object cast(Object o) {
//        return o;
//    }
    public static <T> T cast(Object o, Class<T> clazz) {
        return (T) o;
    }

    public static <T1 extends Number, T2 extends Number> long add(T1 n1, T2 n2) {
        return n1.longValue() + n2.longValue();
    }

}
