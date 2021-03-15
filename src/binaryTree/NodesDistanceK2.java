package binaryTree;

/*You are given a Binary Tree of type integer, a target node, and an integer value K.
        Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
        Example:
        For a given input tree(refer to the image below):
        1. Target Node: 5
        2. K = 2
        alt txt

        Starting from the target node 5, the nodes at distance K are 7 4 and 1.*/

public class NodesDistanceK2 {

    public static void main(String[] args) {
        nodesAtDistanceK(BinaryTreeUse.takeInput(), 3, 1);
    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        printNodesDistanceK(root, node, k);
    }

    private static int printNodesDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        if (root == null)
            return -1;
        if (root.data == node) {
            printNodes(root, k);
            return 0;
        }
        int lD = printNodesDistanceK(root.left, node, k) + 1;
        if (lD != 0) {
            if (lD == k) {
                System.out.println(root.data);
            } else {
                printNodes(root.right, k - lD - 2);
            }
            return lD;
        }
        int rD = printNodesDistanceK(root.right, node, k) + 1;
        if (rD != 0) {
            if (rD == k) {
                System.out.println(root.data);
            } else {
                printNodes(root.left, k - rD - 2);
            }
            return rD;
        }
        return -1;
    }

    private static void printNodes(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return;
        if (k == 0)
            System.out.println(root.data);
        printNodes(root.left, k - 1);
        printNodes(root.right, k - 1);
    }
}
