package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class EmployeeParserException extends RuntimeException{

    public EmployeeParserException() {
    }

    public EmployeeParserException(String message) {
        super(message);
    }

    public EmployeeParserException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
