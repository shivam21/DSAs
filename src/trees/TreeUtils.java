package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUtils {
    public static void printLevelWise(TreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        StringBuilder s = new StringBuilder().append(root.data).append("\n");
        q.add(root);
        boolean isNullAdded = false;
        TreeNode<Integer> nullNode = new TreeNode<>(null);
        while (!q.isEmpty()) {

            TreeNode<Integer> node = q.poll();
            if (node.data == null) {
                s.append("\n");
                if (!q.isEmpty())
                    q.add(nullNode);
                continue;
            }
            int count = node.children.size();
            for (int i = 0; i < count; i++) {
                TreeNode<Integer> child = node.children.get(i);
                s.append(child.data).append(" ");
                q.add(child);
            }
            if (!isNullAdded) {
                q.add(nullNode);
                isNullAdded = true;
            }

        }
        System.out.println(s);
    }

    public static TreeNode<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        TreeNode<Integer> root = new TreeNode<>(s.nextInt());
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> currentNode = q.poll();
            int numChildren = s.nextInt();
            for (int i = 0; i < numChildren; i++) {
                TreeNode<Integer> node = new TreeNode<>(s.nextInt());
                currentNode.children.add(node);
                q.add(node);
            }
        }
        return root;
    }
}
