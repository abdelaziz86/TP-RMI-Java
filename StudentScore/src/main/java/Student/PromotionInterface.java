package Student;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PromotionInterface extends Remote {
    void add_student(String studentId, String name, int age) throws RemoteException;
    StudentInterface get_student(String studentId) throws RemoteException;
    double promotion_score() throws RemoteException;
}
