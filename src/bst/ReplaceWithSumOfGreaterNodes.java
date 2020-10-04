package bst;

import binaryTree.BinaryTreeNode;

public class ReplaceWithSumOfGreaterNodes {
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        replaceWithLargerNodesSumHelper(root, 0);
    }

    private static int replaceWithLargerNodesSumHelper(BinaryTreeNode<Integer> root, int sum) {
        if (root == null)
            return 0;
        int rightSum = replaceWithLargerNodesSumHelper(root.right, sum);
        root.data += rightSum + sum;
        replaceWithLargerNodesSumHelper(root.left, root.data+rightSum);
        return root.data;
    }


}
