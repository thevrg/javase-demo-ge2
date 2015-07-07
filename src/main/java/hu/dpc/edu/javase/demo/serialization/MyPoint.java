package hu.dpc.edu.javase.demo.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author IQJB
 */
public class MyPoint extends BaseClass implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int y = 10;
    private transient BaseClass other;

    public MyPoint(int x, int y) {
        super(x);
        this.y = y;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(x);
        out.writeInt(y);
        out.writeObject(other);
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        x = in.readInt();
        y = in.readInt();
        other = (BaseClass) in.readObject();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BaseClass getOther() {
        return other;
    }

    public void setOther(BaseClass other) {
        this.other = other;
    }
    
    @Override
    public String toString() {
        return "MyPoint{" + "x=" + x + ", y=" + y + '}' + (other != null ? "other.x: " + other.x : "");
    }

}
