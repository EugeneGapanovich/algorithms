package by.gapanovich.algorithms.algorithm;

public class AlgorithmClass {
    public int recursiveDichotomousSearch(int[] numbers, int left, int right, int key) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == key)
                return mid;
            if(numbers[mid] < key){
                return recursiveDichotomousSearch(numbers,mid + 1, right, key);
            }
            if(numbers[mid] > key){
                return recursiveDichotomousSearch(numbers, left, mid - 1, key);
            }
        }
        return -1;
    }
}
