package nl.groep4b;

import java.util.ArrayList;

import static nl.groep4b.Main.saveData;

public class Exam {
    /**
     * This class is used to create and take Exams
     */
    //Variables:
    private final String examTitle;
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

    public Exam(ExamBean bean) {
        this.examTitle = bean.getExamTitle();
        this.pointsToPass = bean.getPointsToPass();
        this.maxPoints = bean.getMaxPoints();

        ArrayList<Question> returnedQuestions = new ArrayList<>();
        for (QuestionBean questionBean : bean.getQuestions()) {
            switch (questionBean.getQuestionType()) {
                case MC -> returnedQuestions.add(new MCQuestion(questionBean));
                case OPEN -> returnedQuestions.add(new OpenQuestion(questionBean));
                case YESNO -> returnedQuestions.add(new YNQuestion(questionBean));
                default -> throw new RuntimeException();
            }
        }

        this.questions = returnedQuestions.toArray(new Question[0]);
    }

    //Methods:
    public void doExam(ScannerV2 scan){
        int points = 0;
        for (Question question : questions) {
            boolean correct = question.askQuestion(scan);
            if (correct) {
                points += question.getWeight();
            }
        }
        if (points >= pointsToPass) {
            Main.loggedInStudent.passedExam(this);
            System.out.println("Congratulations, you passed the exam with a score of " + points + " out of " + maxPoints + ".");
        }
        else {
            System.out.println("Sorry, you failed the test. You got " + points + " points but you need at least " + pointsToPass + "points.");
        }
        saveData();
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

    //Getters:
    public int getPointsToPass() {
        return pointsToPass;
    }
    public String getExamTitle(){
        return examTitle;
    }
}