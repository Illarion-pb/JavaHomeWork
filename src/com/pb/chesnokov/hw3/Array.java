package com.pb.chesnokov.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner in = new Scanner(System.in);
        String value;
        int num;


/*        for (int i = 0; i < array.length; i++)
            array[i] = (int) Math.round((Math.random() * 200) - 100);
*/
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите %d-й элемент массива: ", i);
            value = in.next();
            try {
                num = Integer.parseInt(value);
            }
            catch (NumberFormatException ex) {
                i --;
                System.out.println("Неверный символ!");
                continue;
            }
            array[i] = num;
        }

        int sum = 0;
        int positiv = 0;

        System.out.println("Исходный массив:");
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d%s", array[i], (i < (array.length - 1))?", ":"]\n");
            sum += array[i];
            if (array[i] > 0) {
                positiv ++;
            }
        }
        System.out.println("----------------------------------------");
        System.out.printf("Сумма элементов массива = %d. \n", sum);
        System.out.printf("В массиве - %d положительных элементов.\n", positiv);

        int tmp;
        sum = 0;

        System.out.println("----------------------------------------");
        System.out.println("Массив, отсортированный по возрастанию методом пузырька:");
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    sum ++;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d%s", array[i], (i < (array.length - 1))?", ":"]\n");
        }
        System.out.printf("Число перестановок - %d.", sum);
    }
}
