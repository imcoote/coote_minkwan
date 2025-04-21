/*
- 문제 풀이 시간: 60분
- 시간복잡도:
    - O(NlogN)
- 메모리: 26584KB
- 실행시간: 496ms
- 풀이
    - Comparator로 구현
*/

import java.io.*;
import java.util.*;

public class 절댓값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)){ // 같으면 실제값으로 오름차순(음수를 우선으로)
                    return o1 - o2;
                }
                else {
                    return Math.abs(o1) - Math.abs(o2); // 절댓값 기준으로 오름차순 정렬
                }
            }
        });

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) {
                pq.add(x);
            } else {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
