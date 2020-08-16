package NewCode.bilibili;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/13
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            arr[i] = Integer.parseInt(str);
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        int weigth = 1;
        int currentWigth = 1;
        int pre = min;
        for (int i = minIndex + 1; i < arr.length; i++) {
            if (arr[i] > pre) {
                currentWigth++;
            } else {
                currentWigth = 1;
            }
            weigth += currentWigth;
            pre = arr[i];
        }

        currentWigth = 1;
        pre = min;
        for (int i = minIndex - 1; i >= 0; i--) {
            if (arr[i] > pre) {
                currentWigth++;
            } else {
                currentWigth = 1;
            }
            weigth += currentWigth;
            pre = arr[i];
        }
        System.out.println(weigth);
    }
}
