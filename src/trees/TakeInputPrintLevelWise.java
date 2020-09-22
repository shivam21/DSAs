package trees;

import static trees.TreeUtils.takeInput;

public class TakeInputPrintLevelWise {
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        TreeNode<Integer> result = findMaxNode(root);
        System.out.println(result.data);
    }

    public static TreeNode<Integer> findMaxNode(TreeNode<Integer> root) {
        TreeNode<Integer> maxNode = root;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = findMaxNode(root.children.get(i));
            if (maxNode.data < node.data)
                maxNode = node;
        }
        return maxNode;
    }



    public static int height(TreeNode<Integer> root){
        if(root==null)
            return 0;
        int childMaxHeight=0;
        for (int i = 0; i < root.children.size(); i++) {
            int subHeight = height(root.children.get(i));
            if (subHeight>childMaxHeight)
                childMaxHeight=subHeight;
        }
        return 1+childMaxHeight;
    }
}
