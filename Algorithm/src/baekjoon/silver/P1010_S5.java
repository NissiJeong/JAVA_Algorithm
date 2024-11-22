package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * - 우선 해당 문제는 dp 알고리즘 분류로 들어왔다.
 *   dp 알고리즘을 푸는 순서는
 *   - 규칙을 찾을 때까지 직접 손으로 풀어본다.
 *   - 규칙을 찾고 어떻게 반복하면 좋을지 어떤 자료구조가 추가로 필요할지 생각한다.
 *   - 새로 생성한 나만의 자료구조에 현재 어떤 값을 넣으면 좋을지 판단한다.(반복되는 연산이나 추후에 반복적으로 쓰이는 값들)
 *   - 연산을 반복해 가면서 자료구조에 저장했던 값들을 꺼내와서 사용한다.
 * <p>
 *   ** 나만의 자료구조를 하나 만들고 거기에 어떤 정보를 담아야 이전 단계로 돌아가지 않을지 고민이 필요 **
 * <p>
 * 문제 분석
 * - 숫자 n, m 이 주어진다.(n<=m)
 * - 2, 4 라고 하면 왼쪽1번이 오른쪽 1부터 4-1까지 다리를 놓을 수 있음
 * - 오른쪽 1부터 다리를 놓는 경우의 수를 생각하고 그 뒤의 경우의 수를 생각한다.
 * - 오른쪽 1이면 2,3,4 3개 / 2이면 3,4 / 3이면 4
 * - 3,4 라고 하면
 * - 왼1 오1 => 왼2 오2 => 왼3 오3
 *                    => 왼3 오4
 *          => 왼2 오3 => 왼3 오4
 *   왼1 오2 => 왼2 오3 => 왼3 오4
 * - 배열에 완쪽 다리가 어디에 있는지 저장하고 왼쪽 다음 다리는 왼쪽 이전 다리가 선택한 후의 것부터 카운트 하면 됨!
 * <p>
 * 문제 풀이
 * - 테스트 케이스의 수 t 가 주어짐
 * - 왼쪽 지역 n, 오른쪽 지역 m
 * - 일차원 배열을 만들어서 왼쪽 지역의 n의 인덱스 값에 오른쪽 지역의 인덱스 값을 저장해 둔다.(처음에는 0)
 * - 이중 반복문을 반복하면서 두번째 반복문의 시작점은 일차원 배열 n 의 인덱스에 저장해둔 오른쪽 지역의 인덱스 이후부터 시작한다.
 * - 이중 반복문의 마지막 반복 count 는 오른쪽 지역 m - 왼쪽 남아있는 지역의 개수
 * <p>
 * 일단 문제 분석부터 풀이까지 전체 다 실패.....
 * 실패 원인
 * - 규칙부터 잘 못 생각하였음
 * - 규칙이 잘 못 되니 풀이가 완전 잘못 됐고 작은 문제로 쪼개는 것과 메모제이션도 잘못 되었음
 * - 해당 문제는 구글링 하여 풀이법을 보고 습득해야 할 것 같음
 * - 우선 비슷한데 좀 더 난이도가 쉬운 문제인 11050번 문제를 풀고오자
 */
public class P1010_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(createBridge(n, m));
        }
    }

    public static int createBridge(int n, int m) {
        int[] bridgeIdx = new int[n+1];
        int count = 0;

        for(int i=1; i<n; i++) {
            for(int j=bridgeIdx[i]; j<=m-(n-bridgeIdx[i]); j++) {
                count++;
            }
            bridgeIdx[i+1] = bridgeIdx[i]+1;
        }

        return count;
    }
}
