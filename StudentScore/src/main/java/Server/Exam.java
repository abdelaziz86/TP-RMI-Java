package Server;

import java.io.Serializable;

public class Exam implements Serializable  {
    private String name;
    private double score;
    private double coefficient;

    public Exam(String name, double score, double coefficient) {
        this.name = name;
        this.score = score;
        this.coefficient = coefficient;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
