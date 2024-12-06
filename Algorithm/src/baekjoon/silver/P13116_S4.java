package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. 테스트 케이스 T
    2. 정수 A,B(1<=A,B<=1023, A!=B)
출력:
    1. 정답 T 줄
로직:
    1. 이진트리
    2. arr[N+1] 에 넣고
    3. arr[1] = 0, arr[2] = 1, arr[3] = 1, arr[4] = 2, arr[5] = 2, arr[6] = 3, arr[7] = 3, ...
    4. 찾는건 어떻게? -> 부모 하나씩 올라가면서 같으면 while 문 빠져나와
    5. while 문으로 같이 찾는 건 하나씩 같이 올라가기 때문에 문제가 있음
    6. 하나씩 돌리면서 map.put(parent value,parent count++) 하는건?
    7. 오답...
    8. 보인도 넣어야 함 본인도 경로니까
 다른 풀이
    1. 와.. 진짜 쉽게들 푸셨음..
    2. 부모 노드는 자식 노드의 /2 값임
    3. A,B 받고
    4. while 문 돌면서
    while(A!=B) {
        if(A>B){
            A /= 2;
        }
        else {
            B /= 2;
        }
    }
    5. 1023 까지 저장할 필요도..
    6. map 에 값을 담을 필요도 없었음...
 */
public class P13116_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int[] binaryTree = new int[1024];
        for(int i=2; i<1024; i++) {
            binaryTree[i] = i/2;
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            int maxParent = getMaxParent(binaryTree, A, B);

            bw.write(maxParent*10+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMaxParent(int[] binaryTree, int A, int B) {
        int pA = binaryTree[A], pB = binaryTree[B];

        Map<Integer, Integer> pMap = new HashMap<>();
        pMap.put(A, 1);
        pMap.put(B, 1);
        while(pA != 0) {
            pMap.put(pA, pMap.getOrDefault(pA, 0)+1);
            pA = binaryTree[pA];
        }
        while(pB != 0) {
            pMap.put(pB, pMap.getOrDefault(pB, 0)+1);
            pB = binaryTree[pB];
        }

        int maxParent = 0;
        for(Integer key : pMap.keySet()) {
            if(pMap.get(key) == 2) {
                if(maxParent < key) maxParent = key;
            }
        }
        return maxParent;
    }
}
