package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public interface EmployeeIterator {
    boolean hasNext();
    /**
     * 
     * @return
     * @throws IllegalStateException 
     */
    Employee next() throws IllegalStateException;
}
