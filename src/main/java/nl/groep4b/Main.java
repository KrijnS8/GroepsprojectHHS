package nl.groep4b;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.util.Arrays;

import static nl.groep4b.MenuBehaviour.*;

public class Main {

    //Variables:
    static ScannerV2 scanner = new ScannerV2();
    static ArrayList<MenuItem> mainMenuItems = new ArrayList<>();
    static ArrayList<MenuItem> roleMenuItems = new ArrayList<>();
    static Student loggedInStudent;
    static int choice;
    private static int role;

    static final String LIST = "list";
    static final String OPTIONS = "options";
    static final String BACK = "back";
    static final String EXIT = "exit";

    static final String MENU_ITEM_1 = "Lijst met examens";
    static final String MENU_ITEM_2 = "Lijst met studenten";
    static final String MENU_ITEM_3 = "Nieuwe gebruiker aanmaken";
    static final String MENU_ITEM_4 = "Student verwijderen";
    static final String MENU_ITEM_5 = "Examen afnemen";
    static final String MENU_ITEM_6 = "Is student geslaagd voor test?";
    static final String MENU_ITEM_7 = "Welke examens heeft student gehaald?";
    static final String MENU_ITEM_8 = "Welke student heeft de meeste examens gehaald";
    static final String MENU_ITEM_9 = "Maak een nieuw examen aan";
    static final String MENU_ITEM_EXIT = "Exit";
    static final String MENU_ITEM_BACK = "Terug naar het hoofdmenu";

    static final String ROLE_MENU_ITEM_1 = "ik ben een student";
    static final String ROLE_MENU_ITEM_2 = "ik ben een docent";
    static final String ROLE_MENU_ITEM_3 = "ik ben een beheerder";

    //Methods:
    public static void main(String[] args) {
        initialize();
        saveUsers();
    }

    public static void chooseRole() {
        System.out.println("Wat is jouw rol?");

        for (MenuItem item : roleMenuItems) {
            int index = roleMenuItems.indexOf(item) + 1;
            System.out.println(Wrapper.count(index, item.getString(), OPTIONS));
        }

        int input = scanner.nextInt();  //Get input from user
        if(input > 4 || input < 1){   // if users chooses out of this scope it gives error and reinitialize the method
            System.out.println("error: kies een nummer tussen de 1 en de 4");
            chooseRole();
        }
        else {
            if(input != 4)login(input);
            role = input;
        }
    }

    public static void login(int input)
    {
        System.out.println("Vul uw username in: ");
        String username = scanner.nextLine();

        System.out.println("Vul hier uw Wachtwoord in");
        String password = scanner.nextLine();
        byte[] passwordHashed = PasswordHasher.hashToByteArray(password);

        //put a specified type of user in the arraylist users
        ArrayList<User> users = new ArrayList<>();
        switch (input)
        {
            case 1:
            for (Student student: students){
                users.add(new User(student.getName(), student.getPasswordHashed()));
            }
            break;
            case 2:
                for(DocentBean docentBean: docentBeans){
                    users.add(new User(docentBean.getName(), docentBean.getPasswordHashed()));
                }
                break;
            case 3:
                for(BeheerderBean beheerderBean: beheerderBeans){
                    users.add(new User(beheerderBean.getName(), beheerderBean.getPasswordHashed()));
                }
        }
        //checks if Arraylist users contains user with correct name and password
        boolean passwordCorrect = false;
        for(User user: users){
            if (username.equals(user.getName()) & Arrays.equals(passwordHashed, user.getPasswordHashed()))
            {
                if(input == 1) saveLoggedInStudent(user.getName());
                passwordCorrect = true;
                break;
            }
        }

        if(!passwordCorrect){
            System.out.println("Gebruikersnaam of password is verkeerd");
            System.out.println("Klik op enter om nog een keer te proberen");
            System.out.println("Vul 0 in om uit het programma te gaan");
            if (scanner.nextLine().equals(""))
                login(input);
            else
                System.exit(0);
        }
    }

    public static void saveLoggedInStudent(String studentName){
        for(Student student: students){
            if(student.getName().equals(studentName)){
                loggedInStudent = student;
            }
        }
    }

    public static void initialize() {
        MenuItem student = new MenuItem(ROLE_MENU_ITEM_1, OPTIONS,1);
        MenuItem docent = new MenuItem(ROLE_MENU_ITEM_2, OPTIONS, 2);
        MenuItem admin = new MenuItem(ROLE_MENU_ITEM_3, OPTIONS, 3);

        MenuItem examList = new MenuItem(MENU_ITEM_1, OPTIONS,1);
        MenuItem studentList = new MenuItem(MENU_ITEM_2, OPTIONS, 2);
        MenuItem newUser = new MenuItem(MENU_ITEM_3, OPTIONS, 3);
        MenuItem delStudent = new MenuItem(MENU_ITEM_4, OPTIONS, 4);
        MenuItem doExam = new MenuItem(MENU_ITEM_5, OPTIONS, 5);
        MenuItem studentPassedExams = new MenuItem(MENU_ITEM_6, OPTIONS, 6);
        MenuItem examsPassed = new MenuItem(MENU_ITEM_7, OPTIONS, 7);
        MenuItem mostExamsPassed = new MenuItem(MENU_ITEM_8, OPTIONS, 8);
        MenuItem exit = new MenuItem(MENU_ITEM_EXIT, EXIT, 10);
        MenuItem addExam = new MenuItem(MENU_ITEM_9, OPTIONS, 9);

        roleMenuItems.add(student);
        roleMenuItems.add(docent);
        roleMenuItems.add(admin);
        roleMenuItems.add(exit);

        //Initialize Student and Exam arrays, so they have some examples to start with
        MenuBehaviour.initializeArrays();

        //Initialize the Main menu with menu items
        chooseRole();

        switch(role){
            case 1:
                mainMenuItems.add(examList);
                mainMenuItems.add(doExam);
                mainMenuItems.add(mostExamsPassed);
                mainMenuItems.add(exit);
                mainMenu();
                break;
            case 2:
                mainMenuItems.add(examList);
                mainMenuItems.add(studentList);
                mainMenuItems.add(newUser);
                mainMenuItems.add(delStudent);
                mainMenuItems.add(studentPassedExams);
                mainMenuItems.add(examsPassed);
                mainMenuItems.add(mostExamsPassed);
                mainMenuItems.add(addExam);
                mainMenuItems.add(exit);
                mainMenu();
                break;
            case 3:
                mainMenuItems.add(examList);
                mainMenuItems.add(studentList);
                mainMenuItems.add(newUser);
                mainMenuItems.add(delStudent);
                mainMenuItems.add(doExam);
                mainMenuItems.add(studentPassedExams);
                mainMenuItems.add(examsPassed);
                mainMenuItems.add(mostExamsPassed);
                mainMenuItems.add(addExam);
                mainMenuItems.add(exit);
                mainMenu();
            default:
                break;
        }
    }

    public static void saveUsers(){
        ArrayList<StudentBean> studentBeans = new ArrayList<>();

        for(Student student: students){
            studentBeans.add(student.getBean());
        }

        JsonConverter.objectToJson(studentBeans, "student.json");
        JsonConverter.objectToJson(docentBeans, "docent.json");
        JsonConverter.objectToJson(beheerderBeans, "beheerder.json");
    }

    //Create a new menuItem(in red) which asks if you want to go back to the main menu by typing 0 (zero)
    public static void backToMenu(){
        MenuItem back = new MenuItem(MENU_ITEM_BACK, BACK, 0);

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
        int correctedChoice = mainMenuItems.get(choice-1).getChoice();

        switch (correctedChoice){
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
                MenuBehaviour.newUser();
                backToMenu();
                break;
            case 4:
                MenuBehaviour.delStudent();
                backToMenu();
                break;
            case 5:
                MenuBehaviour.makeExam();
                backToMenu();
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
            case 9:
                MenuBehaviour.addExam();
                backToMenu();
                break;
        }
    }
}


