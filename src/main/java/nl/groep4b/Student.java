package nl.groep4b;

import nl.groep4b.beans.StudentBean;
import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Student {
    String name;
    int age;
    int studentNr;
    ArrayList<Exam> examsPassed = new ArrayList<>();
    byte[] passwordHashed;

    public Student(String name, int age, int studentNr, byte[] password, boolean needsToBeHashed){
        this.name = name;
        this.age = age;
        this.studentNr = studentNr;
        if(needsToBeHashed)
        {
            try
            {
                //hashes password
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(password);
                this.passwordHashed = messageDigest.digest();
            } catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        } else {
            this.passwordHashed = password;
        }
    }

    public Student(StudentBean bean) {
        this.name = bean.getName();
        this.age = bean.getAge();
        this.studentNr = bean.getStudentNr();
        this.passwordHashed = Base64.decodeBase64(bean.getPasswordHashed());
    }

    public byte[] getPasswordHashed()
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
                System.out.println(Wrapper.count(examsPassed.indexOf(exam)+1, exam.getExamTitle(), Main.LIST));
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
        bean.setPasswordHashed(passwordHashed);
        return bean;
    }
}
