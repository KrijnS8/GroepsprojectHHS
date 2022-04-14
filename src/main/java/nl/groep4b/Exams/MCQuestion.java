package nl.groep4b.Exams;

import nl.groep4b.Beans.QuestionBean;
import nl.groep4b.Menu.ScannerV2;

public class MCQuestion extends Question {
    /**
     * This child class of Question is used to implement multiple choice questions
     */

    //Variables:
    private final String[] options;
    private final int correctAnswer;

    //Constructors:
    public MCQuestion(String text, int weight) {
        super(text, weight);

        ScannerV2 scanner = new ScannerV2();
        System.out.println("Hoeveel opties heeft de vraag?");
        int optionsNr = scanner.nextInt();
        scanner.nextLine();
        options = new String[optionsNr];
        for (int i = 0; i < optionsNr; i++) {
            System.out.println("Geef optie: " + (i + 1));
            options[i] = scanner.nextLine();
        }
        System.out.println("Welke optie is correct?");
        correctAnswer = scanner.nextInt();

    }

    public MCQuestion(String text, int weight, String[] options, int correctAnswer) {
        super(text, weight);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public MCQuestion(QuestionBean bean) {
        super(bean.getText(), bean.getWeight());
        this.options = bean.getMCQuestionOptions();
        this.correctAnswer = bean.getMCQuestionsCorrectAnswer();
    }

    //Methods:
    @Override
    public boolean askQuestion() {
        //Asks the question and waits for an answer, returns whether the answer given was correct.
        System.out.println(super.getText());
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + ": " + options[i]);
        }
        ScannerV2 scanner = new ScannerV2();
        int givenAnswer = scanner.nextInt();
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
        bean.setQuestionType(QuestionBean.MC_QUESTION_TYPE);
        bean.setMCQuestionOptions(options);
        bean.setMCQuestionsCorrectAnswer(correctAnswer);
        return bean;
    }
}
