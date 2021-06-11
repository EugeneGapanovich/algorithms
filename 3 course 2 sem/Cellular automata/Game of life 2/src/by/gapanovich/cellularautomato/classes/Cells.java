package by.gapanovich.cellularautomato.classes;

public class Cells {
    private int[][] cells;
    private int n;

    public Cells(int n) {
        this.n = n;
        cells = new int[n][n];
    }

    public void checkAllCells() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = this.isCellAlive(i, j) ? 1 : 0;
            }
        }
        cells = copy;
    }

    public boolean isCellAlive(int i, int j) {
        int neighbours = countNeighbours(i, j);
        if (cells[i][j] == 1) {
            return neighbours == 2 || neighbours == 3;
        } else {
            return neighbours == 3;
        }
    }

    public int countNeighbours(int i, int j) {
        int neighbours = 0;
        if (cells[i][j] == 1) {
            neighbours--;
        }
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < n && l >= 0 && l < n) {
                    if (cells[k][l] == 1) {
                        neighbours++;
                    }
                }
            }
        }

        return neighbours;
    }

    public int getN() {
        return n;
    }

    public void setCells(int[][] cells) {
        this.cells = cells;
    }

    public int getElement(int i, int j) {
        return cells[i][j];
    }

    public void setCell(int i, int j, int val) {
        cells[i][j] = val;
    }

    public void clearCells() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = 0;
            }
        }
    }
}
