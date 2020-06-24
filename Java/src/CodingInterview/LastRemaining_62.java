package CodingInterview;

import Struct.ListNode;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/21
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class LastRemaining_62 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        System.out.println(lastRemaining(70866, 116922));

        long end = System.currentTimeMillis();
        double time = (end - start) / 1000.0;
        System.out.println(time);
    }

    public static int lastRemaining(int n, int m) {

        if (n < 1 || m < 1) {
            return -1;
        }

        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        p.next = head;
        p = head;

        if (m == 1) {
            while (p.next != head) {
                p = p.next;
            }
            return p.val;
        }

        while (getListNode(p) > 1) {
            for (int i = 1; i < m - 1; i++) {
                p = p.next;
            }
            p.next = p.next.next;
            p = p.next;
        }
        return p.val;
    }

    public static int getListNode(ListNode head) {
        if (head == null) {
            return 0;
        }
        int num = 1;
        ListNode p = head.next;
        while (p != head) {
            num++;
            p = p.next;
        }
        return num;
    }
}
