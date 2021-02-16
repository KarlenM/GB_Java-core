/*
    1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
    или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
    в какой именно ячейке лежат неверные данные.

    3. В методе main() вызвать полученный метод, обработать возможные исключения
    MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */
package ru.geekbrains.lesson9;

import ru.geekbrains.lesson7.Colorize;
import ru.geekbrains.lesson9.exceptions.MyArrayDataException;
import ru.geekbrains.lesson9.exceptions.MyArraySizeException;

import java.util.Arrays;
import java.util.Random;

public class Main {
    /*
        В конце урока был вопрос почему выбрали checked или unchecked Исключение.
        Ответ: Выбрал unchecked Exceptions потому что их не надо обязательно обрабатывать.
     */

    private static final String ARRAY_SIZE = "4x4";
    private static String[][] strArray;
    private static int arraySum = 0;

    public static void main(String[] args) throws Exception {
        strArray = new String[4][4];

        // Два вида заполнения массива для тестов
        // fillArrayWith(strArray, "10");
        fillArrayRandom(strArray);

        // Печать массива ддя тестов
        printArray(strArray);

        try {
            homeworkMethod();
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Program error: " + e.getMessage());
        } finally {
            System.out.println("Array sum is: " + arraySum);
        }
    }

    private static void homeworkMethod() {
        int[] arraySize = getIntValuesFromTheString();

        isArraySizeCorrect(strArray, arraySize[0], arraySize[1]);

        castStringArrayToIntArray();
    }

    private static int[] getIntValuesFromTheString() {
        String[] strSplit = ARRAY_SIZE.split("x");

        return new int[]{
                Integer.parseInt(strSplit[0].trim()),
                Integer.parseInt(strSplit[1].trim())
        };
    }

    private static void isArraySizeCorrect(String[][] haystack, int row, int column) {
        if (haystack.length != row ||
                haystack[0].length != column)
            throw new MyArraySizeException("Wrong array size");

        System.out.println(
                Colorize.make(
                        "ok",
                        "Array have correct size"
                )
        );
    }

    private static void castStringArrayToIntArray() {
        System.out.println(
                Colorize.make(
                        "ok",
                        "Conversion to int and sum"
                )
        );

        int[][] newIntArray = new int[4][4];

        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                try {
                    newIntArray[i][j] = Integer.parseInt(strArray[i][j].trim());
                    arraySum += newIntArray[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Wrong data in array newIntArray[" + i + "][" + j + "]");
                }
            }
        }
    }

    private static void fillArrayWith(String[][] strArray, String fillWith) {
        for (String[] row : strArray) {
            Arrays.fill(row, fillWith);
        }

        System.out.println(
                Colorize.make(
                        "ok",
                        "Array filled"
                )
        );
    }

    private static void fillArrayRandom(String[][] strArray) {
        Random random = new Random();

        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                int nextInt = random.nextInt(94) + 33;

                strArray[i][j] = i % 2 == 0 || j == 0
                    ? "" + nextInt
                    : Character.toString((char) nextInt);
            }
        }
    }

    private static void printArray(String[][] strArray) {
        for (String[] row : strArray) {
            for (String column : row) {
                System.out.print(column + "\t");
            }
            System.out.println("\n");
        }
    }
}
