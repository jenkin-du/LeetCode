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
class Main20200906_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] fn = new int[n + 1];
        int[] dn = new int[n + 1];

        if (n <= 2) {
            System.out.println(n);
        }

        fn[1] = 1;
        fn[2] = 2;

        dn[1] = 0;
        dn[2] = 1;

        for (int i = 3; i <= n; i++) {
            fn[i] = fn[i - 1] + fn[i - 2] - dn[i - 2];
            dn[i] = fn[i - 2];
        }
        System.out.println(fn[n]);
    }
}
