package LeetCode;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/19
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class RotateList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(5);

        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        head = rotateRight(head, 10);
        printNode(head);
        System.out.println();
    }

    public static void printNode(ListNode node) {
        if (node != null) {
            System.out.print(node.val + ",");
            printNode(node.next);
        }
    }


    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        k = k % length;
        if (k==0||length == 1||k == length) {
            return head;
        }

        k = k % length;
        int l = length - k;
        p = head;
        l--;
        while (l > 0) {
            p = p.next;
            l--;
        }
        ListNode q = p.next;
        p.next = null;
        ListNode m = q;
        while (m.next != null) {
            m = m.next;
        }
        m.next = head;
        head = q;

        return head;
    }
}
