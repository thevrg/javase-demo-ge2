package hu.dpc.edu.javase.demo.serialization;

import java.io.Serializable;

/**
 *
 * @author IQJB
 */
public class BaseClass {
    protected int x = 5;

    public BaseClass() {
    }

    public BaseClass(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
}
