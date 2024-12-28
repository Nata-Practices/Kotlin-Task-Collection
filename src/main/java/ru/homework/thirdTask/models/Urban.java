package ru.homework.thirdTask.models;

public class Urban extends House {
    protected String street;
    protected Integer countOfHouse;
    protected Integer numberOfApartment;
    protected Integer countOfNeighbors;
    protected Integer countOfGraffity;

    public Urban(String _type,
                 String _country,
                 Integer _floors,
                 Integer _height,
                 String _street,
                 Integer _countOfHouse,
                 Integer _numberOfApartment,
                 Integer _countOfNeighbors,
                 Integer _countOfGraffity) {
        super(_type, _country, _floors, _height);
        street = _street;
        countOfHouse = _countOfHouse;
        numberOfApartment = _numberOfApartment;
        countOfNeighbors = _countOfNeighbors;
        countOfGraffity = _countOfGraffity;
    }

    public String getStreet(){
        return "\nУлица: " + street;
    }

    public String getCountOfHouse(){
        return "\nКоличество домов рядом: " + countOfHouse;
    }

    public String getNumberOfApartment(){
        return "\nКвартира: " + numberOfApartment;
    }

    public String getCountOfNeighbors(){
        return "\nКоличество соседей в доме: " + countOfNeighbors;
    }

    public String getCountOfGraffity(){
        return "\nКоличество граффити на доме: " + countOfGraffity;
    }

    public String getFullInfo(){
        return super.getFullInfo() + getStreet() + getCountOfHouse() + getNumberOfApartment() + getCountOfNeighbors() + getCountOfGraffity();
    }
}
