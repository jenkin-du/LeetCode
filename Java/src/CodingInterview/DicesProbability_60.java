package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/18
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class DicesProbability_60 {

    public static void main(String[] args) {

        double[] probabilities = twoSum(1);
        for (double prob : probabilities) {
            System.out.print(prob + ",");
        }
    }


    public static double[] twoSum(int n) {

        //dp：
        //首先用数组的第一维来表示阶段，也就是投掷完了几枚骰子。
        //然后用第二维来表示投掷完这些骰子后，可能出现的点数。
        //数组的值就表示，该阶段各个点数出现的次数。
        //单看第n枚骰子，它的点数可能为 1 , 2, 3, ... , 6 因此投掷完n枚骰子后点数j出现的次数，可以由投掷完n−1枚骰子后，对应点数 j-1, j-2, j-3, ... , 出现的次数之和转化过来。
        //for (第n枚骰子的点数 i = 1; i <= 6; i ++) {
        //    dp[n][j] += dp[n-1][j - i]
        //}
        int[][] dp = new int[n + 1][6 * n + 1];
        double[] ans = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for (int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j > k) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        int k = 0;
        for (int i = n; i <= 6 * n; i++) {
            ans[k] = dp[n][i] / all;
            k++;
        }
        return ans;
    }
}
