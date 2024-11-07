import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BSTAnimation extends Application {
    private BST<Integer> tree = new BST<>();
    private BTView view = new BTView(tree);

    @Override
    public void start(Stage primaryStage) {
        // Input field with a prompt text "Enter the Key Here"
        TextField tfInput = new TextField();
        tfInput.setPromptText("Enter the Key Here");
        tfInput.setPrefColumnCount(10); // Bigger size for easier input

        // Insert, Delete, and prominent Display button styled like an "Enter" key
        Button btnInsert = createAnimatedButton("Insert");
        Button btnDelete = createAnimatedButton("Delete");
        Button btnDisplay = createDisplayButton("Display");

        // Additional Traversal Buttons
        Button btnInorder = createAnimatedButton("Inorder");
        Button btnPreorder = createAnimatedButton("Preorder");
        Button btnPostorder = createAnimatedButton("Postorder");
        Button btnBFT = createAnimatedButton("BFT");

        // Insert functionality
        btnInsert.setOnAction(e -> {
            int value = Integer.parseInt(tfInput.getText());
            tree.insert(value);
            view.animateInsertion(value);
        });

        // Delete functionality
        btnDelete.setOnAction(e -> {
            int value = Integer.parseInt(tfInput.getText());
            tree.delete(value);
            view.displayTree();
        });

        // Display tree functionality
        btnDisplay.setOnAction(e -> view.displayTree());

        // Inorder traversal functionality
        btnInorder.setOnAction(e -> {
            String result = tree.inorderTraversal();
            showAnimatedAlert("Inorder Traversal", formatTraversal(result));
        });

        // Preorder traversal functionality
        btnPreorder.setOnAction(e -> {
            String result = tree.preorderTraversal();
            showAnimatedAlert("Preorder Traversal", formatTraversal(result));
        });

        // Postorder traversal functionality
        btnPostorder.setOnAction(e -> {
            String result = tree.postorderTraversal();
            showAnimatedAlert("Postorder Traversal", formatTraversal(result));
        });

        // Breadth-First Traversal (BFT) functionality
        btnBFT.setOnAction(e -> {
            String result = tree.breadthFirstTraversal();
            showAnimatedAlert("Breadth-First Traversal", formatTraversal(result));
        });

        // Arrange input and display button together
        HBox inputBox = new HBox(10, tfInput, btnDisplay);
        inputBox.setAlignment(Pos.CENTER);

        // Arrange all controls in an HBox and a VBox for better layout
        HBox actionButtons = new HBox(10, btnInsert, btnDelete, btnInorder, btnPreorder, btnPostorder, btnBFT);
        actionButtons.setAlignment(Pos.CENTER);
        actionButtons.setStyle("-fx-padding: 10; -fx-background-color: #f4ebd0; -fx-border-color: #8b5a2b;");

        VBox controlPanel = new VBox(10, inputBox, actionButtons);
        controlPanel.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setTop(controlPanel);
        pane.setCenter(view);

        Scene scene = new Scene(pane, 800, 600);
        scene.getStylesheets().add("style.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Binary Search Tree");
        primaryStage.show();

        view.displayTree();
    }

    private Button createAnimatedButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("animated-button");
        return button;
    }

    private Button createDisplayButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("display-button");
        return button;
    }

    // Method to display traversal result in an animated popup
    private void showAnimatedAlert(String title, TextFlow content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.getDialogPane().setContent(content);

        // Apply CSS for animated popup effect
        alert.getDialogPane().getStyleClass().add("notification-popup");

        // Add a short delay to show the alert
        PauseTransition delay = new PauseTransition(Duration.seconds(0.5));
        delay.setOnFinished(event -> alert.show());
        delay.play();
    }

    // Format traversal result with nodes and arrows for visual appeal
    private TextFlow formatTraversal(String traversal) {
        TextFlow formattedResult = new TextFlow();
        String[] nodes = traversal.trim().split(" ");

        for (int i = 0; i < nodes.length; i++) {
            Text nodeText = new Text("(" + nodes[i] + ")");
            nodeText.getStyleClass().add("traversal-node");
            formattedResult.getChildren().add(nodeText);

            if (i < nodes.length - 1) {
                Text arrow = new Text(" -----> ");
                arrow.getStyleClass().add("traversal-arrow");
                formattedResult.getChildren().add(arrow);
            }
        }

        return formattedResult;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
