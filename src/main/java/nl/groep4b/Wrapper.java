package nl.groep4b;

import java.util.Formatter;

public final class Wrapper {
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

    //Methods:
    //takes a color and a string and changes the string to that color
    public static String color(String color, String string){
        String formatBlack = ANSI_BLACK + "%s" + ANSI_RESET;
        String formatRed = ANSI_RED + "%s" + ANSI_RESET;
        String formatGreen = ANSI_GREEN + "%s" + ANSI_RESET;
        String formatYellow = ANSI_YELLOW + "%s" + ANSI_RESET;
        String formatBlue = ANSI_BLUE + "%s" + ANSI_RESET;
        String formatPurple = ANSI_PURPLE + "%s" + ANSI_RESET;
        String formatCyan = ANSI_CYAN + "%s" + ANSI_RESET;
        String formatWhite = ANSI_WHITE + "%s" + ANSI_RESET;

        //colors available: "black", "red", "green", "yellow", "blue", "purple", "cyan" and "white"(must be spelled correct)
        return switch (color) {
            case "black" -> new Formatter().format(formatBlack, string).toString();
            case "red" -> new Formatter().format(formatRed, string).toString();
            case "green" -> new Formatter().format(formatGreen, string).toString();
            case "yellow" -> new Formatter().format(formatYellow, string).toString();
            case "blue" -> new Formatter().format(formatBlue, string).toString();
            case "purple" -> new Formatter().format(formatPurple, string).toString();
            case "cyan" -> new Formatter().format(formatCyan, string).toString();
            case "white" -> new Formatter().format(formatWhite, string).toString();
            default -> string;
        };
    }

    //Takes a string and formats it with numbers and tabs where necessary
    public static String count(int count, String string, String type){
        String formatOptions = color("cyan", "    %d) ") + "%s";
        String formatList = color("white", "    %d) ") + "%s";
        String formatBack = color("cyan", "%d) ") + "%s";
        String formatDefault = "%d) %s";

        return switch (type){
            case "options" -> new Formatter().format(formatOptions, count, string).toString();
            case "list" -> new Formatter().format(formatList, count, string).toString();
            case "back" -> new Formatter().format(formatBack, count, string).toString();
            default -> new Formatter().format(formatDefault, count, string).toString();
        };
    }
}
