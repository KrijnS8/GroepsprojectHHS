package nl.groep4b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam {
    String examTitle;
    int pointsToPass;
    int maxPoints = 0;
    Question[] questions;

    public Exam(String examTitle, Question[] questions){
        this.examTitle = examTitle;
        this.questions = questions;
        for (Question question : questions) {
            maxPoints += question.getWeight();
        }
        pointsToPass = maxPoints / 2;
    }

    public Exam(String examTitle, Question[] questions, int pointsToPass){
        this(examTitle, questions);
        this.pointsToPass = pointsToPass;
    }

    public String getExamTitle(){
        return examTitle;
    }

    public void doExam(){
        int points = 0;
        List<Question> questionList = Arrays.asList(questions);

        Collections.shuffle(questionList);

        questionList.toArray(questions);
        for (Question question : questions) {
            boolean correct = question.askQuestion();
            if (correct) {
                points += question.getWeight();
            }
        }
        if (points >= pointsToPass) {
            System.out.println("Congratulations, you passed the exam with a score of " + points + " out of " + maxPoints + ".");
        }
        else {
            System.out.println("Sorry, you failed the test. You got " + points + " points but you need at least " + pointsToPass + "points.");
        }
    }
}