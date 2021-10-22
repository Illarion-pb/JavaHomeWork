package com.pb.chesnokov.hw3;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        System.out.println("ИГРА \"Угадай число в диапазоне от 0 до 100\"");

        final int MAX_ATTEMPT = 0; // Число попыток, если 0 - то бескончно

        System.out.printf("Число попыток - %s. \n", (MAX_ATTEMPT == 0)?"бескнечно":Integer.toString(MAX_ATTEMPT));
        System.out.println("Для выхода из программы - введите exit");
        System.out.println("----------------------------------------------");

        int attempt = 0;
        int  rand_num = (int) (Math.random() * 100);
        int num;
        Scanner in = new Scanner(System.in);
        String value;
        while ((MAX_ATTEMPT == 0)?true:(attempt < MAX_ATTEMPT)) {
            attempt ++;
            System.out.printf("Попытка %d%s ", attempt, (MAX_ATTEMPT == 0)?":":(" из " + MAX_ATTEMPT + ":"));
            value = in.next();
            if (value.equalsIgnoreCase("EXIT")) {
                break;
            }
            try {
                num = Integer.parseInt(value);
            }
            catch (NumberFormatException ex) {
                attempt --;
                System.out.println("Неверный символ!");
                continue;
            }
            if (num < rand_num) {
                System.out.println("Введеное число меньше задуманного.");
                continue;
            }
            if (num > rand_num) {
                System.out.println("Введеное число больше задуманного.");
                continue;
            }
            System.out.printf("\nПоздаравляем, Вы угадали число с %d попытки!!!\n", attempt);
            break;
        }
        System.out.println("\nИгра окончена.");

    }
}
