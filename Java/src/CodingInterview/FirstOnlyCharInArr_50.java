package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/11
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class FirstOnlyCharInArr_50 {

    public static void main(String[] args) {

        String str = "itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb";
        System.out.println(findFirstOnlyChar(str));
    }

    private static char findFirstOnlyChar(String s) {

        if (s == null || s.equals("")) {
            return ' ';
        }

        char[] cArr = s.toCharArray();
        int[] counts = new int[26];

        //记录每个字符出现的次数
        for (char c : cArr) {
            int index = c - 'a';
            counts[index] += 1;
        }

        for (char c : cArr) {
            int index = c - 'a';
            if (counts[index] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
