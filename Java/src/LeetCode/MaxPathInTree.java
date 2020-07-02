package LeetCode;

import Struct.TreeNode;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/21
 *     标题   : 二叉树中的最大路径和
 *     题目   : 给定一个非空二叉树，返回其最大路径和。
 *              本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *     思路   : 首先，考虑实现一个简化的函数 maxPath(node)，该函数计算二叉树中的一个节点的最大贡献值，具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
 *             具体而言，该函数的计算如下。
 *             空节点的最大贡献值等于 00。
 *             非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）。
 * </pre>
 */
class MaxPathInTree {


    public static void main(String[] args) {


        TreeNode root = new TreeNode(2);
        TreeNode s1 = new TreeNode(-1);
        TreeNode s2 = new TreeNode(-2);

        root.left = s1;
        root.right = s2;

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPath(root, max);
        return max[0];
    }

    public static int maxPath(TreeNode root, int[] max) {
        if (root != null) {
            //之所以要和零比较，如果子树的最大路径是小于零的，那么子树就不会在最大路径中
            int left = Math.max(maxPath(root.left, max), 0);
            int right = Math.max(maxPath(root.right, max), 0);
            //
            int value = left + right + root.val;
            max[0] = Math.max(value, max[0]);

            return Math.max(left, right) + root.val;
        }
        return 0;
    }
}
