package NewCode.yuanfudao;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/01
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200801 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (input[i][1] > max) {
                max = input[i][1];
            }
        }

        int[] nums = new int[2 * max + 1];
        for (int i = 0; i < n; i++) {
            int start = input[i][0] * 2 - 1;
            int end = input[i][1] * 2 - 1;

            for (int j = start + 1; j < end; j += 2) {
                nums[j]++;
            }
        }

        int maxK = 0;
        for (int i = 2; i < 2 * max + 1; i += 2) {
            if (nums[i] > maxK) {
                maxK = nums[i];
            }
        }
        System.out.println(maxK);
    }


}
