package hu.dpc.edu.javase.demo.io;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author IQJB
 */
public class IODemo {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String result = null;
        int lines;
        char[] buffer = new char[8192];
        try (LineNumberReader in = new LineNumberReader(new CharacterReplacerFilter('>','#',new CharacterReplacerFilter('<', '#', Files.newBufferedReader(Paths.get("pom.xml"), Charset.forName("UTF-8")))));
                StringWriter out = new StringWriter()) {

            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            result = out.toString();
            lines = in.getLineNumber();
        }

        System.out.println(result);
        System.out.println(lines);

    }
}
