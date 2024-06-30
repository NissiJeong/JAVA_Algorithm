package book.doit.chap02;

public class ReverseArray {
    static void swap(int[] a, int idx1, int idx2){
        System.out.println("a["+idx1+"]과(와) a["+idx2+"]를 교환합니다.");
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void reverseArray(int[] a){
        for(int i=0; i<a.length/2; i++){
            for(int l=0; l<a.length; l++)
                System.out.print(a[l]+" ");
            System.out.println();
            swap(a, i, a.length-i-1);
        }
        
    }

    public static void main(String[] args) {
        int[] a = {5,4,7,1,9,3,2};

        reverseArray(a);

        for(int l=0; l<a.length; l++)
                System.out.print(a[l]+" ");

        System.out.println("역순 정렬을 마쳤습니다.");
    }
}
