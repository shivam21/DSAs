package binaryTree;


public class IsCousins {

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        Pair<Integer, BinaryTreeNode<Integer>> pDepth = getDepthAndParent(root, p, 0, null);
        Pair<Integer, BinaryTreeNode<Integer>> qDepth = getDepthAndParent(root, q, 0, null);
        return pDepth.first.equals(qDepth.first) && pDepth.second != qDepth.second;
    }

    private static Pair<Integer, BinaryTreeNode<Integer>> getDepthAndParent(BinaryTreeNode<Integer> root, int data, int depth, BinaryTreeNode<Integer> parent) {
        if (root == null)
            return null;
        if (root.data == data) {
            return new Pair<>(depth, parent);
        }
        Pair<Integer, BinaryTreeNode<Integer>> leftSubTree = getDepthAndParent(root.left, data, depth + 1, root);
        if (leftSubTree == null) {
            return getDepthAndParent(root.right, data, depth + 1, root);
        }
        return leftSubTree;
    }

}
