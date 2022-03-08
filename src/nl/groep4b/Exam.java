package nl.groep4b;

public class Exam {
    String examTitle;
    int maxPoints = 100;

    public Exam(String examTitle){
        this.examTitle = examTitle;
    }

    public Exam(String examTitle, int maxPoints){
        this(examTitle);
        this.maxPoints = maxPoints;
    }

    public String getExamTitle(){
        return examTitle;
    }

    public void doExam(){

    }
}
