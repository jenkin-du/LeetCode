package NewCode.tencent;


import java.util.*;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/20
 *     标题   :
 *     题目   : 字符串解码
 *     思路   :
 * </pre>
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String enStr = sc.nextLine();
        StringBuilder builder = new StringBuilder();
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int index = 0; index < enStr.length(); index++) {
            char c = enStr.charAt(index);
            if (numStack.size() == 0 && c >= 'A' && c <= 'Z') {
                builder.append(c);
            }
            if (c >= '0' && c <= '9') {
                int num = 0;
                while (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                    index++;
                    c = enStr.charAt(index);
                }
                numStack.push(num);
                strStack.push("-");
                index--;
                continue;
            }
            if (c == ']') {
                int multi = numStack.pop();
                String str = strStack.pop();
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < multi; i++) {
                    res.append(str);
                }
                strStack.pop();
                if (numStack.size() != 0) {
                    String topStr = strStack.pop();
                    topStr += res;
                    strStack.push(topStr);
                } else {
                    builder.append(res);
                }
            }

            if (numStack.size() != 0 && c >= 'A' && c <= 'Z') {
                String topStr = strStack.pop();
                if (topStr.equals("-")) {
                    strStack.push("-");
                    String cStr = String.valueOf(c);
                    strStack.push(cStr);
                } else {
                    topStr += c;
                    strStack.push(topStr);
                }
            }
        }
        System.out.println(builder.toString());
    }
}
