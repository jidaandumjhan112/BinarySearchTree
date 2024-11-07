import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>> {
    private TreeNode<T> root;

    // Insert a value into the BST
    public void insert(T value) {
        root = insert(root, value);
    }

    private TreeNode<T> insert(TreeNode<T> node, T value) {
        if (node == null) return new TreeNode<>(value);
        if (value.compareTo(node.value) < 0) node.left = insert(node.left, value);
        else if (value.compareTo(node.value) > 0) node.right = insert(node.right, value);
        return node;
    }

    // Delete a value from the BST
    public void delete(T value) {
        root = delete(root, value);
    }

    private TreeNode<T> delete(TreeNode<T> node, T value) {
        if (node == null) return null;
        if (value.compareTo(node.value) < 0) node.left = delete(node.left, value);
        else if (value.compareTo(node.value) > 0) node.right = delete(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            T minValue = findMin(node.right);
            node.value = minValue;
            node.right = delete(node.right, minValue);
        }
        return node;
    }

    private T findMin(TreeNode<T> node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    // Inorder Traversal
    public String inorderTraversal() {
        StringBuilder result = new StringBuilder();
        inorder(root, result);
        return result.toString();
    }

    private void inorder(TreeNode<T> node, StringBuilder result) {
        if (node != null) {
            inorder(node.left, result);
            result.append(node.value).append(" ");
            inorder(node.right, result);
        }
    }

    // Preorder Traversal
    public String preorderTraversal() {
        StringBuilder result = new StringBuilder();
        preorder(root, result);
        return result.toString();
    }

    private void preorder(TreeNode<T> node, StringBuilder result) {
        if (node != null) {
            result.append(node.value).append(" ");
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }

    // Postorder Traversal
    public String postorderTraversal() {
        StringBuilder result = new StringBuilder();
        postorder(root, result);
        return result.toString();
    }

    private void postorder(TreeNode<T> node, StringBuilder result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.append(node.value).append(" ");
        }
    }

    // Breadth-First Traversal (BFT)
    public String breadthFirstTraversal() {
        StringBuilder result = new StringBuilder();
        if (root == null) return result.toString();

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            result.append(node.value).append(" ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result.toString();
    }
}
