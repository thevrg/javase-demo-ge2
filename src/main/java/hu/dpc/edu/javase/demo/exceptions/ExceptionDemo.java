package hu.dpc.edu.javase.demo.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author IQJB
 */
public class ExceptionDemo {

    /**
     *
     * @param fileName
     * @return
     * @throws hu.dpc.edu.javase.demo.exceptions.ReadFileException sdfsdfsdf
     * @throws FileNotFoundException flsdfl;ksdf
     * @throws UnsupportedEncodingException ksdjflksdjf
     * @throws IOException sdfslkdfjsdlj
     */
    public static String readFile(String fileName) throws ReadFileException, UnsupportedEncodingException, IOException {
        
        final String lineSeparator = System.getProperty("line.separator");
        try (MyResource r1 = new MyResource("R1", NullPointerException.class);
                MyResource r2 = new MyResource("R2", ArrayIndexOutOfBoundsException.class);
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
                MyResource r4 = new MyResource("R4", IllegalStateException.class);) {
            StringBuilder sb = new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(lineSeparator);
            }

            return sb.toString();
        } catch (FileNotFoundException ex) {
            throw new ReadFileException(fileName, ex);
        } finally {
            System.out.println("finally...");
        }
    }

    public static void main(String[] args) throws IOException {
        final String fileName = "pom.xml";

        try {
            String content = readFile(fileName);
            System.out.println("content: " + content);
        } catch (RuntimeException ex) {
            ex.addSuppressed(new Exception("Hello world"));
            ex.addSuppressed(new Exception("Hello world2"));
            ex.printStackTrace();
            for (Throwable suppressed : ex.getSuppressed()) {
                System.out.println("Found suppressed: " + suppressed);
                suppressed.printStackTrace();
            }
        } catch (ReadFileException ex) {
            System.out.println("File not fould: " + ex.getFileName());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IO Exception occured: " + ex.getClass().getName());
        }

        System.out.println("main ends normally..");

    }

}
