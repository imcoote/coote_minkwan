/*
- 문제 풀이 시간: 1시간 30분
- 문제 고민 시간: 3시간
- 시간복잡도: O(N), 누적합을 계산하기 위한 크기가 N인 배열을 for문으로 반복
- 메모리 사용량: 17776KB
- 초기 접근 방법: 현재날짜의 상담이 끝나는 날짜와 이 기간 사이에 있는 상담이 끝나는 날짜와 비교해서 이익이 더 큰쪽을 선택하는 부분으로 구현해봄 -> 구현실패..
- 각 날짜의 상담이 끝나는 날짜의 누적 이익을 계속 비교하면서 접근, 상담이 끝나는 시간이 퇴사 이후라면 바로 제외
*/
import java.util.*;

public class 퇴사_14501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] t = new int[N];
        int[] p = new int[N];

        for (int i = 0; i < N; i++) {
            t[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }

        int[] cumul_profit = new int[N + 1];

        for (int n = 0; n < N; n++) {
            // 해당날짜에 상담을 시작 안하는 경우
            cumul_profit[n + 1] = Math.max(cumul_profit[n + 1], cumul_profit[n]);

            // 해당날짜에 상담을 시작 하는 경우
            if (n + t[n] <= N) {
                cumul_profit[n + t[n]] = Math.max(cumul_profit[n + t[n]], cumul_profit[n] + p[n]);
            }
        }

        System.out.println(cumul_profit[N]);
        scanner.close();
    }
}