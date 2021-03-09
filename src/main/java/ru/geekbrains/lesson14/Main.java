/*
    1. Написать метод, которому в качестве аргумента передается не пустой одномерный
    целочисленный массив. Метод должен вернуть новый массив, который получен путем
    вытаскивания из исходного массива элементов, идущих после последней четверки.
    Входной массив должен содержать хотя бы одну четверку, иначе в методе
    необходимо выбросить RuntimeException.

    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

    2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть
    одной четверки или единицы, то метод вернет false; Написать набор тестов для этого
    метода (по 3-4 варианта входных данных).
    [ 1 1 1 4 4 1 4 4 ] -> true
    [ 1 1 1 1 1 1 ] -> false
    [ 4 4 4 4 ] -> false
    [ 1 4 4 1 1 4 3 ] -> false
 */
package ru.geekbrains.lesson14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int[] getNumbersAfterNumberFour(int[] array) {
        boolean flag = false;

        List<Integer> arrayAfterNumberFour = new ArrayList<>();

        for (int i : array) {
            if (flag) {
                arrayAfterNumberFour.add(i);
            }

            if (i == 4) {
                arrayAfterNumberFour.clear();
                flag = true;
            }
        }

        if (!flag)
            throw new RuntimeException();

        int[] newIntegerArray = new int[arrayAfterNumberFour.size()];

        for (int i = 0; i < arrayAfterNumberFour.size(); i++) {
            newIntegerArray[i] = arrayAfterNumberFour.get(i);
        }

        return newIntegerArray;
    }

    public static boolean findNumberFourInArray(int[] array) {
        boolean numberOne = false;
        boolean numberFour = false;

        for (int i : array) {
            if (i == 1)
                numberOne = true;

            else if (i == 4)
                numberFour = true;
        }

        return numberOne && numberFour;
    }
}
