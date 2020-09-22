package trees;

public class SumNodes {
    public static int sumOfAllNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = root.children.get(i);
            sum += sumOfAllNode(node);
        }
        return sum;
    }
}
