package by.gapanovich.algorithms.reader;

import java.io.InputStream;
import java.util.Scanner;

public class InfoReader {
    public static final String REGEX_DELIMITR = "\\s+";

    public String[] readStringArray(InputStream input){
        Scanner scan = new Scanner(input);
        String line = scan.nextLine();
        line = line.trim();
        String[] numbers = line.split(REGEX_DELIMITR);
        return numbers;
    }

    public int readIntegerNumber(InputStream input){
        Scanner scan = new Scanner(input);
        return scan.nextInt();
    }
}
