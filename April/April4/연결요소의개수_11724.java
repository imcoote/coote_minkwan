/*
- 문제 풀이 시간: 20분
- 시간복잡도:
    - O(N+M)
- 메모리: 141788KB
- 실행시간: 552ms
- 풀이
    - 방향이 없는 그래프이기 때문에 양방향으로 추가
*/

import java.io.*;
import java.util.*;

public class 연결요소의개수_11724 {
    static boolean [] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1]; // 문제에서 정점은 1부터 N까지라고 명시
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v); // 방향이 없는 그래프이기 때문에 둘 다 추가해줘야 함
            graph[v].add(u);
        }

        int cnt = 0;

        for (int i=1; i<=N; i++){
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }
        System.out.print(cnt);
    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}