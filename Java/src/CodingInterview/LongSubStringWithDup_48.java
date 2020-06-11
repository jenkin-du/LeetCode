package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/09
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class LongSubStringWithDup_48 {

    public static void main(String[] args) {
        String str = "a";

        System.out.println(maxSubString(str));
    }

    private static int maxSubString(String str) {

        if (str == null || str.equals("")) {
            return 0;
        }

        char[] cArr = str.toCharArray();
        int maxLength = 1;
        int curLength = 1;
        int start = 0;
        boolean hasSame;

        for (int i = 1; i < cArr.length; i++) {

            hasSame = false;
            for (int j = start; j < i; j++) {
                if (cArr[j] == cArr[i]) {
                    start = i + 1;
                    hasSame = true;
                    break;
                }
            }
            if (hasSame) {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - start + 1;
            } else {
                curLength++;
            }
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }
}
