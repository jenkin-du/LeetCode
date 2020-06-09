/**
 * 面试题38：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有的排列
 */
class StringPermutation_38 {

    public static void main(String[] args) {

        char[] str = "abc".toCharArray();
        stringPermutation(str, 0);
    }

    public static void stringPermutation(char[] str, int begin) {
        if (begin == str.length) {
            System.out.println(str);
        } else {
            for (int i = begin; i < str.length; i++) {
                char temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;

                stringPermutation(str, begin + 1);

                temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;
            }
        }
    }
}
