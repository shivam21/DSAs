package binaryTree;

public class LeavesSameLevel {

    public static void checkLeaves(BinaryTreeNode<Integer> root) {
        System.out.println(getIsLeaves(root) ? "YES" : "NO");
    }

    private static boolean getIsLeaves(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
            return false;
        return getIsLeaves(root.left) && getIsLeaves(root.right);
    }
}
