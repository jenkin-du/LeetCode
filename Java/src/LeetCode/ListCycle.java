package LeetCode;

import Struct.ListNode;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/13
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class ListCycle {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode node = detectCycle(node1);
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("null");
        }

    }

    public static ListNode detectCycle(ListNode head) {

        // HashSet<ListNode> set=new HashSet<>();
        // ListNode p=head;
        // while(p!=null){
        //     if(set.contains(p)){
        //         return p;
        //     }
        //     set.add(p);
        //     p=p.next;
        // }
        // return null;

        //快慢指针
        ListNode fast, slow;
        fast = head.next;
        if (fast != null) {
            fast = fast.next;
        }
        slow = head;
        while (fast != slow && fast != null && slow != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        if (fast == null || slow == null) {
            return null;
        }
        int length = 1;
        slow = fast.next;
        while (slow != fast) {
            length++;
            slow = slow.next;
        }
        slow = head;
        length--;
        while (length > 0) {
            slow = slow.next;
            length--;
        }
        fast = head;
        while (fast != slow.next) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
