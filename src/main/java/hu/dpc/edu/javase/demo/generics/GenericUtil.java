package hu.dpc.edu.javase.demo.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    public static <T> List<T> asList(T... array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    public static <T> T[] asArray(List<? extends T> list, Class<T> type) {
        T[] array = (T[]) Array.newInstance(type, list.size());
        for (int i = 0; i < array.length; i++) {
            T element = list.get(i);
            array[i] = element;
        }
        return array;
    }

    public static <T1 extends Number, T2 extends Number> long add(T1 n1, T2 n2) {
        return n1.longValue() + n2.longValue();
    }

}
