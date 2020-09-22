package trees;

public class CountLeafNodes {
    public static int countLeafNodes(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        if (root.children.size()==0)
            return 1;
        int count=0;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = root.children.get(i);
            count += countLeafNodes(node);
        }
        return count;

    }
}
