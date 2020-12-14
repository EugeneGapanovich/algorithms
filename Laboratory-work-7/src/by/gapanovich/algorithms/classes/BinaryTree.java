package by.gapanovich.algorithms.classes;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(Node root){
        this.root = root;
    }

    public Node getRoot(){
        return root;
    }

    public BinaryTree(int value){
        root = new Node(value);
    }

    public void insert(int value){
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value){
        if (current == null){
            return new Node(value);
        }
        if (value < current.getValue()){
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if(value > current.getValue()){
            current.setRight(insertRecursive(current.getRight(), value));
        } else {
            return current;
        }
        return current;
    }

    @Override
    public String toString(){
        return root.toString();
    }
}
