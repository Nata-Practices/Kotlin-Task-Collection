package ru.homework.thirdTask;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    private static final Map<Integer, String> myBasicValues = new HashMap<Integer, String>() {{
        put(0, "[А-ЯЁ][а-яё]{1,15}");
        put(1, "[А-ЯЁ][а-яё]{1,15}");
        put(2, "\\d{1,3}");
        put(3, "\\d{1,3}");
    }};
    private static final Map<Integer, String> myBasicFields = new HashMap<Integer, String>() {{
        put(0, "Вид");
        put(1, "Страна");
        put(2, "Количество этажей");
        put(3, "Высота");
    }};

    private static final Map<Integer, String> myUrbanValues = new HashMap<Integer, String>() {{
        put(0, "[А-ЯЁ][а-яё]{1,15}");
        put(1, "\\d{1,3}");
        put(2, "\\d{1,4}");
        put(3, "\\d{1,4}");
        put(4, "\\d{1,3}");
    }};
    private static final Map<Integer, String> myUrbanFields = new HashMap<Integer, String>() {{
        put(0, "Название улицы");
        put(1, "Количество домов рядом");
        put(2, "Номер квартиры");
        put(3, "Количество соседей");
        put(4, "Количество граффити");
    }};

    private static final Map<Integer, String> myIndividualValues = new HashMap<Integer, String>() {{
        put(0, "[А-ЯЁ][а-яё]{1,15}");
        put(1, "\\d{1,4}");
        put(2, "\\d{1,4}");
        put(3, "[А-ЯЁ][а-яё]{1,15}");
        put(4, "\\d{1,3}");
    }};
    private static final Map<Integer, String> myIndividualFields = new HashMap<Integer, String>() {{
        put(0, "Название улицы");
        put(1, "Площадь м²");
        put(2, "Год постройки дома");
        put(3, "Материал дома");
        put(4, "Высота забора");
    }};

    public static void checkInput(String content, String type) {
        Map<Integer, String> localValues = myBasicValues;
        Map<Integer, String> localFields = myBasicFields;
        switch (type) {
            case "urban":
                localValues = myUrbanValues;
                localFields = myUrbanFields;
                break;
            case "individual":
                localValues = myIndividualValues;
                localFields = myIndividualFields;
                break;
            case "basic":
                break;
        }

        String[] data = content.split(", ");
        for (int index = 0; index < data.length; index++) {
            String value = data[index];
            if (!value.matches(localValues.get(index)+"$")) {
                System.out.println("Ошибка в поле >>> \"" + localFields.get(index) + "\": " + value);
            }
        }
    }
}
