package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/15
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
public class TwoNumberWithSum_57_1 {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoNum = twoSum(nums, target);
        for (int num : twoNum) {
            System.out.print(num + ",");
        }

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] twoNum = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {

            int sum = nums[start] + nums[end];
            if (sum == target) {
                twoNum[0] = nums[start];
                twoNum[1] = nums[end];
                break;
            }
            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return twoNum;
    }
}
