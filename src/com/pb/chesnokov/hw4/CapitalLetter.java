package com.pb.chesnokov.hw4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetter {
    public static String upFirst(String inWord) {
        //Проверка, является ли первая буква слова маленькой
        Pattern pattern = Pattern.compile("^[a-zа-яё]");
        Matcher matcher = pattern.matcher(inWord);
        return (matcher.find())?matcher.group().toUpperCase() + inWord.substring(1):inWord;
    }

    public static void main(String[] args) {
//        String text = "Истина - это то, что выдерживает проверку опытом. Энштейн А.";
        Scanner in = new Scanner(System.in);
        String text;

        System.out.println("Введите предложение:");
        text = in.nextLine();

        StringBuilder text2 = new StringBuilder(text); //результирующая строка
        //Своеобразно разбираем строку на слова,
        //флаг Pattern.UNICODE_CHARACTER_CLASS - для нормального понимания кирилицы
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            //Проходим по словам и заменяем их в результирующей строке
            text2.replace(matcher.start(), matcher.end(), upFirst(matcher.group()));
        }
        System.out.println("-------------------------------");
        System.out.println("Результат работы программы:");
        System.out.println(text2);

    }
}
