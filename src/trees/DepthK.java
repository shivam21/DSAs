package trees;

import static trees.TreeUtils.takeInput;

public class DepthK {


    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        printNodesDepthK(root, 2);
    }

    public static void printNodesDepthK(TreeNode<Integer> root, int k) {
        if (k <= 0) {
            System.out.println(root.data);
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = root.children.get(i);
            printNodesDepthK(node, k - 1);
        }
    }
}
