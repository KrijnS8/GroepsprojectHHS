package nl.groep4b.Menu;

public class MenuItem {
    /**
     * This class is for creating menu Items as options or as list
     */

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
