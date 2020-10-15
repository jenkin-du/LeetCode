package NewCode.dji;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/16
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200816_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] value = new int[n + 1];
        int[] day = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            value[i] = scanner.nextInt();
            day[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][x + 1];
        for (int i = 1; i <= n; i++) {
            for (int d = 1; d <= x; d++) {
                if (d - day[i] < 0) {
                    dp[i][d] = dp[i - 1][d];
                } else {
                    dp[i][d] = Math.max(dp[i][d - day[i]] + value[i], dp[i - 1][d]);
                }
            }
        }
        System.out.println(dp[n][x]);

    }
}
