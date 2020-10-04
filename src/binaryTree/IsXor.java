package binaryTree;

public class IsXor {

    public static boolean checkXorProperty(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;
        if (root.left != null && root.right != null) {
             if(!root.data.equals(root.left.data ^ root.right.data)){
                 return false;
             }
        }
        return checkXorProperty(root.left) && checkXorProperty(root.right);
    }
}
