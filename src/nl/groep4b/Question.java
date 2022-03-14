package nl.groep4b;

import java.util.Scanner;

abstract class Question {
    private String text;
    public abstract boolean askQuestion();
    private int weight;

    public Question(String text, int weight) {
        this.text = text;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getText() {
        return text;
    }
}

class MCQuestion extends Question {
    private String[] options;
    private int correctAnswer;

    public MCQuestion(String text, int weight, String[] options, int correctAnswer) {
        super(text, weight);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion() {
        System.out.println(super.getText());
        for (int i = 0; i < options.length; i++) {
            System.out.println(i+1 + ": " + options[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int givenAnswer = scanner.nextInt();
        System.out.println();
        return (correctAnswer == givenAnswer);
    }

}

class OpenQuestion extends Question {
    private String correctAnswer;

    public OpenQuestion(String text, int weight, String correctAnswer) {
        super(text, weight);
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion() {
        System.out.println(super.getText());
        Scanner scanner = new Scanner(System.in);
        String givenAnswer = scanner.nextLine();
        System.out.println();
        return (correctAnswer.equals(givenAnswer));
    }
}

class YNQuestion extends Question {
    private boolean correctAnswer;

    public YNQuestion(String text, int weight, boolean correctAnswer) {
        super(text, weight);
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion() {
        System.out.println(super.getText());
        System.out.println("true of false");
        Scanner scanner = new Scanner(System.in);
        boolean givenAnswer = scanner.nextBoolean();
        System.out.println();
        return (givenAnswer == correctAnswer);
    }
}