package LeetCode;

import Struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class LevelOrder {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> l : lists) {
            for (Integer num : l) {
                System.out.print(num + ",");
            }
            System.out.println();
        }


    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int newCount = 0;
        queue.offer(root);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            list.add(node.val);
            count--;

            if (node.left != null) {
                queue.offer(node.left);
                newCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                newCount++;
            }
            if (count == 0) {
                count = newCount;
                newCount = 0;
                lists.add(list);
                list = new ArrayList<>();
            }
        }
        return lists;
    }
}
