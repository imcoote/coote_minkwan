/*
- 문제 풀이 시간: 10분
- 시간복잡도:
    - O(n)
- 메모리: 20164KB
- 실행시간: 288ms
- 풀이
    - 큐 구현
    - back은 큐 전체를 순회하여 가장 마지막 원소를 last에 저장하여 관리
*/

import java.io.*;
import java.util.*;

public class 큐_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.poll());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        Integer last = null;
                        for (Integer element : queue) {
                            last = element;
                        }
                        System.out.println(last);
                    }
                    break;
            }
        }
    }
}
