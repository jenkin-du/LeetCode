package LeetCode;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/05
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class StoneGame {

    public static class Pair {
        public int first;
        public int second;

        Pair() {
        }

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        int[] piles = {5, 3, 4, 5};
        System.out.println(stoneGame(piles));
    }


    public static boolean stoneGame(int[] piles) {

        int len = piles.length;
        Pair[][] dp = new Pair[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = new Pair();
            }
        }
        for (int i = 0; i < len; i++) {
            dp[i][i].first = piles[i];
        }

        for (int k = 1; k < len; k++) {
            for (int j = k; j < len; j++) {
                int i = j - k;
                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;

                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }

        return dp[0][len - 1].first > dp[0][len - 1].second;
    }
}
