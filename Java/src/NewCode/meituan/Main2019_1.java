package NewCode.meituan;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/11
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main2019_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][x + 1];
        for (int i = 0; i <= x; i++) {
            dp[0][i] = 1000010;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                if (j <= arr[i]) {
                    dp[i][j] = Math.min(arr[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - arr[i]] + arr[i]);
                }
            }
        }
        System.out.println(dp[n][x]);
    }
}
