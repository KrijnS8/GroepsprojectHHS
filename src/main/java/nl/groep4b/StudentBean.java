package nl.groep4b;

import java.util.ArrayList;
import java.util.Objects;

public class StudentBean {

    //Variables:
    private String name;
    private int age;
    private int studentNr;
    private ArrayList<ExamBean> examsPassed = new ArrayList<>();
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
    public ArrayList<ExamBean> getExamsPassed() {
        //return examsPassed;
        return this.examsPassed;
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
    public void setExamsPassed(ArrayList<ExamBean> examsPassed) {
this.examsPassed = examsPassed;
    }
    public void setPasswordHashed(String passwordHashed)
    {
        this.passwordHashed = passwordHashed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentBean that = (StudentBean) o;
        return age == that.age && studentNr == that.studentNr && name.equals(that.name) && examsPassed.equals(that.examsPassed) && passwordHashed.equals(that.passwordHashed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, studentNr, examsPassed, passwordHashed);
    }
}
