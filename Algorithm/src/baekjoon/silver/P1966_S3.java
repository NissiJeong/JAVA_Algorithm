package baekjoon.silver;

/*
우선순위 큐?
*/

import java.io.*;
import java.util.*;

public class P1966_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- >0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Print> printQueue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                printQueue.add(new Print(i, priority));
                pq.add(priority);
            }

            int index = 0;
            while(!pq.isEmpty()) {
                Print print = printQueue.poll();
                if(pq.peek() != print.priority) {
                    printQueue.add(print);
                }
                else if(pq.peek() == print.priority) {
                    index++;
                    pq.poll();
                    if(print.index == M) {
                        sb.append(index).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}

class Print {
    int index;
    int priority;

    Print(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
