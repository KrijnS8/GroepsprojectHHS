package nl.groep4b;
import nl.groep4b.beans.ExamBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam {
    /**
     * This class is used to create and take Exams
     */
    //Variables:
    private String examTitle;
    private int pointsToPass;
    private int maxPoints = 0;
    Question[] questions;

    //Constructors:
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

    //Methods:
    public void doExam(){
        int points = 0;
        /*List<Question> questionList = Arrays.asList(questions);

        Collections.shuffle(questionList);

        questionList.toArray(questions);*/
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

    public ExamBean toBean() {
        ExamBean bean = new ExamBean();
        bean.setExamTitle(examTitle);
        bean.setPointsToPass(pointsToPass);
        bean.setMaxPoints(maxPoints);
        bean.setQuestions(questions);
        return bean;
    }

    //Getters:
    public int getPointsToPass() {
        return pointsToPass;
    }
    public String getExamTitle(){
        return examTitle;
    }
}