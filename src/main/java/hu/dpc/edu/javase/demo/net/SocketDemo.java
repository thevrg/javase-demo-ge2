/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author IQJB
 */
public class SocketDemo {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("index.hu", 80)) {

            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            out.println("GET / HTTP/1.1");
            out.println("Host: index.hu");
            out.println();
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            String line;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            System.out.println("socket closed...");
        }
        
    }

}
