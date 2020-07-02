package LeetCode;

import Struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/02
 *     标题   : 非递归后序遍历
 *     题目   :
 *     思路   :
 * </pre>
 */
class NonRecursivePostTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode s1 = new TreeNode(2);
        TreeNode t1 = new TreeNode(3);

        root.right = s1;
        s1.left = t1;

        List<Integer> sequence = postorderTraversal(root);
        for (Integer re : sequence) {
            System.out.print(re + ",");
        }

    }


    public static List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }

        ArrayList<Integer> sequence = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode lastNode = root;
        while (!stack.empty()) {
            TreeNode topNode = stack.peek();
            if ((lastNode == topNode.left || lastNode == topNode.right) ||
                    (topNode.left == null && topNode.right == null)) {
                sequence.add(topNode.val);
                lastNode = stack.pop();
            } else {
                if (topNode.right != null) {
                    stack.push(topNode.right);
                }
                if (topNode.left != null) {
                    stack.push(topNode.left);
                }
            }

        }
        return sequence;
    }
}
