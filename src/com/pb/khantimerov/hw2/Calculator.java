package com.pb.khantimerov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int operand1, operand2, result;
        float resultDivide;
        String sign;

        System.out.println("Введите целое число.");
        operand1 = scan.nextInt();
        System.out.println("Введите еще одно целое число.");
        operand2 = scan.nextInt();
        System.out.println("Введите один из арифметических опеаторов +, -, * или / .");
        sign = scan.next();

        switch(sign) {
            case "+" :
            {
                result = operand1 + operand2;
                System.out.println("x = " + operand1 + ", y = " + operand2 + "\nx + y = " + result);
            }
            break;

            case "-" :
            {
                result = operand1 - operand2;
                System.out.println("x = " + operand1 + ", y = " + operand2 + "\nx - y = " + result);
            }
            break;

            case "*" :
            {
                result = operand1 * operand2;
                System.out.println("x = " + operand1 + ", y = " + operand2 + "\nx * y = " + result);
            }
            break;

            case "/" :
                if(operand2 == 0) {
                    System.out.println("Деление на 0 невозможно.");
                } else {
                    resultDivide = (float) operand1 / operand2;
                    System.out.println("x = " + operand1 + ", y = " + operand2 + "\nx / y = " + resultDivide);
                }
                break;

            default :
            {
                System.out.println("Вы ввели недопустимый символ, вычисление невозможно.");
            }
        }
    }
}