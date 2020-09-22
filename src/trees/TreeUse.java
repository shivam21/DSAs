package trees;

public class TreeUse {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(2);
        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(4);
        TreeNode<Integer> node3 = new TreeNode<>(5);
        root.children.add(node1);
        root.children.add(node2);
        node2.children.add(node3);
        printTree(root);
    }

    private static void printTree(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        for (TreeNode<Integer> child : root.children) {
            printTree(child);
        }
    }
}
