package Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class PromotionImpl extends UnicastRemoteObject implements PromotionInterface {
    private Map<String, StudentInterface> students = new HashMap<>();

    @Override
    public void add_student(String studentId, String name, int age) throws RemoteException {
        StudentInterface student = new StudentImpl(name, age, studentId);
        students.put(studentId, student);
    }



    @Override
    public StudentInterface get_student(String studentId) throws RemoteException {
        return students.get(studentId);
    }

    @Override
    public double promotion_score() throws RemoteException {
        double totalScore = 0.0;
        int studentCount = students.size();
        for (StudentInterface student : students.values()) {
            totalScore += student.calculate_average();
        }
        if (studentCount == 0) {
            return 0.0; // Avoid division by zero
        }
        return totalScore / studentCount;
    }



}
