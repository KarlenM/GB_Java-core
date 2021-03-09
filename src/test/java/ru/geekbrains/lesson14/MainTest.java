package ru.geekbrains.lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainTest {
    // Дополнительный тест на исключение RuntimeException
    @Test
    void getNumbersAfterNumberFourException() {
        System.out.println("RuntimeException test: getNumbersAfterNumberFour");
        Assertions.assertThrows(
                RuntimeException.class,
                () -> Main.getNumbersAfterNumberFour(new int[]{1, 1, 1, 1, 1, 1, 1})
        );

        System.out.println("done\n");
    }

    @Test
    void getNumbersAfterNumberFour() {
        List<int[]> arrays = new ArrayList<>();

        arrays.add(new int[]{1, 2, 3, 4, 5});
        arrays.add(new int[]{3, 4, 5, 7, 8, 1, 2});
        arrays.add(new int[]{4, 4, 4, 4, 4, 4, 4});
        arrays.add(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7});

        System.out.println("Method test: getNumbersAfterNumberFour");
        for (int[] array : arrays) {
            System.out.println("Вх: " + Arrays.toString(array) + " -> вых: " + Arrays.toString(Main.getNumbersAfterNumberFour(array)));
            Main.getNumbersAfterNumberFour(array);
        }
        System.out.println();
    }

    @Test
    void findNumberFourInArray() {
        List<int[]> arrays = new ArrayList<>();

        arrays.add(new int[]{1, 1, 1, 4, 4, 1, 4, 4});
        arrays.add(new int[]{1, 1, 1, 1, 1, 1});
        arrays.add(new int[]{4, 4, 4, 4});
        arrays.add(new int[]{1, 4, 4, 1, 1, 4, 3});

        System.out.println("Method test: findNumberFourInArray");
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array) + " -> " + Main.findNumberFourInArray(array));
        }
        System.out.println();
    }
}