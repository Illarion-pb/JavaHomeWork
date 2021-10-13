package com.pb.chesnokov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter value: ");
        num = in.nextInt();

        switch ((num >= 0 && num <= 14)?0:(num >= 15 && num <= 35)?1:(num >=36 && num <= 50)?2:(num >= 51 && num <= 100)?3:4) {
            case 0: {
                System.out.println("Value in range [0 - 14]");
                break;
            }
            case 1: {
                System.out.println("Value in range [15 - 35]");
                break;
            }
            case 2: {
                System.out.println("Value in range [36 - 50]");
                break;
            }
            case 3: {
                System.out.println("Value in range [51 - 100]");
                break;
            }
            case 4: {
                System.out.println("Value out of any range");
                break;
            }
        }
    }

}
