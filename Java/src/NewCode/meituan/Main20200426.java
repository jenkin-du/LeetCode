package NewCode.meituan;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/04
 *     标题   : 火星文字典
 *     题目   : 已知一种新的火星文的单词由英文字母（仅小写字母）组成，但是此火星文中的字母先后顺序未知。给出一组非空的火星文单词，
 *             且此组单词已经按火星文字典序进行好了排序（从小到大），请推断出此火星文中的字母先后顺序。
 *     思路   :
 * </pre>
 */
class Main20200426 {

    static class CNode {
        public char c;
        public CNode next = null;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strArr = line.split(" ");
        CNode head = new CNode();
        head.c = strArr[0].toCharArray()[0];
        char pre = head.c;
        for (int i = 0; i < strArr.length; i++) {
            char[] cArr = strArr[i].toCharArray();
            if (check(head, pre, cArr[0])) {
//                insert(head, cArr[0]);
                pre = cArr[0];
                for (int j = 1; j < cArr.length; j++) {
                    if (!check(head, pre, cArr[j])) {
                        System.out.println("invalid");
                        return;
                    }
                }
                if (i > 0) {
                    pre = strArr[i - 1].toCharArray()[0];
                }
            } else {
                System.out.println("invalid");
                return;
            }
        }
    }

    public static boolean check(CNode head, char pre, char current) {

        if (head.next == null) {
            return true;
        }

        return false;
    }
}
