package nl.groep4b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static nl.groep4b.Main.saveUsers;

public final class MenuBehaviour {
    /**
     * This class has static methods for the behaviour of several menu options
     */

    //Variables:
    static ScannerV2 scanner = new ScannerV2();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<DocentBean> docentBeans = new ArrayList<>();
    public static ArrayList<BeheerderBean> beheerderBeans = new ArrayList<>();
    static ArrayList<Exam> exams = new ArrayList<>();

    static final String LIST = "list";
    static final String OPTIONS = "options";

    //Methods:
    //Initialize the arrays
    public static void initializeArrays() {
        //gets all the HashMaps from Json file
        //student.json
        ArrayList<StudentBean> studentBeans = JsonConverter.jsonToObjectArrayList("student.json", StudentBean.class);
        for (StudentBean bean : studentBeans) {
            students.add(new Student(bean));
        }

        //docent.json
        ArrayList<DocentBean> docent = JsonConverter.jsonToObjectArrayList("docent.json", DocentBean.class);
        docentBeans.addAll(docent);

        //beheerder.json
        ArrayList<BeheerderBean> beheerder = JsonConverter.jsonToObjectArrayList("beheerder.json", BeheerderBean.class);
        beheerderBeans.addAll(beheerder);


        //Initialize exams with 2 exams: English 101 en Calculus 101
        Question ynTest = new YNQuestion("Is this test hard?",
                5,
                false);

        Question mcTest = new MCQuestion("Wie is onze docent",
                5,
                new String[]{"Anniek Wieman", "Anneke Wieman"},
                2);

        Question openTest = new OpenQuestion("Wat is de afkorting van Haagse HogeSchool",
                5,
                "HHS");

        Question[] testQuestions = {ynTest, mcTest, openTest};
        Question[] emptyQuestionList = {};
        Exam exampleEnglish1 = new Exam("English 101", testQuestions);
        Exam exampleCalculus1 = new Exam("Calculus 101", emptyQuestionList, 150);

        exams.add(exampleEnglish1);
        exams.add(exampleCalculus1);
    }

    //Print out "Studenten:" followed by the list of students(numbers before the students follow list convention as you
    // cannot interact further with the students that are presented)
    public static void showStudentList(String type) {
        System.out.println("Studenten:");

        String format = "%s (%d) ";

        for (Student student : students) {
            int index = students.indexOf(student) + 1;
            String studentString = new Formatter().format(format, student.getName(),
                    student.getStudentNr()).toString();

            System.out.println(Wrapper.count(index, studentString, type));
        }
    }

    //Print out "Examens:" followed by the list of exams(numbers before the exams follow list convention as you
    // cannot interact further with the exams that are presented)
    public static void showExamList(String type) {
        System.out.println("Examens:");

        for (Exam exam : exams) {
            int index = exams.indexOf(exam) + 1;

            System.out.println(Wrapper.count(index, exam.getExamTitle(), type));
        }
    }

    // asks for a name, age and studentNr and adds this to the list of students as a new Student Object
    // then show the list of students again
    public static void newUser()
    {
        System.out.println(" 1) Nieuwe student toevoegen\n 2) Nieuwe docent toevoegen\n 3) Nieuwe beheerder toevoegen\n 4) Terug naar het hoofdmenu");
        int menu = scanner.nextInt();
        switch (menu)
        {
            case 1:
                //creates new student
                try
                {
                    System.out.print("Naam: ");
                    String name = scanner.nextLine();

                    System.out.print("Leeftijd: ");
                    int age = scanner.nextInt();

                    System.out.print("Leerling nummer: ");
                    int leerlingNr = scanner.nextInt();

                    System.out.print("Leerling wachtwoord");
                    String password = scanner.nextLine();

                    students.add(new Student(name, age, leerlingNr, PasswordHasher.hashToByteArray(password)));
                    showStudentList(LIST);
                } catch (InputMismatchException ime)
                {
                    System.out.println("Error: Probeer het opnieuw");
                    newUser();
                }
            case 2:
                //creates new docent
                System.out.print("Naam: ");
                String name = scanner.nextLine();

                System.out.print("Wachtwoord: ");
                String password = scanner.nextLine();
                DocentBean docentBean = new DocentBean();
                docentBean.setName(name);
                try
                {
                    docentBean.setPasswordHashed(hashPassword(password));
                } catch (NoSuchAlgorithmException e)
                {
                    System.out.println("Iets ging verkeerd, probeer het opnieuw.");
                    newUser();
                }
                docentBeans.add(docentBean);
                break;
            case 3:
                //creates new beheerder
                System.out.print("Naam: ");
                name = scanner.nextLine();

                System.out.print("Wachtwoord: ");
                password = scanner.nextLine();
                BeheerderBean beheerderBean = new BeheerderBean();
                beheerderBean.setName(name);
                try
                {
                    beheerderBean.setPasswordHashed(hashPassword(password));
                } catch (NoSuchAlgorithmException e)
                {
                    System.out.println("Iets ging verkeerd, probeer het opnieuw.");
                    newUser();
                }
                beheerderBeans.add(beheerderBean);
            default:
                saveUsers();
            break;
        }
    }

    //returns hashed password
    public static byte[] hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
        return messageDigest.digest();
    }

    //Show the list of students and delete the student associated with the number that is typed
    public static void delStudent() {
        showStudentList(OPTIONS);
        System.out.println("Toets het nummer van de leerling die u wilt verwijderen.");
        int index = scanner.nextInt();
        students.remove(index - 1);
        saveUsers();
    }

    public static void makeExam() {
        System.out.println("Welk examen wilt u maken?");
        showExamList(LIST);
        int examIndex = scanner.nextInt();
        exams.get(examIndex - 1).doExam();
    }

    //Show the list of students and
    //gets the number of exams passed by the student associated with the number that is typed
    public static void examsByStudent() {
        showStudentList(OPTIONS);
        System.out.println("Toets het nummer van de leerling waarvan u de gehaalde examens wilt zien.");
        int index = scanner.nextInt();
        students.get(index - 1).printExamsPassed();
    }

    //Loops through all students and gets the number of exams passed then if the student has more exams passed than the
    //previous student in the list, change bestStudent to that student. and print out the result
    public static void mostExamsPassed() {
        int bestStudentExams = 0;
        String bestStudent = "Nobody";

        for (Student students : students) {
            if (students.getNrExamsPassed() >= bestStudentExams) {
                bestStudentExams = students.getNrExamsPassed();
                bestStudent = students.getName();
            }
        }

        System.out.println("De student met de meeste examens behaald is: " + bestStudent +
                " met " + bestStudentExams + " examens gehaald");
    }

    //Shows a list of all students, lets you choose one, shows a list of all exams, lets you choose one,
    //and check if the chosen student has passed the chosen exam
    public static void didStudentPass() {
        showStudentList(OPTIONS);

        System.out.println("Toets het nummer van de leerling waarvan u het gehaalde examen wilt zien.");
        int studentIndexScanner = scanner.nextInt();
        int studentIndex = studentIndexScanner - 1;

        showExamList(OPTIONS);

        System.out.println("Toets het nummer van het examen waarvan u wilt zien of " +
                getStudentName(studentIndex) + " het heeft gehaald.");
        int examIndexScanner = scanner.nextInt();
        int examIndex = examIndexScanner - 1;
        scanner.nextLine();

        if (getExamsPassed(studentIndex).size() != 0) {

            for (Exam exam : getExamsPassed(studentIndex)) {
                System.out.println(getExamTitle(examIndex));

                if (exam.getExamTitle().equals(exams.get(examIndex).getExamTitle())) {
                    System.out.println("Ja, " + getStudentName(studentIndex) +
                            " heeft " + getExamTitle(examIndex) + " gehaald!");
                }
                else {
                    System.out.println("Helaas, " + getStudentName(studentIndex) +
                            " heeft " + getExamsPassed(examIndex) + " nog niet gehaald.");
                }
            }
        }

        else {
            System.out.println("Helaas, " + getStudentName(studentIndex) +
                    " heeft " + getExamsPassed(examIndex) + " nog niet gehaald.");
        }
    }

    public static void addExam() {
        ScannerV2 scanner = new ScannerV2();
        System.out.println("Hoe heet het examen?");
        String examTitle = scanner.nextLine();

        System.out.println("""
                Wat voor een vraag wilt u toevoegen?
                1) Meerkeuze vraag
                2) Ja/Nee vraag
                3) Open vraag
                """);

        int choice = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Question> questions = new ArrayList<>();

        while (choice != 0) {
            System.out.println("Wat is de vraag?");
            String title = scanner.nextLine();
            System.out.println("Hoeveel punten is de vraag waard?");
            int weight = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    Question mcquestion = new MCQuestion(title, weight);
                    questions.add(mcquestion);
                }
                case 2 -> {
                    System.out.println("Is het goede antwoord true of false");
                    boolean correctAnswerYN = scanner.nextBoolean();
                    Question ynquestion = new YNQuestion(title, weight, correctAnswerYN);
                    questions.add(ynquestion);
                }
                case 3 -> {
                    System.out.println("What is the correct answer?");
                    String correctAnswerOpen = scanner.nextLine();
                    Question openquestion = new OpenQuestion(title, weight, correctAnswerOpen);
                    questions.add(openquestion);
                }
                default ->{
                }

            }

            System.out.println("""
                    Wat voor een vraag wilt u toevoegen?
                    1) Meerkeuze vraag
                    2) Ja/Nee vraag
                    3) Open vraag
                    0) Examen is klaar
                    """);

            choice = scanner.nextInt();
            scanner.nextLine();

        }

        Question[] questionArray = new Question[questions.size()];
        for (int i = 0; i < questions.size(); i++) {
            questionArray[i] = questions.get(i);
        }

        System.out.println("Hoeveel punten moet een student behalen om het examen te halen?");
        System.out.println("Vul -1 in voor de standaard berekening (de helft van de punten om het examen te halen)");
        int pointsToPass = scanner.nextInt();

        if (pointsToPass == -1) {
            Exam exam = new Exam(examTitle, questionArray);
            exams.add(exam);
        }
        else {
            Exam exam = new Exam(examTitle, questionArray, pointsToPass);
            exams.add(exam);
        }

        System.out.println("Het examen: " + examTitle + " is aangemaakt. Hij kan nu worden gemaakt");

    }

    //Getters
    public static String getStudentName(int i) {
        return students.get(i).getName();
    }
    public static ArrayList<Exam> getExamsPassed(int i){
        return students.get(i).getExamsPassed();
    }
    public static String getExamTitle(int i){
        return exams.get(i).getExamTitle();
    }
}