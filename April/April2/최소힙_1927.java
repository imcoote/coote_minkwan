/*
- 문제 풀이 시간: 10분
- 시간복잡도:
    - O(n): N개의 정수
    - O(log n): add와 poll연산
    - O(n*logn)
- 메모리: 31268KB
- 실행시간: 784ms
- 풀이
    - 우선순위 큐를 사용한 최소 힙 구현
*/

import java.io.*;
import java.util.*;

public class 최소힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int x= Integer.parseInt(br.readLine());

            if(x == 0) {
                if(queue.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(queue.poll());
                }
            }
            else {
                queue.add(x);
            }
        }
    }
}
