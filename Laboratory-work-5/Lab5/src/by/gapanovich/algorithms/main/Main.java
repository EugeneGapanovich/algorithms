package by.gapanovich.algorithms.main;

/*
    Task
    Разработать следующие алгоритмы и программы с использованием рекурсии:
    Дихотомического поиска целочисленного значения ключа в заданном массиве и вывода этого массива.
*/

import by.gapanovich.algorithms.algorithm.AlgorithmClass;
import by.gapanovich.algorithms.classes.ArrayClass;
import by.gapanovich.algorithms.creator.ArrayCreator;
import by.gapanovich.algorithms.reader.InfoReader;

import java.util.Arrays;

public class Main {
    static final int COUNT_ELEMENTS = 25;
    static final int START = 1;
    static final int END = 100;
    static final int LEFT = 0;

    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] arrayNumbers = arrayCreator.createArray(COUNT_ELEMENTS);
        arrayNumbers = arrayCreator.fillArrayFromInterval(START, END, arrayNumbers);

        ArrayClass arrayClass = new ArrayClass();
        arrayClass.print(arrayNumbers);
        Arrays.sort(arrayNumbers);
        arrayClass.printWithIndexes(arrayNumbers);
        AlgorithmClass algorithm = new AlgorithmClass();
        InfoReader reader = new InfoReader();
        System.out.println("Enter key:");
        int key = reader.readIntegerNumber(System.in);
        long startTime = System.nanoTime();
        int position = algorithm.recursiveDichotomousSearch(arrayNumbers, LEFT, arrayNumbers.length-1, key);
        long endTime = System.nanoTime();
        long leadTime = endTime - startTime;
        System.out.println("Lead time=" + leadTime);
        if (position == -1){
            System.out.println("There is no such key");
        } else {
            System.out.println("Key " + key + " found at number " + position);
        }
    }
}
