package com.pb.chesnokov.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Integer> ints = new NumBox<>(10);
        NumBox<Float> floats = new NumBox<>(11);
        ints.add(15);
        floats.add(15.7F);
        ints.add(22);
        floats.add(22.3F);
        ints.add(65);
        floats.add(65.4F);
        ints.add(23);
        floats.add(23.1F);
        ints.add(645);
        floats.add(64.5F);
        ints.add(33);
        floats.add(33.9F);
        ints.add(5);
        floats.add(5.0F);

        ints.add(16);
        ints.add(17);
        ints.add(18);
        ints.add(19);

        System.out.println("----------------------------------");

        System.out.println("Размер \"ints\" = " + ints.length());
        System.out.println("Размер \"floats\" = " + floats.length());
        System.out.println("Среднее арифметическое в \"ints\" = " + ints.average());
        System.out.println("Среднее арифметическое в \"floats\" = " + floats.average());
        System.out.println("Максимальный элемент \"ints\" = " + ints.max());
        System.out.println("Максимальный элемент \"floats\" = " + floats.max());

        System.out.println("----------------------------------");
        System.out.println("Вывод 15-го элемента \"ints\":");
        try {
            System.out.println(ints.get(15));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("----------------------------------");
        System.out.println("Вывод 3-го элемента \"floats\":");
        try {
            System.out.println(floats.get(3));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
