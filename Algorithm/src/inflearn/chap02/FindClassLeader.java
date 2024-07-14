package inflearn.chap02;

import java.util.*;

/*
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

4
 */
public class FindClassLeader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr=new int[n+1][6];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=5; j++){
				arr[i][j]=sc.nextInt();
			}
		}

        System.out.println(findClassLeader(n, arr));
    }

    private static int findClassLeader(int n, int[][] arr) {
        int answer=0, max=0;
		for(int i=1; i<=n; i++){
			int cnt=0;
			for(int j=1; j<=n; j++){
				for(int k=1; k<=5; k++){
					if(arr[i][k]==arr[j][k]){
						cnt++;
						break;
					}
				}
			}
			if(cnt>max){
				max=cnt;
				answer=i;
			}
		}
		return answer;
    }
}
