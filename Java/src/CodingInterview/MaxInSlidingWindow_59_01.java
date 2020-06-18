package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/17
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class MaxInSlidingWindow_59_01 {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k <= 0) {
            return nums;
        }

        int len = nums.length - k + 1;
        int[] arr = new int[len];
        int max = nums[0];
        for (int i = 1; i < k; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
            }
        }
        arr[0] = max;
        int j = 1;
        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            //如果滑出去的是最大值
            if (max == nums[i - k]) {
                max = Integer.MIN_VALUE;
                int m = i - k + 1;
                while (m <= i) {
                    if (nums[m] > max) {
                        max = nums[m];
                    }
                    m++;
                }
            } else {
                if (num > max) {
                    max = num;
                }
            }
            arr[j++] = max;
        }

        return arr;
    }
}
