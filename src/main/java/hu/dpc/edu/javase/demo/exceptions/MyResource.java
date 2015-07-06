package hu.dpc.edu.javase.demo.exceptions;

/**
 *
 * @author IQJB
 */
public class MyResource implements AutoCloseable {

    private String name;
    private Class exType;

    public MyResource(String name, Class exType) {
        this.name = name;
        this.exType = exType;
    }

    @Override
    public void close() throws RuntimeException {
        try {
            System.out.println(name + ": close()");
            RuntimeException ex = (RuntimeException) exType.newInstance();
            throw ex;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

}
