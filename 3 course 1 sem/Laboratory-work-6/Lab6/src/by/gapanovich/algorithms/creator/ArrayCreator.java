package by.gapanovich.algorithms.creator;

public class ArrayCreator {
    public int[] createArray(int size){
        int[] array = new int[size];
        return array;
    }

    public int[] fillArrayFromInterval(int start, int end, int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()* (end - start)) + start;
        }
        return array;
    }
}
