package hu.dpc.edu.javase.demo.main;

/**
 *
 * @author IQJB
 */
public class LoopDemo {
    public static void main(String[] args) {
        valami:
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            for (int j = 0; j < 10; j++) {
                if (j % 3 == 2) {
                    break valami;
                }
                System.out.println("hello: " + arg + ", " + j);
            }
            System.out.println("FORI : " + i);
        }
    }
}
