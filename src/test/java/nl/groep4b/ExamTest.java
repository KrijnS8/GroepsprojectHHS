package nl.groep4b;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ExamTest {
    Question testMCquestion = new MCQuestion("het antwoord is 2", 5, new String[]{"1", "2", "3"}, 2);
    Question testOpenQuestion = new OpenQuestion("In welke stad is de HHS?", 5, "Den Haag");
    Question testYNquestion = new YNQuestion("Is dit een ja/nee vraag?", 5, true);
    Exam exam = new Exam("testExam", new Question[] {testMCquestion, testOpenQuestion, testYNquestion});
    Exam oneQexam = new Exam("testExam", new Question[] {testYNquestion});

    @Test
    public void testQuestions() {
        assertEquals(testYNquestion.getText(), "Is dit een ja/nee vraag?");

        String[] answers1 = new String[] {"Den Haag"};
        assertTrue(testOpenQuestion.askQuestion(new TestScanner(answers1)));

        String[] answers2 = new String[] {"true"};
        assertTrue(testYNquestion.askQuestion(new TestScanner(answers2)));

        String[] answers3 = new String[] {"2"};
        assertTrue(testMCquestion.askQuestion(new TestScanner(answers3)));

    }

    @Test
    public void testExam() {
        Main.loggedInStudent = new Student("name1", 88, -1, "wachtwoord".getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String[] answers = new String[] {"2", "Den Haag", "true"};
        exam.doExam(new TestScanner(answers));
        assertTrue(outContent.toString().contains("Congratulations, you passed the exam with a score of 15 out of 15."));

        assertEquals("testExam", exam.getExamTitle());
        assertEquals(15/2, exam.getPointsToPass());
    }
}