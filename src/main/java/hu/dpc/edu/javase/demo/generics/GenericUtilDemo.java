package hu.dpc.edu.javase.demo.generics;

import hu.dpc.edu.javase.demo.Department;
import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.Manager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class GenericUtilDemo {
    public static void main(String[] args) {
//        Integer i2 = GenericUtil.cast("ABC");
        ArrayList<Employee>empList = new ArrayList<>();
        empList.add(new Manager(111, "Bela", new Department("HR")));
        empList.add(new Manager(112, "jOZSI", new Department("HR")));
        Object[] eArr = new Entity[0];
       // eArr[7] = "ABC";
        System.out.println("eArr.getClass(): " + eArr.getClass());
        System.out.println("empList.getClass(): " + empList.getClass());
        
        Entity[] toArray = (Entity[]) empList.toArray(eArr);
        System.out.println("toArray: " + Arrays.toString(toArray));
        System.out.println("eArr == toArray : " + (eArr == toArray));
        
    }
}
