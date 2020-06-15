package CodingInterview;

import java.util.HashMap;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/14
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class NumAppearOnce_56_2 {

    public static void main(String[] args) {

        int[] nums = {3, 4, 3, 3};
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count + 1);
            }
        }

        int num = 0;
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (count == 1) {
                num = key;
                break;
            }
        }

        return num;

    }

    public static int singleNumber2(int[] nums) {

        int mask;
        int[] bitSum = new int[32];

        for (int num : nums) {
            mask = 1;
            for (int j = 31; j >= 0; j--) {
                int bitAnd = mask & num;
                if (bitAnd != 0) {
                    bitSum[j]++;
                }

                mask <<= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }
}
