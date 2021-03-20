package by.gapanovich.algorithms.creator;

import by.gapanovich.algorithms.classes.BinaryTree;

public class BinaryTreeCreator {
    public BinaryTree createBinaryTree(int start, int end, int count){
        int counter = 0;
        BinaryTree binaryTree = new BinaryTree();
        while(counter < count){
            binaryTree.insert((int)(Math.random()* (end - start)) + start);
            counter++;
        }
        return binaryTree;
    }
}
