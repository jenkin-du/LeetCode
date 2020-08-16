package NewCode.NetEasy;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/08
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];
        for (int k = 0; k < m; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            arr[i][j] = 1;
        }

        int result = 0;
        for (int i = 1; i < n - 1; n++) {
            for (int j = i + 1; j <= n; j++) {

                int[][] temp = copy(arr);
                result += fun(temp, i, j);

            }
        }
        System.out.println(result);
    }

    private static int fun(int[][] arr, int i, int j) {

        int n = arr.length;
//        if (arr[i][j] == 1 && arr[j][i] == 1) {
//            return 1;
//        }
        for (int k = 1; k < n; k++) {
            if (i == k) {
                continue;
            }

            if (arr[i][k] == 1 && k == j) {
                return 1;
            } else if (arr[i][k] == 1) {
                arr[i][k] = 0;
                return fun(arr, k, j);
            }
        }

        return 0;
    }

    private static int[][] copy(int[][] arr) {

        int[][] temp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, arr.length);
        }
        return temp;
    }
}
