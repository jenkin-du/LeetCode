package LeetCode;

import java.util.Arrays;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/03
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class CoinChange1 {

    public static void main(String[] args) {

        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.print(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int rows = coins.length;
        int cols = amount + 1;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = amount + 1;
            }
        }
        dp[0][0] = 0;
        for (int j = 0; j < cols; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            }
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = 0;
            for (int j = 1; j < cols; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        return dp[rows - 1][amount] > amount ? -1 : dp[rows - 1][amount];
    }
}
