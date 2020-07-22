package NewCode.tencent;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/21
 *     标题   :
 *     题目   : 求逆序书对
 *     思路   :
 * </pre>
 */
class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = (int) Math.pow(2, n);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count = sc.nextInt();
        int[] counts = new int[count];
        for (int i = 0; i < count; i++) {
            counts[i] = sc.nextInt();
        }

        for (int i = 0; i < count; i++) {
            //反转
            reserve(nums, counts[i]);
            int[] aux = new int[n];
            for (int j = 0; j < n; j++) {
                aux[j] = nums[j];
            }
            int reserveNum = getResarveNum(aux, 0, n - 1);
            System.out.println(reserveNum);
        }
    }

    public static void reserve(int[] nums, int count) {
        if (count == 0) {
            return;
        }
        int num = (int) Math.pow(2, count);
        for (int i = 0; i < nums.length; i += num) {
            int[] aux = new int[num];
            int k = i;
            for (int j = num - 1; j >= 0; j--, k++) {
                aux[j] = nums[k];
            }
            k = i;
            for (int j = 0; j < num; j++, k++) {
                nums[k] = aux[j];
            }
        }
    }

    //求逆序数对
    public static int getResarveNum(int[] nums, int start, int end) {
        int reserveNum = 0;
        if (start < end) {
            int middle = start + (end - start) / 2;
            int left = getResarveNum(nums, start, middle);
            int right = getResarveNum(nums, middle + 1, end);

            int[] aux = new int[end - start + 1];
            int p1 = middle;
            int p2 = end;
            int p3 = end - start + 1;

            while (p1 >= start || p2 > middle) {
                p3--;
                if (p1 >= start && p2 <= middle) {
                    aux[p3] = nums[p1];
                    p1--;
                    continue;
                }
                if (p2 > middle && p1 < start) {
                    aux[p3] = nums[p2];
                    p2--;
                    continue;
                }
                if (nums[p1] > nums[p2]) {
                    aux[p3] = nums[p1];
                    p1--;
                    reserveNum += p2 - middle;
                } else {
                    aux[p3] = nums[p2];
                    p2--;
                }
            }
            //复制到原来的数组
            p1 = start;
            p3 = 0;
            for (; p1 <= end; p1++, p3++) {
                nums[p1] = aux[p3];
            }

            reserveNum += left;
            reserveNum += right;
        }
        return reserveNum;
    }
}
