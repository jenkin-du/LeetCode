package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/14
 *     标题   :
 *     题目   :一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *     思路   : 通过异或操作可以找到数组中只出现一次的数字：如果两个数相同，那么异或的结果为0，所以最后的结果就是那个只出现一次的数字
 *             现在数组中出现了两个只出现一次的数字，那么我们可以把这个数组分为两个子数组，每个子数组中分别出现一个只出现一个的数字，其他数字都出现两次。如果分？
 *             还是根据第一次异或的结果，结果的二进制肯定有一位不为0，那么我们就根据这些数字中的这一位是否为零来拆分数组。
 * </pre>
 */
class NumberAppearOnce_56_1 {

    public static void main(String[] args) {

        int[] nums = {4, 1, 4, 6};

        int[] twoNum = singleNumbers(nums);
        for (int integer : twoNum) {
            System.out.print(integer + ",");
        }

    }

    private static int[] singleNumbers(int[] nums) {

        //异或的结果
        int sum = 0;
        for (int num : nums) {
            //异或
            sum ^= num;
        }
        int index = 0;
        while ((sum & 1) == 0 && index < 32) {
            sum = sum << 1;
            index++;
        }
        //找到异或结果不为零的那位，

        int[] twoNums = new int[2];

        for (int num : nums) {
            if (((num << index) & 1) == 0) {
                twoNums[0] ^= num;
            } else {
                twoNums[1] ^= num;
            }
        }

        return twoNums;
    }
}
