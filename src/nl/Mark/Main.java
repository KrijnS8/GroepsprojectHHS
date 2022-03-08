package nl.Mark;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<MenuItem> mainMenuItems = new ArrayList<>();
    static int choice;

    static final String LIST = "list";
    static final String OPTIONS = "options";
    static final String BACK = "back";
    static final String EXIT = "exit";

    static final String MENU_ITEM_1 = "Lijst met examens";
    static final String MENU_ITEM_2 = "Lijst met studenten";
    static final String MENU_ITEM_3 = "Nieuwe student inschrijven";
    static final String MENU_ITEM_4 = "Student verwijderen";
    static final String MENU_ITEM_5 = "Examen afnemen";
    static final String MENU_ITEM_6 = "Is student geslaagd voor test?";
    static final String MENU_ITEM_7 = "Welke examens heeft student gehaald?";
    static final String MENU_ITEM_8 = "Welke student heeft de meeste examens gehaald";
    static final String MENU_ITEM_EXIT = "Exit";
    static final String MENU_ITEM_BACK = "Terug naar het hoofdmenu";

    public static void main(String[] args) {
        initialize();

        mainMenu();
    }

    public static void initialize() {

        //Initialize Student and Exam arrays, so they have some examples to start with
        MenuBehaviour.initializeArrays();

        //Initialize the Main menu with menu items
        MenuItem examList = new MenuItem(MENU_ITEM_1, OPTIONS);
        MenuItem studentList = new MenuItem(MENU_ITEM_2, OPTIONS);
        MenuItem newStudent = new MenuItem(MENU_ITEM_3, OPTIONS);
        MenuItem delStudent = new MenuItem(MENU_ITEM_4, OPTIONS);
        MenuItem doExam = new MenuItem(MENU_ITEM_5, OPTIONS);
        MenuItem studentPassedExams = new MenuItem(MENU_ITEM_6, OPTIONS);
        MenuItem examsPassed = new MenuItem(MENU_ITEM_7, OPTIONS);
        MenuItem mostExamsPassed = new MenuItem(MENU_ITEM_8, OPTIONS);
        MenuItem exit = new MenuItem(MENU_ITEM_EXIT, EXIT);


        mainMenuItems.add(examList);
        mainMenuItems.add(studentList);
        mainMenuItems.add(newStudent);
        mainMenuItems.add(delStudent);
        mainMenuItems.add(doExam);
        mainMenuItems.add(studentPassedExams);
        mainMenuItems.add(examsPassed);
        mainMenuItems.add(mostExamsPassed);
        mainMenuItems.add(exit);

    }

    //Create a new menuItem(in red) which asks if you want to go back to the main menu by typing 0 (zero)
    public static void backToMenu(){
        MenuItem back = new MenuItem(MENU_ITEM_BACK, BACK);

        System.out.println("\n" + Wrapper.count(0,  back.getString(), BACK));

        int backConfirm = scanner.nextInt();

        if (backConfirm == 0){
            System.out.print("\033[H\033[2J");
            Main.mainMenu();
        }
        else {
            System.out.println("Om terug te keren naar het hoofdmenu typ 0 (nul)");
            backToMenu();
        }
    }

    public static void mainMenu() {
        System.out.println("Menu:");

        for (MenuItem item : mainMenuItems) {
            int index = mainMenuItems.indexOf(item) + 1;
            System.out.println(Wrapper.count(index, item.getString(), OPTIONS));
        }

        choice = scanner.nextInt();
        switch (choice){
            case 0:
                break;
            case 1:
                MenuBehaviour.showExamList(LIST);
                backToMenu();
                break;
            case 2:
                MenuBehaviour.showStudentList(LIST);
                backToMenu();
                break;
            case 3:
                MenuBehaviour.newStudent();
                backToMenu();
                break;
            case 4:
                MenuBehaviour.delStudent();
                backToMenu();
                break;
            case 5:

                break;
            case 6:
                MenuBehaviour.didStudentPass();
                backToMenu();
                break;
            case 7:
                MenuBehaviour.examsByStudent();
                backToMenu();
                break;
            case 8:
                MenuBehaviour.mostExamsPassed();
                backToMenu();
                break;
        }
    }
}


