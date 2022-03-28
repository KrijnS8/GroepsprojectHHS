package nl.groep4b;

import java.util.Optional;
import java.util.Scanner;

public abstract class Question {
    private final String text;
    public abstract boolean askQuestion();
    public abstract QuestionBean getBean();
    private final int weight;

    public Question(String text, int weight) {
        this.text = text;
        this.weight = weight;
    }

    public Question(QuestionBean bean) {
        this.text = bean.getText();
        this.weight = bean.getWeight();
    }

    public int getWeight() {
        return weight;
    }

    public String getText() {
        return text;
    }
}

class MCQuestion extends Question {
    private final String[] options;
    private final int correctAnswer;

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

    @Override
    public boolean askQuestion() {
        System.out.println(super.getText());
        for (int i = 0; i < options.length; i++) {
            System.out.println(i+1 + ": " + options[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int givenAnswer = scanner.nextInt();
        System.out.println();
        if (correctAnswer == givenAnswer) {
            return true;
        }
        else {
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

class OpenQuestion extends Question {
    private final String correctAnswer;

    public OpenQuestion(String text, int weight, String correctAnswer) {
        super(text, weight);
        this.correctAnswer = correctAnswer;
    }

    public OpenQuestion(QuestionBean bean) {
        super(bean.getText(), bean.getWeight());
        this.correctAnswer = bean.getOpenQuestionCorrectAnswer();
    }

    @Override
    public boolean askQuestion() {
        System.out.println(super.getText());
        Scanner scanner = new Scanner(System.in);
        String givenAnswer = scanner.nextLine();
        System.out.println();
        if (correctAnswer.equals(givenAnswer)) {
            return true;
        }
        else {
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

class YNQuestion extends Question {
    private final boolean correctAnswer;

    public YNQuestion(String text, int weight, boolean correctAnswer) {
        super(text, weight);
        this.correctAnswer = correctAnswer;
    }

    public YNQuestion(QuestionBean bean) {
        super(bean.getText(), bean.getWeight());
        this.correctAnswer = bean.isYNQuestionCorrectAnswer();
    }

    @Override
    public boolean askQuestion() {
        System.out.println(super.getText());
        System.out.println("true of false");
        Scanner scanner = new Scanner(System.in);
        boolean givenAnswer = scanner.nextBoolean();
        System.out.println();
        if (correctAnswer == givenAnswer) {
            return true;
        }
        else {
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
