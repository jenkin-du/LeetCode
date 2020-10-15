package com.Node;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class K {

    public static class ListNode {
        public int value;
        ListNode next = null;
    }

    public static void main(String[] args) {

        int n = 10;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(fib(n));

    }

    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode post = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = post;
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode curr = start;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
