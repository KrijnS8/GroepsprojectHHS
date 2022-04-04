package nl.groep4b;

public class MenuItem {

    //Variables:
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";

    String string;
    String type;
    int choice;

    //Constructors:
    public MenuItem(String string, String type, int choice){
        this.type = type;
        this.choice = choice;

        if (this.type.equals("exit") || this.type.equals("back")) {
            this.string = Wrapper.color("red", string);
        }
        else{
            this.string = string;
        }

    }

    //Getters:
    public String getString() {
        return string;
    }
    public String getType() {
        return type;
    }
    public int getChoice() {
        return choice;
    }

}
