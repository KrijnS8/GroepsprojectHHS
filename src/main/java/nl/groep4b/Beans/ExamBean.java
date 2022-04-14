package nl.groep4b.Beans;

public class ExamBean {

    private String examTitle;
    private int pointsToPass;
    private int maxPoints;
    private QuestionBean[] questions;

    public ExamBean() {
        // Empty constructor
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public int getPointsToPass() {
        return pointsToPass;
    }

    public void setPointsToPass(int pointsToPass) {
        this.pointsToPass = pointsToPass;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public QuestionBean[] getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionBean[] questions) {
        this.questions = questions;
    }
}