package NewCode.tencent;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/23
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200823_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                dp[i] = 1;
            }
            int max = 0;
            for (int i = 2; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        if (dp[i] > max) {
                            max = dp[i];
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            for (int i = 2; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        if (dp[i] > max) {
                            max = dp[i];
                        }
                    }
                }
            }
            System.out.println(max);


            t--;
        }
    }
}
