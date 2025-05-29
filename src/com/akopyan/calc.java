package com.akopyan;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }


    private static String calc(String input) throws Exception {
        int result;
        String[] parts = input.split(" ");
        if (parts.length!=3 || parts[1].length() != 1)
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        int num1 = Integer.parseInt(parts[0]);
        char sign = parts[1].charAt(0);
        int num2 = Integer.parseInt(parts[2]);
        if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10) {
            switch (sign) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '/' -> {
                    if (num1 / num2 == 0) {
                        throw new Exception("деление на ноль запрещено");
                    } else result = num1 / num2;
                }
                case '*' -> result = num1 * num2;
                default -> throw new Exception("Неверный оператор");
            }
        } else throw new Exception("числа не соответствуют требованиям");
        return String.valueOf(result);
    }
}


