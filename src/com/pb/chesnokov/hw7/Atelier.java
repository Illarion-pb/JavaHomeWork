package com.pb.chesnokov.hw7;


import com.pb.chesnokov.hw6.Animal;

import java.util.ArrayList;
import java.util.List;

public class Atelier {

    // Классы, наследники Closes
    class Tshirt extends Clothes implements ManClothes, WomanClothes {

        private String name;

        public Tshirt(Size size, String color, double price) {
            super(size, color, price);
            this.name = "Футболка";
        }

        @Override
        public void dressMan() {
            System.out.printf("   %s \"%s\", размер - %d, цвет - %s, стоимость - %.2f грн.\n", ManClothes.clo, name, size.getEuroSize(), color, price);
        }

        @Override
        public void dressWoman() {
            System.out.printf("   %s \"%s\", размер - %d, цвет - %s, стоимость - %.2f грн.\n", WomanClothes.clo, name, size.getEuroSize(), color, price);
        }
    }

    private class Pants extends Clothes implements ManClothes, WomanClothes {
        private String name;

        public Pants(Size size, String color, double price) {
            super(size, color, price);
            this.name = "Штаны";
        }

        @Override
        public void dressMan() {
            System.out.printf("   %s \"%s\", размер - %d, цвет - %s, стоимость - %.2f грн.\n", ManClothes.clo, name, size.getEuroSize(), color, price);
        }

        @Override
        public void dressWoman() {
            System.out.printf("   %s \"%s\", размер - %d, цвет - %s, стоимость - %.2f грн.\n", WomanClothes.clo, name, size.getEuroSize(), color, price);
        }
    }

    private class Skirt extends Clothes implements WomanClothes {
        private String name;

        public Skirt(Size size, String color, double price) {
            super(size, color, price);
            this.name = "Юбка";
        }

        @Override
        public void dressWoman() {
            System.out.printf("   %s \"%s\", размер - %d, цвет - %s, стоимость - %.2f грн.\n", WomanClothes.clo, name, size.getEuroSize(), color, price);
        }
    }

    private class Tie extends Clothes implements ManClothes {
        private String name;

        public Tie(Size size, String color, double price) {
            super(size, color, price);
            this.name = "Галстук";
        }

        @Override
        public void dressMan() {
            System.out.printf("   %s \"%s\", размер - %d, цвет - %s, стоимость - %.2f грн.\n", ManClothes.clo, name, size.getEuroSize(), color, price);
        }
    }

    private static void dressMan(List<Clothes> clothes) {
        System.out.println("Мужчина одел:");
        for (Clothes clothe: clothes)
            if (clothe instanceof ManClothes)
                ((ManClothes) clothe).dressMan();
    }

    private static void dressWomen(List<Clothes> clothes) {
        System.out.println("Женщина одела:");
        for (Clothes clothe: clothes)
            if (clothe instanceof WomanClothes)
                ((WomanClothes) clothe).dressWoman();
    }

    public static void main(String[] args) {
        Atelier atelier = new Atelier();
        List<Clothes> clothes = new ArrayList<>();
        clothes.add(atelier.new Tshirt(Size.L, "красный", 25.4));
        clothes.add(atelier.new Pants(Size.XXS, "серые", 46.41));
        clothes.add(atelier.new Skirt(Size.M, "черная", 52.72));
        clothes.add(atelier.new Tie(Size.S, "зеленый", 12.1));

        System.out.println("------------- Список элементов -------------");
        for (Clothes clothe: clothes) {
            System.out.println(clothe);
        }
        System.out.println("------------- метод dressMan -------------");
        dressMan(clothes);
        System.out.println("------------- метод dressWoman -------------");
        dressWomen(clothes);
    }
}
