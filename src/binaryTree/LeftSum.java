package binaryTree;

public class LeftSum {

    public static int findSum(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.left != null) {
            sum += root.left.data;
        }
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        return sum + leftSum + rightSum;
    }
}
