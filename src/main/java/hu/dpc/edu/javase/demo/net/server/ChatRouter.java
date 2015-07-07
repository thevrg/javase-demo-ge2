package hu.dpc.edu.javase.demo.net.server;

/**
 *
 * @author IQJB
 */
public interface ChatRouter {
    public void broadcast(String message);
    public void registerClient(ChatClient client);
    public void unregisterClient(ChatClient client);
}
