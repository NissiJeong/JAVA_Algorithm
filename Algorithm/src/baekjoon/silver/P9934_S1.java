package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. K (1<=K<=10)
    2. 빌딩원 번호들(중복X, 구간 1,2^k 에 포함)
출력:
    1. K줄에 걸쳐 정답 출력(레벨에 맞게)
로직:
    1. 설명을 보니 inOrder 이진 트리 구현인 듯
    2. 완전 이진 트리이고
    3. 반을 나눠 가운데 있는 것이 루트 이고
    4. 분할해 가면서 왼쪽은 왼쪽 트리, 오른쪽은 오른쪽 트리에 순서대로 넣으면?
        상세로직:
        1. arr[k] 만큼 숫자 입력
        2. int mid = arr.length/2, arr[mid] -> 루트
        3. arr[0..mid-1] -> 좌, arr[mid+1..arr.length-1] -> 우
        4. 2-3번 반복(재귀)
        5. 2*i+1, 2*i+2
 */
public class P9934_S1 {

    public static int[] binaryTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[(int)Math.pow(2, K)-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<(int)Math.pow(2, K)-1; i++)arr[i] = Integer.parseInt(st.nextToken());

        binaryTree = new int[(int)Math.pow(2, K)-1];
        int mid = arr.length/2;
        binaryTree[0] = arr[mid];

        recursiveLeftTree(Arrays.copyOfRange(arr,0, mid), 0);
        recursiveRightTree(Arrays.copyOfRange(arr,mid+1, arr.length), 0);

        for(int i=0; i<K; i++) {
            for(int j=(int)Math.pow(2,i)-1; j<(Math.pow(2,i)-1)+Math.pow(2,i); j++) {
                bw.write(binaryTree[j]+ " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    public static void recursiveLeftTree(int[] arr, int level) {
        if(arr.length == 1) {
            binaryTree[level*2+1] = arr[0];
            return;
        }

        int mid = arr.length /2;
        binaryTree[level*2+1] = arr[mid];
        recursiveLeftTree(Arrays.copyOfRange(arr,0, mid), level*2+1);
        recursiveRightTree(Arrays.copyOfRange(arr,mid+1, arr.length), level*2+1);
    }
    public static void recursiveRightTree(int[] arr, int level) {
        if(arr.length == 1) {
            binaryTree[level*2+2] = arr[0];
            return;
        }

        int mid = arr.length /2;
        binaryTree[level*2+2] = arr[mid];
        recursiveLeftTree(Arrays.copyOfRange(arr,0, mid), level*2+2);
        recursiveRightTree(Arrays.copyOfRange(arr,mid+1, arr.length), level*2+2);
    }
}
