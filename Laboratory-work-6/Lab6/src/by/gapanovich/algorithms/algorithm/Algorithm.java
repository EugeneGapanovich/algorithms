package by.gapanovich.algorithms.algorithm;

public class Algorithm {
    public int[] bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public int[] shakerSort(int[] array){
        int left = 0;
        int right = array.length - 1;
        int temp;
        do {
            for (int i = left; i < right; i++) {
                if(array[i] > array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            right--;
            for(int i = right; i > left; i--){
                if(array[i] < array[i-1]){
                    temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                }
            }
            left++;
        } while (left < right);
        return array;
    }
}
