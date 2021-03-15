package bst;

import binaryTree.BinaryTreeNode;

/*Given a binary search tree, replace each nodes' data with the sum of all nodes' which are greater or equal than it. You need to include the current node's data also.
        That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.
        You don't need to return or print, just change the data of each node.
        Input format :

        Line 1 : Elements in level order form (separated by space)

        (If any node does not have left or right child, take -1 in its place)

        Output format : Elements are printed in level order wise, every level in new line*/

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
