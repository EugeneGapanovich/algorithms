package by.gapanovich.algorithms.main;

/*
    Task:
    1. Построить двоичное дерево, содержащее n = 12 узлов.
    Значения ключей в узлах задавать с помощью датчика случайных чисел с диапазоном D от 0 до 80.
    2. Построить В+ дерево, содержащее n = 12 узлов и имеющее степень m = 5.
    Значения ключей в узлах задавать с помощью датчика случайных чисел с диапазоном D от 0 до 80.
    3. Обеспечить симметричный обход деревьев.
    4. Выполнить поиск значения ключа по близости сверху.
*/

import by.gapanovich.algorithms.algorithm.BinaryTreeAlgorithms;
import by.gapanovich.algorithms.classes.BinaryTree;
import by.gapanovich.algorithms.classes.Node;
import by.gapanovich.algorithms.creator.BinaryTreeCreator;

public class Main {
    static final int COUNT_ELEMENTS = 12;
    static final int START = 0;
    static final int END = 80;
    static final int KEY = 50;
    public static void main(String[] args) {
        BinaryTreeCreator binaryTreeCreator = new BinaryTreeCreator();
        BinaryTree binaryTree = binaryTreeCreator.createBinaryTree(START,END,COUNT_ELEMENTS);
        System.out.println(binaryTree.toString());

        BinaryTreeAlgorithms binaryTreeAlgorithm = new BinaryTreeAlgorithms();
        binaryTreeAlgorithm.symmetricTraversal(binaryTree.getRoot());

        Node key = binaryTreeAlgorithm.search(binaryTree.getRoot(), KEY);
        System.out.println();
        System.out.println("Key nearby from above:" + key.getValue());
    }
}
