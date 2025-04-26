/*
- 문제 풀이 시간: 50분
- 시간복잡도:
    - O(1)
- 메모리: 14224KB
- 실행시간: 104ms
- 풀이
    - 경우의 수로 나눠 구현
    - 1. 직선만 써서 가는 경우 -> 맨해턴 거리 이용
    - 2. 대각선만 써서 가는 경우(유클리디안) + 대각선 쓰다가 직선 한 번 쓰는 경우
    - 3. 대각선 여러 번과 직선 여러 번
*/

import java.io.*;
import java.util.*;

public class 걷기_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long case1,case2,case3;

        // 1. 직선만 사용
        case1 = (X+Y) * W;

        // 2. 대각선만 or 대각선과 한 번의 직선
        case2 = 0;
        if((X+Y) % 2 == 0){ // 짝수면 대각선으로만 가능
            case2 = Math.max(X,Y) * S;
        }else{ // 홀수면 대각선으로 가서 마지막에 직선 사용
            case2 = (Math.max(X,Y) - 1) * S + W;
        }

        // 3. 대각선과 여러 번의 직선
        case3 = (Math.min(X, Y)) * S + (Math.abs(X - Y)) * W;

        System.out.println(Math.min(case1, Math.min(case2, case3)));
    }
}
