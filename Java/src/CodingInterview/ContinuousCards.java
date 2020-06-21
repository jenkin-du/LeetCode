package CodingInterview;

import java.util.Arrays;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/19
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class ContinuousCards {

    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {

        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                break;
            }
        }
        if (i == nums.length) {
            return true;
        }
        int min = nums[i];
        //排除存在相同的数字
        for (int k = i; k < nums.length; k++) {
            if (k == 0) {
                continue;
            }
            if (nums[k] == nums[k - 1]) {
                return false;
            }
        }
        int max = nums[nums.length - 1];
        return max - min + 1 <= nums.length;
    }
}
