package nl.groep4b.Exams;

import nl.groep4b.Beans.QuestionBean;
import nl.groep4b.Menu.ScannerV2;

public class OpenQuestion extends Question {
    /**
     * This child class of Question is used to implement open questions
     */

    //Variables
    private final String correctAnswer;

    //Constructors:
    public OpenQuestion(String text, int weight, String correctAnswer) {
        super(text, weight);
        this.correctAnswer = correctAnswer;
    }

    public OpenQuestion(QuestionBean bean) {
        super(bean.getText(), bean.getWeight());
        this.correctAnswer = bean.getOpenQuestionCorrectAnswer();
    }

    //Methods:
    @Override
    public boolean askQuestion() {
        //Asks the question and waits for an answer, returns whether the answer given was correct.
        System.out.println(super.getText());
        ScannerV2 scanner = new ScannerV2();
        String givenAnswer = scanner.nextLine();
        System.out.println();
        // Gives you the correct answer if you gave the wrong answer
        if (correctAnswer.equals(givenAnswer)) {
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
        bean.setQuestionType(QuestionBean.OPEN_QUESTION_TYPE);
        bean.setOpenQuestionCorrectAnswer(correctAnswer);
        return bean;
    }
}
