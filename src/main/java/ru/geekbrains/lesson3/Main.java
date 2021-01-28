// Мкртчян Карлен
// Домашнее задание 3
package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static final int GUESS_NUMBER_ATTEMPTS = 3;
    static final int GUESS_NUMBER_MAX_VALUE = 9;

    public static void main(String[] args) {
        // Task 1
        guessTheNumber();

        // Task 2
        guessTheWord();
    }

    /*
        Написать программу, которая загадывает случайное число от 0 до 9 и пользователю
        дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
        больше ли указанное пользователем число, чем загаданное, или меньше.
        После победы или проигрыша выводится запрос –
        «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    */
    public static void guessTheNumber() {
        int attempts = GUESS_NUMBER_ATTEMPTS;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int guessNumber = random.nextInt(GUESS_NUMBER_MAX_VALUE);

        do {
            String userText = attempts == GUESS_NUMBER_ATTEMPTS
                    ? "- Task 1 -\nGuess the number from 0 to 9: "
                    : "Try again: ";

            print(userText);

            int enteredNumber = scanner.nextInt();

            if (enteredNumber != guessNumber) {
                String guessResult = enteredNumber > guessNumber
                        ? "the number is less"
                        : "the number is above";

                print2ln("Wrong! " + guessResult);
            }

            else {
                print2ln("Right!");
                break;
            }
        } while(--attempts > 0);

        String userResult = attempts == 0
                ? "You lose, guessed number: " + guessNumber
                : "You WIN!!!";

        print(userResult + "\nWant to play again? 1 – yes / 0 – no");
        // либо print(userResult + "\nПовторить игру еще раз? 1 – да / 0 – нет");

        int playAgain = scanner.nextInt();

        newLine();

        if(playAgain == 1)
            guessTheNumber();
    }

    /*
        2. * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
        "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
        "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
        Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        apple – загаданное apricot - ответ игрока ap############# (15 символов,
        чтобы пользователь не мог узнать длину слова) Для сравнения двух слов посимвольно можно пользоваться:
        String str = "apple"; char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой
        позиции Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
    */
    public static void guessTheWord() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int attempts = 0;

        String[] words = {
                "apple", "orange", "lemon",
                "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon",
                "leak", "kiwi", "mango",
                "mushroom", "nut", "olive",
                "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin",
                "potato"
        };

        String guessedWord = words[random.nextInt(words.length)].toLowerCase(),
               enteredWord = "";

        // Подсказка
        print2ln("- Task 2 -\nGuessed word: " + guessedWord);

        do {
            String response = attempts == 0
                    ? "Guess the word: "
                    : "Try again: ";

            print(response);

            enteredWord = scanner.next().toLowerCase();

            newLine();

            if(guessedWord.equals(enteredWord)) {
                println("You WIN!!! " + attempts + " attempts");
                break;
            }

            else {
                println("Wrong, guessed letters is " + guessedLetters(guessedWord, enteredWord));
            }

            attempts++;
        } while(!guessedWord.equals(enteredWord));
    }

    private static String guessedLetters(String guessedWord, String enteredWord) {
        String result = "";

        char[] answerAttempt = new char[15];

        /*
            Заменил на встроенный метод Arrays.fill();
            for (int i = 0; i < answerAttempt.length; i++) {
                answerAttempt[i] = '#';
            }
        */
        Arrays.fill(answerAttempt, '#');

        /*
            Заменил на встроенный метод Math.min();
            int guessedWordLength = guessedWord.length() > enteredWord.length()
                ? enteredWord.length()
                : guessedWord.length();
         */
        int guessedWordLength = Math.min(guessedWord.length(), enteredWord.length());

        for (int i = 0; i < guessedWordLength; i++) {
            if(guessedWord.charAt(i) == enteredWord.charAt(i)) {
                answerAttempt[i] = guessedWord.charAt(i);
            }
        }

        for(char letter : answerAttempt) {
            result += letter;
        }

        return result;
    }

    private static void print(String str) {
        System.out.print(str);
    }

    private static void println(String str) {
        System.out.println(str);
    }

    private static void print2ln(String str) {
        println(str + "\n");
    }

    private static void newLine() {
        println("");
    }
}

