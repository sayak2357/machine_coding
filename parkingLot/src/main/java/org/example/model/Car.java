package org.example.model;

public class Car {
    private String resgistrationNumber;
    private String color;

    public Car(String registrationNumber, String color) {
        this.resgistrationNumber = registrationNumber;
        this.color = color;
    }


    public String getResgistrationNumber() {
        return resgistrationNumber;
    }

    public void setResgistrationNumber(String resgistrationNumber) {
        this.resgistrationNumber = resgistrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
