package LeetCode;

import java.util.*;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/08
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class MediumSlidingWindow {

    public static void main(String[] args) {


        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
//        int[] nums = {1, 3, -1, 3};
//        int k = 3;
        double[] res = medianSlidingWindow(nums, k);

        for (double re : res) {
            System.out.print(re + ",");
        }
        System.out.println();
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {

        ArrayList<Double> list = new ArrayList<>();
        PriorityQueue<MyInteger> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        PriorityQueue<MyInteger> aux = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

        MyInteger[] myNums = new MyInteger[nums.length];
        for (int i = 0; i < nums.length; i++) {
            myNums[i] = new MyInteger(nums[i]);
        }

        HashSet<MyInteger> set = new HashSet<>();
        int temp = k - 1;
        while (temp >= 0) {
            queue.offer(myNums[temp--]);
        }
        int end = k;
        int start = 0;
        int[] arr = new int[k];
        while (end <= nums.length) {
            int j = 0;
            while (queue.size() != 0) {
                MyInteger integer = queue.poll();
                if (!set.contains(integer)) {
                    arr[j++] = integer.value;
                }
                aux.offer(integer);
            }

            int middle = k / 2;
            if (k % 2 == 1) {
                list.add((double) (arr[middle]));
            } else {
                long res = (long) arr[middle] + (long) arr[middle - 1];
                double mid = (res) * 1.0 / 2;
                list.add(mid);
            }

            queue = aux;
            aux = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

            if (end >= nums.length) {
                break;
            }

            queue.offer(myNums[end]);
            set.add(myNums[start]);

            start++;
            end++;
        }

        double[] result = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }

    static class MyInteger {

        int value;

        public MyInteger(int value) {
            this.value = value;
        }
    }
}
