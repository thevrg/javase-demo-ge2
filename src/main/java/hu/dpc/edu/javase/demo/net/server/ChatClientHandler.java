package hu.dpc.edu.javase.demo.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author IQJB
 */
public class ChatClientHandler implements ChatClient, Runnable {

    private Socket socket;
    private volatile PrintStream out;
    private ChatRouter router;

    public ChatClientHandler(Socket socket, ChatRouter router) {
        this.socket = socket;
        this.router = router;
    }

    @Override
    public synchronized void send(String message) {
        out.println(message);
    }

    @Override
    public void run() {
        try (Socket clientConn = socket;
                PrintStream o = out = new PrintStream(clientConn.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(clientConn.getInputStream(), "UTF-8"));) {
            
            router.registerClient(this);

            String line;
            while ((line = in.readLine()) != null) {
                router.broadcast(socket.getRemoteSocketAddress() + ": " + line);
            }
        } catch (IOException exception) {
            System.out.println("Exception!");
            throw new RuntimeException(exception);
        } finally {
            router.unregisterClient(this);
        }
    }

}
