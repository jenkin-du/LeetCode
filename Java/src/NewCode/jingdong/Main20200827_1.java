package NewCode.jingdong;

import java.util.Scanner;
import java.util.Stack;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/27
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200827_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        int reserveN = 0;
        int weight = 1;
        for (char c : arr) {
            reserveN += (c - '0') * weight;
            weight *= 10;
        }

        Stack<Integer> stack = new Stack<>();
        while (reserveN > 0) {
            stack.push(reserveN % 5);
            reserveN = reserveN / 5;
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
