package com.pb.chesnokov.hw4;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {
    public static String phrase2charString(String inText) {
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(inText);
        String outText = new String("");
        while (matcher.find()) {
            outText += matcher.group();
        }
        return outText.toUpperCase();
    }

    public static String sortCharString(String inText) {
        char[] charArray = inText.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text1, text2;

//        text1 = "Аз есмь строка, живу я, мерой остр2.";
//        text2 = "За семь морей ростка я вижу рост.2";

        System.out.println("Введите первую фразу:");
        text1 = in.nextLine();
        System.out.println("Введите вторую фразу:");
        text2 = in.nextLine();

        text1 = phrase2charString(text1);
        text2 = phrase2charString(text2);

        text1 = sortCharString(text1);
        text2 = sortCharString(text2);

        System.out.printf("Первая фраза %sявляется анагрммой второй.", (Objects.equals(text1, text2))?"":"не ");
    }
}
