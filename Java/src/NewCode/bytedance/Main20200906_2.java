package NewCode.bytedance;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/06
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200906_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] l = new int[n];
        int[] r = new int[n];

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    l[i] = j + 1;
                    break;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                if (arr[k] > arr[i]) {
                    r[i] = k + 1;
                    break;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            int m = l[i] * r[i];
            if (m > max) {
                max = m;
            }
        }
        System.out.println(max);
    }
}
