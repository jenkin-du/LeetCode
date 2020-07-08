package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

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
        double[] res = medianSlidingWindow(nums, k);

        for (double re : res) {
            System.out.print(re + ",");
        }
        System.out.println();
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {

        // if(k<=1){
        //     return new double[1];
        // }

        ArrayList<Double> list = new ArrayList<>();
        PriorityQueue<MyInteger> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.value));
        PriorityQueue<MyInteger> aux = new PriorityQueue<>(Comparator.comparingInt(v -> v.value));
        HashSet<MyInteger> set = new HashSet<>();
        int temp = k - 1;
        while (temp >= 0) {
            MyInteger integer = new MyInteger(nums[temp--]);
            queue.offer(integer);
        }
        int end = k;
        int start = 0;
        int[] arr = new int[k];
        while (end < nums.length) {
            int j = 0;
            while (queue.size() != 0) {
                MyInteger integer = queue.poll();
                if (!set.contains(integer)) {
                    arr[j++] = integer.value;
                }
                if (integer != null) {
                    aux.offer(integer);
                }
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
            aux = new PriorityQueue<>();

            int addNum = nums[end];
            queue.offer(new MyInteger(addNum));

            int deleteNum = nums[start];
            set.add(new MyInteger(deleteNum));

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
