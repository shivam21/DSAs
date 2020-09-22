package trees;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T data;
    public List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        children =new ArrayList<>();
    }
}
