package hu.dpc.edu.javase.demo;

import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class EmployeeParser implements EmployeeReader {

    private static final Map<String, Class<? extends Employee>> CLASS_BY_TYPE_NAME;

    static {
        Map<String, Class<? extends Employee>> classByTypeName = new HashMap<>();
        classByTypeName.put("Manager", Manager.class);
        classByTypeName.put("Employee", Employee.class);
        classByTypeName.put("Secretary", Secretary.class);
        CLASS_BY_TYPE_NAME = Collections.unmodifiableMap(classByTypeName);
    }

    private static Employee createEmployeeByType(String type, long id, String name, double salary) throws EmployeeParserException, IllegalArgumentException {
        Class<? extends Employee> clazz = CLASS_BY_TYPE_NAME.get(type);
//        String className = "hu.dpc.edu.javase.demo." + type;
//        clazz = Class.forName(className);
        
        if (clazz == null) {
            throw new EmployeeParserException("Illegal employee type: " + type);
        }
        try {
            return clazz.getConstructor(Long.TYPE, String.class, Double.TYPE).newInstance(id, name, salary);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new EmployeeParserException("Could not instantiate " + clazz.getName());
        }
    }

    private ReadableSource source;

    public EmployeeParser(ReadableSource source) {
        this.source = source;
    }

    @Override
    public EmployeeIterator readEmployees() {

        final Scanner scanner = new Scanner(source.getReader()).useDelimiter("[\r\n]+");

        return new EmployeeIterator() {

            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }

            @Override
            public Employee next() throws IllegalStateException {
                Employee employee;
                String line = scanner.next();
                Scanner lineScanner = new Scanner(line).useDelimiter(",");
                long id = lineScanner.nextLong();
                String type = lineScanner.next();
                String name = lineScanner.next();
                double salary = lineScanner.nextDouble();
                employee = createEmployeeByType(type, id, name, salary);

                if (employee instanceof Manager) {
                    String departmentName = lineScanner.next();
                    Department department = new Department(departmentName);
                    Manager m = (Manager) employee;
                    m.setManagerOf(department);
                }

                return employee;
            }

        };

    }

}
