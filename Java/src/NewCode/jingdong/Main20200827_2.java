package NewCode.jingdong;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/27
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200827_2 {

    public static class Node {
        public int value;
        public Node next = null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Node head = new Node();
        while (m > 0) {

            int t = scanner.nextInt();
            if (t == 1) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                //插入数据
                insertNode(head, index, value);
            }
            //删除数据
            if (t == 2) {
                int index = scanner.nextInt();
                deleteNode(head, index);
            }
            //查询数据
            if (t == 3) {
                printNode(head);
            }

            m--;
        }
    }

    private static void printNode(Node head) {
        Node p = head.next;
        while (p != null) {
            System.out.print(p.value);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }

    private static void deleteNode(Node head, int index) {

        Node p = head;
        index--;
        while (index > 0) {
            p = p.next;
            index--;
        }
        Node q = p.next;
        p.next = q.next;
    }

    private static void insertNode(Node head, int index, int value) {

        Node p = head;
        index--;
        while (index > 0) {
            p = p.next;
            index--;
        }
        Node q = p.next;
        Node node = new Node();
        node.value = value;
        node.next = q;
        p.next = node;
    }
}
