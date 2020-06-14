package NewCode;

import java.util.ArrayList;
import java.util.Comparator;
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
public class BiteMonster {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N, M, T;
        N = scanner.nextInt();
        T = scanner.nextInt();
        M = scanner.nextInt();

        int[] monster = new int[N];
        for (int i = 0; i < N; i++) {
            monster[i] = scanner.nextInt();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : monster) {
            arrayList.add(num);
        }
        arrayList.sort(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            monster[i] = arrayList.get(i);
        }
        int n, m, t;

        int X = 0;
        while (true) {
            n = N;
            m = M;
            t = T;
            int k = 0;
            X++;
            int[] nums = new int[N];
            if (N >= 0) System.arraycopy(monster, 0, nums, 0, N);

            for (int i = 0; i < t; i++) {
                if (m > 0 && k < n) {
                    nums[k] -= X;
                    if (nums[k] < 0) {
                        k++;
                    }
                    m--;
                } else {
                    nums[k] -= 1;
                    if (nums[k] < 0) {
                        k++;
                    }
                }
            }

            if (nums[N - 1] <= 0) {
                break;
            }
        }
        System.out.println(X);

    }
}
