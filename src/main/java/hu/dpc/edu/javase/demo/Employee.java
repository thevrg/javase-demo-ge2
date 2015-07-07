package hu.dpc.edu.javase.demo;

import hu.dpc.edu.javase.demo.generics.Entity;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author IQJB
 */
public class Employee extends InfoExposerBaseClass implements Comparable, Entity<Long> {

    private static final AtomicLong counter = new AtomicLong();
    private final long id;
    protected String name = "xxx";
    private double salary;

    public static final double DEFAULT_SALARY = 10000D;
    public static final String DEFAULT_NAME;

    static {
        System.out.println("Loading Employee class...");
        DEFAULT_NAME = System.getProperty("Emplyee.DEFAULT_NAME", "Unknown");
        counter.set(Long.getLong("Employee.counter", 0L));
    }

    public static long getCounter() {
        return counter.get();
    }

    protected static long generateId() {
        return counter.incrementAndGet();
    }

    static {
        System.out.println("Employee class loaded successfully...");
    }

    public Employee() {
        this(generateId());
    }
    
    public Employee(long id) {
        this.id = id;
    }

    public Employee(double salary) {
        this(generateId(), DEFAULT_NAME, salary);
    }

    public Employee(long id, String name) {
        this(id, name, DEFAULT_SALARY);
    }

    public Employee(final long id, final String name, final double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void appendInfo(StringBuilder sb) {
        sb
                .append("id=").append(id)
                .append(", name=").append(name)
                .append(", salary=").append(salary);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals");
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("compareTo");
        Employee other = (Employee) o;
        int result = (int) (id - other.id);
        if (result == 0) {
            result = this.name.compareTo(other.name);
        }
        return result;
    }
}
