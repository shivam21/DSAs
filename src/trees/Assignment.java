package trees;

class NodeSum {
    TreeNode<Integer> node;
    int sum;

    public NodeSum(TreeNode<Integer> node, int sum) {
        this.node = node;
        this.sum = sum;
    }
}

public class Assignment {

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {
        if (root == null)
            return false;
        if (root.data == x)
            return true;
        boolean containsX = false;
        for (int i = 0; i < root.children.size(); i++) {
            containsX = containsX || checkIfContainsX(root.children.get(i), x);
        }
        return containsX;
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.data > x)
            count++;
        for (int i = 0; i < root.children.size(); i++) {
            count += numNodeGreater(root.children.get(i), x);
        }
        return count;

    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        return findMaxSumNode(root).node;
    }

    private static NodeSum findMaxSumNode(TreeNode<Integer> root) {
        if (root == null)
            return new NodeSum(null, 0);
        if (root.children.size() == 0)
            return new NodeSum(root, root.data);
        TreeNode<Integer> maxSumNode = root;
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum += root.children.get(i).data;
        }
        for (int i = 0; i < root.children.size(); i++) {
            NodeSum child = findMaxSumNode(root.children.get(i));
            if (sum < child.sum) {
                maxSumNode = child.node;
                sum = child.sum;
            }
        }

        return new NodeSum(maxSumNode, sum);
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.children.size() != root2.children.size())
            return false;
        boolean isIdentical = root1.data.equals(root2.data);
        for (int i = 0; i < root1.children.size(); i++) {
            isIdentical = isIdentical && checkIdentical(root1.children.get(i), root2.children.get(i));
        }
        return isIdentical;
    }

    public static TreeNode<Integer> findNextSmallerNode(TreeNode<Integer> root, int n) {
        if (root == null)
            return null;
        // Write your code here
        int nextSmallerElement = Integer.MIN_VALUE;
        TreeNode<Integer> nextSmallerNode = null;
        if (root.data < n) {
            nextSmallerElement = root.data;
            nextSmallerNode = root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = findNextSmallerNode(root.children.get(i), n);
            if (node != null && node.data > nextSmallerElement) {
                nextSmallerElement = node.data;
                nextSmallerNode = node;
            }
        }
        return nextSmallerNode;
    }

    public static int countLeafNodes(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        if (root.children.size() == 0)
            return 1;
        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += countLeafNodes(root.children.get(i));
        }
        return count;
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        TreeNode<Integer> largest = findLargestElement(root);
        return findNextSmallerNode(root, largest.data);
    }

    private static TreeNode<Integer> findLargestElement(TreeNode<Integer> root) {
        if (root == null)
            return null;
        TreeNode<Integer> largest = root;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = findLargestElement(root.children.get(i));
            if (largest.data < node.data) {
                largest = node;
            }
        }
        return largest;
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root) {
        if (root == null)
            return;
        replaceWithDepthValue(root, 0);
    }

    private static void replaceWithDepthValue(TreeNode<Integer> root, int depth) {
        root.data = depth;
        for (int i = 0; i < root.children.size(); i++) {
            replaceWithDepthValue(root.children.get(i), depth + 1);
        }
    }
}
