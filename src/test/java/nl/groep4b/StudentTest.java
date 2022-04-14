package nl.groep4b;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    String name1 = "Benjamin";
    int age1 = 19;
    int studentNr1 = 18073856;

    String name2 = "Raphael";
    int age2 = 18;
    int studentNr2 = 76483893;

    String name3 = "Kees";
    int age3 = 21;
    int studentNr3 = 21045835;

    String wachtwoord = "wachtwoord";

    ArrayList<Student> testStudents = new ArrayList<>();

    @Test
    public void createStudentTest(){
        Student student1 = new Student(name1, age1, studentNr1, wachtwoord.getBytes(), false);
        Student student2 = new Student(name2, age2, studentNr2, wachtwoord.getBytes(), false);
        Student student3 = new Student(name3, age3, studentNr3, wachtwoord.getBytes(), false);

        testStudents.add(student1);
        testStudents.add(student2);
        testStudents.add(student3);

        assertEquals("Benjamin", student1.getName());
        assertEquals(19, student1.getAge());
        assertEquals(18073856, student1.getStudentNr());

        assertEquals("Raphael", student2.getName());
        assertEquals(18, student2.getAge());
        assertEquals(76483893, student2.getStudentNr());

        assertEquals("Kees", student3.getName());
        assertEquals(21, student3.getAge());
        assertEquals(21045835, student3.getStudentNr());
    }

    @Test
    public void examPassedTest(){
        for(Student student: testStudents){
            assertEquals(0, student.getNrExamsPassed());
        }
    }

}
