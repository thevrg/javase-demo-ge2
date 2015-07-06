package hu.dpc.edu.javase.demo.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author IQJB
 */
public class MapDemo {
    public static void main(String[] args) {
        SortedMap m = new TreeMap();
        m.put(23, "huszonharom");
        m.put(23, "Huszonharom");
        m.put(new Integer(3), "harom");
        
        Object harom = m.get(3);
        
        System.out.println("m: " + m);
        System.out.println("harom: " + harom);
        
        for (Object key : m.keySet()) {
            System.out.println("Key: " + key  + ", value: " + m.get(key));
        }
        
        for (Object e : m.entrySet()) {
            Map.Entry entry = (Map.Entry) e;
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        
        String[]arr = {"alma","korte","barack"};
        List<String> list = Collections.unmodifiableList(Arrays.asList(arr));
        System.out.println("list: "  +  list);
        arr[1]="KORTE";
        System.out.println("list: "  +  list);
        list.set(0,"ALMA");
        System.out.println("list: "  +  list);
        
        System.out.println("arr: " + Arrays.toString(arr));
        
        
        
    }
}
