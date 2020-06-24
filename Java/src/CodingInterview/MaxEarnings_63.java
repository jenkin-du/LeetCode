package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/23
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class MaxEarnings_63 {

    public static void main(String[] args) {

        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfitWithDP(nums));

    }

    public static int maxProfit(int[] prices) {

        if (prices.length < 1) {
            return 0;
        }
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        int maxValue = 0;
        int maxIndex = prices.length + 1;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < min && maxIndex == prices.length + 1) {
                min = prices[i];
                continue;
            }
            if (prices[i] < min && i > maxIndex) {
                maxIndex = prices.length + 1;

                int currentMax = max - min;
                if (maxValue < currentMax) {
                    maxValue = currentMax;
                }
                min = prices[i];
                max = Integer.MIN_VALUE;
            }

            if (prices[i] > max) {
                maxIndex = i;
                max = prices[i];
                int currentMax = max - min;
                if (maxValue < currentMax) {
                    maxValue = currentMax;
                }
            }
        }
        return maxValue;
    }

    //动态规划版本
    public static int maxProfitWithDP(int[] prices) {

        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }

        return dp[prices.length - 1];
    }
}
