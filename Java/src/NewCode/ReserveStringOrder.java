package NewCode;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目：输入一行字符串，字符串中有若干个单词，单词之间有若干个空格，倒叙打印出单词，单词之间的空格只有一个
 */
class ReserveStringOrder {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        Stack<String> stacks = new Stack<>();
        String[] arr = str.split("\\s+");
        for (String s : arr) {
            stacks.push(s);
        }
        while (!stacks.empty()) {
            String out = stacks.peek();
            System.out.print(out);
            System.out.print(" ");

            stacks.pop();
        }
        System.out.print("\n");

        System.out.print(reverseWords("  hello world!  "));
        System.out.println("*");
    }

    public static String reverseWords(String s) {

        Stack<String> stacks = new Stack<>();
        String[] arr = s.split("\\s+");
        for (String str : arr) {
            if (!str.equals("")) {
                stacks.push(str);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stacks.empty()) {
            String out = stacks.peek();
            stacks.pop();
            result.append(out);

            if (!stacks.empty()) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
