/*
- 문제 풀이 시간: 60분
- 시간복잡도:
    - O(N * K)
- 메모리: 53820KB
- 실행시간: 180ms
*/

import java.io.*;
import java.util.*;

public class 평범한배낭_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1]; // 인덱스를 1부터 사용
        int[] V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (W[i] > j) { // 가방에 넣을 수 없다면 이전 물건까지 넣음
                    dp[i][j] = dp[i - 1][j];
                } else { // 가방에 넣을 수 있다면 이전 물건까지 넣었던 가치와 이번 물건까지 넣었던 가치를 비교하여 더 큰걸 선택
                    dp[i][j] = Math.max(dp[i - 1][j], V[i] + dp[i - 1][j - W[i]]);
                }
            }
        }
        
        System.out.print(dp[N][K]);
    }
}