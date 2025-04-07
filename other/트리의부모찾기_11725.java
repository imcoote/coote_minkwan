import java.io.*;
import java.util.*;

public class 트리의부모찾기_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 개수 입력

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++)
            tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1; // 1-based to 0-based
            int node2 = Integer.parseInt(st.nextToken()) - 1; // 1-based to 0-based
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        boolean[] visited = new boolean[N];
        int[] parentNode = new int[N];

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int node : tree.get(v)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentNode[node] = v;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(parentNode[i] + 1).append("\n");
        }
        System.out.print(sb.toString());

        br.close();
    }
}
