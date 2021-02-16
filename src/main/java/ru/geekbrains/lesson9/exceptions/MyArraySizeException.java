package ru.geekbrains.lesson9.exceptions;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String message) {
        super(message);
    }
}
