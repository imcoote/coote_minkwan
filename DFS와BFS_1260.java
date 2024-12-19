import java.util.*;

public class DFS와BFS_1260 {
    static List<List<Integer>> adjacent;
    static boolean[] visited;
    static List<Integer> dfsResult;
    static List<Integer> bfsResult;

    // DFS
    static void dfs(int c) {
        dfsResult.add(c);
        visited[c] = true;

        for (int n : adjacent.get(c)) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    // BFS
    static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        bfsResult.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int n : adjacent.get(c)) {
                if (!visited[n]) {
                    queue.offer(n);
                    bfsResult.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        adjacent = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjacent.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            adjacent.get(s).add(e);
            adjacent.get(e).add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjacent.get(i));
        }

        visited = new boolean[N + 1];
        dfsResult = new ArrayList<>();
        dfs(V);

        visited = new boolean[N + 1];
        bfsResult = new ArrayList<>();
        bfs(V);

        for (int i : dfsResult) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : bfsResult) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
