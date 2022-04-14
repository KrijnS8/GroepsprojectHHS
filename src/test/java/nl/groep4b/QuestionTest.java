package nl.groep4b;

import org.junit.Test;

import static org.junit.Assert.*;


public class QuestionTest {
    //Initialize exams with 2 exams: English 101 en Calculus 101
    Question Question1 = new YNQuestion("Is this test hard?", 5, false);
    Question Question2 = new MCQuestion("Wie is onze docent", 5, new String[]{"Anniek Wieman", "Anneke Wieman"}, 2);
    Question Question3 = new OpenQuestion("Wat is de afkorting van Haagse HogeSchool", 5, "HHS");

        @Test
        public void QuestionTest1(){
            String[] answer = new String[] {"false"};
            boolean YourAns = Question1.askQuestion(new TestScanner(answer));
            String Question1text = "Is this test hard?";
            int Question1Weight = 5;

            assertEquals(Question1text, Question1.getText());
            assertEquals(Question1Weight, Question1.getWeight());
            assertTrue(YourAns);

        }
        @Test
        public void QuestionTest2(){
            String[] answer = new String[] {"2"};
            boolean YourAns = Question2.askQuestion(new TestScanner(answer));

            String Question2text = "Wie is onze docent";
            int Question2Weight = 5;

            assertEquals(Question2text, Question2.getText());
            assertEquals(Question2Weight, Question2.getWeight());
            assertTrue(YourAns);

        }
        @Test
        public void Questiontest3(){
            String[] answer = new String[] {"HHS"};
            boolean YourAns = Question3.askQuestion(new TestScanner(answer));
            String Question3text = "Wat is de afkorting van Haagse HogeSchool";
            int Question3Weight = 5;

            assertEquals(Question3text, Question3.getText());
            assertEquals(Question3Weight, Question3.getWeight());
            assertTrue(YourAns);
        }

    }
