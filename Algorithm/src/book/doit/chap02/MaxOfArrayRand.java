package book.doit.chap02;

import java.util.Random;

public class MaxOfArrayRand {
    static int maxOf(int[] a){
        int max = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i] > max)
                max = a[i];
        }

        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("키의 최대값을 구합니다.");
        int a = rand.nextInt(10);
        System.out.print("사람 수: "+a);

        int[] height = new int[a];

        System.out.println("키 값을 아래와 같습니다.");
        for(int i=0; i<a; i++){
            height[i] = 100+rand.nextInt(90);
            System.out.println("height["+i+"]: "+height[i]);
        }

        System.out.println("최대값: "+maxOf(height));
    }
}
