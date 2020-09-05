package NewCode.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/21
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200821_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            if (n == 1) {
                System.out.println(arr[0]);
            } else if (n == 2) {
                System.out.println(Math.max(arr[0], arr[1]));
            } else if (n > 2) {
                int all = 0;
                int a0 = arr[0];
                for (int i = 1; i < n; i++) {
                    all += arr[i];
                }
                all += a0 * (n - 2);
                System.out.println(all);
            }
            t--;
        }

    }
}
