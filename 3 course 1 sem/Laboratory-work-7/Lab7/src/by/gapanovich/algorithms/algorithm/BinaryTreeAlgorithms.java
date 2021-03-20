package by.gapanovich.algorithms.algorithm;

import by.gapanovich.algorithms.classes.Node;

public class BinaryTreeAlgorithms {
    public void symmetricTraversal(Node localRoot){
        if(localRoot != null) {
            symmetricTraversal(localRoot.getLeft());
            System.out.print(localRoot.getValue() + " ");
            symmetricTraversal(localRoot.getRight());
        }
    }

    public Node search(Node root, int key) {
        Node successor = null;
        while (root != null) {
            if (root.getValue() > key) {
                successor = root;
                root = root.getLeft();
            } else {
                root = root.getRight();
            }
        }
        return successor;
    }

}
