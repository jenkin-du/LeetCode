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
class NumberOfK_53_1 {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int count = search(nums, 8);
        System.out.println(count);
    }

    public static int search(int[] nums, int target) {

        int firstIndex = -1;
        int lastIndex = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] > target) {
                end = middle - 1;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
            if (nums[middle] == target) {
                if ((middle > 0 && nums[middle - 1] != target) || middle == 0) {
                    firstIndex = middle;
                    break;
                } else {
                    end = middle - 1;
                }
            }
        }

        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] > target) {
                end = middle - 1;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
            if (nums[middle] == target) {
                if ((middle < nums.length - 1 && nums[middle + 1] != target) || middle == nums.length - 1) {
                    lastIndex = middle;
                    break;
                } else {
                    start = middle + 1;
                }
            }
        }

        if (firstIndex != -1 && lastIndex != -1) {
            return lastIndex - firstIndex + 1;
        }
        return 0;
    }

}
