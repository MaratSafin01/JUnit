package dto;

import java.util.ArrayList;

public class Car {

    private ArrayList<String> owners = new ArrayList<>();

    private String manufacturer;

    private String number;

    private int year;

    private String owner;

    public Car(String manufacturer, String number, int year, String owner) {
        this.manufacturer = manufacturer;
        this.number = number;
        this.year = year;
        this.owner = owner;
        owners.add(owner);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        owners.add(owner);
        this.owner = owner;
    }

    public ArrayList<String> getOwners() {
        return owners;
    }

    private String testMethod() {
        return "Abc";
    }

    private String anotherTestMethod(String a) {
        return a;
    }

    public String getDataFromRemoteServer() throws Exception {


        throw new Exception("error!!!");
    }
}
