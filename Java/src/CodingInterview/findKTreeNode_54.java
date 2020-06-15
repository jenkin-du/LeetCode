package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/13
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class findKTreeNode_54_2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode s1 = new TreeNode(9);
        TreeNode s2 = new TreeNode(20);

        root.left = s1;
        root.right = s2;

        TreeNode t1 = new TreeNode(15);
        TreeNode t2 = new TreeNode(7);

        s2.left = t1;
        s2.right = t2;

        boolean[] is = new boolean[1];
        is[0] = true;
        isBalancedCore(root, is);
        System.out.println(is[0]);

    }

    public static int isBalancedCore(TreeNode root, boolean[] is) {

        if (root == null) {
            return 0;
        }

        int left = isBalancedCore(root.left, is);
        int right = isBalancedCore(root.right, is);

        if (left > right + 1 || right > left + 1) {
            is[0] = false;
            return 0;
        } else {
            return left > right ? left + 1 : right + 1;
        }
    }
}
