package by.gapanovich.algorithms.classes;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    private final int R;
    private final int[][] dfa;
    private final String pat;

    public KMP(String pat) {
        this.R = 256;
        this.pat = pat;
        int m = pat.length();
        dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];  // Copy mismatch cases.
            }
            dfa[pat.charAt(j)][j] = j + 1;  // Set match case.
            x = dfa[pat.charAt(j)][x];  // Update restart state.
        }
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == m) {
            return i - m;   // found
        }
        return n;   // not found
    }

    public void printDFA(String pattern) {
        System.out.println("dfa:");
        int sum = 0;
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < pattern.length(); j++) {
                sum += dfa[i][j];
            }
            if (sum > 0) {
                indexes.add(i);
                sum = 0;
            }
        }
        for (Integer index : indexes) {
            for (int j = 0; j < pattern.length(); j++) {
                System.out.printf("%4d", dfa[index][j]);
            }
            System.out.println();
        }
    }
}
