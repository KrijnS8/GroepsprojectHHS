package nl.groep4b;

public abstract class Question {
    /**
     * This class is used to create general Questions
     */

    //Variables:
    private final String text;
    public abstract boolean askQuestion();
    private final int weight;

    //Constructors:
    public Question(String text, int weight) {
        this.text = text;
        this.weight = weight;
    }

    //Getters:
    public int getWeight() {
        return weight;
    }
    public String getText() {
        return text;
    }
}

class MCQuestion extends Question {
    /**
     * This child class of Question is used to implement multiple choice questions
     */

    //Variables:
    private final String[] options;
    private final int correctAnswer;

    //Constructors:
    public MCQuestion(String text, int weight) {
        super(text, weight);

        Scanner2 scanner = new Scanner2();
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

    //Methods:
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

    //Methods:
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

    //Methods:
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