package hu.dpc.edu.javase.demo.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author IQJB
 */
public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        MyCallableTask task1 = new MyCallableTask("Task1", 2000);
        MyCallableTask task2 = new MyCallableTask("Task2", 3000);
        Future<String> task1Future = es.submit(task1);
        Future<String> task2Future = es.submit(task2);
        
        Thread.sleep(10);
        
//        task1Future.cancel(true);
        
        es.shutdown();
        
        
        
//        String result2 = task2Future.get();
//        System.out.println("task2.result: " + result2);
//        String result1 = task1Future.get();
//        System.out.println("task1.result: " + result1);

        //es.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("main ends...");
    }
}
