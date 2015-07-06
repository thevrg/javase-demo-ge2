package hu.dpc.edu.javase.demo.exceptions;

/**
 *
 * @author IQJB
 */
public class ReadFileException extends Exception {

    private final String fileName;
    
    private static String createMessage(String fileName) {
        return "File not found: " + fileName;
    }

    public ReadFileException(String fileName) {
        super(createMessage(fileName));
        this.fileName = fileName;
    }


    public ReadFileException(String fileName, Throwable cause) {
        super(createMessage(fileName),cause);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
