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
        String str = "aabaab!bb";

        System.out.println(maxSubString(str));
    }

    private static int maxSubString(String str) {

        if (str == null || str.equals("")) {
            return 0;
        }

        if (str.trim().equals("")){
            return 1;
        }

        char[] cArr = str.toCharArray();
        int maxLength = 1;
        int curLength = 1;
        int start = 0;

        int[] cIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            cIndex[i] = -1;
        }
        cIndex[cArr[0] - ' '] = 0;

        for (int i = 1; i < cArr.length; i++) {
            int index = cIndex[cArr[i] - ' '];
            if (index == -1 || i - index > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                start = index + 1;
                curLength = i - start + 1;
            }
            cIndex[cArr[i] - ' '] = i;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }
}
