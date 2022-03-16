package nl.groep4b;

import java.util.ArrayList;

public class Student {
    String name;
    int age;
    int studentNr;
    ArrayList<Exam> examsPassed = new ArrayList<>();

    public Student(String name, int age, int studentNr){
        this.name = name;
        this.age = age;
        this.studentNr = studentNr;
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
}