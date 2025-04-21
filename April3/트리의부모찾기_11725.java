/*
- 문제 풀이 시간: 60분
- 시간복잡도:
    - O(n)
- 메모리: 67040KB
- 실행시간: 532ms
- 풀이
    - 큐 구현
    - back은 큐 전체를 순회하여 가장 마지막 원소를 last에 저장하여 관리
*/

import java.io.*;
import java.util.*;

public class 트리의부모찾기_11725 {
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] parentNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < N; i++)
            tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        visited = new boolean[N];
        parentNode = new int[N];

        bfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(parentNode[i] + 1).append("\n");
        }
        System.out.print(sb.toString());

        br.close();
    }

    static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int node : tree.get(v)) {
                if (!visited[node]) {
                    visited[node] = true;
                    parentNode[node] = v;
                    queue.add(node);
                }
            }
        }
    }
}
