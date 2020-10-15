package NewCode.bytedance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/04
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200904_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            while (t > 0) {
                set.add(sc.nextInt());
                t--;
            }
            list.add(set);
        }
        int count = 0;
        for (int k = 1; k <= c; k++) {
            int temp = 0;
            for (int i = 0; i < m; i++) {
                if (list.get(i).contains(k)) {
                    temp++;
                }
                if (temp >= 2) {
                    count++;
                    break;
                }
            }
            if (temp < 2) {
                for (int i = m, l = 0; l < n; i++, l++) {
                    if (i >= n) {
                        i = i % n;
                    }
                    if (list.get(l).contains(k)) {
                        temp--;
                    }
                    if (list.get(i).contains(k)) {
                        temp++;
                    }
                    if (temp >= 2) {
                        count++;
                        break;
                    }

                }
            }
        }
        System.out.println(count);
    }
}
