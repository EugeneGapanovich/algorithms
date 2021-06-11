package by.gapanovich.algorithms.validator;

public class Lines {

    public static boolean areRotations(String firstString, String secondString) {
        return (firstString.length() == secondString.length()) &&
                ((firstString + firstString).contains(secondString));
    }

    public static boolean isExistCyclePermutation(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            return false;
        }
        return sort(firstString).equals(sort(secondString));
    }

    private static String sort(String string) {
        char[] content = string.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }
}
