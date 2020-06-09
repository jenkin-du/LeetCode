package CodingInterview;

import java.util.Scanner;

/**
 * 面试题45：数字转化成字符串
 */
class TranslateNumberToString_46 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int pre1, pre2;
        pre1 = pre2 = 1;
        int count = 1;

        int a = number % 10;
        number /= 10;
        int b = number % 10;

        while (number > 0) {
            int temp = b * 10 + a;
            if (temp >= 10 && temp <= 25) {
                count = pre2 + pre1;
            } else {
                count = pre2;
            }

            pre1 = pre2;
            pre2 = count;

            a = b;
            number /= 10;
            b = number % 10;
        }
        System.out.println(count);
    }
}
