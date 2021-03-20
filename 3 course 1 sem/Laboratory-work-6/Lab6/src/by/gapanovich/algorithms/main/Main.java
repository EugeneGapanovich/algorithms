package by.gapanovich.algorithms.main;

import by.gapanovich.algorithms.algorithm.Algorithm;
import by.gapanovich.algorithms.creator.ArrayCreator;

import java.util.Arrays;

/*
    Task:
    Составить две программы, которые реализуют алгоритмы простой сортировки «пузырьком» и шейкером.
    Исходные данные задавать с помощью датчика случайных чисел.
*/
public class Main {

    static final int COUNT_ELEMENTS = 25;
    static final int START = -20;
    static final int END = 30;

    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] firstArray = arrayCreator.createArray(COUNT_ELEMENTS);
        int[] secondArray = arrayCreator.createArray(COUNT_ELEMENTS);
        firstArray = arrayCreator.fillArrayFromInterval(START, END, firstArray);
        secondArray = arrayCreator.fillArrayFromInterval(START,END,secondArray);
        System.out.println("Initialising arrays:");
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));

        Algorithm algorithm = new Algorithm();
        firstArray = algorithm.bubbleSort(firstArray);
        secondArray = algorithm.shakerSort(secondArray);
        System.out.println("Bubble sort:");
        System.out.println(Arrays.toString(firstArray));
        System.out.println("Shaker sort:");
        System.out.println(Arrays.toString(secondArray));
    }
}
