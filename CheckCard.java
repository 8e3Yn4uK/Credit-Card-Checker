package CheckSum;

/**
 Цифры кода умножаются на коэффициенты из таблицы (2 1 2 1 и т.д.) , если результат умножения превосходит 9,
 то вычитаем из него 9, получившиеся числа складываем. В этой сумме берём последнюю цифру, остальные отбрасываем
 (т. е. остаток от деления на 10).

 Если контрольная сумма есть 0, то номер признаётся правильным.
 */

import java.util.Scanner;


public class CheckCard {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter credit card number without spaces: ");
        String input = sc.nextLine();
        System.out.println();
        try {
            char[] inputChar = input.toCharArray();
            int[] arr = new int[inputChar.length];
            for (int i = 0; i < inputChar.length; i++) {
                arr[i] = Character.digit(inputChar[i], 10);
            }
            int sum = 0;

            for (int i = 0; i < 16; i = i + 2) {
                arr[i] = arr[i] * 2;
                if (arr[i] >= 10) {
                    sum = sum + (arr[i] - 9);
                } else {
                    sum = sum + arr[i];
                }
                sum = sum + arr[i + 1];
            }
            if (sum % 10 == 0) {
                System.out.println("Code is valid");
            } else {
                System.out.println("Code is invalid");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Check card number");
        }
    }
}
