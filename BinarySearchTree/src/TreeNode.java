public class TreeNode<T> {
    T value;
    TreeNode<T> left, right;

    public TreeNode(T value) {
        this.value = value;
        left = right = null;
    }
}
