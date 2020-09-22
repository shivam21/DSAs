package trees;

public class Traversal {

    private void preOrder(TreeNode<Integer> root) {
        if (root == null)
            return;
        System.out.println(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            postOrder(root.children.get(i));
        }
    }

    private void postOrder(TreeNode<Integer> root) {
        if (root == null)
            return;
        for (int i = 0; i < root.children.size(); i++) {
            postOrder(root.children.get(i));
        }
        System.out.println(root.data + " ");
    }
}
