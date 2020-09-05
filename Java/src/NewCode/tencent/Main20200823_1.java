package NewCode.tencent;

import java.util.PriorityQueue;
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
class Main20200823_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                queue.offer(sc.nextInt());
            }
            if (n == 1) {
                System.out.println(queue.poll());
            } else {
                int cost = 0;

                while (queue.size() >= 2) {
                    int a = queue.poll();
                    int b = queue.poll();

                    int temp = a + b;
                    queue.offer(temp);
                    cost += temp;
                }

                System.out.println(cost);
            }
            t--;
        }
    }
}
