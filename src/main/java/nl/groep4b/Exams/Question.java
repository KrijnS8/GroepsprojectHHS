package nl.groep4b.Exams;

import nl.groep4b.Beans.QuestionBean;
import nl.groep4b.Menu.ScannerV2;

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

