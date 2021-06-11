package by.gapanovich.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms {
    public static Integer[][] floydAlgorithm(Integer[][] distanceMatrix) {
        Integer[][] indexes = new Integer[distanceMatrix.length][distanceMatrix[0].length];
        for (int i = 0; i < distanceMatrix.length; i++) {
            for (int j = 0; j < distanceMatrix.length; j++) {
                indexes[i][j] = j;
            }
        }
        for (int k = 0; k < distanceMatrix.length; k++) {
            for (int i = 0; i < distanceMatrix.length; i++) {
                if (i == k || distanceMatrix[i][k] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < distanceMatrix.length; j++) {
                    if (j == k || distanceMatrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (distanceMatrix[i][k] + distanceMatrix[k][j] < distanceMatrix[i][j]) {
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        indexes[i][j] = indexes[i][k];
                    }
                }
            }
        }

        System.out.println("Floyd");
        System.out.println(Arrays.deepToString(distanceMatrix));
        return distanceMatrix;
    }

    public static void littleAlgorithm(Integer[][] matrix) {
        List<Integer> resultRow = new ArrayList<>();
        List<Integer> resultColumn = new ArrayList<>();
        List<List<Integer>> distanceMatrix;
        distanceMatrix = new ArrayList<>(matrix.length + 1);
        for (int i = 0; i < matrix.length + 1; i++) {
            distanceMatrix.add(new ArrayList<>());
        }
        boolean[] availableRows = new boolean[matrix.length];
        boolean[] availableColumns = new boolean[matrix.length];
        Arrays.fill(availableRows, true);
        Arrays.fill(availableColumns, true);
        for (int i = 0; i < matrix.length + 1; i++) {
            distanceMatrix.get(i).add(i);
        }

        for (int j = 1; j < matrix.length + 1; j++) {
            distanceMatrix.get(0).add(j);
        }

        int dimension = distanceMatrix.get(0).size() - 1;

        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                if (i == j) {
                    distanceMatrix.get(i).add(Integer.MAX_VALUE);
                } else {
                    distanceMatrix.get(i).add(matrix[i - 1][j - 1]);
                }
            }
        }

        Integer border = 0;

        while (dimension != 2) {
            Integer minRow;
            for (int i = 1; i <= dimension; i++) {
                minRow = findMinRowValue(i, dimension, distanceMatrix);
                border += minRow;
                for (int j = 1; j <= dimension; j++) {
                    if (distanceMatrix.get(i).get(j) != Integer.MAX_VALUE) {
                        Integer val = distanceMatrix.get(i).get(j) - minRow;
                        distanceMatrix.get(i).set(j, val);
                    }
                }
            }

            Integer minColumn;
            for (int j = 1; j <= dimension; j++) {
                minColumn = findMinColumnValue(j, dimension, distanceMatrix);
                border += minColumn;
                for (int i = 1; i <= dimension; i++) {
                    if (distanceMatrix.get(i).get(j) != Integer.MAX_VALUE) {
                        Integer val = distanceMatrix.get(i).get(j) - minColumn;
                        distanceMatrix.get(i).set(j, val);
                    }
                }
            }

            int countZeros = findCountZeros(distanceMatrix, dimension);

            List<List<Integer>> zeros;
            zeros = new ArrayList<>(countZeros);
            for (int i = 0; i < countZeros; i++) {
                zeros.add(new ArrayList<Integer>());
            }

            // degree
            Integer minRowValueZeros;
            Integer minColumnValueZeros;
            int zeroNumber = 0;
            for (int i = 1; i <= dimension; i++) {
                for (int j = 1; j <= dimension; j++) {
                    if (distanceMatrix.get(i).get(j) == 0) {
                        minRowValueZeros = findMinRowValueExcludeValue(i, j, dimension, distanceMatrix);
                        minColumnValueZeros = findMinColumnValueExcludeValue(j, i, dimension, distanceMatrix);
                        zeros.get(zeroNumber).add(minRowValueZeros + minColumnValueZeros);
                        zeros.get(zeroNumber).add(distanceMatrix.get(i).get(0));
                        zeros.get(zeroNumber).add(distanceMatrix.get(0).get(j));
                        zeroNumber += 1;
                    }
                }
            }

            int index = findIndexMaxDegree(zeros, countZeros);
            int indexRow = zeros.get(index).get(1);
            int indexColumn = zeros.get(index).get(2);

            availableRows[indexRow - 1] = false;
            availableColumns[indexColumn - 1] = false;
            resultRow.add(indexRow);
            resultColumn.add(indexColumn);
            distanceMatrix = removeRowAndColumn(indexRow, indexColumn, distanceMatrix, dimension, availableRows, availableColumns);
            distanceMatrix = rewriteValue(indexRow, indexColumn, distanceMatrix, dimension, availableRows, availableColumns);
            dimension -= 1;
        }

        resultRow.add(distanceMatrix.get(1).get(0));
        resultColumn.add(distanceMatrix.get(0).get(1));

        resultRow.add(distanceMatrix.get(2).get(0));
        resultColumn.add(distanceMatrix.get(0).get(2));

        System.out.println("Way:");
        for (int i = 0; i < resultRow.size(); i++) {
            System.out.println("[" + resultRow.get(i) + ";" + resultColumn.get(i) + "]");
        }
    }

    private static Integer findMinRowValue(int i, int dimension, List<List<Integer>> distanceMatrix) {
        Integer min = Integer.MAX_VALUE;
        for (int k = 1; k <= dimension; k++) {
            if (distanceMatrix.get(i).get(k) <= min) {
                min = distanceMatrix.get(i).get(k);
            }
        }
        return min;
    }

    private static Integer findMinColumnValue(int j, int dimension, List<List<Integer>> distanceMatrix) {
        Integer min = Integer.MAX_VALUE;
        for (int k = 1; k <= dimension; k++) {
            if (distanceMatrix.get(k).get(j) <= min) {
                min = distanceMatrix.get(k).get(j);
            }
        }
        return min;
    }

    private static Integer findCountZeros(List<List<Integer>> distanceMatrix, int dimension) {
        int count = 0;
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                if (distanceMatrix.get(i).get(j) == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private static Integer findMinColumnValueExcludeValue(int j, int i, int dimension, List<List<Integer>> distanceMatrix) {
        Integer min = Integer.MAX_VALUE;
        for (int k = 1; k <= dimension; k++) {
            if (k != i) {
                if (distanceMatrix.get(k).get(j) <= min) {
                    min = distanceMatrix.get(k).get(j);
                }
            }
        }
        return min;
    }

    private static Integer findMinRowValueExcludeValue(int i, int j, int dimension, List<List<Integer>> distanceMatrix) {
        Integer min = Integer.MAX_VALUE;
        for (int k = 1; k <= dimension; k++) {
            if (k != j) {
                if (distanceMatrix.get(i).get(k) <= min) {
                    min = distanceMatrix.get(i).get(k);
                }
            }
        }
        return min;
    }

    private static Integer findIndexMaxDegree(List<List<Integer>> zeros, int count) {
        int index = -1;
        Integer maxDegree = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            if (zeros.get(i).get(0) >= maxDegree) {
                maxDegree = zeros.get(i).get(0);
                index = i;
            }
        }
        return index;
    }

    private static List<List<Integer>> removeRowAndColumn(
            int indexRow,
            int indexColumn,
            List<List<Integer>> distanceMatrix,
            int dimension,
            boolean[] availableRow,
            boolean[] availableColumns) {
        int row = -1;
        int column = -1;
        for (int i = 1; i <= dimension; i++) {
            if (distanceMatrix.get(i).get(0) == indexRow) {
                row = i;
                break;
            }
        }
        for (int j = 1; j <= dimension; j++) {
            if (distanceMatrix.get(0).get(j) == indexColumn) {
                column = j;
                break;
            }
        }
        for (int j = 0; j <= dimension; j++) {
            distanceMatrix.get(j).remove(column);
        }
        distanceMatrix.remove(row);
        return distanceMatrix;
    }

    private static List<List<Integer>> rewriteValue(
            int indexRow,
            int indexColumn,
            List<List<Integer>> distanceMatrix,
            int dimension,
            boolean[] availableRows,
            boolean[] availableColumns) {
        int row = -1;
        int column = -1;
        if (!availableRows[indexColumn - 1] || !availableColumns[indexRow - 1]) {
            int[] arr = findElem(distanceMatrix, dimension);
            distanceMatrix.get(arr[0]).set(arr[1], Integer.MAX_VALUE);
        } else {
            for (int i = 1; i <= dimension; i++) {
                if (distanceMatrix.get(i).get(0) == indexColumn) {
                    row = i;
                    break;
                }
            }
            for (int j = 1; j <= dimension; j++) {
                if (distanceMatrix.get(0).get(j) == indexRow) {
                    column = j;
                    break;
                }
            }
            distanceMatrix.get(row).set(column, Integer.MAX_VALUE);
        }
        return distanceMatrix;
    }

    private static int[] findElem(List<List<Integer>> distanceMatrix, int dimension) {
        int row = -1;
        int[] countsRow = new int[dimension];
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                if (distanceMatrix.get(i - 1).get(j - 1) == Integer.MAX_VALUE) {
                    break;
                }
                row = i;
            }
            if (row > -1) {
                break;
            }
        }

        int column = -1;
        int[] countsCol = new int[dimension];
        for (int j = 1; j <= dimension; j++) {
            for (int i = 1; i <= dimension; i++) {
                if (distanceMatrix.get(i - 1).get(j - 1) == Integer.MAX_VALUE) {
                    break;
                }
                column = j;
            }
            if (column > -1) {
                break;
            }
        }
        return new int[]{row, column};
    }
}
