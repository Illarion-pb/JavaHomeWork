package com.pb.chesnokov.hw6;

import java.util.Objects;

public class Cat extends Animal{
    private int numPurrsPerSecond;

    public Cat(int uniq) {
        super("Whiskas", "дом", "Кошка");
        this.numPurrsPerSecond = uniq;
    }

    @Override
    public void makeNoise() {
        super.makeNoise("мяу-мяу");
    }

    @Override
    public void eat() {
        System.out.printf("Кошка ест %s \n", food);
    }

    public void getNumPurrsPerSecond() {
        System.out.println("Количество мурлыканий в секунду - " + numPurrsPerSecond);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return numPurrsPerSecond == cat.numPurrsPerSecond;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numPurrsPerSecond);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "food='" + food + '\'' +
                ", numPurrsPerSecond=" + numPurrsPerSecond +
                '}';
    }
}
