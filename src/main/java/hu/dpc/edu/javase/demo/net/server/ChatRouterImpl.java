package hu.dpc.edu.javase.demo.net.server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class ChatRouterImpl implements ChatRouter{

    private final List<ChatClient>clients = new ArrayList<>();
    
    @Override
    public synchronized void broadcast(String message) {
        System.out.println("Broadcasting : " + message);
        for (ChatClient client : clients) {
            client.send(message);
        }
    }

    @Override
    public synchronized void registerClient(ChatClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void unregisterClient(ChatClient client) {
        clients.remove(client);
    }
    
}
