package by.gapanovich.algorithms.Printer;

public class MatrixPrinter {
    public static void printMatrix(int[]matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + ";");
        }
        System.out.println();
    }

    public static void printMatrix(int[][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ";");
            }
            System.out.println();
        }
    }
}
