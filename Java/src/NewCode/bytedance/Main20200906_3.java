package NewCode.bytedance;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/06
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200906_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = arr[n + i] = scanner.nextInt();
        }

        int all = 0;
        for (int i = 0; i < n; i++) {
            all += arr[i];
        }

        if (m == 1) {
            int[] dp = new int[n];
            dp[0] = arr[0];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                if (dp[i - 1] < 0) {
                    dp[i] = arr[i];
                } else {
                    dp[i] = dp[i - 1] + arr[i];
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            System.out.println(max);
        } else {
            int[] dp = new int[2 * n + 1];
            dp[0] = arr[0];
            int max = Integer.MIN_VALUE;
            int index;
            for (int i = 1; i < 2 * n; i++) {
                if (dp[i - 1] < 0) {
                    dp[i] = arr[i];
                } else {
                    dp[i] = dp[i - 1] + arr[i];
                }
                if (dp[i] > max) {
                    max = dp[i];
                    index = i;
                }
            }

            if (all <= 0) {
                System.out.println(max);
            } else {
                all = max + (m - 2) * all;
                System.out.println(all);
            }
        }


    }
}
