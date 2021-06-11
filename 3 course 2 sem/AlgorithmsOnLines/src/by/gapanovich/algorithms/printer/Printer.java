package by.gapanovich.algorithms.printer;

public class Printer {
    public static void displayMatch(int offset, String pattern, String txt) {
        if (offset == txt.length()) {
            System.out.println("There is no match");
        } else {
            System.out.println("\nThere is a match");
            System.out.println("text:         " + txt);
            System.out.print("find pattern: ");
            for (int i = 0; i < offset; i++) {
                System.out.print(" ");
            }
            System.out.println(pattern);
        }
    }
}
