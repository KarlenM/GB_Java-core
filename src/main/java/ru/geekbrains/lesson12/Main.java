/*
    Необходимо написать два метода, которые делают следующее:

    1. Создают одномерный длинный массив, например:
        static final int SIZE = 10 000 000;
        static final int HALF = SIZE / 2;
        float[] arr = new float[SIZE].

    2. Заполняют этот массив единицами.

    3. Засекают время выполнения: long a = System.currentTimeMillis().

    4. Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

    5. Проверяется время окончания метода System.currentTimeMillis().

    6. В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).

    Отличие первого метода от второго:
        - Первый просто бежит по массиву и вычисляет значения.
        - Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и
        потом склеивает эти массивы обратно в один.
 */

package ru.geekbrains.lesson12;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr1 = new float[HALF];
    static float[] arr2 = new float[HALF];

    public static void main(String[] args) {
        usualMethod();
        methodWithThreads();
    }

    private static void usualMethod() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        calculateArrayAndGetTime("method 1 - array 1", arr);
    }

    private static void methodWithThreads() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        arraySplit(arr);

        AtomicInteger threadEndCounter = new AtomicInteger();

        // Сделал специально без executor сервиса, чтоб понять как работают обычные потоки.
        new Thread(() -> {
            calculateArrayAndGetTime("method 2 - array 1", arr1);
            threadEndCounter.getAndIncrement();
        }).start();

        new Thread(() -> {
            calculateArrayAndGetTime("method 2 - array 2", arr2);
            threadEndCounter.getAndIncrement();
        }).start();

        // Не знаю правильно это или нет
        do {
            if (threadEndCounter.get() == 2) {
                arrayJoin(arr);
            }
        } while (threadEndCounter.get() != 2);
    }

    private static void calculateArrayAndGetTime(String methodName, float[] arr) {
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(methodName + " - calculation:\t" + (System.currentTimeMillis() - a) + " ms");
    }

    private static void arraySplit(float[] arr) {
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        System.out.println("method 2 - array 1 - array split:\t" + (System.currentTimeMillis() - a) + " ms");
    }

    private static void arrayJoin(float[] arr) {
        long a = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println("method 2 - array 1 - array join:\t" + (System.currentTimeMillis() - a) + " ms");
    }
}
