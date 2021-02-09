package ru.geekbrains.lesson7;

public class Colorize {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {

    }

    public static String make(String type, String message) {
        String result;

        if(type.equalsIgnoreCase("warning"))
            result = ANSI_YELLOW + message + ANSI_RESET;

        else if(type.equalsIgnoreCase("error"))
            result = ANSI_RED + message + ANSI_RESET;

        else if(type.equalsIgnoreCase("ok"))
            result = ANSI_GREEN + message + ANSI_RESET;

        else
            result = ANSI_RESET + message + ANSI_RESET;

        return result;
    }
}
