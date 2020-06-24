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
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 前序遍历
     */
    public static void preOrderPrint(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");

            preOrderPrint(root.left);
            preOrderPrint(root.right);
        }
    }
}
