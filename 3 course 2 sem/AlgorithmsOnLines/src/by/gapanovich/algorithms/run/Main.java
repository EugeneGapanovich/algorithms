package by.gapanovich.algorithms.run;

import by.gapanovich.algorithms.classes.KMP;
import by.gapanovich.algorithms.printer.Printer;
import by.gapanovich.algorithms.validator.Lines;

public class Main {
    public static void main(String[] args) {
        String pat = "ABRACADABRA";
        String txt = "IDHFGDFABRASJRGODABRACADABRASNGLISD";
        KMP kmp = new KMP(pat);
        kmp.printDFA(pat);
        Printer.displayMatch(kmp.search(txt), pat, txt);

        String firstString = "string";
        String secondString = "ingstr";
        System.out.println("First string: " + firstString);
        System.out.println("Second string: " + secondString);
        System.out.println("Checking for cyclic permutation: " +
                Lines.areRotations(firstString, secondString));
    }
}
