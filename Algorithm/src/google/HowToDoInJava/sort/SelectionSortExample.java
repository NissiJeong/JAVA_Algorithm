package google.HowToDoInJava.sort;

import java.util.Arrays;

public class SelectionSortExample {

    public static void main(String[] args) {
        int[] array = {5,3,7,6,4,2,1};

        selecctionSort(array,0,array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void selecctionSort(int[] array, int formIndex, int toIndex){
        for(int currentIndex = formIndex; currentIndex < toIndex; currentIndex++){
            int indexToMove = currentIndex;
            for(int tempIndexInLoop = currentIndex+1; tempIndexInLoop<toIndex; tempIndexInLoop++){
                if(array[indexToMove] > array[tempIndexInLoop]){
                    int temp = array[indexToMove];
                    array[indexToMove] = array[tempIndexInLoop];
                    array[tempIndexInLoop] = temp;
                }
            }
        }
    }

}
