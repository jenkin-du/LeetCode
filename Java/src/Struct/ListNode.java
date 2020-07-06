package Struct;

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
public class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static void printListNode(ListNode root) {
        if (root != null) {
            System.out.print(root.val + ",");
            printListNode(root.next);
        } else {
            System.out.println();
        }
    }
}
