package NewCode.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/06
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200906_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] str = line.split(";");
        String testStr = str[0].toLowerCase();
        String answerStr = str[1].toLowerCase();

        String[] testArr = testStr.split("\\s+");
        ArrayList<String> testList = new ArrayList<>();
        for (String s : testArr) {
            if (s.contains(",") || s.contains(".") || s.contains("!") || s.contains("?")) {
                int index1 = s.contains(",") ? s.indexOf(",") : s.length();
                int index2 = s.contains(".") ? s.indexOf(".") : s.length();
                int index3 = s.contains("!") ? s.indexOf("!") : s.length();
                int index4 = s.contains("?") ? s.indexOf("?") : s.length();

                int index = Math.min(index1, Math.min(index2, Math.min(index3, index4)));
                String temp = s.substring(0, index);
                testList.add(temp);
                for (int i = index; i < s.length(); i++) {
                    testList.add(s.substring(i, i + 1));
                }
            } else {
                testList.add(s);
            }
        }

        String[] answerArr = answerStr.split("\\s+");
        ArrayList<String> answerList = new ArrayList<>();
        for (String s : answerArr) {
            if (s.contains(",") || s.contains(".") || s.contains("!") || s.contains("?")) {
                int index1 = s.contains(",") ? s.indexOf(",") : s.length();
                int index2 = s.contains(".") ? s.indexOf(".") : s.length();
                int index3 = s.contains("!") ? s.indexOf("!") : s.length();
                int index4 = s.contains("?") ? s.indexOf("?") : s.length();

                int index = Math.min(index1, Math.min(index2, Math.min(index3, index4)));
                String temp = s.substring(0, index);
                answerList.add(temp);
                for (int i = index; i < s.length(); i++) {
                    answerList.add(s.substring(i, i + 1));
                }
            } else {
                answerList.add(s);
            }
        }

        int testLen = testList.size();
        int answerLen = answerList.size();
        int[][] dp = new int[testLen + 1][answerLen + 1];
        for (int i = 1; i <= answerLen; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= testLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= testLen; i++) {
            for (int j = 1; j <= answerLen; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= testLen; i++) {
            for (int j = 1; j <= answerLen; j++) {
                String testWord = testList.get(i - 1);
                String answerWord = answerList.get(j - 1);
                if (testWord.equals(answerWord)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if ((testWord.equals(",") || testWord.equals(".") || testWord.equals("!"))
                        && (answerWord.equals(",") || answerWord.equals(".") || answerWord.equals("!"))) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
            }
        }
        System.out.println("(" + dp[testLen][answerLen] + "," + answerList.size() + ")");

    }
}
