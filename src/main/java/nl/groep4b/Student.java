package nl.groep4b;

import nl.groep4b.beans.StudentBean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Student {
    String name;
    int age;
    int studentNr;
    ArrayList<Exam> examsPassed = new ArrayList<>();
    String passwordHashed;

    public Student(String name, int age, int studentNr, String password){
        this.name = name;
        this.age = age;
        this.studentNr = studentNr;
        try
        {
            //hashes password
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            this.passwordHashed = new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
    }

    public Student(StudentBean bean) {
        this.name = bean.getName();
        this.age = bean.getAge();
        this.studentNr = bean.getStudentNr();
    }

    public String getPasswordHashed()
    {
        return passwordHashed;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getStudentNr(){
        return studentNr;
    }

    public int getNrExamsPassed(){
        return examsPassed.size();
    }

    public ArrayList<Exam> getExamsPassed() {
        return examsPassed;
    }

    //Print a list of passed exams by the student as a list
    public void printExamsPassed() {
        if(examsPassed.size() > 0)
            for (Exam exam : examsPassed){
                System.out.println(Wrapper.count(examsPassed.indexOf(exam)+1, exam.examTitle, Main.LIST));
        }
        else {
            System.out.println("Deze student heeft nog geen examens gehaald.");
        }

    }

    public StudentBean getBean() {
        StudentBean bean = new StudentBean();
        bean.setName(name);
        bean.setAge(age);
        bean.setStudentNr(studentNr);
        bean.setExamsPassed(examsPassed);
        return bean;
    }
}
