package nl.groep4b.beans;

import nl.groep4b.Exam;
import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;

public class StudentBean {

    private String name;
    private int age;
    private int studentNr;
    private ArrayList<Exam> examsPassed = new ArrayList<>();
    private byte[] passwordHashed;

    public StudentBean() {
        // Empty constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentNr() {
        return studentNr;
    }

    public String getPasswordHashed()
    {
        return Base64.encodeBase64String(passwordHashed);
    }

    public void setPasswordHashed(byte[] passwordHashed)
    {
        this.passwordHashed = passwordHashed;
    }

    public void setStudentNr(int studentNr) {
        this.studentNr = studentNr;
    }

    public ArrayList<Exam> getExamsPassed() {
        return examsPassed;
    }

    public void setExamsPassed(ArrayList<Exam> examsPassed) {
        this.examsPassed = examsPassed;
    }
}
