package hu.dpc.edu.javase.demo;

import java.lang.reflect.Method;

/**
 *
 * @author IQJB
 */
public class ReflectionDemo {
    
    public static void printInfo(Object object) {
        printInfo(object.getClass());
    }
    public static void printInfo(Class clazz) {
        System.out.println("class name: " +  clazz.getName());
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println("declared method: " + declaredMethod);
        }
        for (Method method : clazz.getMethods()) {
            System.out.println("method: " + method);
        }
    }
    
    public static Object createSameTypeObject(Object o) {
        try {
            return o.getClass().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
