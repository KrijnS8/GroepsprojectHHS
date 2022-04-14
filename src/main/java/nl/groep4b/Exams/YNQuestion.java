package nl.groep4b.Exams;

import nl.groep4b.Beans.QuestionBean;
import nl.groep4b.Menu.ScannerV2;

public class YNQuestion extends Question {
    /**
     * This child class of question is used to implement yes-or-no questions
     */

    //Variables:
    private final boolean correctAnswer;

    //Constructors:
    public YNQuestion(String text, int weight, boolean correctAnswer) {
        super(text, weight);
        this.correctAnswer = correctAnswer;
    }

    public YNQuestion(QuestionBean bean) {
        super(bean.getText(), bean.getWeight());
        this.correctAnswer = bean.isYNQuestionCorrectAnswer();
    }

    //Methods:
    @Override
    public boolean askQuestion() {
        //Asks the question and waits for an answer, returns whether the answer given was correct.
        System.out.println(super.getText());
        System.out.println("true of false");
        ScannerV2 scanner = new ScannerV2();
        boolean givenAnswer = scanner.nextBoolean();
        System.out.println();
        // Gives you the correct answer if you gave the wrong answer
        if (correctAnswer == givenAnswer) {
            return true;
        } else {
            System.out.println("Dat is fout, het goede antwoord is: " + correctAnswer);
            System.out.println();
            return false;
        }
    }

    @Override
    public QuestionBean getBean() {
        QuestionBean bean = new QuestionBean();
        bean.setText(this.getText());
        bean.setWeight(this.getWeight());
        bean.setQuestionType(QuestionBean.YN_QUESTION_TYPE);
        bean.setYNQuestionCorrectAnswer(correctAnswer);
        return bean;
    }
}
