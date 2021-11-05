package com.pb.chesnokov.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private int numAwards;

    public Horse (int uniq) {
        super("сено", "стойло", "Лошадь");
        this.numAwards = uniq;
    }

    @Override
    public void makeNoise() {
        super.makeNoise("и-го-го");
    }

    @Override
    public void eat() {
        System.out.printf("Лошадь ест %s \n", food);
    }

    public void getNumAwards() {
        System.out.println("Количество наград - " + numAwards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return numAwards == horse.numAwards;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAwards);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "food='" + food + '\'' +
                ", numAwards=" + numAwards +
                '}';
    }
}
