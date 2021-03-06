package nl.groep4b;

public class QuestionBean {

    private String text;
    private int weight;
    private questionSort questionType;

    // MCQuestionBean variables
    private String[] MCQuestionOptions;
    private int MCQuestionsCorrectAnswer;

    // OpenQuestionBean variables
    private String OpenQuestionCorrectAnswer;

    // YNQuestionBean variables
    private boolean YNQuestionCorrectAnswer;

    public QuestionBean() {
        // Empty constructor
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public questionSort getQuestionType() {
        return questionType;
    }

    public void setQuestionType(questionSort questionType) {
        this.questionType = questionType;
    }

    public String[] getMCQuestionOptions() {
        return MCQuestionOptions;
    }

    public void setMCQuestionOptions(String[] MCQuestionOptions) {
        this.MCQuestionOptions = MCQuestionOptions;
    }

    public int getMCQuestionsCorrectAnswer() {
        return MCQuestionsCorrectAnswer;
    }

    public void setMCQuestionsCorrectAnswer(int MCQuestionsCorrectAnswer) {
        this.MCQuestionsCorrectAnswer = MCQuestionsCorrectAnswer;
    }

    public String getOpenQuestionCorrectAnswer() {
        return OpenQuestionCorrectAnswer;
    }

    public void setOpenQuestionCorrectAnswer(String openQuestionCorrectAnswer) {
        OpenQuestionCorrectAnswer = openQuestionCorrectAnswer;
    }

    public boolean isYNQuestionCorrectAnswer() {
        return YNQuestionCorrectAnswer;
    }

    public void setYNQuestionCorrectAnswer(boolean YNQuestionCorrectAnswer) {
        this.YNQuestionCorrectAnswer = YNQuestionCorrectAnswer;
    }
}

enum questionSort{
    OPEN,
    YESNO,
    MC
        }