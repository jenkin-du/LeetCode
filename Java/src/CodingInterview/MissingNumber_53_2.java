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
        int[] nums = {1};
        System.out.println(missingNumber2(nums));
    }

    public static int missingNumber(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] == middle && middle < nums.length - 1) {
                start = middle + 1;
            } else if (nums[middle] == middle && middle == nums.length - 1) {
                return middle + 1;
            } else {
                if ((middle > 0 && nums[middle - 1] == middle - 1)) {
                    return middle;
                } else {
                    end = middle - 1;
                }
            }
        }
        return 0;
    }

    public static int missingNumber2(int[] nums) {

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid) {
                //如果相等，说明前面没有缺失，要往后面找
                low = mid + 1;
            } else {
                //如果不相等，说明缺失的在前面，要往前面找
                high = mid - 1;
            }
        }
        return low;
    }
}
