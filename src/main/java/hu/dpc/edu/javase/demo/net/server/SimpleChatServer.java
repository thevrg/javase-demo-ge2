package hu.dpc.edu.javase.demo.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author IQJB
 */
public class SimpleChatServer {

    private int port;
    private ExecutorService executor;

    public SimpleChatServer(int port) throws IOException {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(12);
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        ChatRouter chatRouter = new ChatRouterImpl();
        while (true) {
            Socket clientConn = serverSocket.accept();
            ChatClientHandler clientHandler = new ChatClientHandler(clientConn, chatRouter);
            executor.execute(clientHandler);
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleChatServer server = new SimpleChatServer(8000);
        server.start();
    }
}
