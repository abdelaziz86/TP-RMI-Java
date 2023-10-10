package Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl extends UnicastRemoteObject implements StudentInterface {
    private String name;
    private int age;
    private String Id;
    private List<Exam> exams = new ArrayList<>();

    public StudentImpl(String name, int age, String Id) throws RemoteException {
        this.name = name;
        this.age = age;
        this.Id = Id;
    }

    @Override
    public String getId() throws RemoteException {
        return Id;
    }

    @Override
    public void add_exam(String examName, double score, double coefficient) throws RemoteException {
        exams.add(new Exam(examName, score, coefficient));
    }

    @Override
    public String print_exams() throws RemoteException {
        StringBuilder result = new StringBuilder();
        for (Exam exam : exams) {
            result.append(exam.getName()).append(": ").append(exam.getScore()).append(", ");
        }
        return result.toString();
    }

    @Override
    public double calculate_average() throws RemoteException {
        double totalScore = 0.0;
        double totalCoefficient = 0.0;
        for (Exam exam : exams) {
            totalScore += exam.getScore() * exam.getCoefficient();
            totalCoefficient += exam.getCoefficient();
        }
        if (totalCoefficient == 0.0) {
            return 0.0; // Avoid division by zero
        }
        return totalScore / totalCoefficient;
    }





}
