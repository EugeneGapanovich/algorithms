package by.gapanovich.algorithms.classes;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Node getLeft(){
        return this.left;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public Node getRight(){
        return right;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (right != null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│ " : " "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value).append("\n");
        if (left != null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? " " : "│ "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
