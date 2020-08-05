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
class Main202008022 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] middle = new int[n][2];
        int[][] dinner = new int[m][2];

        for (int i = 0; i < n; i++) {
            middle[i][0] = sc.nextInt();
            middle[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            dinner[i][0] = sc.nextInt();
            dinner[i][1] = sc.nextInt();
        }
        if (t == 0) {
            System.out.println(0);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curT = middle[i][1];
            int curK = middle[i][0];
            int currMin = Integer.MAX_VALUE;
            if (curT >= t) {
                currMin = curK;
            } else {
                int j = 0;
                for (; j < m; j++) {
                    int tempT = dinner[j][1];
                    int tempK = dinner[j][0];
                    if (curT + tempT >= t) {
                        currMin = curK + tempK;
                        break;
                    }
                }
                for (; j < m; j++) {
                    int tempT = dinner[j][1];
                    int tempK = dinner[j][0];
                    if (curT + tempT >= t) {
                        if (curK + tempK < currMin) {
                            currMin = curK + tempK;
                        }
                    }
                }
            }
            if (currMin < min) {
                min = currMin;
            }
        }

        for (int i = 0; i < m; i++) {
            int curT = dinner[i][1];
            int curK = dinner[i][0];
            int currMin = Integer.MAX_VALUE;
            if (curT >= t) {
                currMin = curK;
            } else {
                int j = 0;
                for (; j < n; j++) {
                    int tempT = middle[j][1];
                    int tempK = middle[j][0];
                    if (curT + tempT >= t) {
                        currMin = curK + tempK;
                        break;
                    }
                }
                for (; j < n; j++) {
                    int tempT = middle[j][1];
                    int tempK = middle[j][0];
                    if (curT + tempT >= t) {
                        if (curK + tempK < currMin) {
                            currMin = curK + tempK;
                        }
                    }
                }
            }
            if (currMin < min) {
                min = currMin;
            }
        }
        System.out.println(min);
    }
}
