package hu.dpc.edu.javase.demo.concurrency;

/**
 *
 * @author IQJB
 */
public class WaitNotifyDemo {

    private static Thread P1;
    private static Thread P2;
    private static Thread C1;
    private static Thread C2;

    private static volatile boolean timeToQuit;

    public static boolean isTimeToQuit() {
        return timeToQuit;
    }

    public static void shutdown() {
        timeToQuit = true;
        P1.interrupt();
        P2.interrupt();
        C1.interrupt();
        C2.interrupt();
    }

//    public static void println(String str) {
//        System.out.println(str);
//    }
//    
//    public static void push(MyStack stack, char c) {
//        stack.push(c);
//    }
    public static void main(String[] args) throws InterruptedException {
        MyStack stack = new MyStack();
        Producer p = new Producer(stack);
        Consumer c = new Consumer(stack);
        P1 = new Thread(p, "P1");
        P2 = new Thread(p, "P2");
        C1 = new Thread(c, "C1");
        C2 = new Thread(c, "C2");

        P1.start();
        P2.start();
        C1.start();
        C2.start();
        
        Thread.sleep(13000);
        shutdown();
    }
}
