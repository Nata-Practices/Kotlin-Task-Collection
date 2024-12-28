package ru.homework;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainTask1 {

    public static void main(String[] a) {
        System.out.print("Сколько целых чисел вы собираетесь ввести? ");

        Scanner in = new Scanner(System.in);
        int size = 0;
        String cur = in.next();
        if (isStringInt(cur)) {
            size = Integer.parseInt(cur);
        } else {
            System.out.println("Вы ввели не целое число.");
            System.exit(0);
        }

        if (size == 0) {
            System.out.print("Вы ничего не ввели.");
            System.exit(0);
        }

        int[] numbers = new int[size];
        String current;
        System.out.print("Введите целые числа через пробел и нажмите <Enter>: ");
        for (int i = 0; i < size; i++) {
            current = in.next();
            if (isStringInt(current)) {
                numbers[i] = Integer.parseInt(current);
            } else {
                System.out.printf("Вы ввели не целое число \"%s\". Попробуйте ещё раз.", current);
                System.exit(0);
            }
        }

        List<String> palindromes = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            String number = String.valueOf(numbers[i]);
            if (number.equals(reverseString(number)) && number.length() > 1) {
                palindromes.add(number);
            }
        }

        System.out.println("Числа-палиндромы: " + palindromes);
    }

    private static boolean isStringInt(String s)
    {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}