/*
- 문제 풀이 시간: 20분
- 시간복잡도:
    - O(n): N개의 정수
    - O(log n): add와 poll연산
    - O(n*logn)
- 메모리: 32420KB
- 실행시간: 844ms
- 풀이
    - 우선순위 큐를 사용한 최대 힙 구현
*/

import java.io.*;
import java.util.*;

public class 최대힙_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x));

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
                continue;
            }
            pq.add(x);
        }
    }
}
