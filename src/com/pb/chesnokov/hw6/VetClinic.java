package com.pb.chesnokov.hw6;

import java.util.ArrayList;
import java.util.List;

public class VetClinic {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal());
        animals.add(new Cat(5));
        animals.add(new Dog(10));
        animals.add(new Horse(11));

        Object obj = null;

        try {
            Class clazz = Class.forName("com.pb.chesnokov.hw6.Veterinarian");
            obj = clazz.newInstance();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        if (obj instanceof Veterinarian)
            for(Animal animal: animals)
                ((Veterinarian) obj).treatAnimal(animal);
        System.out.println("***************************");
        for (Animal animal: animals) {
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            if (animal instanceof Dog) ((Dog) animal).getNumBittenThieves();
            if (animal instanceof Cat) ((Cat) animal).getNumPurrsPerSecond();
            if (animal instanceof Horse) ((Horse) animal).getNumAwards();
            System.out.println("-----------------------------");
        }

        System.out.println("******************************");
        System.out.println("animals[2] = " + animals.get(2).toString());
        Dog dog1 = new Dog(10);
        Dog dog2 = new Dog(15);
        System.out.println("hashCodes: \n   animals[2] - " + animals.get(2).hashCode() + "; \n   dog1 - " + dog1.hashCode() + "; \n   dog2 - " + dog2.hashCode());
        System.out.println("animals[2] == dog1 - " + animals.get(2).equals(dog1) + "\nanimals[2] == dog2 - " + animals.get(2).equals(dog2));
    }
}
