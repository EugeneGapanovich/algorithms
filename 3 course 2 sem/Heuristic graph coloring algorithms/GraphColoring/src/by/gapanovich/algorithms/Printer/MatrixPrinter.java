package by.gapanovich.algorithms.Printer;

import by.gapanovich.algorithms.Classes.Edge;
import by.gapanovich.algorithms.Classes.Vertex;

public class MatrixPrinter {
    public static void printMatrix(int[] matrix) {
        for (int value : matrix) {
            System.out.print(value + ";");
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + ";");
            }
            System.out.println();
        }
    }

    public static void printEdgesArray(Edge[] edges) {
        for (Edge edge : edges) {
            System.out.println(edge.toString());
        }
        System.out.println();
    }

    public static void printVerticesAndEdges(Vertex[] vertices, Edge[] edges) {
        for (Vertex vertex : vertices){
            System.out.println(vertex.toString());
        }
        for (Edge edge : edges) {
            System.out.println(edge.toStringWithoutBrackets());
        }
        System.out.println();
    }
}
