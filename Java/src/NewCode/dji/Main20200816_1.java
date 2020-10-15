package NewCode.dji;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/16
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200816_1 {

    public static class Pair {
        public int start;
        public int end;
        public int time;

        public Pair(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        ArrayList<ArrayList<Pair>> pairsList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            pairsList.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < p; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int time = scanner.nextInt();

            Pair pair = new Pair(start, end, time);
            pairsList.get(end).add(pair);
        }

        int x = scanner.nextInt();
        int[] dp = new int[x + 1];
        for (int i = 1; i <= x; i++) {
            dp[i] = 100000;
        }
        for (int i = 1; i <= x; i++) {
            ArrayList<Pair> pairs = pairsList.get(i);
            for (Pair pair : pairs) {
                int start = pair.start;
                int time = pair.time;
                dp[i] = Math.min(dp[i], dp[start] + time);
            }
        }
        System.out.println(dp[x]);
    }
}
