package Server;
import Client.StudentInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    void add_student(String Id, String name, int age) throws RemoteException;
    StudentInterface get_student(String studentId) throws RemoteException;
    double promotion_score() throws RemoteException;
}

