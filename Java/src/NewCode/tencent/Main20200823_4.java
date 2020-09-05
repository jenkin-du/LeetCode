package NewCode.tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/23
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200823_4 {

    static class Node {
        public int index = -1;
        public Node next = null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();

        Node[] nodes = new Node[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            Node node = new Node();
            node.index = i;
            if (nodes[index] != null) {
                node.next = nodes[index];
            }
            nodes[index] = node;
        }
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (nodes[i] != null) {
                Node node = nodes[i];

                list.add(String.valueOf(str.charAt(node.index)));
                set.add(String.valueOf(str.charAt(node.index)));
                k--;
                if (k == 0) {
                    System.out.println(list.get(list.size() - 1));
                }

                StringBuilder temp = new StringBuilder();
                temp.append(str.charAt(node.index));
                int count = 2;
                if (node.index + 1 < str.length()) {
                    temp.append(str.charAt(node.index + 1));
                }
                while (node != null) {

                    count++;
                    node = node.next;
                }
            }
        }
    }
}
