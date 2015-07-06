package hu.dpc.edu.javase.demo.main;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author IQJB
 */
public class SystemPropertiesDemo {
    public static void main(String[] args) {
        
        Set<Map.Entry<Object, Object>> entrySet = System.getProperties().entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            System.out.println(entry.getKey() + " => " + entry.getValue() );
        }
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ENVIRONMENT:");
        System.out.println();
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue() );
            
        }
    }
}
