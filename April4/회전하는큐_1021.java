import java.io.*;
import java.util.*;

public class 회전하는큐_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] location = new int[M]; // 배열에 위치정보 저장
        for (int i = 0; i < M; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int target = location[i];
            int idx = 0;
            for (int num : deque) {
                if (num == target) break;
                idx++;
            }

            if (idx <= deque.size() / 2) {
                // 왼쪽 회전
                for (int j = 0; j < idx; j++) {
                    int front = deque.pollFirst();
                    deque.offerLast(front);
                    cnt++;
                }
            } else {
                // 오른쪽 회전
                int rightRotations = deque.size() - idx;
                for (int j = 0; j < rightRotations; j++) {
                    int back = deque.pollLast();
                    deque.offerFirst(back);
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
