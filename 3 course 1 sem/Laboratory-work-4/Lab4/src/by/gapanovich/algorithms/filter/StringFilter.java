package by.gapanovich.algorithms.filter;

public class StringFilter{
    public static final String REGEX = "\\d+";

    public String[] filterInt(String[] numbers){
        int counter = 0;
        for (String numberString : numbers
        ) {
            if (numberString.matches(REGEX)){
                counter++;
            }
        }
        String[] validStr = new String[counter];
        int i = 0;
        for (String numberString : numbers) {
            if (numberString.matches("\\d+")){
                validStr[i++] = numberString;
            }
        }
        return validStr;
    }

}
