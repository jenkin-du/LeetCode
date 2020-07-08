package LeetCode;

import Struct.ListNode;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/04
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class ReserveKListNode {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode.printListNode(node1);
        ListNode.printListNode(reverseKGroup(node1, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode newHead = null;
        ListNode pre;
        ListNode post;
        ListNode p = head;
        ListNode next;
        ListNode node;
        ListNode lastNode = null;
        while (p != null) {
            pre = lastNode;
            lastNode = node = p;

            int temp = k;
            temp--;
            //定位k个node
            while (node != null && temp > 0) {
                node = node.next;
                temp--;
            }
            if (node == null && temp > 0) {
                break;
            }

            if (node != null) {
                post = node.next;
                node = post;
            } else {
                post = null;
            }

            //反转
            while (p != post && p != null) {
                next = p.next;
                p.next = node;
                node = p;
                p = next;
            }

            if (pre == null) {
                newHead = node;
            } else {
                pre.next = node;
            }

            p = post;

        }
        return newHead;
    }
}
