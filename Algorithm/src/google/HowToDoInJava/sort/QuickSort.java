package google.HowToDoInJava.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,5,7,4,3,10,9,8,2,6};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high){
        int index = partitionArr(arr, low, high);
        if(low<index-1){
            quickSort(arr,low,index-1);
        }
        if(index<high){
            quickSort(arr,index,high);
        }
    }

    public static int partitionArr(int[] arr, int low, int high){
        int start = low;
        int end = high;
        int pivot = arr[(low+high)/2];

        while(start <= end){
            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot){
                end--;
            }
            if(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }
}
