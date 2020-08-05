package NewCode.pinduoduo;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/02
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200802 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int curr = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            curr += nums[i];
            if (curr == k && i < n - 1) {
                System.out.println("paradox");
                return;
            }
            if (curr > k) {
                curr = 2 * k - curr;
                count++;
            }
        }
        System.out.println((k-curr) + " " + count);

    }
}
