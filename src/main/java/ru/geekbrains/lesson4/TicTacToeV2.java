package ru.geekbrains.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeV2 {
    private static final int MAP_SIZE = 3;
    private static final String TAB_SPACE = "  ";
    public static final String[] LINES_DIRECTIONS = {
            "horizontal",
            "vertical",
            "diagonalLeft",
            "diagonalRight"
    };

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = '⨉';
    private static final char DOT_O = '○';

    private static String userName = "";
    private static char userDot;
    private static char computerDot;
    private static int dotsForWin = 4;

    private static char[][] map;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public static void main(String[] args) {
        initMap();
        initUser();
        showMap();

        while(isNotVictory() || isMapFull()) {
            userTurn();

            if(isMapFull())
                break;

            computerTurn();
        }
    }

    private static void initMap() {
        map = new char[MAP_SIZE][MAP_SIZE];

        for (char[] row : map) {
            Arrays.fill(row, DOT_EMPTY);
        }

        if(dotsForWin > MAP_SIZE)
            dotsForWin = MAP_SIZE;
    }

    private static void initUser() {
        getUserName();
        getUserDot();
        welcomeMessage();
    }

    private static void getUserName() {
        System.out.print("Enter your name: ");
        userName = SCANNER.nextLine();
        System.out.println();
    }

    private static void getUserDot() {
        System.out.print("Select dot type " + DOT_X +
                " or " + DOT_O +
                "\nFor " + DOT_X + " press 1" +
                "\nFor " + DOT_O + " press 2" +
                "\n--> ");

        int selectedDotIndex = SCANNER.nextInt();

        if(selectedDotIndex == 1) {
            userDot = DOT_X;
            computerDot = DOT_O;
        }

        else {
            userDot = DOT_O;
            computerDot = DOT_X;
        }


    }

    private static void welcomeMessage() {
        System.out.println(
                "\nHello, " + userName + "." +
                "\nYour grid is " + map.length + " x " + map.length +
                "\nYour dot is " + userDot +
                "\nLet's start to play!\n"
        );
    }

    private static void showMap() {
        for (int row = 0; row <= map.length; row++) {
            for (int column = 0; column < map.length; column++) {
                if(row == 0) {
                    if (column == 0)
                        System.out.print(TAB_SPACE + " ");

                    System.out.print(ANSI_RESET + (column + 1) + TAB_SPACE);
                }

                else {
                    String color = dotColor(map[row - 1][column]);
                    System.out.print(color + map[row - 1][column] + TAB_SPACE);
                }

            }

            if(row + 1 <= map.length)
                System.out.print("\n" + ANSI_RESET + (row + 1) + TAB_SPACE);
        }

        System.out.println(ANSI_RESET + "\n");
    }

    private static String dotColor(char dot) {
        String color = ANSI_CYAN;

        if(dot == computerDot) {
            color = ANSI_RED;
        }

        else if(dot == userDot) {
            color = ANSI_YELLOW;
        }

        return color;
    }

    private static boolean isNotVictory() {
        for (String direction : LINES_DIRECTIONS) {
            String[] victory = victoryAttemptInAnyLine(direction, dotsForWin);

           if(victory != null) {
               victory(victory[0]);

               return false;
           }
        }

        return true;
    }

    private static void victory(String winner) {
        String winnerStr = winner.equals("User")
                ? ANSI_GREEN + userName + " WIN!!!" + ANSI_RESET
                : ANSI_RED + "Computer WIN!!!" + ANSI_RESET;

        System.out.println(winnerStr);
    }

    private static String[] victoryAttemptInAnyLine(String type, int dotsQuantity) {
        int computerDotsInDiagonal = 0,
                computerDotsInLine = 0,
                userDotsInDiagonal = 0,
                    userDotsInLine = 0;

        String[] found = {null, null};

        for (int row = 0; row < map.length; row++) {
            computerDotsInLine = 0;
            userDotsInLine = 0;

            for (int column = 0, diagonalRow = map.length - 1;
                 column < map.length;
                 column++, diagonalRow--) {

                char mapCoordinates = switch (type) {
                    case "vertical" -> map[column][row];
                    case "diagonalLeft" -> map[column][column];
                    case "diagonalRight" -> map[diagonalRow][column];
                    default -> map[row][column];
                };

                if(type.equals("vertical") || type.equals("horizontal")) {
                    if (mapCoordinates == userDot) {
                        userDotsInLine++;
                        computerDotsInLine = 0;
                    }

                    else if (mapCoordinates == computerDot) {
                        computerDotsInLine++;
                        userDotsInLine = 0;
                    }

                    else {
                        computerDotsInLine = 0;
                        userDotsInLine = 0;
                    }
                }

                else {
                    if (mapCoordinates == userDot) {
                        userDotsInDiagonal++;
                        computerDotsInDiagonal = 0;
                    }

                    else if (mapCoordinates == computerDot) {
                        computerDotsInDiagonal++;
                        userDotsInDiagonal = 0;
                    }

                    else {
                        computerDotsInDiagonal = 0;
                        userDotsInDiagonal = 0;
                    }
                }

                if (userDotsInLine >= dotsQuantity ||
                        userDotsInDiagonal >= dotsQuantity) {
                    found[0] = "User";
                    found[1] = type;

                    return found;
                }

                else if (computerDotsInLine >= dotsQuantity ||
                        computerDotsInDiagonal >= dotsQuantity) {
                    found[0] = "Computer";
                    found[1] = type;

                    return found;
                }
            }
        }

        return null;
    }

    private static boolean isMapFull() {
        for (char[] chars : map) {
            for (int column = 0; column < map.length; column++) {
                if (chars[column] == DOT_EMPTY)
                    return false;
            }
        }

        if(isNotVictory())
            System.out.println(ANSI_RED + "GAME OVER" + ANSI_RESET);

        return true;
    }

    private static void userTurn() {
        System.out.println(ANSI_YELLOW + "- Your turn - " + ANSI_RESET);

        int row, column;

        do {
            System.out.print("column number -> ");
            column = SCANNER.nextInt() - 1;

            System.out.print("row number -> ");
            row = SCANNER.nextInt() - 1;

            System.out.println();
        } while(isNotValidTurn(row, column, false));

        map[row][column] = userDot;

        showMap();
    }

    private static void computerTurn() {
        System.out.println(ANSI_RED + "- Computer turn - " + ANSI_RESET);

        int row, column;

        do {
            int[] coordinates = computerAI();
            row = coordinates[0];
            column = coordinates[1];
        } while(isNotValidTurn(row, column, true));

        System.out.println("row number -> " + (row + 1));
        System.out.println("column number -> " + (column + 1) + "\n");

        map[row][column] = computerDot;

        showMap();
    }

    private static boolean isNotValidTurn(int row, int column, boolean withoutMessage) {
        if(row < 0 || column < 0 || row > map.length || column > map.length) {
            if(!withoutMessage)
                System.out.println(ANSI_RED + "THE DOT IS OUT OF RANGE, TRY AGAIN" + ANSI_RESET);
            return true;
        }

        else if(map[row][column] != DOT_EMPTY)
        {
            if(!withoutMessage)
                System.out.println(ANSI_RED + "THE DOT IS ALREADY EXIST, TRY AGAIN" + ANSI_RESET);
            return true;
        }

        return false;
    }

    private static int[] computerAI() {
        int row = RANDOM.nextInt(map.length),
            column = RANDOM.nextInt(map.length);

        int[] coordinates = {row, column};

        for (String direction : LINES_DIRECTIONS) {
            int[] tryToFind = findUserWarningDotsQuantity(direction);
            if (tryToFind != null) {
                System.out.println("tryToFind: " + Arrays.toString(tryToFind));
                coordinates = tryToFind;
            }
        }

        return coordinates;
    }

    private static int[] findUserWarningDotsQuantity(String direction) {
        int[] coordinates = new int[2];

        int computerDotsInLine = 0,
               emptyDotsInLine = 0;

        for (int row = 0; row < map.length; row++) {
            for (int column = 0, diagonalRow = map.length - 1;
                 column < map.length;
                 column++, diagonalRow--) {

                char mapCoordinates = switch (direction) {
                    case "vertical" -> map[column][row];
                    case "diagonalLeft" -> map[column][column];
                    case "diagonalRight" -> map[diagonalRow][column];
                    default -> map[row][column];
                };

                if (mapCoordinates == userDot) {
                    computerDotsInLine++;
                }

                else if (computerDotsInLine > 1 && mapCoordinates == DOT_EMPTY) {
                    if (++emptyDotsInLine > 0) {
                        switch (direction) {
                            case "vertical" -> {
                                coordinates[0] = column;
                                coordinates[1] = row;
                            }
                            case "diagonalLeft" -> {
                                coordinates[0] = column;
                                coordinates[1] = column;
                            }
                            case "diagonalRight" -> {
                                coordinates[0] = diagonalRow;
                                coordinates[1] = column;
                            }
                            default -> {
                                coordinates[0] = row;
                                coordinates[1] = column;
                            }
                        }

                        System.out.println(
                                ANSI_GREEN +
                                "FOUND map[" + (coordinates[0] + 1) + "][" + (coordinates[1] + 1) + "]" +
                                ANSI_RESET + "\n"
                        );

                        return coordinates;
                    }
                } else {
                    computerDotsInLine = 0;
                }
            }
        }

        return null;
    }
}
