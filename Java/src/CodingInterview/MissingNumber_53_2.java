package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/12
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class MissingNumber_53_2 {

    public static void main(String[] args) {
        int[] nums={0};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] == middle) {
                start = middle + 1;
            } else {
                if ((middle > 0 && nums[middle - 1] == middle - 1) || middle == 0) {
                    return middle;
                } else {
                    end = middle - 1;
                }
            }
        }
        return 0;
    }
}
