// Мкртчян Карлен
// Домашнее задание 2
package ru.geekbrains.lesson2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Если нельзя было выводить массив с помощью Arrays.toString()
        // То сделал два других метода: printArray(array) и arrayToString(array)

        // Task 1
        changeArrayValue();

        // Task 2
        fillArray();

        // Task 3
        multiplyNumbersInArray();

        // Task 4
        createTwoDimensionalSquare();

        // Task 5
        findMinMax();

        // Task 6
        int[] balanceArray = {4, 2, 4, 1, 2, 1, 5, 1};
        checkBalance(balanceArray);

        // Task 7
        int[] valueChangeArray = {1, 2, 3, 4, 5, 6, 7, 8};
        arrayValueChangePos(valueChangeArray, 2);
    }

    /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */
    private static void changeArrayValue() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        println("- Task 1 - \n" +
                "Before: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++)
            array[i] = array[i] == 1 ? 0 : 1;

        print2ln("After:  " + Arrays.toString(array));
    }

    /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    */
    private static void fillArray() {
        int[] array = new int[8];

        for (int i = 0; i < array.length; i++)
            array[i] = i * 3;

        print2ln("- Task 2 - \n" +
                 "Filled array: " + Arrays.toString(array));
    }

    /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        и числа меньшие 6 умножить на 2;
     */
    private static void multiplyNumbersInArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        println("- Task 3 -\nBefore: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        print2ln("After: " + Arrays.toString(array));
    }

    /*
        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    private static void createTwoDimensionalSquare() {
        int[][] square = new int[6][6];

        println("- Task 4 -");

        for (int i = 0; i < square.length; i++) {
            int[] row = square[i];

            for (int j = 0; j < row.length; j++) {
                // Диагональ слева направо
                if (j == i) {
                    System.out.print("1  ");
                }

                // Диагональ справа на лево
                else if (j == square.length - (i + 1)) {
                    System.out.print("1  ");
                }

                else {
                    System.out.print(row[j] + "  ");
                }
            }

            newLine();
        }

        newLine();
    }

    /*
        5. ** Задать одномерный массив и найти в нем минимальный
        и максимальный элементы (без помощи интернета);
    */
    private static void findMinMax() {
        int[] array = {4, 5, 3, 6, 9, 10, 2, 1, 7, 8};
        int min = array[0], max = array[0];

        for (int a : array) {
            if(max < a)
                max = a;

            if(min > a)
                min = a;
        }

        print2ln("- Task 5 -\n" +
                "Array: " + Arrays.toString(array) + "\n" +
                "Min value: " + min + "\n" +
                "Max value: " + max);
    }

    /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
        части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
        эти символы в массив не входят.
    */
    private static void checkBalance(int[] array) {
        int leftSide = 0;
        boolean found = false;
        String str = "[ ";

        for (int i = 0; i < array.length; i++) {
            int rightSide = 0;

            leftSide += array[i];

            for (int j = i + 1; j < array.length; j++) {
                rightSide += array[j];
            }

            str += array[i];

            if(leftSide != rightSide && i != array.length - 1) {
                str += ", ";
            }

            else if(i != array.length - 1) {
                str += " || ";
                found = true;
            }
        }

        str = found
                ? str + " ]"
                : "not found";

        print2ln("- Task 6 -\n" +
                 "Array: " + arrayToString(array) + "\n" +
                 "Equals sides: " + str);
    }

    /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n
        (может быть положительным, или отрицательным), при этом метод должен сместить
        все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
        задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ]
        при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2
        (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     */
    private static void arrayValueChangePos(int[] array, int n) {
        println("- Task 7 -");

        int pos = 0;

        println("Array: " + arrayToString(array));

        for (int i = 0; i < n; i++) {
            int firstNumber = array[0];

            for (int j = 0; j < array.length; j++) {
                if(j + 1 < array.length)
                    array[j] = array[j + 1];
            }

            array[array.length - 1] = firstNumber;
        }

        println("Shift " + n + " to the left: " + arrayToString(array));
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

    private static void printArray(int[] array) {
        String str = "";

        for (int i = 0; i < array.length; i++) {
            str += i == array.length - 1
                    ? array[i]
                    : array[i] + ", ";
        }

        println("[ " + str + " ]");
    }

    private static String arrayToString(int[] array) {
        String str = "";

        for (int i = 0; i < array.length; i++) {
            str += i == array.length - 1
                    ? array[i]
                    : array[i] + ", ";
        }

        return "[ " + str + " ]";
    }
}
