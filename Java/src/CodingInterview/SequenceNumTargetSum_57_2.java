package CodingInterview;

import java.util.ArrayList;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/15
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class SequenceNumTargetSum_57_2 {

    public static void main(String[] args) {

        int[][] resultArr = findContinuousSequence(15);
        for (int[] arr : resultArr) {
            for (int i : arr) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public static int[][] findContinuousSequence(int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int p1 = 1;
        int p2 = 1;

        int tempSum = 1;
        while (p1 <= p2 && p1 <= target / 2) {

            if (tempSum == target) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = p1; i <= p2; i++) {
                    list.add(i);
                }
                result.add(list);
                tempSum -= p1;
                p1++;
            }

            if (tempSum + p2 + 1 <= target) {
                p2++;
                tempSum += p2;
            } else {
                tempSum -= p1;
                p1++;
            }
        }

        int[][] resultArr = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            int len = result.get(i).size();
            int[] subArr = new int[len];
            for (int j = 0; j < len; j++) {
                subArr[j] = result.get(i).get(j);
            }
            resultArr[i] = subArr;
        }
        return resultArr;
    }
}
