#Binary Search Tree Visualization with JavaFX
  This project is a graphical representation of a Binary Search Tree (BST) using JavaFX. Users can insert, delete, and display nodes in the BST and view traversal orders, such as Inorder, Preorder, Postorder, and Breadth-First Traversal, in an animated and visually appealing format.
##Features
  -Insert & Delete Nodes: Add or remove nodes from the tree with real-time visual feedback.
  -Display Tree: Display the current structure of the BST.
  -Traversal Orders:
    -Inorder
    -Preorder
    -Postorder
    -Breadth-First Traversal (BFT)
  Animated Node Insertion: New nodes appear with a growth animation for a more dynamic visualization.
  Traversal Visualization: Each traversal displays nodes in a visually appealing, ordered format with arrows connecting each node.
  
##Getting Started
  ###Prerequisites
  -Java Development Kit (JDK) 17 or later
  -JavaFX SDK 17 or later
  An IDE like IntelliJ IDEA, Eclipse, or VS Code with JavaFX support
  
  ###Installing JavaFX
  If you haven't already installed JavaFX:
    Download JavaFX SDK from JavaFX Downloads.
    Extract the SDK to a directory, for example, C:\javafx-sdk.
##Usage
  Interface Overview
    Input Field: Enter a number and press "Insert" to add it to the tree.
      Prompt: The input field displays "Enter the Key Here" as a hint.
    Buttons:
    Insert: Adds a new node with the specified value.
    Delete: Removes a node with the specified value.
    Display: Shows the current tree structure.
    Inorder, Preorder, Postorder, BFT: Displays the selected traversal order in an animated popup.
    
###Traversal Display
  Each traversal method presents the nodes in the correct order, formatted with arrows to enhance readability. The traversal results are shown in a dialog box with an animated entry effect, making it visually engaging.
##Project Structure
  BSTAnimation.java: Main JavaFX application that sets up the UI and handles user interactions.
  BST.java: Contains the logic for the Binary Search Tree, including insertion, deletion, and traversal methods.
  BTView.java: Handles the graphical representation of the BST, including animations for inserting nodes and drawing the tree.
  TreeNode.java: Represents a single node in the BST.
  style.css: Stylesheet for the JavaFX components, including buttons and animations.
  
##Code Highlights
  Animated Node Insertion: BTView uses JavaFX animations to smoothly insert nodes into the tree.
  Traversal Order Display: Traversal results are presented in a visually structured format with arrows, enhancing readability and user experience.
  CSS Styling: The style.css file provides a cohesive and attractive style for the UI elements, including hover effects and animations for buttons.
  
##Example Usage
  Insert Nodes:
    Enter 25 in the input field and click Insert.
    Enter 15, then 50, and click Insert each time.
    Watch as each node grows into place with an animation.
  Display Traversal Orders:
    Click Inorder to see the nodes arranged in Inorder.
    Click BFT for Breadth-First Traversal.
  Delete Nodes:
    Enter 15 in the input field and click Delete to remove the node with value 15.
    Click Display to update the tree structure.
##Built With
  Java - Programming language
  JavaFX - Java GUI library
  IntelliJ IDEA - Recommended IDE  
  Contributing
  Contributions are welcome! If you'd like to improve this project, please fork the repository and submit a pull request.
##Acknowledgments
Thanks to Prof. Lisa for providing insights into Binary Search Tree visualizations.
