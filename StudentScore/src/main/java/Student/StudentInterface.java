package Student;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
    void add_exam(String examName, double score, double coefficient) throws RemoteException;
    String print_exams() throws RemoteException;
    double calculate_average() throws RemoteException;
    String getId() throws RemoteException;


}
