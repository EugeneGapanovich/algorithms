package by.gapanovich.algorithms.classes;

import java.util.Arrays;

public class ArrayClass {
    public void print(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }

    public void printWithIndexes(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++){
            System.out.print(i + "-" + array[i] + "; ");
        }
        System.out.println(array.length - 1 + "-" + array[array.length - 1] + "]");
    }


}
