package nl.groep4b;

public abstract class Question {
    /**
     * This class is used to create general Questions
     */

    //Variables:
    private final String text;
    public abstract boolean askQuestion();
    public abstract QuestionBean getBean();
    private final int weight;

    //Constructors:
    public Question(String text, int weight) {
        this.text = text;
        this.weight = weight;
    }

    public Question(QuestionBean bean) {
        this.text = bean.getText();
        this.weight = bean.getWeight();
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
            System.out.println(i+1 + ": " + options[i]);
        }
        ScannerV2 scanner = new ScannerV2();
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