package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/12
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */


class CommonNodeInList_52 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        ListNode headA = new ListNode(4);
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA8 = new ListNode(8);
        ListNode nodeA4 = new ListNode(4);
        ListNode nodeA5 = new ListNode(5);

        headA.next = nodeA1;
        nodeA1.next = nodeA8;
        nodeA8.next = nodeA4;
        nodeA4.next = nodeA5;

        ListNode headB = new ListNode(5);
        ListNode nodeB0 = new ListNode(0);
        ListNode nodeB1 = new ListNode(1);

        headB.next = nodeB0;
        nodeB0.next = nodeB1;
        nodeB1.next = nodeA8;

        ListNode node = getIntersectionNode2(headA, headB);
        System.out.println(node.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        int length1 = 0;
        int length2 = 0;

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            length1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            length2++;
            p2 = p2.next;
        }

        p1 = headA;
        p2 = headB;

        int diff = Math.abs(length1 - length2);
        if (length1 > length2) {
            while (diff > 0) {
                p1 = p1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                p2 = p2.next;
                diff--;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    //双指针法
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }

        return p1;
    }
}
