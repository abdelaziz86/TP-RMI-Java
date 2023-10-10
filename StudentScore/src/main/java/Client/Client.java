package Client;

import Server.ServerInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Locate the RMI registry running on the server
            Registry registry = LocateRegistry.getRegistry("localhost", 1099); // Replace "localhost" with the server's hostname

            // Lookup the remote object by name
            ServerInterface server = (ServerInterface) registry.lookup("RemoteObjectName");

            // Call the remote methods
            server.add_student("123", "John", 20);
            server.get_student("123").add_exam("Math", 90.0, 0.5);
            server.get_student("123").add_exam("Science", 85.0, 0.5);


            server.add_student("456", "Alice", 22);
            server.get_student("456").add_exam("Math", 88.0, 0.4);
            server.get_student("456").add_exam("Science", 92.0, 0.6);

            double promotionScore = server.promotion_score();
            System.out.println("Promotion Score: " + promotionScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

