package ru.homework;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class MainTask4 {

    public static void main(String[] a) {
        File file = new File(Paths.get("").toAbsolutePath() + "/build/libs/data.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath()), "UTF-8"))) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();

            if (line1 != null && line2 != null) {
                char[] charsInLine1 = line1.toCharArray();
                char[] charsInLine2 = line2.toCharArray();

                System.out.print("Символы, которые встречаются в двух строках: ");
                for (char c : charsInLine1) {
                    for (char c1 : charsInLine2) {
                        if (c == c1) {
                            System.out.print(c + " ");
                        }
                    }
                }

                System.out.print("\nСимволы, которые входят в первую строку и не входят во вторую: ");
                for (char c : charsInLine1) {
                    boolean found = false;
                    for (char c1 : charsInLine2) {
                        if (c == c1) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.print(c + " ");
                    }
                }

                System.out.print("\nСимволы, которые содержатся хотя бы в одной строке: ");
                char[] charsInTwoLines = new char[charsInLine1.length + charsInLine2.length];
                System.arraycopy(charsInLine1, 0, charsInTwoLines, 0, charsInLine1.length);
                System.arraycopy(charsInLine2, 0, charsInTwoLines, charsInLine1.length, charsInLine2.length);
                System.out.print(
                        Arrays.toString(getUnique(charsInTwoLines))
                                .replace("[", "")
                                .replace("]", "")
                );

            } else {
                System.out.println("Файл не содержит 2 строки.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка в чтении файла: " + e.getMessage());
        }
    }

    private static char[] getUnique(char[] chars) {
        ArrayList<Character> uniqueChars = new ArrayList<>();
        for (char c : chars) {
            if (!uniqueChars.contains(c)) {
                uniqueChars.add(c);
            }
        }
        char[] result = new char[uniqueChars.size()];
        for (int i = 0; i < uniqueChars.size(); i++) {
            result[i] = uniqueChars.get(i);
        }
        return result;
    }
}