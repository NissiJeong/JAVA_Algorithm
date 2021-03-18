package google.HowToDoInJava.sort;

import java.util.Arrays;

public class InsertionSortExample {
    public static void main(String[] args) {
        int[] array = {12,13,24,10,3,6,90,70};

        insertionSort(array, 0, array.length);

        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] arr, int fromIndex, int toIndex){
        int d;
        for(int i=fromIndex+1; i<toIndex; i++){
            d = arr[i];
            int j=i;
            while(j > fromIndex && arr[j-1] > d){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = d;
        }
    }
}
