package by.gapanovich.algorithms.main;

import by.gapanovich.algorithms.creator.ArrayCreator;
import by.gapanovich.algorithms.manipulation.ArrayOperation;


public class Main {
    static final int COUNT_ELEMENTS = 50_000_000;
    static final int START = -100_000;
    static final int END = 100_000;

    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] arrayNumbers = arrayCreator.createArray(COUNT_ELEMENTS);
        arrayNumbers = arrayCreator.fillArrayFromInterval(START, END, arrayNumbers);
        ArrayOperation arrayOperation = new ArrayOperation();

        while(true){
            long timeStartMethodSumPositiveNumbers = System.currentTimeMillis();
            long sumPositiveNumbers = arrayOperation.sumPositiveNumbers(arrayNumbers);
            long timeEndMethodSumPositiveNumbers = System.currentTimeMillis();

            long timeStartMethodSumNegativeNumbers = System.currentTimeMillis();
            long sumNegativeNumbers = arrayOperation.sumNegativeNumbers(arrayNumbers);
            long timeEndMethodSumNegativeNumbers = System.currentTimeMillis();
            System.out.println("Amount of elements=" + COUNT_ELEMENTS);
            System.out.println("Sum of positive numbers=" + sumPositiveNumbers);
            System.out.println("Sum of negative numbers=" + sumNegativeNumbers);
            System.out.println("Method execution time sumPositiveNumbers()=" + (timeEndMethodSumPositiveNumbers
                    - timeStartMethodSumPositiveNumbers));
            System.out.println("Method execution time sumNegativeNumbers()=" + (timeEndMethodSumNegativeNumbers
                    - timeStartMethodSumNegativeNumbers));
            System.out.println("Cycle completed");
        }
    }
}
