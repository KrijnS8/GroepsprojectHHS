package nl.groep4b;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class ExamTest {
    Question testMCquestion = new MCQuestion("het antwoord is 2", 5, new String[]{"1", "2", "3"}, 2);
    Question testOpenQuestion = new OpenQuestion("In welke stad is de HHS?", 5, "Den Haag");
    Question testYNquestion = new YNQuestion("Is dit een ja/nee vraag?", 5, true);
    Exam exam = new Exam("testExam", new Question[] {testMCquestion, testOpenQuestion, testYNquestion});

    @Test
    public void testQuestions() {
        assertEquals(testYNquestion.getText(), "Is dit een ja/nee vraag?");

        ByteArrayInputStream in = new ByteArrayInputStream("Den Haag".getBytes());
        System.setIn(in);
        assertTrue(testOpenQuestion.askQuestion());
        in = new ByteArrayInputStream("Delft".getBytes());
        System.setIn(in);
        assertFalse(testOpenQuestion.askQuestion());

        in = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in);
        assertTrue(testMCquestion.askQuestion());

    }

    @Test
    public void testExam() {
        /*String userInput = "2" + System.getProperty("line.separator")
                + "2" + System.getProperty("line.separator") + "true" + System.getProperty("line.separator");
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        exam.doExam();*/

        assertEquals("testExam", exam.getExamTitle());
        assertEquals(15/2, exam.getPointsToPass());
    }
}