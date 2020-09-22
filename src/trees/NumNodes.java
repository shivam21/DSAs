package trees;

public class NumNodes {


    public static int numNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int numNodes = 1;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = root.children.get(i);
            numNodes += numNodes(node);
        }
        return numNodes;
    }




}
