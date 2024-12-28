package ru.homework.thirdTask.models;

public class Individual extends House {
    protected String street;
    protected Integer area;
    protected Integer yearOfConstruction;
    protected String materialOfHouse;
    protected Integer fenceHeight;

    public Individual(String _type,
                      String _country,
                      Integer _floors,
                      Integer _height,
                      String _street,
                      Integer _area,
                      Integer _yearOfConstruction,
                      String _materialOfHouse,
                      Integer _fenceHeight) {
        super(_type, _country, _floors, _height);
        street = _street;
        area = _area;
        yearOfConstruction = _yearOfConstruction;
        materialOfHouse = _materialOfHouse;
        fenceHeight = _fenceHeight;
    }

    public String getStreet() {
        return "\nУлица: " + street;
    }

    public String getArea() {
        return "\nПлощадь: " + area + " м²";
    }

    public String getYearOfConstruction() {
        return "\nГод постройки: " + yearOfConstruction;
    }

    public String getMaterialOfHouse() {
        return "\nМатериал дома: " + materialOfHouse;
    }

    public String getFenceHeight() {
        return "\nВысота забора: " + fenceHeight + " м";
    }

    public String getFullInfo() {
        return super.getFullInfo() + getStreet() + getArea() + getYearOfConstruction() + getMaterialOfHouse() + getFenceHeight();
    }
}
