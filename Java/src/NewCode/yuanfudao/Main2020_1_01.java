package NewCode.yuanfudao;

/*
 * 字符串解码
 */

import java.util.*;

public class Main2020_1_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n > 0) {
            String src = sc.nextLine();
            String result = decomposize(src);
            System.out.println(result);
            n--;
        }
    }

    public static String decomposize(String src) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = src.toCharArray();
        char lastChar = ' ';
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() == 0 && arr[i] >= 'A' && arr[i] <= 'Z') {
                sb.append(arr[i]);
                lastChar = arr[i];
                continue;
            }
            if (stack.size() == 0 && arr[i] >= '0' && arr[i] <= '9') {
                int num = arr[i] - '0';
                i++;
                while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
                    int temp = (int) arr[i] - '0';
                    num = num * 10 + temp;
                    i++;
                }
                for (int k = 0; k < num - 1; k++) {
                    sb.append(lastChar);
                }
                lastChar = ' ';
                i--;
                continue;
            }
            if (arr[i] == '(') {
                String value = String.valueOf(arr[i]);
                stack.push(value);
            }
            if (((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= '0' && arr[i] <= '9')) && stack.size() > 0) {
                String value = String.valueOf(arr[i]);
                stack.push(value);
            }
            if (arr[i] == ')') {
                i++;
                int num = 0;
                while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
                    int temp = arr[i] - '0';
                    num = num * 10 + temp;
                    i++;
                }
                i--;
                StringBuilder res = new StringBuilder(stack.pop());
                String c = res.toString();
                while (!c.equals("(")) {
                    c = stack.pop();
                    res.insert(0, c);
                }
                res = new StringBuilder(res.substring(1));
                StringBuilder resultSB = getString(res);
                String temp = resultSB.toString();
                for (int k = 0; k < num - 1; k++) {
                    resultSB.append(temp);
                }
                if (stack.size() > 0) {
                    stack.push(resultSB.toString());
                } else {
                    sb.append(resultSB);
                }
            }
        }
        return sb.toString();
    }

    private static StringBuilder getString(StringBuilder res) {

        StringBuilder resultSB = new StringBuilder();
        char[] tempArr = res.toString().toCharArray();
        char l = ' ';
        for (int k = 0; k < tempArr.length; k++) {
            if (tempArr[k] >= 'A' && tempArr[k] <= 'Z') {
                resultSB.append(tempArr[k]);
                l = tempArr[k];
            } else {
                int n = 0;
                while (k < tempArr.length && tempArr[k] >= '0' && tempArr[k] <= '9') {
                    int t = tempArr[k] - '0';
                    n = n * 10 + t;
                    k++;
                }
                k--;
                for (int m = 0; m < n - 1; m++) {
                    resultSB.append(l);
                }
            }
        }
        return resultSB;
    }
}
