package Server;

import Student.PromotionImpl;
import Student.PromotionInterface;
import Student.StudentImpl;
import Student.StudentInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) {
        try {
            PromotionInterface promotion = new PromotionImpl();
            StudentInterface student1 = new StudentImpl("John", 20, "123");
            StudentInterface student2 = new StudentImpl("Alice", 22, "456");

            promotion.add_student("123", "John", 20);
            promotion.add_student("456", "Alice", 22);

            Registry registry = LocateRegistry.createRegistry(1099); // Use a different port if needed
            registry.rebind("PromotionService", promotion);
            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

