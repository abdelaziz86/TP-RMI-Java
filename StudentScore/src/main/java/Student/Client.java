package Student;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099); // Replace "localhost" with the server's hostname
            PromotionInterface promotion = (PromotionInterface) registry.lookup("PromotionService");

            // Add exams for students
            promotion.get_student("123").add_exam("Math", 90, 0.5);
            promotion.get_student("123").add_exam("History", 85, 0.3);
            promotion.get_student("456").add_exam("Math", 95, 0.6);
            promotion.get_student("456").add_exam("History", 88, 0.4);

            // Calculate and print the average scores
            System.out.println("John's average score: " + promotion.get_student("123").calculate_average());
            System.out.println("Alice's average score: " + promotion.get_student("456").calculate_average());

            // Calculate and print the promotion average score
            System.out.println("Promotion's average score: " + promotion.promotion_score());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
