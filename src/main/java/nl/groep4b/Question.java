package nl.groep4b;

import java.util.Scanner;

public abstract class Question {
    //General class for questions
    private final String text;
    public abstract boolean askQuestion();
    private final int weight;

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
    //implements a multiple choice question
    private final String[] options;
    private final int correctAnswer;

    public MCQuestion(String text, int weight, String[] options, int correctAnswer) {
        super(text, weight);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion() {
        //Asks the question and waits for an answer, returns whether the answer given was correct.
        System.out.println(super.getText());
        for (int i = 0; i < options.length; i++) {
            System.out.println(i+1 + ": " + options[i]);
        }
        Scanner2 scanner = new Scanner2();
        int givenAnswer = scanner.nextInt();
        System.out.println();
        // Gives you the correct answer if you gave the wrong answer
        if (correctAnswer == givenAnswer) {
            return true;
        }
        else {
            System.out.println("Dat is fout, het goede antwoord is: " + correctAnswer);
            System.out.println();
            return false;
        }
    }

}

class OpenQuestion extends Question {
    private final String correctAnswer;

    public OpenQuestion(String text, int weight, String correctAnswer) {
        super(text, weight);
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion() {
        //Asks the question and waits for an answer, returns whether the answer given was correct.
        System.out.println(super.getText());
        Scanner2 scanner = new Scanner2();
        String givenAnswer = scanner.nextLine();
        System.out.println();
        // Gives you the correct answer if you gave the wrong answer
        if (correctAnswer.equals(givenAnswer)) {
            return true;
        }
        else {
            System.out.println("Dat is fout, het goede antwoord is: " + correctAnswer);
            System.out.println();
            return false;
        }
    }
}

class YNQuestion extends Question {
    private final boolean correctAnswer;

    public YNQuestion(String text, int weight, boolean correctAnswer) {
        super(text, weight);
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion() {
        //Asks the question and waits for an answer, returns whether the answer given was correct.
        System.out.println(super.getText());
        System.out.println("true of false");
        Scanner2 scanner = new Scanner2();
        boolean givenAnswer = scanner.nextBoolean();
        System.out.println();
        // Gives you the correct answer if you gave the wrong answer
        if (correctAnswer == givenAnswer) {
            return true;
        }
        else {
            System.out.println("Dat is fout, het goede antwoord is: " + correctAnswer);
            System.out.println();
            return false;
        }
    }
}