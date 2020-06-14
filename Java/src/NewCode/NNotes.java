package NewCode;

import java.util.Scanner;

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
class NNotes {

    public static void main(String[] args) {

        int length;
        Scanner scanner = new Scanner(System.in);
        length = scanner.nextInt();

        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        if (length == 1) {
            System.out.print(nums[0]);
            System.out.print(" ");
            System.out.print(1);
        } else {
            int[] fun = new int[length];
            int[] count = new int[length];
            //初始化

            fun[0] = nums[0];
            fun[1] = Math.max(nums[1], nums[0]);
            count[0] = 1;
            count[1] = 1;
            for (int i = 2; i < length; i++) {
                int temp = nums[i] + fun[i - 2];
                if (temp > fun[i - 1]) {
                    fun[i] = temp;
                    count[i] = count[i - 2] + 1;
                } else {
                    fun[i] = fun[i - 1];
                    count[i] = count[i - 1];
                }
            }
            System.out.println(fun[length - 1] + " " + count[length - 1]);
        }
    }
}
