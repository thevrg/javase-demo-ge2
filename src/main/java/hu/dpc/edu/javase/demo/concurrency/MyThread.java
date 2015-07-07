package hu.dpc.edu.javase.demo.concurrency;

/**
 *
 * @author IQJB
 */
public class MyThread extends Thread {

    
    private int i;

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }
    
    

    @Override
    public void run() {
        String tn = Thread.currentThread().getName();
        for (; i < 50; i++) {
            System.out.println(tn + ": i=" + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
