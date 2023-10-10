package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) {
        try {
            ServerInterface server = new ServerInterfaceImpl();

            // Create or obtain a reference to the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099); // Use a different port if needed

            // Bind the remote object with a name in the registry
            registry.rebind("RemoteObjectName", server);

            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
