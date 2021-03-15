package trees;

import java.util.ArrayList;

/*Remove all leaf nodes from a given Binary Tree. Leaf nodes are those nodes, which don't have any children.
        Note : Root will also be a leaf node if it doesn't have left and right child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
        Input format :

        Elements in level order form (separated by space)

        (If any node does not have left or right child, take -1 in its place)

        Output Format :

        Elements are printed level wise, each level in new line (separated by space).*/

public class RemoveLeafNodes {

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if (root == null)
            return null;
        if (root.children.size() == 0)
            return null;
        for (int i = root.children.size() - 1; i >= 0; i--) {
            TreeNode<Integer> child = removeLeafNodes(root.children.get(i));
            if (child == null) {
                root.children.remove(i);
            }
        }

        return root;
    }
}
