package hu.dpc.edu.javase.demo.concurrency;

/**
 *
 * @author IQJB
 */
public class ThreadDemo {

    private static void hello() {
        synchronized (ThreadDemo.class) {
            
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        MyTask r1 = new MyTask("R1");
        MyTask r2 = new MyTask("R2");
        
        Thread t1 = new Thread(r1, "T1");
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread t2 = new Thread(r2, "T2");
        Thread t3 = new Thread(r1, "T3");
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread t4 = new Thread(r2, "T4");
        t2.setPriority(Thread.MIN_PRIORITY);
        ThreadGroup tg = t1.getThreadGroup();

        t1.join();
        
        
        System.out.println("tg: " + tg);
        
        System.out.println("t1.isAlive() : " + t1.isAlive());
        
        System.out.println("starting T1");
        t1.start();
        
        
        System.out.println("t1.isAlive() : " + t1.isAlive());
        
        System.out.println("starting T2");
        t2.start();
        t3.start();
        t4.start();
        
        
        t1.join();
        t1.join();
        t1.join();
        t1.join();
        t1.join();
        t1.join();
        System.out.println("t1.isAlive() : " + t1.isAlive());
        System.out.println("main ends...");
        
//        Thread t3 = new Thread(r1, "T3");
//        t3.start();
        
        
    }

}
