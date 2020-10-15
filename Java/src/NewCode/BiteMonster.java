package NewCode;

import java.util.ArrayList;
import java.util.Arrays;
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

        if(N>T){
            System.out.println(-1);
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
        int[] nums = new int[N];
        do {
            n = N;
            m = M;
            t = T;
            int k = 0;

            System.arraycopy(monster, 0, nums, 0, N);
            X++;
            for (int i = 0; i < t; i++) {
                if (m > 0 && k < n && nums[k] >= X) {
                    nums[k] -= X;
                    if (nums[k] <= 0) {
                        k++;
                    }
                    m--;
                } else {
                    if (k < n) {
                        nums[k] -= 1;
                        if (nums[k] <= 0) {
                            k++;
                        }
                    }
                }
            }
        } while (nums[N - 1] > 0);
        System.out.println(X);

    }
}
