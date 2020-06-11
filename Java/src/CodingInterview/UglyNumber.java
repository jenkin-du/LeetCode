package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/10
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class UglyNumber {

    public static void main(String[] args) {
        System.out.println(getUglyNumber(1500));
    }

    private static int getUglyNumber(int n) {

        int[] uglyArr = new int[n];
        uglyArr[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int nextIndex = 1;

        while (nextIndex < n) {
            int min = Math.min(uglyArr[p2] * 2, Math.min(uglyArr[p3] * 3 , uglyArr[p5] * 5 ));
            uglyArr[nextIndex] = min;

            while (uglyArr[p2] * 2 <= min) {
                p2++;
            }
            while (uglyArr[p3] * 3 <= min) {
                p3++;
            }
            while (uglyArr[p5] * 5 <= min) {
                p5++;
            }
            nextIndex++;
        }

        return uglyArr[nextIndex - 1];
    }

}
