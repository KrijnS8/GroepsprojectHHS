package nl.groep4b;

import java.util.ArrayList;
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

    public Exam(String examTitle, Question[] questions, int points){
        this(examTitle, questions);
        this.pointsToPass = points;
    }

    public Exam(ExamBean bean) {
        this.examTitle = bean.getExamTitle();
        this.pointsToPass = bean.getPointsToPass();
        this.maxPoints = bean.getMaxPoints();

        ArrayList<Question> returnedQuestions = new ArrayList<>();
        for (QuestionBean questionBean : bean.getQuestions()) {
            switch (questionBean.getQuestionType()) {
                case QuestionBean.MC_QUESTION_TYPE -> returnedQuestions.add(new MCQuestion(questionBean));
                case QuestionBean.OPEN_QUESTION_TYPE -> returnedQuestions.add(new OpenQuestion(questionBean));
                case QuestionBean.YN_QUESTION_TYPE -> returnedQuestions.add(new YNQuestion(questionBean));
                default -> throw new RuntimeException();
            }
        }

        this.questions = returnedQuestions.toArray(new Question[0]);
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

    public ExamBean toBean() {
        ExamBean bean = new ExamBean();
        bean.setExamTitle(examTitle);
        bean.setPointsToPass(pointsToPass);
        bean.setMaxPoints(maxPoints);

        ArrayList<QuestionBean> questionBeans = new ArrayList<>();
        for (Question question : questions) {
            questionBeans.add(question.getBean());
        }

        bean.setQuestions(questionBeans.toArray(new QuestionBean[0]));
        return bean;
    }
}