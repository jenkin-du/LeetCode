package Struct;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


    public static List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }


    public static List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
