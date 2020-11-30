package by.gapanovich.algorithms.main;

import by.gapanovich.algorithms.algorithm.AlgorithmClass;
import by.gapanovich.algorithms.classes.ArrayClass;
import by.gapanovich.algorithms.creator.ArrayCreator;
import by.gapanovich.algorithms.filter.StringFilter;
import by.gapanovich.algorithms.reader.InfoReader;

import java.util.Arrays;
/*
    Task:
    Разработать алгоритм и программу дихотомического поиска.
    В качестве исходных данных использовать массив целых чисел, который вводится с клавиатуры.
    Аргумент поиска – число.
 */
public class Main {
    static final int COUNT_ELEMENTS = 10_000_000;
    static final int START = -100_000;
    static final int END = 100_000;
    static final int KEY = 1_500;

    public static void main(String[] args) {

        /*ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createArray(COUNT_ELEMENTS);
        array = arrayCreator.fillArrayFromInterval(START, END, array);
        Arrays.sort(array);
        AlgorithmClass algorithm = new AlgorithmClass();
        long startTime = System.currentTimeMillis();
        System.out.println(algorithm.dichotomousSearch(array, KEY));
        long endTime = System.currentTimeMillis();
        System.out.println("Count of elements=" + COUNT_ELEMENTS);
        System.out.println("Lead time=" + (endTime - startTime));*/



        System.out.println("Enter the array of integer values:");
        InfoReader reader = new InfoReader();
        String[] strings = reader.readStringArray(System.in);
        StringFilter filter = new StringFilter();
        String[] stringNumbers = filter.filterInt(strings);
        ArrayCreator creator = new ArrayCreator();
        int[] arrayNumbers = creator.factoryArray(stringNumbers);
        System.out.println("Initial array:");
        ArrayClass arrayClass = new ArrayClass();
        arrayClass.print(arrayNumbers);
        System.out.println("Enter key");
        int key = reader.readIntegerNumber(System.in);
        Arrays.sort(arrayNumbers);
        System.out.println("Sorted array:");
        arrayClass.printWithIndexes(arrayNumbers);
        AlgorithmClass algorithm = new AlgorithmClass();
        long startTime = System.nanoTime();
        int position = algorithm.dichotomousSearch(arrayNumbers, key);
        long endTime = System.nanoTime();
        long leadTime = endTime - startTime;
        if (position == -1){
            System.out.println("There is no such key");
        }else{
            System.out.println("Key " + key + " found at number " + position);
        }
        System.out.println("Lead time=" + leadTime);

    }
}
