package com.pb.chesnokov.hw6;

public class Animal {
    protected String food = "незвестный корм";
    private String location = "недостоверное местоположение";
    private String aType = "Животное";

    public Animal() {}

    public Animal(String f, String l) {
        this.food = f;
        this.location = l;
    }

    public Animal(String f, String l, String t) {
        this(f, l);
        this.aType = t;
    }

    public void makeNoise() {
        System.out.printf("%s издала неизвестный звук \n", this.aType);
    }

    public void makeNoise (String noise) {
        System.out.printf("%s издала звук - \"%s\" \n", this.aType, noise);
    }

    public void eat () {
        System.out.println("Животное кушает");
    }

    public void sleep () {
        System.out.printf("%s спит \n", this.aType);
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public String getaType() {
        return aType;
    }
}
