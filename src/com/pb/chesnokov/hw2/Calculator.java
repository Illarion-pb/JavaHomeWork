package com.pb.chesnokov.hw2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1, operand2;
        char sign;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter operand1: ");
        operand1 = in.nextInt();
        System.out.print("Enter operand2: ");
        operand2 = in.nextInt();
        System.out.print("Enter sign: ");
        sign = in.next().charAt(0);
        switch (sign) {
            case '+': {
                System.out.printf("%d + %d = %d", operand1, operand2, operand1+operand2);
                break;
            }
            case '-': {
                System.out.printf("%d - %d = %d", operand1, operand2, operand1-operand2);
                break;
            }
            case '*': {
                System.out.printf("%d * %d = %d", operand1, operand2, operand1*operand2);
                break;
            }
            case '/': {
                if (operand2 == 0)
                    System.out.println("Devision by 0");
                else
                    System.out.printf("%d / %d = %f", operand1, operand2, (double)operand1/operand2);
                break;
            }
            default:
                System.out.println("Not a math sign");
        }
    }


}
