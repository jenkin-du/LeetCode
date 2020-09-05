import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/02
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class TestObject {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String p = scan.next();
        String s = scan.next();
        scan.close();
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[j][i] = dp[j - 1][i - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[j][i] = dp[j][i - 1] || dp[j - 1][i] || dp[j - 1][i - 1];
                }
            }
        }
        if (dp[p.length()][s.length()])
            System.out.println("1");
        else
            System.out.println("0");
    }
}
