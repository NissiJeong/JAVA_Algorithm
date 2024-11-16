package datatype.String;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysExample {
    public static void main(String[] args) {
        int[] numbers = {5,8,7,1,3,5,9};

        Arrays.sort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));

        int[] original = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(original, original.length);
        int[] copyOfRange = Arrays.copyOfRange(original, 1,4);

        System.out.println("original = " + Arrays.toString(original));
        System.out.println("copy = " + Arrays.toString(copy));
        System.out.println("copyOfRange = " + Arrays.toString(copyOfRange));


        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {3, 2, 1};

        System.out.println("Arrays.equals(array1, array2) = " + Arrays.equals(array1, array2));
        System.out.println("Arrays.equals(array2, array3) = " + Arrays.equals(array2, array3));
        Arrays.sort(array3);
        System.out.println("Arrays.equals(array2, array3) = " + Arrays.equals(array2, array3));

        int[] numbers2 = {1, 2, 3, 4, 5};
        int index = Arrays.binarySearch(numbers2, 4);
        int noIndex = Arrays.binarySearch(numbers2, 6);

        System.out.println("index = " + index);
        System.out.println("noIndex = " + noIndex);

        int[] numbers4 = new int[3];

        Arrays.sort(numbers4);
        for (int number : numbers4) {
            System.out.print(number+" ");
        }

        Integer[] numbers3 = {1,2,4,5,6};
        Arrays.sort(numbers3, Comparator.reverseOrder());

        System.out.println("Arrays.toString(numbers2) = " + Arrays.toString(numbers2));

        Arrays.sort(numbers3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1.compareTo(o2); //오름차순
                return o1 - o2; //오름차순
            }
        });

        System.out.println("Arrays.toString(numbers2) = " + Arrays.toString(numbers2));

        Arrays.sort(numbers3, (a,b) ->
                b - a //내림차순
        );

        System.out.println("Arrays.toString(numbers2) = " + Arrays.toString(numbers2));
    }
}
