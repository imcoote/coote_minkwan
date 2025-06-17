/*
- 문제 풀이 시간: 10분
- 시간복잡도:
    - O(N)
- 메모리: 36916KB
- 실행시간: 180ms
*/

import java.io.*;
import java.util.*;

public class 카드2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        while (dq.size() > 1) {
            dq.pollFirst();
            if (dq.size() > 0) {
                int tmp = dq.pollFirst();
                dq.offer(tmp);
            }
        }

        System.out.print(dq.poll());
    }
}
