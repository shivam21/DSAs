package binaryTree;

import java.util.ArrayList;

public class NodesDistanceK {

    public static void main(String[] args) {
        nodesAtDistanceK(BinaryTreeUse.takeInput(), 3, 1);
    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        ArrayList<Pair<BinaryTreeNode<Integer>, String>> list = findNodePath(root, node, new Pair<>(null, ""), new ArrayList<>());
        int p = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            Pair<BinaryTreeNode<Integer>, String> element = list.get(i);
            if (element.second.equals("L")) {
                if (k - p == 0) {
                    System.out.println(element.first.data);
                }
                printNodesAtDepthK(element.first.right, k - p - 1);
            } else if (element.second.equals("R")) {
                if (k - p == 0) {
                    System.out.println(element.first.data);
                }
                printNodesAtDepthK(element.first.left, k - p - 1);
            } else {
                printNodesAtDepthK(element.first, k);
            }
            p++;
        }
    }

    private static void printNodesAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return;
        if (k == 0)
            System.out.println(root.data);
        printNodesAtDepthK(root.left, k - 1);
        printNodesAtDepthK(root.right, k - 1);
    }

    private static ArrayList<Pair<BinaryTreeNode<Integer>, String>> findNodePath(BinaryTreeNode<Integer> root, int node, Pair<BinaryTreeNode<Integer>, String> pair, ArrayList<Pair<BinaryTreeNode<Integer>, String>> list) {
        if (root == null)
            return null;
        if (!pair.second.isEmpty())
            list.add(pair);
        if (root.data == node) {
            list.add(new Pair<>(root, ""));
            return list;
        }
        ArrayList<Pair<BinaryTreeNode<Integer>, String>> leftList = findNodePath(root.left, node, new Pair<>(root, "L"), new ArrayList<>(list));
        if (leftList == null) {
            return findNodePath(root.right, node, new Pair<>(root, "R"), new ArrayList<>(list));
        }
        return leftList;
    }



}
