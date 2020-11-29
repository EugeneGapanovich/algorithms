package by.gapanovich.algorithms.algorithm;



public class AlgorithmClass {

    public String dichotomousSearch(int[] numbers, int key){
        if(numbers.length == 0){
            return "Array is empty!";
        }
        int left = 0;
        int right = numbers.length - 1;
        int mid;

        while(left <= right){
            mid = (left + right)/2;
            if(numbers[mid] == key){
                return "Key " + key + " found at number " + mid;
            }
            if(numbers[mid] < key){
                left = mid + 1;
            }
            if(numbers[mid] > key){
                right = mid -1;
            }
        }
        return "There is no such key " + key;
    }
}
