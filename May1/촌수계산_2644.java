import java.io.*;
import java.util.*;

public class 촌수계산_2644 {

    static int[] parent;
    static int n;
    static int p1, p2;
    static List<List<Integer>> relatives;
    static int[] depth;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        relatives = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            relatives.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            parent[y] = x;
            relatives.get(x).add(y);
            relatives.get(y).add(x);
        }

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        bfs(p1);

        if (distance[p2] > 0) {
            System.out.println(distance[p2]);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == p2) {
                return;
            }

            for (int neighbor : relatives.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
    }
}