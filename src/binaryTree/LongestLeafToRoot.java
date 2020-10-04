package binaryTree;

import java.util.ArrayList;
import java.util.Collections;

public class LongestLeafToRoot {

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new ArrayList<>();
        return longestRootToLeafPathHelper(root, 0).first;
    }

    private static Pair<ArrayList<Integer>, Integer> longestRootToLeafPathHelper(BinaryTreeNode<Integer> root, int depth) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.add(root.data);
            return new Pair<>(newList, depth);
        }
        Pair<ArrayList<Integer>, Integer> left = longestRootToLeafPathHelper(root.left, depth + 1);
        Pair<ArrayList<Integer>, Integer> right = longestRootToLeafPathHelper(root.right, depth + 1);
        if (right == null || (left != null && left.second > right.second)) {
            left.first.add(root.data);
            return left;
        }
        right.first.add(root.data);
        return right;
    }

}
