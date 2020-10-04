package trees;

import java.util.ArrayList;

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
