// 문제 풀이 시간: 15분
// 시간복잡도: O(nlogn)
// 배열의 모든요소 n, 정렬 logn
// 메모리 사용량: 18016KB

import java.util.*;

public class ATM_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String line = sc.nextLine();
        String[] stringArr = line.split(" ");
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(stringArr[i]);
        }

        Arrays.sort(t);

        int total = 0;
        int score = 0;

        for (int i = 0; i < n; i++) {
            total += t[i];
            score += total;
        }

        System.out.println(score);
    }
}