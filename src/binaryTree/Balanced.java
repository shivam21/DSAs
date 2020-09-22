package binaryTree;


public class Balanced {

    public static boolean checkBalanced(BinaryTreeNode<Integer> root) {
        return checkBalancedHelper(root).first;

    }

    private static Pair<Boolean, Integer> checkBalancedHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new Pair<>(true, 0);
        }
        Pair<Boolean, Integer> leftSubTree = checkBalancedHelper(root.left);
        Pair<Boolean, Integer> rightSubTree = checkBalancedHelper(root.right);
        boolean isBalanced = Math.abs(leftSubTree.second - rightSubTree.second) <= 1;
        return new Pair<>(leftSubTree.first && rightSubTree.first && isBalanced, 1 + Math.max(leftSubTree.second, rightSubTree.second));
    }


}
