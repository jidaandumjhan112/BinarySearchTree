import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BTView extends Canvas {
    private BST<Integer> tree;
    private final int nodeRadius = 25;
    private final int vGap = 60;

    public BTView(BST<Integer> tree) {
        this.tree = tree;
        setWidth(800);
        setHeight(600);
        getStyleClass().add("canvas-background");
    }

    public void displayTree() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());

        // Draw the existing tree as a static background
        if (tree.getRoot() != null) {
            drawStaticTree(gc, tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
        }
    }

    private void drawStaticTree(GraphicsContext gc, TreeNode<Integer> node, double x, double y, double hGap) {
        if (node == null) return;

        // Draw branches
        gc.setStroke(Color.SADDLEBROWN.darker().darker()); // Darker brown for more contrast
        gc.setLineWidth(6); // Thicker branch for better visibility
        if (node.left != null) {
            gc.strokeLine(x, y, x - hGap, y + vGap);
            drawStaticTree(gc, node.left, x - hGap, y + vGap, hGap / 2);
        }
        if (node.right != null) {
            gc.strokeLine(x, y, x + hGap, y + vGap);
            drawStaticTree(gc, node.right, x + hGap, y + vGap, hGap / 2);
        }

        // Draw existing nodes as static "fruits"
        Color fruitColor = Color.hsb((node.value * 30) % 360, 0.8, 0.9);
        gc.setFill(fruitColor);
        gc.fillOval(x - nodeRadius, y - nodeRadius, nodeRadius * 2, nodeRadius * 2);

        gc.setFill(Color.WHITE);
        gc.setFont(new Font(15));
        gc.fillText(node.value.toString(), x - 8, y + 5);
    }

    // Method to animate the insertion of a new node
    public void animateInsertion(int value) {
        GraphicsContext gc = getGraphicsContext2D();
        TreeNode<Integer> parent = tree.getRoot(); // Start from root to find position

        // Determine the x, y coordinates for the new node
        double x = getWidth() / 2;
        double y = vGap;
        double hGap = getWidth() / 4;
        while (parent != null) {
            if (value < parent.value) {
                if (parent.left == null) break;
                x -= hGap;
                y += vGap;
                hGap /= 2;
                parent = parent.left;
            } else if (value > parent.value) {
                if (parent.right == null) break;
                x += hGap;
                y += vGap;
                hGap /= 2;
                parent = parent.right;
            } else {
                return; // Value already exists
            }
        }

        // Draw the branch first, then animate the node
        gc.setStroke(Color.SADDLEBROWN.darker().darker());
        gc.setLineWidth(6);
        if (parent != null) {
            double parentX = x + (value < parent.value ? hGap : -hGap);
            double parentY = y - vGap;
            gc.strokeLine(parentX, parentY, x, y); // Draw branch
        }

        // Animate the "growth" of the new node (fruit)
        Color fruitColor = Color.hsb((value * 30) % 360, 0.8, 0.9);
        gc.setFill(fruitColor);

        // Final size of the node (fruit)
        double finalSize = nodeRadius * 2;

        // Draw the node at final size and add text
        gc.fillOval(x - nodeRadius, y - nodeRadius, finalSize, finalSize);
        gc.setFill(Color.WHITE);
        gc.fillText(value + "", x - 8, y + 5);
    }
}
