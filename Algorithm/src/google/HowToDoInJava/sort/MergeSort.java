package google.HowToDoInJava.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {6,3,2,7,1,21,4,8};
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right){
        if(left < right){   //원소 수가 2개 이상일 경우 실행
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);

            mergeSort(arr, mid+1, right);

            merge(arr,left, mid,right);
        }
    }

    //2개의 인전합 배열 arr[left..mid]와 list[mid+1..right]의 합병 과정
    private static void merge(int arr[], int left, int mid, int right){
        int i = left; //정렬된 왼쪽 배열에 대한 인덱스
        int j = mid+1; //정렬된 오른쪽 배열에 대한 인덱스
        int k = left; //정렬될 새로운 배열에 대한 인덱스
        int temp[] = new int[arr.length]; //새로운 배열
        //새로운 배열공간에 두개의 배열을 정렬하면서 하나씩 넣기
        while(i<=mid && j<=right){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        //왼쪽 공간에 남아있는 것이 있으면 새로운 배열에 복사
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        //오른쪽 공간에 남아있는 것이 있으면 새로운 배열에 복사
        while(j<=right){
            temp[k++] = arr[j++];
        }
        //새로운 배열에 정렬한것 원래 배열에 복사
        for(int index=left;index<k;index++){
            arr[index] = temp[index];
        }
    }
}
