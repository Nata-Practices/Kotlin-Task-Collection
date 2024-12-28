package ru.homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTask2 {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+\\.([a-zA-Z]{2,5})$|(localhost))";

    public static void main(String[] a) {
        System.out.print("Введите электронную почту: ");
        Scanner in = new Scanner(System.in);

        pattern = Pattern.compile(EMAIL_PATTERN);
        String email = in.next();
        MainTask2 checker = new MainTask2();

        if (checker.validate(email)) {
            System.out.println("Электронная почта введена верно");
        } else {
            System.out.println("Электронная почта введена неверно");
        }
    }
    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }

}