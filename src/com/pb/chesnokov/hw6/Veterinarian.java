package com.pb.chesnokov.hw6;

public class Veterinarian {
    public void  treatAnimal(Animal animal) {
        System.out.printf("%s находясь в %s съел - %s и заболел. \n", animal.getaType(), animal.getLocation(), animal.getFood());
    }
}
