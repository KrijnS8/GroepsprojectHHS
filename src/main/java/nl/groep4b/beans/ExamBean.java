package nl.groep4b.beans;

import nl.groep4b.Question;

public class ExamBean {

    //Variables:
    private String examTitle;
    private int pointsToPass;
    private int maxPoints;
    private Question[] questions;

    //Constructors:
    public ExamBean() {
        // Empty constructor
    }

    //Getters:
    public String getExamTitle() {
        return examTitle;
    }
    public int getPointsToPass() {
        return pointsToPass;
    }
    public int getMaxPoints() {
        return maxPoints;
    }
    public Question[] getQuestions() {
        return questions;
    }

    //Setters:
    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }
    public void setPointsToPass(int pointsToPass) {
        this.pointsToPass = pointsToPass;
    }
    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}






