package NewCode.NetEasy;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/08
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200808_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            int n = arr[i];
            int value = fun(n);
            System.out.println(value % 10007);
        }

    }

    private static int fun(int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];

    }
}
