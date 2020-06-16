package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/16
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class TreeSerializeAndDeserialize {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode s1 = new TreeNode(23);
        TreeNode s2 = new TreeNode(56);
//        TreeNode t1 = new TreeNode(4);
//        TreeNode t2 = new TreeNode(5);

        root.left = s1;
        root.right = s2;
//        s2.left = t1;
//        s2.right = t2;

        TreeSerializeAndDeserialize s = new TreeSerializeAndDeserialize();
        String data = s.serialize(root);
        System.out.println(data);

        s.printNode(s.deserialize(data));
        System.out.println();
    }

    public void printNode(TreeNode root) {

        if (root != null) {
            System.out.println(root.val);
            printNode(root.left);
            printNode(root.right);
        }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        String[] datas = new String[1];
        datas[0] = "";
        serializeCore(root, datas);

        return datas[0];
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        char[] cArr = data.toCharArray();
        int[] indexes = new int[1];
        return deserializeCore(indexes, cArr);
    }

    public void serializeCore(TreeNode root, String[] datas) {

        if (root != null) {
            datas[0] += "$";
            datas[0] += root.val;
            datas[0] += "$";

            serializeCore(root.left, datas);
            serializeCore(root.right, datas);
        } else {
            datas[0] += "#";
        }
    }

    public TreeNode deserializeCore(int[] indexes, char[] cArr) {

        TreeNode node = null;
        if (indexes[0] < cArr.length && cArr[indexes[0]] != '#') {

            if (cArr[indexes[0]] == '$') {
                indexes[0]++;
            }
            int flag = 1;
            int weight = 10;
            int num = 0;
            while (cArr[indexes[0]] != '$') {
                if (cArr[indexes[0]] == '-') {
                    flag = -1;
                    indexes[0]++;
                    continue;
                }
                int a = cArr[indexes[0]] - '0';
                num = num * weight + a;

                indexes[0]++;
            }
            num *= flag;

            node = new TreeNode(num);
            node.left = node.right = null;
            indexes[0]++;

            node.left = deserializeCore(indexes, cArr);
            node.right = deserializeCore(indexes, cArr);
        } else {
            indexes[0]++;
        }

        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
