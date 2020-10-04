package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ancestors {

    public static ArrayList<Integer> ancestors(BinaryTreeNode<Integer> root, int k) {
        return getAncestors(root, k, "");
    }

    private static ArrayList<Integer> getAncestors(BinaryTreeNode<Integer> root, int k, String paths) {
        if (root == null)
            return null;
        if (root.data == k) {
            paths += root.data + " ";
            String[] arr = paths.split(" ");
            ArrayList<Integer> result = new ArrayList<>();
            for (String s : arr) {
                result.add(Integer.valueOf(s));
            }
            return result;
        }
        ArrayList<Integer> leftSubtree = getAncestors(root.left, k, root.data + " " + paths);
        if (leftSubtree == null) {
            return getAncestors(root.right, k, root.data + " " + paths);
        }
        return leftSubtree;
    }

}
