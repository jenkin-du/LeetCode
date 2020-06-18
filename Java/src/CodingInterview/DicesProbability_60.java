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

    }


    public double[] twoSum(int n) {

        int cols = 6 * n;
        int[][] dp = new int[n][cols];
        for (int i = 0; i < n; i++) {
            dp[0][0] = 1;
        }

        for (int i = 2; i < n; i++) {
            for (int j = i; j < i * n; j++) {
                for (int k = 0; k < 6; k++) {
                    dp[i][j] = dp[i - 1][j - k];
                }
            }
        }
        double all = Math.pow(6, n);
        double[] result = new double[5 * n + 1];
        for (int i = n - 1; i < 6 * n; i++) {
            int k = i - n;
            result[k] = dp[n - 1][i] / all;
        }

        return result;
    }

    ;
}
