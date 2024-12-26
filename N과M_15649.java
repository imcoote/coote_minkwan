import java.io.*;
import java.util.*;

public class N과M_15649 {
    static int N, M;
    static boolean[] visited;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        res = new int[M];
        sb = new StringBuilder();

        dfs(0);
        System.out.print(sb.toString());
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[depth] = i;

                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}
