package ru.homework.thirdTask.models;

import java.util.ArrayList;

public class House {
    protected Integer id;
    protected String type;
    protected String country;
    protected Integer floors;
    protected Integer height;
    protected String old_type;
    private static final ArrayList<House> houses = new ArrayList<>();

    public House(String _type, String _country, int _floors, int _height) {
        id = houses.size() + 1;
        type = _type;
        country = _country;
        floors = _floors;
        height = _height;
        houses.add(this);
    }

    @Override
    public String toString() {
        return type;
    }

    public String getType() {
        return "\nТип: " + type;
    }

    public String getPos() {
        return "\nСтрана: " + country;
    }

    public String getFloors() {
        return "\nКоличество этажей в доме: " + floors;
    }

    public String getHeight() {
        return "\nВысота дома: " + height + " м";
    }

    public String getFullInfo() {
        return getType() + getPos()  + getFloors() + getHeight();
    }

    public void changeType(String new_type) {
        old_type = type;
        type = new_type;
    }

    public void resetName(){
        type = old_type;
    }

    public static String getHousesList(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < houses.size(); i++) {
            result.append("\n").append(i + 1).append(") ").append(houses.get(i).type);
        }
        return result.toString();
    }

    public static House select(String searchingType) {
        for (House house : houses) {
            if (house.type.equals(searchingType)) {
                return house;
            }
        }
        System.out.println("Дома " + searchingType + " не существует");
        return null;
    }

    public static House highest() {
        House highest = null;
        int max = 0;
        for (House house : houses) {
            if (max < house.height) {
                max = house.height;
                highest = house;
            }
        }
        return highest;
    }

    public static void sortingByHeight() {
        for(int i = 0; i < houses.size(); i++)
        {
            House temp;
            for(int j = i + 1; j < houses.size(); j++)
            {
                if(houses.get(i).height > houses.get(j).height)
                {
                    temp = houses.get(i);
                    houses.set(i, houses.get(j));
                    houses.set(j, temp);
                }
            }
        }
    }

    public static String outputTwostoreyHouses() {
        StringBuilder result = new StringBuilder();
        for (House house : houses) {
            if (house.height > 50) {
                result.append("\n")
                        .append(house.id)
                        .append(") ")
                        .append(house.type)
                        .append(" - ")
                        .append(house.height)
                        .append(" этажа");
            }
        }
        return result.toString();
    }
}
