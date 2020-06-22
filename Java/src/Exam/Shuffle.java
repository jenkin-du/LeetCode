package Exam;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/22
 *     标题   : 洗牌
 *     题目   : 输入n张牌，牌的数字范围在1-9，输入k，表示洗k次牌，接着输入n个数，表示牌的数字
 *              洗牌规则
 *              首先将牌分为左右两堆，如果n是奇数，那么左边比右边多一张拍，比如有6张牌，牌的数字为1，2，3，4，5，6；分为两堆，左边一堆为1，2，3，右边一堆为4，5，6；
 *              奇数次洗牌时，先放左边的牌，后放右边的牌，以此交叉放完，表示洗了一次牌；然后将牌重新分堆，再次洗牌
 *              偶数次洗牌时，先放右边的牌，后方左边的牌，以此交叉放完，表示洗了一次牌；
 *              当洗了k次牌的时候，输出牌的顺序，数字以空格隔开
 *
 *              输入样例：
 *              6 2 1 2 3 4 5 6 7
 *              //表示7张牌，洗两次，七张牌分别是 1 2 3 4 5 6 7
 *              //第一次洗牌，分为两堆：1 2 3 和 4 5 6，洗牌结果：1 4 2 5 3 6
 *              //第二次洗牌，分为两堆：1 4 2 和 5 3 6，洗牌结果：5 1 3 4 6 2
 *              最后输出：5 1 3 4 6 2
 *     思路   :
 * </pre>
 */
class Shuffle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] nums2 = new int[n];
        //用s1和s2指向两堆牌开始的位置
        int s1 = 0, s2;
        if (n % 2 == 0) {
            s2 = n / 2;
        } else {
            s2 = n / 2 + 1;
        }
        //用p1和p2指向正在放的牌
        int p1, p2;
        int m;
        int i = 1;
        while (i <= k) {

            p1 = s1;
            p2 = s2;
            m = 0;
            //奇数次放，先放左（前部分），后放右(后部分)
            if (i % 2 == 1) {
                while (p1 < s2 || p2 < n) {
                    if (p1 < s2) {
                        nums2[m++] = nums[p1++];
                    }
                    if (p2 < n) {
                        nums2[m++] = nums[p2++];
                    }
                }
            } else {
                //奇数次放，先放右(后部分)，后放左（前部分）
                while (p1 < s2 || p2 < n) {
                    if (p2 < n) {
                        nums2[m++] = nums[p2++];
                    }
                    if (p1 < s2) {
                        nums2[m++] = nums[p1++];
                    }
                }
            }
            i++;
            if (i <= k) {
                int[] temp = nums;
                nums = nums2;
                nums2 = temp;
            }
        }

        for (int j = 0; j < n; j++) {
            System.out.print(nums2[j] + " ");
        }
        System.out.println();

    }
}
