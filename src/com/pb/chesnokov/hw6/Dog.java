package com.pb.chesnokov.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private int numBittenThieves;

    public Dog(int uniq) {
        super("Pedigree", "двор", "Собака");
        this.numBittenThieves = uniq;
    }

    @Override
    public void makeNoise() {
        super.makeNoise("гав-гав");
    }

    @Override
    public void eat() {
        System.out.printf("Собака ест %s \n", food);
    }

    public void getNumBittenThieves() {
        System.out.println("Количество покусаных воров - " + numBittenThieves);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return numBittenThieves == dog.numBittenThieves;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numBittenThieves);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food='" + food + '\'' +
                ", numBittenThieves=" + numBittenThieves +
                '}';
    }
}
