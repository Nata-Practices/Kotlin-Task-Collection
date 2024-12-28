package ru.homework;

import ru.homework.thirdTask.Utils;
import ru.homework.thirdTask.models.House;
import ru.homework.thirdTask.models.Individual;
import ru.homework.thirdTask.models.Urban;
import java.util.Scanner;

public class MainTask3 {

    private static final String INPUT_REGEX = "^([А-ЯЁ][а-яё]{1,15})(,\\s)([А-ЯЁ][а-яё]{1,15})(,\\s)(\\d{1,3})(,\\s)(\\d{1,3})$";
    private static final String INPUT_URBAN_REGEX= "^([А-ЯЁ][а-яё]{1,15})(,\\s)(\\d{1,3})(,\\s)(\\d{1,4})(,\\s)(\\d{1,4})(,\\s)(\\d{1,3})$";
    private static final String INPUT_INDIVIDUAL_REGEX = "^([А-ЯЁ][а-яё]{1,15})(,\\s)(\\d{1,4})(,\\s)(\\d{1,4})(,\\s)([А-ЯЁ][а-яё]{1,15})(,\\s)(\\d{1,3})$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            String input;
            while (true) {
                System.out.println("Создать дом?\n\t1) Да\n\t2) Перейти к функциям");
                input = scanner.nextLine();
                if (input.equals("2")) {
                    run = false;
                    myFunctions();
                } else if (input.equals("1")) break;
                System.out.println("Выберите один из двух вариантов выше");
            }

            if (!run) break;

            System.out.println("Введите общую информацию о доме в следующем формате:\n"
                    + "Вид (Вилла), Страна (Россия), количество этажей (2), высота в метрах (7)");
            input = scanner.nextLine();
            while (!input.matches(INPUT_REGEX)) {
                Utils.checkInput(input, "basic");
                input = scanner.nextLine();
            }

            String[] CommonInfo = input.split(", ");

            System.out.println("Какой тип у вашего дома?:\n1) Городского типа;\n2) Частный");
            while (true) {
                input = scanner.nextLine();
                if (input.equals("1")) {
                    System.out.println(
                            "Введите специфическую информацию о доме в следующем формате:\n" +
                                    "Название улицы (Бульварная), Количество домов рядом (2), Номер квартиры (32), " +
                                    "Количество соседей (123), Количество граффити (1)"
                    );
                    input = scanner.nextLine();
                    while (!input.matches(INPUT_URBAN_REGEX)) {
                        Utils.checkInput(input, "urban");
                        input = scanner.nextLine();
                    }
                    String[] urbanInfo = input.split(", ");
                    House urbanHouse = new Urban(
                            CommonInfo[0],
                            CommonInfo[1],
                            Integer.parseInt(CommonInfo[2]),
                            Integer.parseInt(CommonInfo[3]),
                            urbanInfo[0],
                            Integer.parseInt(urbanInfo[1]),
                            Integer.parseInt(urbanInfo[2]),
                            Integer.parseInt(urbanInfo[3]),
                            Integer.parseInt(urbanInfo[4])
                    );
                    break;
                } else if (input.equals("2")){
                    System.out.println(
                            "Введите специфическую информацию о доме в следующем формате:\n" +
                                    "Название улицы (Уличная), Площадь м² (100), Год постройки дома (2002), " +
                                    "Материал дома (Кирпич), Высота забора (2)"
                    );
                    input = scanner.nextLine();
                    while (!input.matches(INPUT_INDIVIDUAL_REGEX)) {
                        Utils.checkInput(input, "individual");
                        input = scanner.nextLine();
                    }
                    String[] individualInfo = input.split(", ");
                    House individualHouse = new Individual(
                            CommonInfo[0],
                            CommonInfo[1],
                            Integer.parseInt(CommonInfo[2]),
                            Integer.parseInt(CommonInfo[3]),
                            individualInfo[0],
                            Integer.parseInt(individualInfo[1]),
                            Integer.parseInt(individualInfo[2]),
                            individualInfo[3],
                            Integer.parseInt(individualInfo[4])
                    );
                    break;
                }
                System.out.println("Выберите один из двух вариантов выше");
            }
            System.out.println("Дом успешно создан.");
        }
    }

    private static void myFunctions(){
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Выберете функцию:" +
                    "\n\t1) Вывести список домов;" +
                    "\n\t2) Показать список зданий с высотой более 50 м;" +
                    "\n\t3) Отсортировать список по возрастанию высоты;" +
                    "\n\t4) Выбрать дом для редактирования;" +
                    "\n\t5) Определить самое высокое здание;" +
                    "\n\t6) Вернуться назад.");
            String opt;
            opt = scanner.nextLine();
            switch (opt) {
                case ("1"):
                    System.out.println(House.getHousesList());
                    break;
                case ("2"):
                    System.out.println(House.outputTwostoreyHouses());
                    break;
                case ("3"):
                    House.sortingByHeight();
                    System.out.println("\nСортировка прошла успешно\n");
                    System.out.println(House.getHousesList());
                    break;
                case ("4"):
                    System.out.println("\nВведите тип дома");
                    houseWorker(House.select(scanner.nextLine()));
                    break;
                case ("5"):
                    if (House.highest() != null) {
                        House highest = House.highest();
                        System.out.println("\nСамое высокое здание - " + highest.getType() + highest.getHeight());
                        houseWorker(House.highest());
                    }
                    else {
                        System.out.println("Домов не существует");
                    }
                    break;
                case ("6"):
                    run = false;
                    main(new String[]{""});
                default:
                    System.out.println("Выберите один из шести вариантов выше");
            }
        }
    }

    private static void houseWorker(House house){
        Scanner scanner = new Scanner(System.in);
        boolean run = house != null;
        while (run) {
            System.out.println("Выберете операцию над зданием " + house + ":" +
                    "\n\t1) Вывести информацию" +
                    "\n\t2) Изменить название" +
                    "\n\t3) Сбросить название" +
                    "\n\t4) Вернуться к выбору функций");
            switch (scanner.nextLine()) {
                case ("1"):
                    System.out.println(house.getFullInfo());
                    break;
                case ("2"):
                    System.out.println("\nВведите новое название >> ");
                    house.changeType(scanner.nextLine());
                    System.out.println("\nНазвание дома успешно изменено на " + house.getType());
                    break;
                case ("3"):
                    house.resetName();
                    System.out.println("\nНазвание успешно сброшено");
                    break;
                case ("4"):
                    run = false;
                    break;
                default:
                    System.out.println("Выберите один из четырёх выриантов выше");
            }
        }
    }
}
