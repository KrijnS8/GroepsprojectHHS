package nl.groep4b.Beans;

import nl.groep4b.Exams.Exam;

import java.util.ArrayList;

public class StudentBean {

    //Variables:
    private String name;
    private int age;
    private int studentNr;
    private ArrayList<Exam> examsPassed = new ArrayList<>();
    private String passwordHashed;

    //Constructors:
    public StudentBean() {
        // Empty constructor
    }

    //Getters:
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getStudentNr() {
        return studentNr;
    }
    public ArrayList<Exam> getExamsPassed() {
        return examsPassed;
    }
    public String getPasswordHashed()
    {
        return passwordHashed;
    }

    //Setters:
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setStudentNr(int studentNr) {
        this.studentNr = studentNr;
    }
    public void setExamsPassed(ArrayList<Exam> examsPassed) {
        this.examsPassed = examsPassed;
    }
    public void setPasswordHashed(String passwordHashed)
    {
        this.passwordHashed = passwordHashed;
    }
}
