package by.gapanovich.algorithms.manipulation;

public class ArrayOperation {
    public long sumNegativeNumbers(int[] array){
        long sum = 0;
        for (int value : array) {
            if (value < 0) {
                sum += value;
            }
        }
        return sum;
    }

    public long sumPositiveNumbers(int[] array){
        long sum = 0;
        for (int value : array) {
            if (value > 0) {
                sum += value;
            }
        }
        return sum;
    }
}
